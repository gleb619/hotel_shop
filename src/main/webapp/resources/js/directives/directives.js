'use strict';

angular.module('shopApp.directives', [])
.directive('ngThumb', ['$window', function($window) {
var helper = {
    support: !!($window.FileReader && $window.CanvasRenderingContext2D),
    isFile: function(item) {
        return angular.isObject(item) && item instanceof $window.File;
    },
    isImage: function(file) {
        var type =  '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
        return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
    }
};

return {
    restrict: 'A',
    template: '<canvas/>',
    link: function(scope, element, attributes) {
        if (!helper.support) return;

        var params = scope.$eval(attributes.ngThumb);

        if (!helper.isFile(params.file)) return;
        if (!helper.isImage(params.file)) return;

        var canvas = element.find('canvas');
        var reader = new FileReader();

        reader.onload = onLoadFile;
        reader.readAsDataURL(params.file);

        function onLoadFile(event) {
            var img = new Image();
            img.onload = onLoadImage;
            img.src = event.target.result;
        }

        function onLoadImage() {
            var width = params.width || this.width / this.height * params.height;
            var height = params.height || this.height / this.width * params.width;
            canvas.attr({ width: width, height: height });
            canvas[0].getContext('2d').drawImage(this, 0, 0, width, height);
            }
            
        }
    };
}])

.directive('cdraggable', function ($document) {
	"use strict";
	return function (scope, element, attrs) {
		
		var startX = 0
		, startY = 0
		, x = 0
		, y = 0
		, elementToMove = {};
		
		if (attrs.movableId != null) {
			elementToMove = $('#' + attrs.movableId);
		}
		else {
			elementToMove = element;
		}
		
		element.on('mousedown', '> *', function (e) {
			if(!$(event.target).is("h4")) {
	           e.stopPropagation();
	        }
		});
		
		element.on('mousedown', function (event) {
			event.preventDefault();
			elementToMove.css({
				position: 'fixed',
				cursor: 'move',
				width: elementToMove.width() + 2
			});
			startX = event.screenX - x;
			startY = event.screenY - y;
			$document.on('mousemove', mousemove);
			$document.on('mouseup', mouseup);
//	      $(elementToMove).removeClass("animated bounce")
		});
		
		function mousemove(event) {
			y = event.screenY - startY;
			x = event.screenX - startX;
			elementToMove.css({
				top: y + 'px',
				left: x + 'px'
			});
		}
		
		function mouseup() {
			$(elementToMove).addClass('animated bounce');
			elementToMove.css({
				position: 'relative',
				cursor: 'auto',
				width: 'auto'
			});
			
			$document.unbind('mousemove', mousemove);
			$document.unbind('mouseup', mouseup);
		}
		
		scope.$on('$destroy', function() {
			element.off();
			$document.unbind('mousemove', mousemove);
			$document.unbind('mouseup', mouseup);
		});
		
	};
})

.directive('ngEnter', function () {
    return {
    	restrict : 'A',
		link : function (scope, element, attrs) {
	        element.bind("keydown keypress", function (event) {
	            if(event.which === 13) {
	                scope.$apply(function (){
	                    scope.$eval(attrs.ngEnter);
	                });

	                event.preventDefault();
	            }
	        });
	        
	        scope.$on('$destroy', function() {
	        	element.off();
			});
	    }
    };
})

.directive('collapseTarget', function() {
	return {
		restrict : 'A',
		scope : {
			collapseTarget : "@",
			collapseClass : "@"
		},
		link : function(scope, elm, attr) {
			elm.on('click', function() {
				if($(scope.collapseTarget).hasClass(scope.collapseClass)) {
					$(scope.collapseTarget).removeClass(scope.collapseClass);
				}
				else {
					$(scope.collapseTarget).addClass(scope.collapseClass);
				}
			});
			
			scope.$on('$destroy', function() {
				elm.off();
			});
		}
	};                                                                                    
})

.directive('scrollTo', function() {
    return {
		restrict : 'A',
		scope : {
			scrollTo : "@",
			scrollTimeout: "@"
		},
		link : function(scope, elm, attr) {
			elm.on('click', function() {
				
				if(scope.scrollTimeout){
					var timer = setTimeout(function() {
						scroll();
						clearTimeout(timer);
						timer = null;
					}, scope.scrollTimeout);
				}
				else {
					scroll();
				}
				
			});
			
			function scroll() {
				$('html, body').animate({
					scrollTop : $(scope.scrollTo).offset().top
				}, "slow");
			}
			
			scope.$on('$destroy', function() {
	        	elm.off();
			});
		}
	};                                                                                    
})

