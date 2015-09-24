(function(angular, $, _){
'use strict';

var template = '<div class="combobox {{ addClass }} {{ params.addClass }}">' +
  '<input type="text" ng-model="selected.text" ng-focus="focus" ng-keyup="handleKeyup($event, selected.text)" placeholder="{{ placeholder }}" ng-disabled="disabled">' +
  '<span class="open" ng-click="toggleOptions()" ng-class="{disabled: !options.length}">Open</span>' +
  '<ul class="options" ng-if="showOptions && options.length" ng-class="{flip: flip}">' +
    '<li class="option" ng-repeat="option in options" data-value="{{option.value}}" ng-click="selectOption(option)" ng-class="{hilighted: hilighted == $index}">{{option.text}}</li>' +
  '</ul>' +
'</div>{{options.length}}';

angular.module('ngCombobox', [])
  .directive('combobox', ['$compile', '$document', '$timeout',
  function($compile, $document, $timeout) {
    return {
      scope: {
        data: '=',
        params: '=',
        model: '=ngModel',
        disabled: '=ngDisabled'
      },
      link: function($scope, $element, $attrs, ctrl){
        var params = $.extend({}, $scope.params);

        // Compile the combobox template with our scope
        var $combobox = $compile(template)($scope);

        $scope.addClass = $attrs.class;

        // Replace input with combobox
        $timeout(function(){
          buildOptions();
          setSelected($scope.model);
          $element.replaceWith($combobox);
        });

        $scope.showOptions = false;

        $scope.options = [];

        // Grab placeholder if provided
        $scope.placeholder = $element.attr('placeholder') || null;

        // Build options list
        var buildOptions = function(filter){
          $scope.options = [];

          filter = filter || '';
          filter = filter.toLowerCase();

          if ($scope.data) {
            _.each($scope.data, function(item){
              // If a format function has been provided, let's use it
              item = params.formatOption ? params.formatOption(item) : item;

              // If item is a string let's conform it to our options format
              if (typeof item == 'string') {
                item = {
                  value: item,
                  text: item
                };
              }

              // If the item text matches the current input text, push it to the options
              if (item.text.toLowerCase().indexOf(filter) >= 0) {
                $scope.options.push(item);
              }
            });
          }
        };

        // UI method for updating the model on selection
        $scope.selectOption = function(option){
          $scope.showOptions = false;
          $scope.model = option.value;
        };

        // Set the new selected option
        var setSelected = function(value){
          $scope.selected = _.clone(_.find($scope.options, {value: value})) || {value: value, text: value};
        };

        var filterOptions = _.debounce(function(text){
          $scope.$apply(function(){
            buildOptions(text);

            // See if there's an option that matches
            var option = _.find($scope.options, {text: text});

            if (option) {
              $scope.model = option.value;
            } else {
              $scope.model = text;
            }
          });
        }, 100);

        $scope.hilighted = null;

        $scope.handleKeyup = function(event, text){
          // Show dropdown while typing
          if (!$scope.showOptions) {
            $scope.showOptions = true;
          }

          if (event.keyCode == 40) {
            // Handle down arrow
            if ($scope.hilighted == null) {
              $scope.hilighted = 0;
            } else if ($scope.hilighted < ($scope.options.length - 1)) {
              $scope.hilighted++;
            }
          } else if (event.keyCode == 38) {
            // Handle up arrow
            if ($scope.hilighted > 0) {
              $scope.hilighted--;
            }
          } else if (event.keyCode == 13) {
            // Handle enter
            $scope.selectOption($scope.options[$scope.hilighted]);
            $scope.hilighted = null;
          }
        };

        // Open/close the options when the open button is clicked
        $scope.toggleOptions = function(){
          $scope.showOptions = !$scope.showOptions;
          $scope.focus = true;
        };

        // Listen for the data to change and update options
        $scope.$watchCollection('data', function(newVal, oldVal){
          if (newVal != oldVal) {
            buildOptions();
            // Reset selected if data changes to make sure we use the correct
            // display text
            setSelected($scope.selected.value);
          }
        });

        // Listen for the input value to change and handle any side effects
        $scope.$watch('selected.text', function(newVal, oldVal){
          if (newVal != oldVal) {
            filterOptions(newVal);
          }
        });

        // Watch for show options to change and check whether options needs to be flipped
        $scope.$watch('showOptions', function(val){
          if (val) {
            var $options = $combobox.find('.options');
            var bottomEdge = $combobox.offset().top + $combobox.height() + $options.height();

            if (bottomEdge + 24 > $(window).height()) {
              $scope.flip = true;
            } else {
              $scope.flip = false;
            }
          }
        });

        // Listen for the model to change
        $scope.$watch('model', function(newVal, oldVal){
          // Update selected with new value if it's changed
          if (newVal !== oldVal) {
            setSelected(newVal);
          }
        });

        // Hide options when user clicks outside
        var hideOptions = function(event){
          var isChild = $combobox.has(event.target).length > 0;
          var isSelf = $combobox[0] == event.target;
          var isInside = isChild || isSelf;

          if (!isInside) {
            $scope.$apply(function(){
              $scope.showOptions = false;
              $scope.focus = false;
            });
          }
        };

        $document.on('click', hideOptions);

        // If the mousewheel plugin is available, let's prevent scrolling
        // parent elements when the options container is fully scrolled
        if ($.fn.mousewheel) {
          $combobox.delegate('.options', 'mousewheel', function (event) {
            var $this = $(this);
            var top = $this.scrollTop();

            if (event.deltaY > 0 && top - event.deltaY <= 0) {
              event.preventDefault();
              event.stopPropagation();
            } else if (event.deltaY < 0 && $this.get(0).scrollHeight - top + event.deltaY <= $this.height()) {
              event.preventDefault();
              event.stopPropagation();
            }
          });
        }

        // Clean up
        $scope.$on('$destroy', function(){
          $document.off('click', hideOptions);
        });
      }
    };
  }]);

})(window.angular, window.$, window._);
