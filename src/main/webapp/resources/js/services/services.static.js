'use strict';

angular.module('shopApp.services.static', ['ngResource'])

.service('$benchmark', ['$localStorage', '$q', 'APP_INFO',
function($localStorage, $q, APP_INFO) {
	var $storage = $localStorage.$default({});
	var key = APP_INFO.prefix + '-benchmark_result';
	(function() {
		if(typeof $storage[key] == "undefined"){
			$storage[key] = {};
		}
	}());
	
	this.isInit = function() {
		var result = (typeof $storage[key] != "undefined");
		
		if(result){
			if(this.version() == 0 || this.version() != APP_INFO.simple_version){
				result = false;
			}
		}
		
		return result;
	};
	
	this.isBuzy = function() {
		return this.readProperty('buzy', false);
	};
	
	this.drop = function() {
		delete $storage[key];
	};
	
	this.storage = function() {
		return $storage[key];
	};
	
	this.settingsKey = function() {
		return key;
	};
	
	this.changeSettings = function(settings) {
		if(typeof settings == "undefined"){
			
		}
		else if(typeof settings == "object"){
			
		}
		else {
			if(settings == 'high'){
				$storage[key].batch_size = 30;
				$storage[key].power_level = 1;
				$storage[key].power_string = 'high';
				$storage[key].allow_modal = true;
				$storage[key].power = true;
			}
			else if(settings == 'normal'){
				$storage[key].batch_size = 20;
				$storage[key].power_level = 2;
				$storage[key].power_string = 'normal';
				$storage[key].allow_modal = false;
				$storage[key].power = false;
			}
			else if(settings == 'low'){
				$storage[key].batch_size = 10;
				$storage[key].power_level = 3;
				$storage[key].power_string = 'low';
				$storage[key].allow_modal = false;
				$storage[key].power = false;
			}
		}
	};
	
	var convertToBatch = function(benchmark_result) {
		var output = 5;
		
		if(benchmark_result > -1 && benchmark_result < 21){
			output = 25;
		}
		else if (benchmark_result > 20 && benchmark_result < 51){
			output = 20;
		}
		else if (benchmark_result > 50 && benchmark_result < 101){
			output = 15;
		}
		else if (benchmark_result > 100 && benchmark_result < 201){
			output = 10;
		}
		
		return output;
	};
	
	this.testFPS = function() {
		var fps = 0, now, lastUpdate = (new Date)*1 - 1;

		var fpsFilter = 50;

		function drawFrame(){
		  var thisFrameFPS = 1000 / ((now=new Date) - lastUpdate);
		  fps += (thisFrameFPS - fps) / fpsFilter;
		  lastUpdate = now * 1 - 1;
		  $timeout(function() {
			  drawFrame
		  }, 1);
		}

		var fpsTestArray = new Array(60);
		for (var index = 0; index < fpsTestArray.length; index++) {
			fpsTestArray[index] = fps.toFixed(1);
			console.info('fps: ', fpsTestArray[index]);
			APP.sleep(16, $q)
		}
		
		$storage[key]['fps'] = APP.AVG(fpsTestArray);
	};
	
	this.test = function() {
		if(APP_INFO.debug){
			console.info('test: ', 'start testing machine');
		}
		$storage[key] = {
			buzy: true	
		};
		var deferred = $q.defer();

		var timer = setTimeout(function() {
			var start = new Date().getTime();
			var array = new Array(2000000);
			for (var i = 0; i < array.length; i++) {
				array[i] = i * (i + 1) / 2;
			}
			var elapsed = new Date().getTime() - start;
//			#---------------------------------------
			$storage[key] = {
				  batch_size: convertToBatch(elapsed)
				, power: false
				, power_level: 3
				, power_string: 'low'
				, allow_modal: false
				, buzy: false
				, elapsed_time: elapsed
				, cacheble: false
				, version: APP_INFO.simple_version
			};
			
			if(elapsed > -1 && elapsed < 21){
				$storage[key].power_level = 1;
				$storage[key].power_string = 'high';
//				$storage[key].allow_modal = true;
				$storage[key].power = true;
			}
			else if (elapsed > 50 && elapsed < 201){
				$storage[key].power_level = 2;
				$storage[key].power_string = 'normal';
			}
			
			if(APP_INFO.debug){
				console.info('testing result: ', $storage[key]);
			}
//			#---------------------------------------
			
			deferred.resolve($storage[key]);
			clearTimeout(timer);
	    	timer = null;
		}, 100);
		
		return deferred.promise;
	};
	
	this.fps = function() {
		return this.readProperty('fps', 30);
	};
	
	this.version = function() {
		return this.readProperty('version', 0);
	};
	
	this.batchSize = function() {
		if(!this.isFastInternetSpeed()){
			return 5;
		}
		
		return this.readProperty('batch_size', 5);
	};
	
	this.isPower = function() {
		return this.readProperty('power', false);
	};
	
	this.isModal = function() {
		return this.readProperty('allow_modal', false);
	};
	
	this.isCacheble = function() {
		return this.readProperty('cacheble', false);
	};
	
	this.powerLevel = function() {
		return this.readProperty('power_level', 3);
	};
	
	this.readProperty = function(name, default_value) {
		var value = default_value;
		
		if(typeof $storage[key] == "undefined" || typeof $storage[key][name] == "undefined"){
			this.test().then(function(result) {
				return result[name];
			})
		}
		else {
			return value = $storage[key][name];
		}
	}
	
	this.isAndroid = function() {
		return navigator.userAgent.toLowerCase().indexOf("android") > -1;
	};
	
	this.iOS = function() {
		var platform = navigator.platform;
		return (platform == 'iPad' || platform == 'iPhone' || platform == 'iPod');
	};
	
	this.isWindows = function() {
		return navigator.appVersion.indexOf("Win") > -1;
	};
	
	this.isMacOS = function() {
		return navigator.appVersion.indexOf("MacOS") > -1;
	};
	
	this.isLinux = function() {
		return navigator.appVersion.indexOf("Linux") > -1;
	};
	
	this.isUnix = function() {
		return navigator.appVersion.indexOf("X11") > -1;
	};
	
	this.isMobile = function() {
		if(/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
			return true;
		}
		
		return false;
	};	
	
	this.internetSpeed = function() {
		var iSpeed = APP.getCookie("internet_speed");
		if(typeof iSpeed == "undefined"){
			return 3;
		}
		
		if(iSpeed > -1 && iSpeed < 5001){
			return 1;
		}
		else if(iSpeed > 5000 && iSpeed < 10001){
			return 2;
		}
		
		return iSpeed;
	};
	
	this.isFastInternetSpeed = function() {
		var iSpeed = this.internetSpeed();
		
		if(iSpeed == 1 && iSpeed == 2){
			return true;
		}
		
		return false;
	};
	
	this.timeout = function() {
		var timeout = 100;
		
		if(this.isMobile()){
			timeout = 200;
		}
		
		if(!this.isFastInternetSpeed()){
			timeout = 10;
		}
		
		return timeout;
	};
	
}])