.directive('disableNgAnimate', ['$animate', function($animate) {
	return {
		restrict : 'A',
		link : function(scope, element) {
			$animate.enabled(false, element);
		}
	};
}])

.directive('reEnterPassword', [function() {
	return {
	    require: 'ngModel',
	    restrict : 'A',
	    scope : {
	    	reEnterPassword : "="
		},
	    link: function(scope, elm, attrs, ctrl) {
	    	
	    	function passwordCheck(modelValue, viewValue) {
	    		var originPassword = scope.reEnterPassword;
	    		
	    		if (ctrl.$isEmpty(modelValue)) {
	   	          	return false;
	   	        }
	    		
	    		if (!angular.isDefined(originPassword) || originPassword == null) {
	    			return false;
				}
	    		
	    		return originPassword === modelValue;
			}
	    	
	    	ctrl.$validators.passwordCheck = passwordCheck;
	    }
	};
}])

.directive('affix', function() {
	
	var scrollingFn = $.debounce(function(scope, elm, attr) {
		console.info('scrollTop: ', elm.scrollTop);
	}, 500);
	
	return {
        restrict: 'A',
        link: function (scope, elm, attr) {
    		console.info('scrolling#elm: ', elm);
    		
    		elm.scroll(function(){
    	       console.info('test');   
    	    });
    		
    		/*
            elm.bind('scroll', function() {
            	console.info('scroll#elm: ', elm[0]);
            	scrollingFn(scope, elm[0], attr);
            });
            */
            
            scope.$on('$destroy', function() {
            	console.info('destroy' );
            	elm.off();
    		});
        }
	};

})

.directive('whenScrolled', ['$debounce',
function($debounce) {
	var prevLeft = 0;
	
	var scrolling = function (scope, elm, attr) {
    	var raw = elm[0]
    	,   currentLeft = raw.scrollLeft
    	,	debug = attr.debug ? attr.debug : false;
    	
        elm.bind('scroll', function() {
        	scrollingFn(scope, elm, attr, raw, debug);
        });
        
//        scope.$on('$destroy', function() {
//    		for (var key in scope) {
//    			if (key.substr(0, 1) != '$' && key != 'this')
//    				delete scope[key];
//    		}
//		});
    };
	
	var scrollingFn = $.debounce(function(scope, elm, attr, raw, debug) {
		var scroll = {
			element : elm,
			scrollTop : raw.scrollTop,
			offsetHeight : raw.offsetHeight,
			total : raw.scrollTop + raw.offsetHeight,
			scrollHeight : raw.scrollHeight,
			prevLeft : prevLeft,
			currentLeft : raw.scrollLeft
		};

		if (debug) {
			console.info('scroll', scroll);
		}

		if (raw.scrollTop + raw.offsetHeight >= raw.scrollHeight - 50) {
//			scope.$apply(attr.whenScrolled);
			scope.$digest(attr.whenScrolled);
			if (debug) {
				console.info('onScrollDoneEvent', true);
			}
		}
		
		scroll = null;

	}, 500);
	
	return {
        restrict: 'A',
        link: scrolling
	};

}])

//#-------------------------------------------------------------
//							COMBOBOX
//#-------------------------------------------------------------

