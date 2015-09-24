'use strict';

angular.module('shopApp.controllers.static', [])

.run(function ($rootScope, $templateCache, $staticStorage, $location, $timeout) {

	if(!$staticStorage.benchmark().isInit()){
		$staticStorage.benchmark().test();
	}
	
	if($staticStorage.benchmark().isMobile()){
		$timeout(function() {
			console.info('product_cards.top: ', angular.element("#product_cards").offset().top);
			/*
			angular.element("html, body").animate({
				scrollTop : angular.element("#product_cards").offset().top
			}, "slow");
			*/
			var navbar = angular.element("nav.navbar.navbar-default");
			if(!navbar.hasClass("navbar-fixed-top")){
				navbar.addClass("navbar-fixed-top");
			}
			
			var body = angular.element("body");
			if(!body.hasClass("mobile")){
				body.addClass("mobile");
			}
			
			navbar = null;
			body = null;
			
		}, 1500);
	}
	
	$rootScope.$on('$routeChangeSuccess', function() {
		var html = angular.element("html");
		html.removeClass();
		html.addClass(APP.pathToName($location.$$path));
		html = null;
	});
	
	$rootScope.$on('$destroy', function() {
		for (var key in $rootScope) {
			if (key.substr(0, 1) != '$' && key != 'this')
				delete $rootScope[key];
		}
	});
	
	let keyHolder = angular.element("#key_holder");
	if(angular.isDefined(keyHolder) && keyHolder.length > 0){
		let key = keyHolder[0];
		if("c231edae" !== key.value){
			$rootScope.apikey = key;
		}
		keyHolder = null;
		key = null;
	}
	
})