.factory('$debounce', ['$rootScope', '$browser', '$q', '$exceptionHandler',
function($rootScope, $browser, $q, $exceptionHandler) {
       var deferreds = {},
           methods = {},
           uuid = 0;

       function debounce(fn, delay, invokeApply) {
           var deferred = $q.defer(),
               promise = deferred.promise,
               skipApply = (angular.isDefined(invokeApply) && !invokeApply),
               timeoutId, cleanup,
               methodId, bouncing = false;

           // check we dont have this method already registered
       angular.forEach(methods, function(value, key) {
           if(angular.equals(methods[key].fn, fn)) {
               bouncing = true;
               methodId = key;
           }
       })

       // not bouncing, then register new instance
       if(!bouncing) {
           methodId = uuid++;
           methods[methodId] = {fn: fn};
       } else {
           // clear the old timeout
           deferreds[methods[methodId].timeoutId].reject('bounced');
           $browser.defer.cancel(methods[methodId].timeoutId);
       }

       var debounced = function() {
           // actually executing? clean method bank
           delete methods[methodId];

           try {
               deferred.resolve(fn());
           } catch(e) {
               deferred.reject(e);
               $exceptionHandler(e);
           }

           if (!skipApply) $rootScope.$apply();
       };

       timeoutId = $browser.defer(debounced, delay);

       // track id with method
       methods[methodId].timeoutId = timeoutId;

       cleanup = function(reason) {
           delete deferreds[promise.$$timeoutId];
       };

       promise.$$timeoutId = timeoutId;
       deferreds[timeoutId] = deferred;
       promise.then(cleanup, cleanup);

       return promise;
   }


   // similar to angular's $timeout cancel
   debounce.cancel = function(promise) {
       if (promise && promise.$$timeoutId in deferreds) {
    	   deferreds[promise.$$timeoutId].reject('canceled');
           return $browser.defer.cancel(promise.$$timeoutId);
       }
       return false;
   };

   return debounce;
}])

.factory('docViewer', function ($resource) {
	return $resource('..' + '/viewer/document', {}, {
		view:   { method: 'POST' },
		simple: { method: 'POST', url: '../viewer/document/simple' }
	});
})

.factory('shopServHotelViewSearch', function ($resource) {
	return $resource('..' + '/data/shopservhotelview/search', {}, {
		search:  		{ method: 'POST' },
		search2:  		{ method: 'POST', url: '..' + '/data/shopservhotel2view/search2' },
		customSearch:  	{ method: 'POST', url: '..' + '/data/shopservhotelview/custom-search' },
		load:	  		{ method: 'GET', url: '..' + '/data/shopservhotel2view/scrollable' },
		findById:  		{ method: 'GET', url: '..' + '/data/shopservhotel2view/:id', params: { id: '@id' } }
	});
})

.factory('LogsServiceList', function ($resource) {
	return $resource('..' + '/data/logs', {}, {
		list:  { method: 'GET' }
	});
})

.factory('LocalizationServiceList', function ($resource) {
	return $resource('..' + '/data/localization', {}, {
		list:  { method: 'GET' }
	});
})

.factory('operationDao', function ($resource) {
	return $resource('..' + '/data/operation', {}, {
		operation:  { method: 'POST' }
	});
})