.directive('combobox', ['$compile', '$document', '$timeout', '$filter',
function($compile, $document, $timeout, $filter) {
	
	var template = 
		'<div class="combobox {{ addClass }} {{ params.addClass }}">' +
		'<input type="text" class="combobox-input" ng-model="selected.label" ng-focus="focus" ng-keyup="handleKeyup($event, selected.label)" placeholder="{{ placeholder }}" ng-disabled="disabled">' +
		'<a ng-click="toggleOptions()" class="btn btn-link combobox-open" ng-if="options.length">' +
		'<i class="fa fa-chevron-down"></i>' +
		'</a>' +
		//'<i class="combobox-open fa fa-chevron-down" ng-click="toggleOptions()"></i>' +
//			'<span class="open" ng-click="toggleOptions()" ng-class="{ disabled: !options.length }">Open</span>' +
		'<ul class="combobox-options" ng-if="showOptions && options.length" ng-class="{ flip: flip }">' +
		'<li class="combobox-option" ng-repeat="option in options" data-value="{{ option.value }}" ng-click="selectOption(option)" ng-class="{ \'combobox-hilighted\': hilighted == $index }">' +
		'<span class="combobox-option-label">{{ option.label }}</span>' + 
		'</li>' +
		'</ul>' +
		'</div>';
		//{{ options.length }}
	
	  return {
		scope : {
			combobox : '=',
			params : '=',
			model : '=ngModel',
			disabled : '=ngDisabled'
		},
		link : function($scope, $element, $attrs, ctrl) {
			var $combobox = $compile(template)($scope);
			$scope.showOptions = false;
			$scope.options = [];
			$scope.hilighted = null;
			$scope.placeholder = $element.attr('placeholder') || null;
			
			$timeout(function() {
				dataContainsModel();
				buildOptions();
				setSelected($scope.model);
				$element.replaceWith($combobox);
			});

			// Check data contains model
			var dataContainsModel = function() {
				if(typeof $scope.model == "undefined" || typeof $scope.combobox == "undefined"){
					return;
				}
				var index = $scope.combobox.indexOf($scope.model);
				if(index == -1){
					$scope.combobox.unshift($scope.model);
				}
			};
			
			// Build options list
			var buildOptions = function(filter) {
				$scope.options = [];
				
				if($scope.combobox && $scope.combobox.length > 0){
					$scope.options = $scope.combobox;
				}
			};

			$scope.selectOption = function(option) {
				$scope.showOptions = false;
				$scope.model = option;
			};

			// Set the new selected option
			var setSelected = function(value) {
				$scope.selected = value;
			};

			var filterOptions = $.debounce(function(text) {
				buildOptions(text);
			}, 300);
			
			$scope.handleKeyup = function(event, text) {
				// Show dropdown while typing
				if (!$scope.showOptions) {
					$scope.showOptions = true;
				}

				if (event.keyCode == 40) {
					// Handle down arrow
					if ($scope.hilighted == null) {
						$scope.hilighted = 0;
					} 
					else if ($scope.hilighted < ($scope.options.length - 1)) {
						$scope.hilighted++;
					} 
					else if ($scope.hilighted == ($scope.options.length - 1)) {
						$scope.hilighted = 0;
					}
				} else if (event.keyCode == 38) {
					// Handle up arrow
					if ($scope.hilighted == null) {
						$scope.hilighted = 0;
					} 
					else if ($scope.hilighted > 0) {
						$scope.hilighted--;
					}
					else if ($scope.hilighted == 0) {
						$scope.hilighted = ($scope.options.length - 1);
					}
				} else if (event.keyCode == 13) {
					// Handle enter
					$scope.selectOption($scope.options[$scope.hilighted]);
					$scope.hilighted = null;
				}
			};

			$scope.toggleOptions = function() {
				$scope.showOptions = !$scope.showOptions;
				$scope.focus = true;
			};

			// Listen for the data to change and update
			// options
			$scope.$watchCollection('combobox', function(newVal, oldVal) {
				if(typeof newVal == "undefined" || typeof oldVal == "undefined"){
					return;
				}
				
				if (newVal != oldVal) {
					buildOptions();
					setSelected($scope.selected);
				}
			});

			// Listen for the input value to change and
			// handle any side effects
			$scope.$watch('selected.label', function(newVal, oldVal) {
				if (newVal != oldVal) {
//					filterOptions;
//					filterOptions(newVal);
				}
			});

			// Watch for show options to change and
			// check whether options needs to be flipped
			$scope.$watch('showOptions', function(val) {
				if (val) {
					var $options = $combobox.find('.combobox-options');
					var bottomEdge = $combobox.offset().top + $combobox.height() + $options.height();

					if (bottomEdge + 24 > $(window).height()) {
						$scope.flip = true;
					} else {
						$scope.flip = false;
					}
				}
			});

			// Listen for the model to change
			$scope.$watch('model', function(newVal, oldVal) {
				// Update selected with new value if
				// it's changed
				if (newVal !== oldVal) {
					setSelected(newVal);
				}
			});

			// Hide options when user clicks outside
			var hideOptions = function(event) {
				var isChild = $combobox.has(event.target).length > 0;
				var isSelf = $combobox[0] == event.target;
				var isInside = isChild || isSelf;

				if (!isInside) {
					$scope.$apply(function() {
						$scope.showOptions = false;
						$scope.focus = false;
					});
				}
			};

			$document.on('click', hideOptions);

			// If the mousewheel plugin is available, let's prevent scrolling
			// parent elements when the options container is fully scrolled
			if ($.fn.mousewheel) {
				$combobox.delegate('.combobox-options', 'mousewheel',
				function(event) {
					var $this = $(this);
					var top = $this.scrollTop();

					if (event.deltaY > 0 && top - event.deltaY <= 0) {
						event.preventDefault();
						event.stopPropagation();
					} 
					else if (event.deltaY < 0 && $this.get(0).scrollHeight- top + event.deltaY <= $this.height()) {
						event.preventDefault();
						event.stopPropagation();
					}
				});
			}

			// Clean up
			$scope.$on('$destroy', function() {
				$document.off('click', hideOptions);
			});
		}
	};
}]);