.controller('ShopHotelLandscape2Ctrl', ['$scope', '$servicesStorage', '$localStorage', 'toaster', '$staticStorage', '$timeout', 'APP_INFO',
function ($scope, $servicesStorage, $localStorage, toaster, $staticStorage, $timeout, APP_INFO) {
	
	$scope.scrollable = {
		  pageNumber: 1
		, pageSize: angular.copy($staticStorage.benchmark().batchSize())
		, dataLoading: true
		, initLoading: true
		, scrollableLoading: true
		, isInit: false
	};
	$scope.search = {
		query: ""
	};
	$scope.cities = new Array();
	$scope.details = new Object();
	$scope.customsearch = {
		dellimitter: "AND"
	};
	
	$scope.test = function() {
		$scope.loadDataScrollable();
	};
	
	$scope.searchHotel = function(importantSearch) {
		if (!angular.isDefined(importantSearch) || importantSearch == null) {
			importantSearch = false;
		}
		var goNext = false;
		if(!$staticStorage.benchmark().isMobile()){
			goNext = true;
		}
		else if($staticStorage.benchmark().isMobile() && importantSearch){
			goNext = true;
		}
		
		if (goNext) {
			$scope.scrollable.isInit = true;
			$scope.scrollable.initLoading = true;
			$scope.scrollable.pageNumber = 1;
			$scope.loadData(function() {
				$scope.scrollable.initLoading = false;
			});
		}
	};
	
	$scope.customSearch = function() {
		$scope.loadDataCustom();
	};
	
	$scope.clear = function() {
		$scope.customsearch = new Object();
		$scope.data = null;
		$scope.data = new Array();
		$scope.scrollable.pageNumber = 1;
		$scope.loadDataScrollable();
	};
	
	$scope.loadDataCustom = function(callback) {
		$scope.scrollable.dataLoading = true;
		  
		$staticStorage.ShopServHotelViewSearchDao().customSearch($scope.customsearch, function(data) {
			$scope.scrollable.dataLoading = false;
			if (data.success) {
				$scope.data = null;
				  $scope.data = JSOG.decode(data.data);
			} else {
				toaster.pop('error',data.message);
			}
		});

		if(callback){
		  callback();
		}
	};
	
	$scope.loadData = function(callback) {
		  $scope.scrollable.dataLoading = true;
		  
		  $staticStorage.ShopServHotelViewSearchDao().search2($scope.search.query, function(data) {
			  $scope.scrollable.dataLoading = false;
			  if(data.success){
				  $scope.data = null;
				  $scope.data = JSOG.decode(data.data);
			  }
			  else {
				  toaster.pop('error', data.message);
			  }
		  });
		  
		  if(callback){
			  callback();
		  }
		  else {
			  $scope.scrollable.initLoading = false;
		  }
	};
	
	$scope.loadDataScrollable = function(callback) {
		$scope.scrollable.scrollableLoading = true;
		
		$staticStorage.ShopServHotelViewSearchDao().load($scope.scrollable, function(data) {
			$scope.scrollable.scrollableLoading = false;
			
			if(data.success){
				var oldData = angular.copy($scope.data);
				var data = JSOG.decode(data.data);
				
				$scope.data = null;
				$scope.data = angular.copy($scope.mergeDivided(oldData, data));
				if($staticStorage.benchmark().isPower()){
					$scope.$storage.dataHotel = null;
					$scope.$storage.dataHotel = angular.copy($scope.data);
				}
				data = null;
				oldData = null;
			}
			else {
				toaster.pop('error', data.message);
				$scope.scrollable.pageNumber--;
			}
			
			if(callback){
				callback();
			}
		});
		
		$scope.scrollable.pageNumber++;
	};
	
	$scope.mergeDivided = function (oldData, newData) {
		if (!angular.isDefined(oldData) || oldData == null) {
			oldData = new Array();
		}
		if (!angular.isDefined(newData) || newData == null) {
			newData = new Array();
		}
		
		angular.forEach(newData, function(item, index) {
			var oldItem = APP.loadItem2(item.name, 'name', oldData)
			if ((angular.isDefined(oldItem.item) && oldItem.item != null) && (oldItem.index > -1)) {
				oldData[oldItem.index].data = angular.copy(APP.uniqueArray(oldData[oldItem.index].data.concat(item.data))); 
			}
			else {
				oldData.push(item);
			}
		});
		if(oldData.length == 0){
			oldData = angular.copy(newData);
		}
		
		return oldData;
	};
	
	$scope.loadCities = function () {
		if(APP_INFO.debug){
			console.info(': ', '$scope.loadCities');
		}
		$scope.cities = null;
		if($staticStorage.benchmark().isPower()){
			if(APP_INFO.debug){
				console.info(': ', 'load from storage');
			}
			$scope.cities = $scope.$storage.cities;
		}
		else {
			$scope.cities = new Array();
		}
		
		$servicesStorage.LocationCitiesDao().list({}, function (data) {
			if(APP_INFO.debug){
				console.info('load from server#data: ', data);
			}
			$scope.cities = angular.copy($scope.trimCity(JSOG.decode(data.data)));
			if($staticStorage.benchmark().isPower()){
				if(APP_INFO.debug){
					console.info('save to storage#cities: ', $scope.cities);
				}
				$scope.$storage.cities = $scope.cities;
			}
		});
	};
	
	$scope.trimCity = function (array) {
		if(typeof array === "undefined" || array.length == 0){
			array = new Array();
		}
		
		var newCities = new Array();
		angular.forEach(array, function(item, index) {
			if(newCities.indexOf(item.cityname) == -1){
				newCities.push(item.cityname);
			}
		});
		
		return angular.copy(newCities);
	};
	
	(function() {
		var timer = $timeout(function() {
			$scope.data = null;
			$scope.data = new Array();
			
			if($staticStorage.benchmark().isPower()){
				$scope.$storage = $localStorage.$default({
					dataHotel: []
				});
				$scope.animation = angular.copy($staticStorage.benchmark().storage());
			}
			else {
				$scope.animation = new Object();
				$scope.animation.power = false;
				$scope.$storage = new Object();
			}
			
			if($staticStorage.benchmark().internetSpeed() > 1){
				$scope.data = $scope.$storage.dataHotel;
			}
			$scope.loadCities();
			$scope.loadDataScrollable(function() {
				$scope.scrollable.initLoading = false;
				$scope.scrollable.dataLoading = false;
			});
			
			$timeout.cancel(timer);
		}, 20);
	})();
	
	$scope.$on('$destroy', function() {
		for (var key in $scope) {
			if (key.substr(0, 1) != '$' && key != 'this')
				delete $scope[key];
		}
	});
	
}])