.factory('userDao', function ($resource) {
	return $resource('..' + '/data/current-user', {}, {
		current_user:  { method: 'POST' }
	});
})

.factory('timelineDao', function ($resource) {
	return $resource('..' + '/data/timelineview', {}, {
		list:  { method: 'POST' }
	});
})

.factory('customReqServHotelDao', function ($resource) {
	return $resource('..' + '/data/reqservhotel/custom', {}, {
		 create: { method: 'POST' }
	});
})

.service('$staticStorage', function($benchmark, $debounce, LogsServiceList, LocalizationServiceList, operationDao, userDao, timelineDao, customReqServHotelDao, shopServHotelViewSearch, docViewer) {
	return {
		benchmark: function() {
			return $benchmark;
		}
		, debounce: function() {
			return $debounce;
		}
		, LogsServiceList: function() {
			return LogsServiceList;
		}
		, LocalizationServiceList: function() {
			return LocalizationServiceList;
		}
		, OperationDao: function() {
			return operationDao;
		}
		, UserDao: function() {
			return userDao;
		}
		, TimelineDao: function() {
			return timelineDao;
		}
		, ReqServHotelDao: function() {
			return customReqServHotelDao;
		}
		, ShopServHotelViewSearchDao: function() {
			return shopServHotelViewSearch;
		}
		, DocViewer: function() {
			return docViewer;
		}
		, modules : function() {
			return {
				data : [
				        {
				      	  "name": "CurrCourse"
				      	, "nameRus": "Курс"
				      	, "description": "Курс"
				      	, "connections": []
				      	, "group": "Curr"
				      	, "url": "CurrcourseList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "CurrCurrency"
				      	, "nameRus": "Валюта"
				      	, "description": "Валюта"
				      	, "connections": []
				      	, "group": "Curr"
				      	, "url": "CurrcurrencyList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "DictGlobal"
				      	, "nameRus": "Справочник"
				      	, "description": "Справочник"
				      	, "connections": []
				      	, "group": "Dict"
				      	, "url": "DictglobalList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "DocDocuments"
				      	, "nameRus": "Документы"
				      	, "description": "Документы"
				      	, "connections": []
				      	, "group": "Doc"
				      	, "url": "DocdocumentsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "GroupGlobal"
				      	, "nameRus": "Группа"
				      	, "description": "Группа"
				      	, "connections": []
				      	, "group": "Group"
				      	, "url": "GroupglobalList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "InfoContactInformation"
				      	, "nameRus": "Контактная информация"
				      	, "description": "Контактная информация"
				      	, "connections": []
				      	, "group": "Info"
				      	, "url": "InfocontactinformationList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "InfoServices"
				      	, "nameRus": "Информационные услуги"
				      	, "description": "Информационные услуги"
				      	, "connections": []
				      	, "group": "Info"
				      	, "url": "InfoservicesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "LocationAddress"
				      	, "nameRus": "Адрес"
				      	, "description": "Адрес"
				      	, "connections": []
				      	, "group": "Location"
				      	, "url": "LocationaddressList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "LocationCities"
				      	, "nameRus": "Города"
				      	, "description": "Города"
				      	, "connections": []
				      	, "group": "Location"
				      	, "url": "LocationcitiesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "LocationCountries"
				      	, "nameRus": "Страны"
				      	, "description": "Страны"
				      	, "connections": []
				      	, "group": "Location"
				      	, "url": "LocationcountriesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "LocationTypePlacement"
				      	, "nameRus": "Тип размещения"
				      	, "description": "Тип размещения"
				      	, "connections": []
				      	, "group": "Location"
				      	, "url": "LocationtypeplacementList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentAccount"
				      	, "nameRus": "Взаиморасчеты с юр. лицами"
				      	, "description": "Взаиморасчеты с юр. лицами"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymentaccountList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentAccountRecord"
				      	, "nameRus": "Запись"
				      	, "description": "Запись"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymentaccountrecordList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentContact"
				      	, "nameRus": "Взаиморасчеты с физ. лицами"
				      	, "description": "Взаиморасчеты с физ. лицами"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymentcontactList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentContactRecord"
				      	, "nameRus": "Запись"
				      	, "description": "Запись"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymentcontactrecordList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentDetails"
				      	, "nameRus": "Платежные реквизиты"
				      	, "description": "Платежные реквизиты"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymentdetailsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentPrice"
				      	, "nameRus": "Цена"
				      	, "description": "Цена"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymentpriceList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "PaymentTariff"
				      	, "nameRus": "Тарифам"
				      	, "description": "Тарифам"
				      	, "connections": []
				      	, "group": "Payment"
				      	, "url": "PaymenttariffList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ReqCruiseHotels"
				      	, "nameRus": "Гостиницы"
				      	, "description": "Гостиницы"
				      	, "connections": []
				      	, "group": "Req"
				      	, "url": "ReqcruisehotelsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ReqCruiseServices"
				      	, "nameRus": "Сервисы"
				      	, "description": "Сервисы"
				      	, "connections": []
				      	, "group": "Req"
				      	, "url": "ReqcruiseservicesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ReqHotelRoomsBusy"
				      	, "nameRus": "Бронирование комнаты"
				      	, "description": "Бронирование комнаты"
				      	, "connections": []
				      	, "group": "Req"
				      	, "url": "ReqhotelroomsbusyList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ReqServHotel"
				      	, "nameRus": "Заявка на отель"
				      	, "description": "Заявка на отель"
				      	, "connections": []
				      	, "group": "Req"
				      	, "url": "ReqservhotelList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ReqServHotelRoomBusy"
				      	, "nameRus": "Бронирование комнаты"
				      	, "description": "Бронирование комнаты"
				      	, "connections": []
				      	, "group": "Req"
				      	, "url": "ReqservhotelroombusyList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServCruise"
				      	, "nameRus": "Круиз"
				      	, "description": "Круиз"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServcruiseList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServExcursions"
				      	, "nameRus": "Экскурсии"
				      	, "description": "Экскурсии"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServexcursionsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServGifts"
				      	, "nameRus": "Подарки"
				      	, "description": "Подарки"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServgiftsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServHotel"
				      	, "nameRus": "Отель"
				      	, "description": "Отель"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServhotelList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServHotelRoom"
				      	, "nameRus": "Комнаты"
				      	, "description": "Комнаты"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServhotelroomList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServHotelServices"
				      	, "nameRus": "Гостиничные услуги"
				      	, "description": "Гостиничные услуги"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServhotelservicesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServInsurances"
				      	, "nameRus": "Страховка"
				      	, "description": "Страховка"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServinsurancesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServKidsRule"
				      	, "nameRus": "Детские Правила"
				      	, "description": "Детские Правила"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServkidsruleList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServTicketsAir"
				      	, "nameRus": "Авиабилеты"
				      	, "description": "Авиабилеты"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServticketsairList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServTicketsRail"
				      	, "nameRus": "ЖД Билеты"
				      	, "description": "ЖД Билеты"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServticketsrailList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServTour"
				      	, "nameRus": "Туры"
				      	, "description": "Туры"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServtourList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServTransfer"
				      	, "nameRus": "Трансфер"
				      	, "description": "Трансфер"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServtransferList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServTransferRoute"
				      	, "nameRus": "ServTransferRoute"
				      	, "description": "ServTransferRoute"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServtransferrouteList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServTransferRoutePoint"
				      	, "nameRus": "ServTransferRoutePoint"
				      	, "description": "ServTransferRoutePoint"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServtransferroutepointList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "ServVisas"
				      	, "nameRus": "Визы"
				      	, "description": "Визы"
				      	, "connections": []
				      	, "group": "Serv"
				      	, "url": "ServvisasList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmAccount"
				      	, "nameRus": "Юр лица"
				      	, "description": "Юр лица"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmaccountList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmAccountAddresses"
				      	, "nameRus": "Адреса юр лиц"
				      	, "description": "Адреса юр лиц"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmaccountaddressesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmAccountCommunications"
				      	, "nameRus": "Информация юр лиц"
				      	, "description": "Информация юр лиц"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmaccountcommunicationsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmAccountDetails"
				      	, "nameRus": "Детали юр лиц"
				      	, "description": "Детали юр лиц"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmaccountdetailsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmCommercial"
				      	, "nameRus": "Реклама"
				      	, "description": "Реклама"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmcommercialList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmContact"
				      	, "nameRus": "Физ лица"
				      	, "description": "Физ лица"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmcontactList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmContactAddresses"
				      	, "nameRus": "Адреса физ лиц"
				      	, "description": "Адреса физ лиц"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmcontactaddressesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmContactCommunications"
				      	, "nameRus": "Информация физ лиц"
				      	, "description": "Информация физ лиц"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmcontactcommunicationsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmContactEasy"
				      	, "nameRus": "Лиды"
				      	, "description": "Лиды"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmcontacteasyList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmFirms"
				      	, "nameRus": "Фирмы"
				      	, "description": "Фирмы"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmfirmsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmImage"
				      	, "nameRus": "Изображение"
				      	, "description": "Изображение"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmimageList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmIncidents"
				      	, "nameRus": "Инциденты"
				      	, "description": "Инциденты"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmincidentsList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmOrder"
				      	, "nameRus": "Сделки"
				      	, "description": "Сделки"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmorderList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmPolicies"
				      	, "nameRus": "Политика"
				      	, "description": "Политика"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmpoliciesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "TmUserInfo"
				      	, "nameRus": "Информация о пользователе"
				      	, "description": "Информация о пользователе"
				      	, "connections": []
				      	, "group": "Tm"
				      	, "url": "TmuserinfoList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "UserRoles"
				      	, "nameRus": "Роли пользователей"
				      	, "description": "Роли пользователей"
				      	, "connections": []
				      	, "group": "User"
				      	, "url": "UserrolesList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      , {
				      	  "name": "Users"
				      	, "nameRus": "Пользователи"
				      	, "description": "Пользователи"
				      	, "connections": []
				      	, "group": "Users"
				      	, "url": "UsersList"
				      	, "cls": "fa fa-3x fa-puzzle-piece"
				      }

				      ]
			
//			#----------------------------------
			};
		}
		, templates: function() {
			return {
				currcourse: {
					edit: {
						  url : 'CurrcourseEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'CurrcourseList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'CurrcourseFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'CurrcourseFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'CurrcourseFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'CurrcourseFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'CurrcourseFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'CurrcourseFragmentElist'
						, init : false
						, loading: true
					}
				}

				, currcurrency: {
					edit: {
						  url : 'CurrcurrencyEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'CurrcurrencyList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'CurrcurrencyFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'CurrcurrencyFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'CurrcurrencyFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'CurrcurrencyFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'CurrcurrencyFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'CurrcurrencyFragmentElist'
						, init : false
						, loading: true
					}
				}

				, dictglobal: {
					edit: {
						  url : 'DictglobalEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'DictglobalList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'DictglobalFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'DictglobalFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'DictglobalFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'DictglobalFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'DictglobalFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'DictglobalFragmentElist'
						, init : false
						, loading: true
					}
				}

				, docdocuments: {
					edit: {
						  url : 'DocdocumentsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'DocdocumentsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'DocdocumentsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'DocdocumentsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'DocdocumentsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'DocdocumentsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'DocdocumentsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'DocdocumentsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, groupglobal: {
					edit: {
						  url : 'GroupglobalEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'GroupglobalList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'GroupglobalFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'GroupglobalFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'GroupglobalFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'GroupglobalFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'GroupglobalFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'GroupglobalFragmentElist'
						, init : false
						, loading: true
					}
				}

				, infocontactinformation: {
					edit: {
						  url : 'InfocontactinformationEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'InfocontactinformationList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'InfocontactinformationFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'InfocontactinformationFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'InfocontactinformationFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'InfocontactinformationFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'InfocontactinformationFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'InfocontactinformationFragmentElist'
						, init : false
						, loading: true
					}
				}

				, infoservices: {
					edit: {
						  url : 'InfoservicesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'InfoservicesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'InfoservicesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'InfoservicesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'InfoservicesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'InfoservicesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'InfoservicesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'InfoservicesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, locationaddress: {
					edit: {
						  url : 'LocationaddressEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'LocationaddressList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'LocationaddressFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'LocationaddressFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'LocationaddressFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'LocationaddressFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'LocationaddressFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'LocationaddressFragmentElist'
						, init : false
						, loading: true
					}
				}

				, locationcities: {
					edit: {
						  url : 'LocationcitiesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'LocationcitiesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'LocationcitiesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'LocationcitiesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'LocationcitiesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'LocationcitiesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'LocationcitiesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'LocationcitiesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, locationcountries: {
					edit: {
						  url : 'LocationcountriesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'LocationcountriesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'LocationcountriesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'LocationcountriesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'LocationcountriesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'LocationcountriesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'LocationcountriesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'LocationcountriesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, locationtypeplacement: {
					edit: {
						  url : 'LocationtypeplacementEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'LocationtypeplacementList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'LocationtypeplacementFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'LocationtypeplacementFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'LocationtypeplacementFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'LocationtypeplacementFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'LocationtypeplacementFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'LocationtypeplacementFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymentaccount: {
					edit: {
						  url : 'PaymentaccountEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymentaccountList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymentaccountFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymentaccountFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymentaccountFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymentaccountFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymentaccountFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymentaccountFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymentaccountrecord: {
					edit: {
						  url : 'PaymentaccountrecordEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymentaccountrecordList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymentaccountrecordFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymentaccountrecordFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymentaccountrecordFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymentaccountrecordFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymentaccountrecordFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymentaccountrecordFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymentcontact: {
					edit: {
						  url : 'PaymentcontactEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymentcontactList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymentcontactFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymentcontactFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymentcontactFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymentcontactFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymentcontactFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymentcontactFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymentcontactrecord: {
					edit: {
						  url : 'PaymentcontactrecordEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymentcontactrecordList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymentcontactrecordFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymentcontactrecordFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymentcontactrecordFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymentcontactrecordFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymentcontactrecordFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymentcontactrecordFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymentdetails: {
					edit: {
						  url : 'PaymentdetailsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymentdetailsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymentdetailsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymentdetailsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymentdetailsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymentdetailsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymentdetailsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymentdetailsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymentprice: {
					edit: {
						  url : 'PaymentpriceEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymentpriceList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymentpriceFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymentpriceFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymentpriceFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymentpriceFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymentpriceFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymentpriceFragmentElist'
						, init : false
						, loading: true
					}
				}

				, paymenttariff: {
					edit: {
						  url : 'PaymenttariffEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'PaymenttariffList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'PaymenttariffFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'PaymenttariffFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'PaymenttariffFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'PaymenttariffFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'PaymenttariffFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'PaymenttariffFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relaccountcontacts: {
					edit: {
						  url : 'RelaccountcontactsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelaccountcontactsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelaccountcontactsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelaccountcontactsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelaccountcontactsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelaccountcontactsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelaccountcontactsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelaccountcontactsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relcruisecontacts: {
					edit: {
						  url : 'RelcruisecontactsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelcruisecontactsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelcruisecontactsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelcruisecontactsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelcruisecontactsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelcruisecontactsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelcruisecontactsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelcruisecontactsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relcruisedocs: {
					edit: {
						  url : 'RelcruisedocsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelcruisedocsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelcruisedocsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelcruisedocsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelcruisedocsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelcruisedocsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelcruisedocsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelcruisedocsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relreqservhoteldocdocumentsforhotel: {
					edit: {
						  url : 'RelreqservhoteldocdocumentsforhotelEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelreqservhoteldocdocumentsforhotelList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelreqservhoteldocdocumentsforhotelFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelreqservhoteldocdocumentsforhotelFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelreqservhoteldocdocumentsforhotelFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelreqservhoteldocdocumentsforhotelFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelreqservhoteldocdocumentsforhotelFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelreqservhoteldocdocumentsforhotelFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relreqservhoteldocdocumentsforuser: {
					edit: {
						  url : 'RelreqservhoteldocdocumentsforuserEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelreqservhoteldocdocumentsforuserList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelreqservhoteldocdocumentsforuserFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelreqservhoteldocdocumentsforuserFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelreqservhoteldocdocumentsforuserFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelreqservhoteldocdocumentsforuserFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelreqservhoteldocdocumentsforuserFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelreqservhoteldocdocumentsforuserFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relreqservhoteltmcontacteasy: {
					edit: {
						  url : 'RelreqservhoteltmcontacteasyEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelreqservhoteltmcontacteasyList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelreqservhoteltmcontacteasyFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelreqservhoteltmcontacteasyFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelreqservhoteltmcontacteasyFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelreqservhoteltmcontacteasyFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelreqservhoteltmcontacteasyFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelreqservhoteltmcontacteasyFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelcreditcards: {
					edit: {
						  url : 'RelservhotelcreditcardsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelcreditcardsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelcreditcardsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelcreditcardsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelcreditcardsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelcreditcardsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelcreditcardsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelcreditcardsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhoteldocdocuments: {
					edit: {
						  url : 'RelservhoteldocdocumentsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhoteldocdocumentsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhoteldocdocumentsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhoteldocdocumentsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhoteldocdocumentsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhoteldocdocumentsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhoteldocdocumentsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhoteldocdocumentsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelentertainmentandsport: {
					edit: {
						  url : 'RelservhotelentertainmentandsportEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelentertainmentandsportList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelentertainmentandsportFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelentertainmentandsportFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelentertainmentandsportFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelentertainmentandsportFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelentertainmentandsportFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelentertainmentandsportFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelfeatures: {
					edit: {
						  url : 'RelservhotelfeaturesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelfeaturesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelfeaturesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelfeaturesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelfeaturesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelfeaturesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelfeaturesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelfeaturesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelimage: {
					edit: {
						  url : 'RelservhotelimageEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelimageList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelimageFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelimageFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelimageFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelimageFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelimageFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelimageFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelinfocommercial: {
					edit: {
						  url : 'RelservhotelinfocommercialEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelinfocommercialList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelinfocommercialFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelinfocommercialFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelinfocommercialFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelinfocommercialFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelinfocommercialFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelinfocommercialFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelinfohotelservices: {
					edit: {
						  url : 'RelservhotelinfohotelservicesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelinfohotelservicesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelinfohotelservicesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelinfohotelservicesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelinfohotelservicesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelinfohotelservicesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelinfohotelservicesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelinfohotelservicesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelinfopolicies: {
					edit: {
						  url : 'RelservhotelinfopoliciesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelinfopoliciesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelinfopoliciesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelinfopoliciesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelinfopoliciesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelinfopoliciesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelinfopoliciesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelinfopoliciesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelroomfeatures: {
					edit: {
						  url : 'RelservhotelroomfeaturesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelroomfeaturesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelroomfeaturesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelroomfeaturesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelroomfeaturesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelroomfeaturesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelroomfeaturesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelroomfeaturesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelroomimage: {
					edit: {
						  url : 'RelservhotelroomimageEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelroomimageList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelroomimageFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelroomimageFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelroomimageFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelroomimageFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelroomimageFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelroomimageFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservhotelservkidsrule: {
					edit: {
						  url : 'RelservhotelservkidsruleEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservhotelservkidsruleList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservhotelservkidsruleFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservhotelservkidsruleFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservhotelservkidsruleFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservhotelservkidsruleFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservhotelservkidsruleFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservhotelservkidsruleFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservkidsrulefeatures: {
					edit: {
						  url : 'RelservkidsrulefeaturesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservkidsrulefeaturesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservkidsrulefeaturesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservkidsrulefeaturesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservkidsrulefeaturesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservkidsrulefeaturesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservkidsrulefeaturesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservkidsrulefeaturesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, relservtransfertmcontact: {
					edit: {
						  url : 'RelservtransfertmcontactEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'RelservtransfertmcontactList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'RelservtransfertmcontactFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'RelservtransfertmcontactFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'RelservtransfertmcontactFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'RelservtransfertmcontactFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'RelservtransfertmcontactFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'RelservtransfertmcontactFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltmorderdocdocuments: {
					edit: {
						  url : 'ReltmorderdocdocumentsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltmorderdocdocumentsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltmorderdocdocumentsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltmorderdocdocumentsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltmorderdocdocumentsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltmorderdocdocumentsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltmorderdocdocumentsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltmorderdocdocumentsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltmorderinfoservices: {
					edit: {
						  url : 'ReltmorderinfoservicesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltmorderinfoservicesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltmorderinfoservicesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltmorderinfoservicesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltmorderinfoservicesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltmorderinfoservicesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltmorderinfoservicesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltmorderinfoservicesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltmorderservgifts: {
					edit: {
						  url : 'ReltmorderservgiftsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltmorderservgiftsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltmorderservgiftsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltmorderservgiftsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltmorderservgiftsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltmorderservgiftsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltmorderservgiftsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltmorderservgiftsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltmordertmcontact: {
					edit: {
						  url : 'ReltmordertmcontactEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltmordertmcontactList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltmordertmcontactFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltmordertmcontactFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltmordertmcontactFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltmordertmcontactFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltmordertmcontactFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltmordertmcontactFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltourdocs: {
					edit: {
						  url : 'ReltourdocsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltourdocsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltourdocsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltourdocsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltourdocsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltourdocsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltourdocsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltourdocsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltourhotels: {
					edit: {
						  url : 'ReltourhotelsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltourhotelsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltourhotelsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltourhotelsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltourhotelsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltourhotelsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltourhotelsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltourhotelsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reltourservices: {
					edit: {
						  url : 'ReltourservicesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReltourservicesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReltourservicesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReltourservicesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReltourservicesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReltourservicesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReltourservicesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReltourservicesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reqcruisehotels: {
					edit: {
						  url : 'ReqcruisehotelsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReqcruisehotelsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReqcruisehotelsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReqcruisehotelsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReqcruisehotelsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReqcruisehotelsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReqcruisehotelsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReqcruisehotelsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reqcruiseservices: {
					edit: {
						  url : 'ReqcruiseservicesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReqcruiseservicesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReqcruiseservicesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReqcruiseservicesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReqcruiseservicesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReqcruiseservicesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReqcruiseservicesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReqcruiseservicesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reqhotelroomsbusy: {
					edit: {
						  url : 'ReqhotelroomsbusyEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReqhotelroomsbusyList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReqhotelroomsbusyFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReqhotelroomsbusyFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReqhotelroomsbusyFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReqhotelroomsbusyFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReqhotelroomsbusyFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReqhotelroomsbusyFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reqservhotel: {
					edit: {
						  url : 'ReqservhotelEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReqservhotelList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReqservhotelFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReqservhotelFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReqservhotelFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReqservhotelFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReqservhotelFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReqservhotelFragmentElist'
						, init : false
						, loading: true
					}
				}

				, reqservhotelroombusy: {
					edit: {
						  url : 'ReqservhotelroombusyEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ReqservhotelroombusyList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ReqservhotelroombusyFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ReqservhotelroombusyFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ReqservhotelroombusyFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ReqservhotelroombusyFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ReqservhotelroombusyFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ReqservhotelroombusyFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servcruise: {
					edit: {
						  url : 'ServcruiseEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServcruiseList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServcruiseFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServcruiseFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServcruiseFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServcruiseFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServcruiseFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServcruiseFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servexcursions: {
					edit: {
						  url : 'ServexcursionsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServexcursionsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServexcursionsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServexcursionsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServexcursionsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServexcursionsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServexcursionsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServexcursionsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servgifts: {
					edit: {
						  url : 'ServgiftsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServgiftsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServgiftsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServgiftsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServgiftsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServgiftsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServgiftsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServgiftsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servhotel: {
					edit: {
						  url : 'ServhotelEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServhotelList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServhotelFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServhotelFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServhotelFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServhotelFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServhotelFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServhotelFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servhotelroom: {
					edit: {
						  url : 'ServhotelroomEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServhotelroomList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServhotelroomFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServhotelroomFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServhotelroomFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServhotelroomFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServhotelroomFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServhotelroomFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servhotelservices: {
					edit: {
						  url : 'ServhotelservicesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServhotelservicesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServhotelservicesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServhotelservicesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServhotelservicesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServhotelservicesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServhotelservicesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServhotelservicesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servinsurances: {
					edit: {
						  url : 'ServinsurancesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServinsurancesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServinsurancesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServinsurancesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServinsurancesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServinsurancesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServinsurancesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServinsurancesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servkidsrule: {
					edit: {
						  url : 'ServkidsruleEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServkidsruleList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServkidsruleFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServkidsruleFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServkidsruleFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServkidsruleFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServkidsruleFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServkidsruleFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servticketsair: {
					edit: {
						  url : 'ServticketsairEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServticketsairList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServticketsairFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServticketsairFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServticketsairFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServticketsairFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServticketsairFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServticketsairFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servticketsrail: {
					edit: {
						  url : 'ServticketsrailEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServticketsrailList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServticketsrailFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServticketsrailFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServticketsrailFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServticketsrailFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServticketsrailFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServticketsrailFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servtour: {
					edit: {
						  url : 'ServtourEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServtourList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServtourFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServtourFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServtourFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServtourFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServtourFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServtourFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servtransfer: {
					edit: {
						  url : 'ServtransferEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServtransferList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServtransferFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServtransferFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServtransferFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServtransferFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServtransferFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServtransferFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servtransferroute: {
					edit: {
						  url : 'ServtransferrouteEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServtransferrouteList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServtransferrouteFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServtransferrouteFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServtransferrouteFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServtransferrouteFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServtransferrouteFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServtransferrouteFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servtransferroutepoint: {
					edit: {
						  url : 'ServtransferroutepointEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServtransferroutepointList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServtransferroutepointFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServtransferroutepointFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServtransferroutepointFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServtransferroutepointFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServtransferroutepointFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServtransferroutepointFragmentElist'
						, init : false
						, loading: true
					}
				}

				, servvisas: {
					edit: {
						  url : 'ServvisasEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'ServvisasList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'ServvisasFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'ServvisasFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'ServvisasFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'ServvisasFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'ServvisasFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'ServvisasFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmaccount: {
					edit: {
						  url : 'TmaccountEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmaccountList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmaccountFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmaccountFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmaccountFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmaccountFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmaccountFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmaccountFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmaccountaddresses: {
					edit: {
						  url : 'TmaccountaddressesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmaccountaddressesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmaccountaddressesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmaccountaddressesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmaccountaddressesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmaccountaddressesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmaccountaddressesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmaccountaddressesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmaccountcommunications: {
					edit: {
						  url : 'TmaccountcommunicationsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmaccountcommunicationsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmaccountcommunicationsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmaccountcommunicationsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmaccountcommunicationsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmaccountcommunicationsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmaccountcommunicationsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmaccountcommunicationsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmaccountdetails: {
					edit: {
						  url : 'TmaccountdetailsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmaccountdetailsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmaccountdetailsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmaccountdetailsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmaccountdetailsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmaccountdetailsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmaccountdetailsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmaccountdetailsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmcommercial: {
					edit: {
						  url : 'TmcommercialEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmcommercialList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmcommercialFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmcommercialFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmcommercialFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmcommercialFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmcommercialFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmcommercialFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmcontact: {
					edit: {
						  url : 'TmcontactEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmcontactList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmcontactFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmcontactFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmcontactFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmcontactFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmcontactFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmcontactFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmcontactaddresses: {
					edit: {
						  url : 'TmcontactaddressesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmcontactaddressesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmcontactaddressesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmcontactaddressesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmcontactaddressesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmcontactaddressesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmcontactaddressesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmcontactaddressesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmcontactcommunications: {
					edit: {
						  url : 'TmcontactcommunicationsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmcontactcommunicationsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmcontactcommunicationsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmcontactcommunicationsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmcontactcommunicationsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmcontactcommunicationsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmcontactcommunicationsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmcontactcommunicationsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmcontacteasy: {
					edit: {
						  url : 'TmcontacteasyEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmcontacteasyList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmcontacteasyFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmcontacteasyFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmcontacteasyFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmcontacteasyFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmcontacteasyFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmcontacteasyFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmfirms: {
					edit: {
						  url : 'TmfirmsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmfirmsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmfirmsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmfirmsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmfirmsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmfirmsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmfirmsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmfirmsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmimage: {
					edit: {
						  url : 'TmimageEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmimageList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmimageFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmimageFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmimageFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmimageFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmimageFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmimageFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmincidents: {
					edit: {
						  url : 'TmincidentsEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmincidentsList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmincidentsFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmincidentsFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmincidentsFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmincidentsFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmincidentsFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmincidentsFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmorder: {
					edit: {
						  url : 'TmorderEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmorderList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmorderFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmorderFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmorderFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmorderFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmorderFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmorderFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmpolicies: {
					edit: {
						  url : 'TmpoliciesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmpoliciesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmpoliciesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmpoliciesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmpoliciesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmpoliciesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmpoliciesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmpoliciesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, tmuserinfo: {
					edit: {
						  url : 'TmuserinfoEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'TmuserinfoList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'TmuserinfoFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'TmuserinfoFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'TmuserinfoFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'TmuserinfoFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'TmuserinfoFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'TmuserinfoFragmentElist'
						, init : false
						, loading: true
					}
				}

				, userroles: {
					edit: {
						  url : 'UserrolesEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'UserrolesList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'UserrolesFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'UserrolesFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'UserrolesFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'UserrolesFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'UserrolesFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'UserrolesFragmentElist'
						, init : false
						, loading: true
					}
				}

				, users: {
					edit: {
						  url : 'UsersEdit'
						, init : false
						, loading: true
					}
					, list: {
						  url : 'UsersList'
						, init : false
						, loading: true
					}
					, fragmentlist: {
						  url : 'UsersFragmentList'
						, init : false
						, loading: true
					}
					, fragmentedit: {
						  url : 'UsersFragmentEdit'
						, init : false
						, loading: true
					}
					, fragmentledit: {
						  url : 'UsersFragmentLedit'
						, init : false
						, loading: true
					}
					, fragmentselector: {
						  url : 'UsersFragmentSelector'
						, init : false
						, loading: true
					}
					, fragmentmedit: {
						  url : 'UsersFragmentMedit'
						, init : false
						, loading: true
					}
					, fragmentelist: {
						  url : 'UsersFragmentElist'
						, init : false
						, loading: true
					}
				}

			};
		} 
	};
});
