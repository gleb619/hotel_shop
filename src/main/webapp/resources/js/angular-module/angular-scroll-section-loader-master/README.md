#Angular JS Scroll Section Loader
Auto section loader with scroll event for Angular JS.

##Install
Bower: ```bower install angular-scroll-section-loader```

##Usage
Include module in your html.
```html
  <script src="/angular-scroll-section-loader/scroll-section-loader.js"></script>
```

Add ```scrollSectionLoader``` as a dependency in your Angular app.
```js
  var app = angular.module('myApp',['scrollSectionLoader']);
```

In controller:
```js
  $scope.sections = ['about','services','contact']; //html files to load (about.html, etc)
  $scope.loadedSections = [$scope.sections[0]]; //loaded html files
```

In html:
```html
  <section ng-repeat="section in loadedSections"  
           ng-include="section+'.html'"  
           scroll-section  
           sections="sections"  
           loaded-sections="loadedSections">  
```

##Author
Ismail Demirbilek [@dbtek](http://twitter.com/dbtek)

##License
[MIT](http://opensource.org/licenses/MIT)