.controller('ShopHotelLandscapeEditCtrl', ['$scope', '$staticStorage', '$servicesStorage', '$localStorage', 'toaster', '$routeParams', '$filter', '$location', '$rootScope', '$modal', 'APP_INFO',
function ($scope, $staticStorage, $servicesStorage, $localStorage, toaster, $routeParams, $filter, $location, $rootScope, $modal, APP_INFO) {
	
	$scope.scrollable = {
		  id: $routeParams.id
	  	, initDicts: true
	  	, initLists: true
		, dataLoading: true
		, timeSettingsInit: false
	}
	, $scope.datePicker = {}
	, $scope.priceFilter = {
		  label: 'currcurrency'
		, value: 'dollar'
	}
	, $scope.reqitem = {
		tmContactEasies: [],
		roomcount: 1,
		tariff: {},
		tariffcurrency: "",
		cashless: 'true'
	}
	, $scope.requestinformation = {
		tmContactEasies: [{ manFoman: true, idcard: false, passport: true }]
	}
	, $scope.detail = {
		currency: true,
		coverimage: "../images/static_default.jpg?mw=500",
	}
	, $scope.details = {
		showHints: "",
		minDate: new Date()
	}
	, $scope.$storage = $localStorage.$default({
		itemServHotel: [],
		help: true
	});
	
// ----------------- 17 июля 2015 г. -----------------
	
	$scope.openRequestPage = function(room, tariff) {
		$scope.openRequestPageData(false, room, tariff);
	};
	
	$scope.openRequestPageDebug = function() {
		$scope.openRequestPageData(true);
	};
	
	$scope.openRequestPageData = function(debug, room, tariff) {
		var modalInstance = $modal.open({
			templateUrl: 'shop_hotel_request_wizzard',
			controller: 'ShopHotelRequestWizzardCtrl',
			backdrop: 'static', 
			resolve: {
				modalSettings: function () { 
					return { 
						item: $scope.item,
						fullRandom: debug,
						room: room,
						tariff: tariff
					}; 
				}
			}
		});
		
		modalInstance.result.then(function (modalResult) {
			
		});
	};
	
	$scope.selectImage = function(image) {
		$scope.detail.coverimage = "../images/" + image.image + "?mw=500";
	};
	
	$scope.pickRoom = function(room) {
		var servhotel = room.servhotel;
		$scope.requestinformation.breakfast = room.breakfast;
		$scope.requestinformation.dictglobalbyfood = room.dictglobalbyfood;
		$scope.reqitem.label = room.servhotel + ' - ' + room.label;
		$scope.reqitem.servhotel = { 
			id: room.servhotelid,
			version: room.servhotelversion
		};
		$scope.reqitem.servhotelroom = room;
		
		if (typeof $scope.reqitem.servhotel.id === 'undefined') {
			console.info('servhotel: ', $scope.reqitem.servhotel);
			throw new Error("Hotel haven't got an Id: ");
		}				
		
//		Uncomment this, if you use entity. Now using view.
//		$scope.reqitem.label = room.servhotel.label + ' - ' + room.label;
		
		$scope.reqitem.tariff = APP.loadTariffByHumanNumber($scope.requestinformation.tmContactEasies.length, room.tariffGeneralRate);
		
		if(room.servhotel.timerace){
			$scope.reqitem.race = new Date(room.servhotel.timerace);
			$scope.convertDateAndTime($scope.reqitem.race, 'race');
		}
		
		if(room.servhotel.departure){
			$scope.reqitem.departure = new Date(room.servhotel.timedeparture);
			$scope.convertDateAndTime($scope.reqitem.departure, 'departure');
		}
		
		room.servhotel = servhotel;
		$scope.paymetTypeChange();
		
	};
	
	$scope.pickRoom2 = function(room, humannumber) {
		$scope.pickRoom(room);
		if(typeof humannumber === "undefined"){
			humannumber = 1;
		}
		
		if(humannumber > 1){
			for (var index = 0; index < humannumber - 1; index++) {
				$scope.add();
			}
		}
	};
	
	$scope.validateItem = function (form) {
		$scope.details.showHints = '';
		if(!form.$valid){
			$scope.details.showHints = 'problem';
		}
	};
	
	$scope.finalAcceptWithValidate = function (form) {
		if(form.$valid){
			$scope.submit();
		}
	};
	
	$scope.submit = function () {
		$rootScope.loading = true;
		
		$scope.reqitem.servhotelroom = { 
			id: $scope.reqitem.servhotelroom.id,
			version: $scope.reqitem.servhotelroom.version
		};
		
		$scope.reqitem.tariff = {
			id: $scope.reqitem.tariff.id
		};
		
		if($scope.reqitem.cashless == 'true'){
			$scope.reqitem.paymenttype = true;
		}
		else if($scope.reqitem.cashless == 'false'){
			$scope.reqitem.paymenttype = false;
		}
		
		if(!angular.isDefined($scope.reqitem.tariff.id)){
			delete $scope.reqitem.tariff;
		}
		
		$scope.reqitem.price = $scope.reqitem.totalprice;
		if (!angular.isDefined($scope.reqitem.descr) || $scope.reqitem.descr == null || $scope.reqitem.descr == "") {
			$scope.reqitem.descr = $scope.totalpriceMarkDown();
		}
		
		var request = $scope.createLeads();
		
		$staticStorage.ReqServHotelDao().create(request, function (response) {
			if(response.success){
				toaster.pop('success', "OK");
				$location.path('/');
			}
			else{
				toaster.pop('error', response.message);
			}
			$rootScope.loading = false;
		});
	};
	
	$scope.randomRequest = function() {
		var index = 0;
		var roomIndex = APP.randomNumber(0, $scope.item.rooms.length - 1);
		var locationCountriesIndex = APP.randomNumber(0, $scope.dataLocationCountries.length - 1);
		
		$scope.pickRoom($scope.item.rooms[roomIndex]);
		$scope.accept();
		$scope.reqitem.roomcount = 1;
		$scope.requestinformation.tmContactEasies[index].label = "Test" + APP.randomNumber(0, 100);
		$scope.requestinformation.tmContactEasies[index].email = "mail" + APP.randomNumber(0, 100) + '@test.com';
		$scope.requestinformation.tmContactEasies[index].locationcountries =
			$scope.dataLocationCountries[locationCountriesIndex]
		;
		$scope.requestinformation.tmContactEasies[index].identitynumber = "AA-" + APP.randomNumber(0, 100);
	};
	
	$scope.accept = function() {
		$scope.reqitem.init = true;
	};
	
	$scope.paymetTypeChange = function() {
		if($scope.reqitem.cashless == 'true'){
			$scope.reqitem.singleprice = $scope.reqitem.tariff.corporateRateCost;
			$scope.reqitem.tariffcurrency = $scope.reqitem.tariff.corporateRateCurrencyname;
		}
		else if($scope.reqitem.cashless == 'false'){
			$scope.reqitem.singleprice = $scope.reqitem.tariff.originalRateCost;
			$scope.reqitem.tariffcurrency = $scope.reqitem.tariff.originalRateCurrencyname;
		}
		
		$scope.calculateTotalprice();
	};
	
	$scope.totalpriceMarkDown = function() {
		var result = "";
		result = '(' + $scope.reqitem.singleprice + '*' + $scope.reqitem.datedifference + ')';
		result = result + ' * ' + $scope.reqitem.roomcount;
		
		return result;
	};
	
	$scope.convertDateAndTime = function(value, name) {
		if(name == 'race'){
			$scope.details.minDate = value;
		}
		
		$scope.reqitem[name] = $filter('date')(value, 'yyyy-MM-dd HH:mm');
		
		
		if($scope.scrollable.timeSettingsInit == true){
			var date1 = APP.parseData($scope.reqitem.race);
			var date2 = APP.parseData($scope.reqitem.departure);
			
			if(date2 < date1){
				var distance = APP.daysBetween(date1, date2);
				date2.setDate(date1.getDate() + (-distance)); 
				$scope.reqitem.departure = $filter('date')(date2, 'yyyy-MM-dd HH:mm');
			}
			
			APP.calculateNumberOfNights(
					$scope.item.timerace, 
					$scope.item.timedeparture, 
					$scope.item.timeearlyrace, 
					$scope.item.timelatedeparture, 
					date1, 
					date2, 
					function(result) {
				$scope.reqitem.datedifference = result;
				
				if($scope.reqitem.datedifference == 1){
					$scope.reqitem.datedifferencetype = 1;
				}
				else if($scope.reqitem.datedifference > 1 && $scope.reqitem.datedifference < 5){
					$scope.reqitem.datedifferencetype = 2;
				}
				else {
					$scope.reqitem.datedifferencetype = 3;
				}
			});
		}
		
		$scope.calculateTotalprice();
	};
	
	$scope.createLeads = function() {
		$scope.reqitem.sync = false;
		
		$scope.requestinformation.tmContactEasies.forEach(function(item) {
			item.locationcountries = {
				id: item.locationcountries.id,
				version: item.locationcountries.version
			};
			$scope.reqitem.tmContactEasies.push(item);
		});
		
		return JSOG.stringify($scope.reqitem);
	};
	
	$scope.calculateTotalprice = function() {
		$scope.reqitem.totalprice = ($scope.reqitem.singleprice * $scope.reqitem.datedifference) * $scope.reqitem.roomcount;
	};
	
	$scope.open = function($event, name) {
		$event.preventDefault();
		$event.stopPropagation();

	    $scope.datePicker[name] = true;
	};
	
	$scope.addLead = function() {
		$scope.requestinformation.tmContactEasies.push({ manFoman: true, idcard: false, passport: true });
		$scope.calculateTotalprice();
	};
	
	$scope.deleteElement = function(element, source) {
		if(APP_INFO.debug){
			console.info('element: ', element);
			console.info('source: ', source);
		}
		var index = source.indexOf(element);
		if(APP_INFO.debug){
			console.info('index: ', index);
		}
		source.splice(index, 1);
	};
	
	$scope.changeDeparture = function(distance, step) {
		var innerStep = 0;
		if(step == 'day'){
			innerStep = 1;
		}
		else if(step == 'week'){
			innerStep = 1 * 7;
		}
		
		var value = APP.parseData($scope.reqitem.race);
		var value2 = APP.parseData($scope.reqitem.departure);;
		
		value.setHours(value2.getHours(), value2.getMinutes());
		
		value.setDate(value.getDate() + (innerStep * distance));
		$scope.setDeparture(value);
	};
	
	$scope.setDeparture = function(value) {
		$scope.convertDateAndTime(value, 'departure');
	};
	
	$scope.timeSettings = function(item) {
		$scope.reqitem.race = new Date();
		$scope.reqitem.departure = new Date();
		
		if(item.timerace){
			
		}
		else {
			item.timerace = '2000-01-01 12:00';
		}
		
		if(item.timedeparture){
			
		}
		else {
			item.timedeparture = '2000-01-01 12:00';
		}
		
		if(item.timeearlyrace){
			
		}
		else {
			item.timeearlyrace = '2000-01-01 06:00';
		}
		
		if(item.timelatedeparture){
			
		}
		else {
			item.timelatedeparture = '2000-01-01 18:00';
		}
		
		var timerace = APP.parseData(item.timerace);
		var timedeparture = APP.parseData(item.timedeparture);
		
		$scope.reqitem.race.setHours(timerace.getHours(), timerace.getMinutes());
		$scope.reqitem.departure.setHours(timedeparture.getHours(), timedeparture.getMinutes());
		
		$scope.convertDateAndTime($scope.reqitem.race, 'race');
		$scope.convertDateAndTime($scope.reqitem.departure, 'departure');
		
		$scope.scrollable.timeSettingsInit = true;
		
		$scope.reqitem.totalprice = 0;
		$scope.changeDeparture(1, 'day');
		$scope.convertDateAndTime($scope.reqitem.departure, 'departure');
	};
	
	$scope.gallerySettings = function(item) {
		if (angular.isDefined(item.images) && item.images != null) {
			if(item.images.length > 0){
				$scope.selectImage(item.images[0]);
			}
		}
	};
	
	setTimeout(function() {

		$staticStorage.ShopServHotelViewSearchDao().findById($scope.scrollable, function (data) {
			if(data.success){
				$scope.item = JSOG.decode(data.data);
				$scope.timeSettings($scope.item);
				$scope.gallerySettings($scope.item);
			}
			else {
				toaster.pop('error', data.message);
			}
			
			$scope.scrollable.dataLoading = false;
		});
		
//		$scope.dataDictGlobalByFoodId = $scope.$storage.dataDictGlobalByFoodId; 
//		$servicesStorage.DictGlobalDao().list({}, function (data) {
//			$scope.dataDictGlobalByFoodId = JSOG.decode(data.data); 
//			$scope.$storage.dataDictGlobalByFoodId = $scope.dataDictGlobalByFoodId;
//		});
		
		$scope.dataLocationCountries = $scope.$storage.dataLocationCountries;
		$servicesStorage.LocationCountriesDao().list({}, function (data) {
			$scope.dataLocationCountries = JSOG.decode(data.data); 
			$scope.$storage.dataLocationCountries = $scope.dataLocationCountries;
		});
	}, 100);
	
}])

