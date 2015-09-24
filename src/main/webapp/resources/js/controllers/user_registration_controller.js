(function() {
	'use strict';
	
	angular.module('shopApp').controller('UserRegistrationCtrl', UserRegistrationCtrl);
	
	UserRegistrationCtrl.$inject = ['$scope', '$timeout', '$q', '$servicesStorage', '$staticStorage', 'toaster', '$route', '$location', '$rootScope', 'APP_INFO' ];
	function UserRegistrationCtrl ($scope, $timeout, $q, $servicesStorage, $staticStorage, toaster, $route, $location, $rootScope, APP_INFO) {
//		UserRegistrationCtrl.$inject = ['$scope', '$modal', '$timeout', '$q', '$servicesStorage', '$staticStorage', 'toaster', '$route', 'FileUploader', '$filter', '$location', '$rootScope', 'APP_INFO', 'modalSettings', '$routeParams'];
//		function UserRegistrationCtrl ($scope, $rootScope, $routeParams, $location, $modal, $modalInstance, modalSettings, $servicesStorage, $filter, $staticStorage, toaster, $q, $timeout, WizardHandler, APP_INFO) {
	
		  $scope.item = new Object()
		, $scope.ctrl = {
			  name: 'UserRegistrationCtrl'
			, original: 'Users'  
		}
		, $scope.itemId = -1
		, $scope.itemIndex = -1
		, $scope.loading = true
		, $scope.access = {
			    edit: false
			  , editsimple: false
			  , create: false
			  , createsimple: false
		}
		, $scope.scrollable = {
				  id: -1
				, initDicts: true 
				, initLists: true
		}
		, $scope.selectedItem = new Object()
		, $scope.details = {
				loading: false,
				loader: new Object(),
				showHints: '',
				tabs: {
					physicalPerson: true,
					corporateCustomer: false,
					travelAgency: false
				}
		}
		, $scope.debug = APP.debugInfo('UsersEditCtrl');
		
		APP.defaultEditCtrl($scope, new Object(), new Object(), {
	  		  mode: "edit"
			, isModal: false
			, editItem: {}
			, editItemId: -1
			, excludeList: [ 'users' ]
		}, $servicesStorage, $staticStorage, 'Users', new Object(), $location, $rootScope, toaster, $timeout, APP_INFO);
		
		$scope.saveItem = function (form, callback) {
			if(typeof callback === "undefined"){
				callback = $scope.defaultCallback;
			}
			
			if(form.$valid){
				console.info('$scope.item: ', $scope.item);
				
				$scope.saveItemData(callback);
			}
		};
		
		$scope.saveItemData = function (callback) {
			var daoFunction = $servicesStorage[$scope.ctrl.original + 'Dao'];
			
			$scope.details.loading = true;
			
			$scope.item.relUserDetailses = new Array();
			$scope.item.relUserDetailses.push({ userdetail: $scope.details.item });
			
			var identity = $scope.item.id;
			var	item = JSOG.stringify($scope.item);
			
			$scope.createItem(item, function(result){
				if(callback){
					callback(result);
				}
				else {
					console.info('result: ', result);
					if (angular.isDefined(result.item) && result.item != null) {
						$location.path("/");
					}
					else {
						toaster.pop('error', 'Something went wrong');
					}
				}
			});
		};
		
		$scope.createItem = function (item, callback) {
			var daoFunction = $servicesStorage[$scope.ctrl.original + 'Dao'];
			
			daoFunction().create(item, function (data) {
				$scope.details.loading = false;
				var result = {
					  index: -1
					, item: new Object()
				};
				if(data.success){
					result.item = JSOG.decode(data.data);
				}
				else{
					result.item = null;
				}
				
				callback(result);
			});
		};
		
		$scope.updateItem = function (form) {
			if(APP_INFO.debug){
				console.info('Users#updateItem');
			}

			if(form.$valid){
				$scope.saveItem(form, function(result){
					if(modalSettings.isModal){
						$modalInstance.close(result);
					}
					else {
						$location.path($rootScope.previousPage2);
					}
				});
			}
		};
		
		$scope.validateItem = function (form) {
			if(APP_INFO.debug){
				console.info('Users#validateItem#form: ', form);
			}
			
			$scope.details.showHints = '';
			if(!form.$valid){
				$scope.details.showHints = 'problem';
				if(APP_INFO.debug){
					console.log('----------------');
					var error = form.$error;
				    angular.forEach(error, function(type, typeName){
						console.info('type: ', typeName);
				    	angular.forEach(type, function(field, nameField){
					        if(field.$invalid){
					            var fieldName = field.$name;
					            console.info('field: ', field, ', nameField: ', nameField);
								console.info('	fieldName: ', fieldName, ', nameField: ', nameField);
					        }
				    	});
				    });
					console.log('----------------');
				}
				toaster.pop('warning', 'Please fill in all required fields.');
			}
		};
		
		$scope.random = function () {
			$scope.item.firstname = "test" + APP.randomNumber(0, 100);
			$scope.item.lastname = "test" + APP.randomNumber(0, 100);
			$scope.item.email = "test" + APP.randomNumber(0, 100) + "@test.com";
//			$scope.item.email = "client.taimax@list.ru";
			$scope.item.password = $scope.item.firstname;
			$scope.details.repassword = $scope.item.firstname;
			if($scope.details.tabs.corporateCustomer){
				if (!angular.isDefined($scope.details.item) || $scope.details.item == null) {
					$scope.details.item = new Object();
				}
				$scope.details.item.companyname = "test" + APP.randomNumber(0, 100) + " company";
			}
			else if($scope.details.tabs.travelAgency){
				if (!angular.isDefined($scope.details.item) || $scope.details.item == null) {
					$scope.details.item = new Object();
				}
				$scope.details.item.companyname = "test" + APP.randomNumber(0, 100) + " company";
				$scope.details.item.companysite = "www.test" + APP.randomNumber(0, 100) + "company.com";
			}
		};
		
		$scope.loadItem = function () {
//			APP.afterLoadingDataEditCtrl($scope, $staticStorage, $scope.ctrl.original, modalSettings);
		};
	
		/*---------------------------*/
		
		$scope.init = function(callback) {
			if(callback){
				callback();
			}
		
			$timeout(function(){
				if($scope.access.edit || $scope.access.editsimple){
					$scope.loadItem();
				}
				else {
					$scope.details.loading = false;
					APP.afterLoadingDataEditCtrl($scope, $staticStorage, $scope.ctrl.original, modalSettings);
					$scope.dictionaries();
					$scope.item.physicalperson = true;
					$scope.item.legalentity = false;
				}
				
			}, APP.timeOutCount("Users", $staticStorage));
		};
		
		$scope.dictionaries = function() {
			
		};
		
		/*---------------------------*/
		
		$scope.selectTab = function(owner, name) {
			for(var key in owner) { 
			    owner[key] = false;
			}
			
			owner[name] = true;
			if(name == 'physicalPerson'){
				$scope.item.physicalperson = true;
				$scope.item.legalentity = false;
			}
			else {
				$scope.item.physicalperson = false;
				$scope.item.legalentity = true;
			}
		};
		
		/*---------------------------*/
		
		$scope.init(function() {
//			APP.beforeLoadingDataEditCtrl($scope, $staticStorage, modalSettings, 'Users');
		});
		
		$scope.$on('$destroy', function() {
			for (var key in $scope) {
				if (key.substr(0, 1) != '$' && key != 'this')
					delete $scope[key];
			}
		});
		
	}
})();