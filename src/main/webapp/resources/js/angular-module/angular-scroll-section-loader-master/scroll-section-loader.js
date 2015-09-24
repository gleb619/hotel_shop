/**
 * Angular JS scrollSectionLoader module.
 * Provides <scroll-section-load> directive. And auto template loading with scroll event.
 * http://github.com/dbtek/angular-scroll-section-loader
 * Ismail Demirbilek, 2014
 * MIT License
 */
angular.module('scrollSectionLoader', []).
  directive('scrollSectionLoad', function($compile) {
    return {
      restrict: 'A',
      link: function(scope, element, attrs) {
        var loadedSections = scope[attrs.loadedSections];
        var sections = scope[attrs.sections]; //$scope.sections
        $window = angular.element(window);
        $window.bind('scroll', function(event) {
          var scrollPos = (document.body.scrollTop || document.documentElement.scrollTop) + document.documentElement.clientHeight;
          var elemBottom = element[0].offsetTop + element[0].offsetHeight;
          var scrollPos = (document.body.scrollTop || document.documentElement.scrollTop) + document.documentElement.clientHeight;
          var elemBottom = element[0].offsetTop + element[0].offsetHeight;
          if(scrollPos >= elemBottom) { //scrolled to bottom of scrollSection element
            $window.unbind(event); //this listener is no longer needed.
            if(loadedSections.length < sections.length) { //if there are still elements to load
              //use $apply because we're in the window event context
              scope.$apply(loadedSections.push(sections[loadedSections.length])); //add next section
            }
          }
        });
      }
    };
});