.controller('ShopHotelRequestWizzardCtrl', ['$scope', '$modalInstance', 'modalSettings', '$timeout', '$filter', '$staticStorage', '$servicesStorage', '$rootScope', 'toaster', 'WizardHandler', '$location', 'APP_INFO',
function ($scope, $modalInstance, modalSettings, $timeout, $filter, $staticStorage, $servicesStorage, $rootScope, toaster, WizardHandler, $location, APP_INFO) {
	
	$scope.item = new Object();
	
	$scope.details = new Object();
	$scope.details.room = new Object();
	$scope.details.tariffGeneralRate = new Array();
	$scope.details.tariff = new Object();
	$scope.details.showHints = "";
	$scope.details.conditionagree = false;
	$scope.details.capacities = new Array();
	
	$scope.reqitem = new Object();
	$scope.reqitem.tmContactEasies = new Array();
	
	$scope.requestinformation = new Object();
	$scope.requestinformation.tmContactEasies = new Array();
	
	$scope.datePicker = new Object();
	
// ----------------- 17 июля 2015 г. -----------------
	
	$scope.init = function () {
		$scope.item = angular.copy(modalSettings.item);
		$scope.roomSettings();
		
		if (angular.isDefined(modalSettings.room) && modalSettings.room != null) {
			$scope.details.room = modalSettings.room; 
			$scope.roomSelect();
		}
		
		if (angular.isDefined(modalSettings.tariff) && modalSettings.tariff != null) {
			$scope.tariffSelect(angular.copy(modalSettings.tariff));
		}
		
		$servicesStorage.LocationCountriesDao().list({}, function (data) {
			$scope.dataLocationCountries = JSOG.decode(data.data);
			
			if(modalSettings.fullRandom){
				$scope.fullRandom();
			}
		});
		
	};
	
	$scope.roomSettings = function () {
		if(angular.isDefined($scope.item) && angular.isDefined($scope.item.rooms)) {
			if($scope.item.rooms.length > 0){
				$scope.details.room = angular.copy($scope.item.rooms[0]);
				$scope.roomSelect();
			}
		}
	};
	
	$scope.roomSelect = function () {
		$scope.details.tariffGeneralRate = null;
		$scope.details.tariffGeneralRate = angular.copy($scope.details.room.tariffGeneralRate);
	};
	
	$scope.tariffSelect = function (tarriff) {
		$scope.details.tariff = angular.copy(tarriff);
		
		if (!angular.isDefined($scope.details.tariff.humannumber) || $scope.details.tariff.humannumber == null) {
			$scope.details.tariff.humannumber = 1;
		}
		$scope.details.capacities = null;
		$scope.details.capacities = new Array();
		for (var index = 0; index < $scope.details.tariff.humannumber; index++) {
			$scope.details.capacities.push(index + 1);
		}
		
		$scope.afterTariffSelected();
	};
	
	$scope.tariffRandom = function () {
		var indexRandomRoom = APP.randomNumber(0, $scope.item.rooms.length - 1);
		$scope.details.room = angular.copy($scope.item.rooms[indexRandomRoom]);
		$scope.roomSelect();
		
		var indexRandomTarriff = APP.randomNumber(0, $scope.details.tariffGeneralRate.length - 1);
		$scope.tariffSelect(angular.copy($scope.details.tariffGeneralRate[indexRandomTarriff]));
		$scope.afterTariffSelected();
	};
	
	$scope.requestRandom = function () {
		$scope.reqitem.roomcount = APP.randomNumber(1, 5);
		angular.forEach($scope.requestinformation.tmContactEasies, function(item, index) {
			var countryIndex = APP.randomNumber(0, $scope.dataLocationCountries.length - 1);
			
			item.manFoman = APP.randomBoolean();
			item.label = "Test" + APP.randomNumber(0, 100);
			item.email = "mail" + APP.randomNumber(0, 100) + '@test.com';
			item.locationcountries = $scope.dataLocationCountries[countryIndex];
			item.identitynumber = "AA-" + APP.randomNumber(0, 100);
		});
		
	};
	
	$scope.fullRandom = function () {
		$timeout(function() {
			$scope.tariffRandom();
			$scope.requestRandom();
		}, 20);
	};
	
	$scope.afterTariffSelected = function () {
		$scope.reqitem.cashless = 'true';
		$scope.reqitem.roomcount = 1;
		
		$scope.reqitem.maxcapacity = $scope.details.capacities[$scope.details.capacities.length - 1];
		
		for (var index = 0; index < $scope.details.tariff.humannumber; index++) {
			$scope.addLead();
		}
		
		$scope.timeSettings(angular.copy($scope.item));
		
		var servhotel = $scope.details.room.servhotel;
		$scope.reqitem.label = $scope.details.room.servhotel + ' - ' + $scope.details.room.label;
		$scope.reqitem.servhotel = { 
			id: $scope.details.room.servhotelid,
			version: $scope.details.room.servhotelversion
		};
		$scope.reqitem.servhotelroom = $scope.details.room;
		
		$scope.details.room.servhotel = servhotel;
		servhotel = null;
		
		$scope.paymetTypeChange();
	};
	
// ----------------- 17 июля 2015 г. -----------------
	
	$scope.open = function($event, name) {
		$event.preventDefault();
		$event.stopPropagation();

	    $scope.datePicker[name] = true;
	};
	
	
	$scope.paymetTypeChange = function() {
		if($scope.reqitem.cashless == 'true'){
			$scope.reqitem.singleprice = $scope.details.tariff.corporateRateCost;
			$scope.reqitem.tariffcurrency = $scope.details.tariff.corporateRateCurrencyname;
		}
		else if($scope.reqitem.cashless == 'false'){
			$scope.reqitem.singleprice = $scope.details.tariff.originalRateCost;
			$scope.reqitem.tariffcurrency = $scope.details.tariff.originalRateCurrencyname;
		}
		
		$scope.calculateTotalprice();
	};
	
	$scope.totalpriceMarkDown = function() {
		var result = "";
		result = '(' + $scope.reqitem.singleprice + '*' + $scope.reqitem.datedifference + ')';
		result = result + ' * ' + $scope.reqitem.roomcount;
		
		return result;
	};
	
	$scope.convertDateAndTime = function(value, name) {
		$scope.reqitem[name] = $filter('date')(value, 'yyyy-MM-dd HH:mm');
		
		if($scope.details.timeSettingsInit == true){
			var date1;
			var date2;
			
			if(typeof $scope.reqitem.race === "object"){
				date1 = $scope.reqitem.race;
			}
			else {
				date1 = APP.parseData($scope.reqitem.race);
			}
			
			if(typeof $scope.reqitem.departure === "object"){
				date2 = $scope.reqitem.departure;
			}
			else {
				date2 = APP.parseData($scope.reqitem.departure);
			}
			
			if(date2 < date1){
				var distance = APP.daysBetween(date1, date2);
				date2.setDate(date1.getDate() + (-distance)); 
				$scope.reqitem.departure = $filter('date')(date2, 'yyyy-MM-dd HH:mm');
			}
			
			APP.calculateNumberOfNights(
					$scope.item.timerace, 
					$scope.item.timedeparture, 
					$scope.item.timeearlyrace, 
					$scope.item.timelatedeparture, 
					date1, 
					date2, 
					function(result) {
				$scope.reqitem.datedifference = result;
				
				if($scope.reqitem.datedifference == 1){
					$scope.reqitem.datedifferencetype = 1;
				}
				else if($scope.reqitem.datedifference > 1 && $scope.reqitem.datedifference < 5){
					$scope.reqitem.datedifferencetype = 2;
				}
				else {
					$scope.reqitem.datedifferencetype = 3;
				}
			});
		}
		
		$scope.calculateTotalprice();
	};
	
	$scope.calculateTotalprice = function() {
		$scope.reqitem.totalprice = ($scope.reqitem.singleprice * $scope.reqitem.datedifference) * $scope.reqitem.roomcount;
	};
	
	$scope.timeSettings = function(item) {
		$scope.reqitem.race = new Date();
		$scope.reqitem.departure = new Date();
		
		if (!angular.isDefined(item.timerace)) {
			item.timerace = '2000-01-01 12:00';
		}
		
		if (!angular.isDefined(item.timedeparture)) {
			item.timedeparture = '2000-01-01 12:00';
		}
		
		if (!angular.isDefined(item.timeearlyrace)) {
			item.timeearlyrace = '2000-01-01 06:00';
		}
		
		if (!angular.isDefined(item.timelatedeparture)) {
			item.timelatedeparture = '2000-01-01 18:00';
		}
		
		var timerace = APP.parseData(item.timerace);
		var timedeparture = APP.parseData(item.timedeparture);
		
		$scope.reqitem.race.setHours(timerace.getHours(), timerace.getMinutes());
		$scope.reqitem.departure.setHours(timedeparture.getHours(), timedeparture.getMinutes());
		
		$scope.convertDateAndTime($scope.reqitem.race, 'race');
		$scope.convertDateAndTime($scope.reqitem.departure, 'departure');
		
		$scope.details.timeSettingsInit = true;
		
		$scope.reqitem.totalprice = 0;
		$scope.changeDeparture(1, 'day');
		$scope.convertDateAndTime($scope.reqitem.departure, 'departure');
	};
	
	$scope.addLead = function() {
		$scope.requestinformation.tmContactEasies.push({ manFoman: true, idcard: false, passport: true });
		$scope.calculateTotalprice();
	};
	
	$scope.deleteElement = function(element, source) {
		var index = source.indexOf(element);
		source.splice(index, 1);
	};
	
	$scope.changeDeparture = function(distance, step) {
		var innerStep = 0;
		if(step == 'day'){
			innerStep = 1;
		}
		else if(step == 'week'){
			innerStep = 1 * 7;
		}
		
		var value = APP.parseData($scope.reqitem.race);
		var value2 = APP.parseData($scope.reqitem.departure);;
		
		value.setHours(value2.getHours(), value2.getMinutes());
		
		value.setDate(value.getDate() + (innerStep * distance));
		$scope.setDeparture(value);
	};
	
	$scope.setDeparture = function(value) {
		$scope.convertDateAndTime(value, 'departure');
	};
	
	
// ----------------- 17 июля 2015 г. -----------------
	
	$scope.createLeads = function() {
		$scope.reqitem.sync = false;
		
		$scope.requestinformation.tmContactEasies.forEach(function(item) {
			if (angular.isDefined(item.locationcountries)) {
				item.locationcountries = {
						id: item.locationcountries.id,
						version: item.locationcountries.version
				};
			}
			
			$scope.reqitem.tmContactEasies.push(item);
		});
		
		return JSOG.stringify($scope.reqitem);
	};
	
	$scope.submit = function (callback) {
		$rootScope.loading = true;
		
		$scope.reqitem.servhotelroom = { 
			id: $scope.reqitem.servhotelroom.id,
			version: $scope.reqitem.servhotelroom.version
		};
		
		$scope.reqitem.tariff = {
			id: $scope.details.tariff.id,
			version: $scope.details.tariff.paymentTariffVersion
		};
		
		if($scope.reqitem.cashless == 'true'){
			$scope.reqitem.paymenttype = true;
		}
		else if($scope.reqitem.cashless == 'false'){
			$scope.reqitem.paymenttype = false;
		}
		
		if(!angular.isDefined($scope.reqitem.tariff.id)){
			delete $scope.reqitem.tariff;
		}
		
		$scope.reqitem.price = $scope.reqitem.totalprice;
		if (!angular.isDefined($scope.reqitem.descr) || $scope.reqitem.descr == null || $scope.reqitem.descr == "") {
			$scope.reqitem.descr = $scope.totalpriceMarkDown();
		}
		
		var request = $scope.createLeads();
		
		$staticStorage.ReqServHotelDao().create(request, function (response) {
			$rootScope.loading = false;
			
			if(callback){
				callback(response);
			}
		});
	};
	
	$scope.validateItem = function (form) {
		$scope.details.showHints = '';
		if(!form.$valid){
			$scope.details.showHints = 'problem';
		}
	};
	
	$scope.beforeAcceptWithValidate = function (form) {
		if(form.$valid){
			WizardHandler.wizard().next();
		}
	};
	
	$scope.finalAcceptWithValidate = function (form) {
		if(form.$valid){
			$scope.finalAccept();
		}
	};
	
	$scope.finalAccept = function () {
		$scope.submit(function(response) {
			if(response.success){
				toaster.pop('success', "OK");
			}
			else{
				toaster.pop('error', response.message);
			}
			
			$location.path('/');
			$modalInstance.close(response);
		});
	};
	
	$scope.finalCancel = function () {
		$modalInstance.dismiss('cancel');
	};
	
	$scope.finishedWizard = function () {
		$scope.finalAccept();
	};
	
// ----------------- 17 июля 2015 г. -----------------
	
	$scope.init();
	
}]);

