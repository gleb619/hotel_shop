(function() {

var APP = new Object();
	
	APP.defaultListCtrl = function($scope, $filter) {
		
		$scope.search = function (filtered, array, filter) {
			$scope[filtered] = null; 
			$scope[filtered] = $filter('filter')($scope[array], $scope[filter]);
		};
		
		$scope.sort = function (name, direction) {
			var result = $scope.details[name];
			
			if(typeof result == "undefined"){
				result = true;
			}
			
			if(typeof direction != "undefined"){
				result = direction;
			}
			else {
				$scope.details[name] = !result;
			}
			
			$scope.details.sortableColumn = name;
			$scope.details.sortableReverse = !result;
		};
		
		$scope.isDisabledEdit = function () {
	    	if($scope.selectedItem.id == 'undefined' || isNaN($scope.selectedItem.id)){
	    		return true;
	    	}
	    	
	    	return false;
	    };
	    
	    $scope.checkVisibility = function (name) {
			if($scope.excludes.indexOf(name) > -1){
				return false;
			}
			
			return true;
		};
		
		$scope.setSelected = function (name, item) {
			$scope[name] = item;
		};
	};
	
	APP.defaultSelectorCtrl = function($scope, $modalInstance, $servicesStorage, $staticStorage, $q, toaster) {
		$scope.submitFunc = function () {
			$scope.loading = true;
			
			if($scope.ctrl.original == 'InfoServices'){
				$modalInstance.close({
					data: APP.convertEntities($scope.selectedItems, $q, $servicesStorage, $staticStorage, 'InfoServices', toaster)
				});
			}
			else {
				$modalInstance.close({
					data: $scope.selectedItems
				});
			}
		};
		
		$scope.cancel = function () {
			$scope.loading = true;
			$modalInstance.dismiss('cancel');
		};
		
		$scope.checkVisibility = function (arg) {
			return true;
		};
		
		$scope.onSelectionChanged = function (item) {
			setTimeout(function() {
				if(item.checked){
					$scope.selectedItems.push(item);
				}
				else{
					$scope.selectedItems.splice($scope.selectedItems.indexOf(item), 1);
				}
			}, 100);
		};
	};
	
	APP.defaultEditCtrl = function($scope, $modal, $modalInstance, modalSettings, $servicesStorage, $staticStorage, instanceName, $filter, $location, $rootScope, toaster, APP_INFO) {
		
		specialLogic($scope, $staticStorage, $servicesStorage, toaster, instanceName);
		
		$scope.addDict = function(name, dataType, ownDataType, array) {
			console.log('APP.defaultEditCtrl#ownDataType: ' + ownDataType, ', dataType: ', dataType);
			
//			var templateUrl = APP.capitalize(dataType.toLowerCase()) + 'Edit'
			var templateUrl = APP.capitalize(dataType.toLowerCase()) + 'FragmentMedit'
			, 	controller = dataType + 'EditCtrl'
			, 	modalInstance = $modal.open({
					templateUrl: templateUrl,
					controller: controller,
					resolve: {
						modalSettings: function () { 
							return { 
								  item: new Object()
								, mode: "createsimple"
								, isModal: true
								, isSimple: true
								, editItem: new Object()
								, editItemId: -1
								, excludeList: [ ownDataType ]
							}; 
						}
					}
				});
			
			modalInstance.result.then(function(item){
				array.push(item.item);
				$scope.item[name] = item.item;
//				console.info(
//						'item.item', item.item,
//						'$scope[name]', $scope[name]
//				);
			}, function(){
				
			});
		};
		
		$scope.searchDict = function(name, dataType, ownDataType, array) {
			var templateUrl = APP.capitalize(dataType.toLowerCase()) + 'FragmentSelector'
			, 	controller = dataType + 'SelectorCtrl'
			,	modalInstance = $modal.open({
					templateUrl: templateUrl,
					controller: controller,
					resolve: {
						item: function () { 
							return new Object(); 
						}
					}
				});
				modalInstance.result.then(function (data) {
					if(data.data.length > 0){
						var object = {
								  id: data.data[0].id
								, label: data.data[0].label
								, version: data.data[0].version
						};
						array.push(object);
						$scope.item[name] = object;
					}
				}, function(){
					
				});
		};
		/*
		$scope.item.servHotels = APP.checkDublicate2(
				$scope.item.servHotels
			  , data.data
			  , 'ServHotelView'
		);
		*/
		
		$scope.convertDateAndTime = function(value, name) {
			$scope.item[name] = $filter('date')(value, 'yyyy-MM-dd HH:mm');
		};
		
		$scope.convertTime = function(value, name) {
//			$scope.item[name] = $filter('date')(value, 'HH:mm');
			$scope.item[name] = $filter('date')(value, 'yyyy-MM-dd HH:mm');
		};
		
		$scope.open = function($event, name) {
			$event.preventDefault();
			$event.stopPropagation();
	
		    $scope.details[name] = true;
		};
		
		$scope.checkForNull = function () {
			return true;
		};
		
		$scope.checkVisibility = function (name) {
			if(typeof name === "undefined"){
				return false;
			}
//			console.info(
//					'APP.defaultEditCtrl#modalSettings: ', modalSettings,
//					'\n\nAPP.defaultEditCtrl#name: ', name
//			);
			
			if(modalSettings.excludeList.indexOf(name) > -1){
				return false;
			}
			
			return true;
		};
		
		$scope.deleteSubItem = function (collection, dao, itemId, index) {
			var fn = $servicesStorage[dao + 'Dao'];
					
			if(typeof itemId === "undefined"){
				$scope.item[collection].splice(index, 1);
				return;
			}
			
			fn().remove({ id: itemId }, new Object(), function(){
				$scope.item[collection].splice(index, 1);
			});
		};
	
		$scope.cancel = function () {
			$scope.loading = true;
			if(modalSettings.isModal){
				$modalInstance.dismiss('cancel');
			}
			else {
//				$location.path('/' + APP.capitalize($scope.ctrl.original.toLowerCase()) + 'List');
				$location.path($rootScope.previousPage2);
			}
		};
		
		$scope.setSelected = function (name, item, index) {
			$scope[name] = item;
			$scope.itemIndex = index;
		};
		
		function checkModalSettings() {
			if(modalSettings.mode == "create"){
				$scope.access.create = true;
			}
			else if(modalSettings.mode == "createsimple"){
				$scope.access.createsimple = true;
				if(modalSettings.excludeList.length > 0){
					$scope.item[modalSettings.excludeList[0]] = {
							id: modalSettings.item.id
					};
				}
			}
			else if(modalSettings.mode == "edit"){
				$scope.access.edit = true;
				$scope.item = modalSettings.editItem;
				$scope.itemId = modalSettings.editItemId;
				$scope.selectedItem = modalSettings.editItem;
			}
			else if(modalSettings.mode == "editsimple"){
				$scope.access.editsimple = true;
				$scope.item = modalSettings.editItem;
				$scope.itemId = modalSettings.editItemId;
				$scope.selectedItem = modalSettings.editItem;
			}
			
			if(modalSettings.mode == "editsimple" || modalSettings.mode == "edit"){
				if($staticStorage.benchmark().isCacheble()){
					$scope.item = JSOG.decode($scope.$storage['item' + instanceName]);
				}
			} 
			else if (modalSettings.mode == "create" || modalSettings.mode == "createsimple"){
				$scope.item = new Object();
			}
			
			if(modalSettings.insertParent){
				$scope.item[modalSettings.excludeList[0]] = {
						  id: modalSettings.item.id
						, version: modalSettings.item.version
				};
			}
			
			if(modalSettings.isModal){
				$scope.templates = $staticStorage.templates();
				
				$scope.initTab = function(name, type) {
					setTimeout($scope.initPage(name, type), 100);
				};
				
				$scope.initPage = function(name, type) {
					if(!$scope.templates[name][type].init){
						$scope.templates[name][type].init = true;
					}
				};
			}
			
		}
		
		checkModalSettings();
	};
	
//#---------------------------------------	
	
	APP.convertInfoServices = function(input, $q, $servicesStorage, $staticStorage, toaster) {
		var output = {
			  label:  input.label
			, version: 0
			, price: input.price
		};
		
		output[input.module.toLowerCase()] = {
			 id: input.id
		   , label: input.label
		   , version: input.version
//		   , version: 0
		};
		
		return output;
		
		var deferred = $q.defer();
		$servicesStorage.InfoServicesDao().create(output, function (data) {
			if(data.success){
				deferred.resolve(JSOG.decode(data.data[0]));
			}
			else{
				toaster.pop('error', 'ERROR', data.message);
			}
		});
		
		return deferred.promise;
	};
	
	APP.convertEntity = function(input, $q, $servicesStorage, $staticStorage, type, toaster) {
		var output = JSOG.encode(JSOG.decode(input));
		
		if(type == 'InfoServices'){
			output = APP.convertInfoServices(input, $q, $servicesStorage, $staticStorage, toaster);
//			var promise = APP.convertInfoServices(input, $q, $servicesStorage, $staticStorage, toaster);
//			promise.then(function(result) {
//				output = result;
//			});
		}
		
		return output;
	};
	
	APP.convertEntities = function(input, $q, $servicesStorage, $staticStorage, type, toaster) {
		angular.forEach(input, function(item, index) {
			input[index] = APP.convertEntity(item, $q, $servicesStorage, $staticStorage, type, toaster);
		});
		
		return input;
	};
	
//#---------------------------------------
	
	APP.checkLoading = function(ctrl, modalSettings, $q) {
		if(modalSettings.isSimple){
			APP.sleep(500, $q).then(function(result) {
				return false;
			});
		}
		else {
			return false;
		}
	};
	
	APP.AVG = function (values) {
		var sum = values.reduce(function(sum, value){
			return sum + value;
		}, 0);

		return sum / values.length;
	};
	
	APP.sleep = function (delay, $q) {
		var deferred = $q.defer();
		
		var timer = setTimeout(function() {
			var start = new Date().getTime();
			while (new Date().getTime() < start + delay);
			deferred.resolve(true);
			clearTimeout(timer);
			timer = null;
		}, 20);
        
        return deferred.promise;
    };
	
	APP.capitalize = function(string) {
	    return string.charAt(0).toUpperCase() + string.slice(1);
	};
	
	APP.loadTariffByHumanNumber = function(humanNumber, array) {
		var result = null;
		angular.forEach(array, function(item, index) {
			if(item.humannumber == humanNumber){
				if(result != null){
					result = item;
				}
				else {
					console.info('data: ', 'alternative tariff is: ', item);
				}
			}
		});
		
		if(result == null){
			if (humanNumber <= 1 && array.length > 0) {
				result = array[0];
			}
			else if (humanNumber > array.length && array.length > 0){
				result = array[array.length - 1];
			}
			else {
				result = {
						humannumber: 0,
						corporateRateCost: 1,
						corporateRateCurrencyname: $,
						originalRateCost: 1,
						originalRateCurrencyname: $
				};
			}
		}
		
		return result;
	};
	
	APP.calculateNumberOfNights = function(normalTimeRace, normalTimeDeparture, earlyRaceTime, lateDepartureTime, clientTimeRace, clientTimeDeparture, callback) {
		var dateDifference = APP.daysBetween(clientTimeRace, clientTimeDeparture);
		var normalRace = APP.isNormalRace(normalTimeRace, clientTimeRace);
		var normalDeparture = APP.isNormalDeparture(normalTimeDeparture, clientTimeDeparture);
		var earlyCheckIn = APP.isEarlyCheckIn(earlyRaceTime, normalTimeRace, clientTimeRace);
		var lateCheckOut = APP.isLateCheckOut(lateDepartureTime, normalTimeDeparture, clientTimeDeparture);
		
		if (!normalRace) {
			if (earlyCheckIn) {
				console.info(': ', 'earlyCheckIn');
				dateDifference = dateDifference + 0.5;
			}
			else {
				console.info(': ', 'superEarlyCheckIn');
				dateDifference = dateDifference + 1;
			}
		}
		
		if (!normalDeparture) {
			if (lateCheckOut) {
				console.info(': ', 'lateCheckOut');
				dateDifference = dateDifference + 0.5;
			}
			else {
				console.info(': ', 'superLateCheckOut');
				dateDifference = dateDifference + 1;
			}
		}
		
		if(dateDifference <= 0.5){
			dateDifference = 1;
		}
		
		callback(dateDifference);
	};
	
	APP.timeToRaw = function (time, plusHour) {
		if(typeof plusHour === "undefined"){
			plusHour = 0;
		}
		
		return parseInt(APP.addZero(time.getHours() + plusHour).toString() + APP.addZero(time.getMinutes()).toString())
	};
	
	APP.addZero = function (i) {
	    if (i < 10) {
	        i = "0" + i;
	    }
	    
	    return i;
	};
	
	APP.isNormalRace = function (normalTimeRace, clientTimeRace) {
		normalTimeRace = APP.parseData(normalTimeRace);
		
		var normalTimeRaceRaw = APP.timeToRaw(normalTimeRace); 
		var normalTimeRaceEndRaw = APP.timeToRaw(normalTimeRace, 1); 
		var clientTimeRaceTimeRaceRaw = APP.timeToRaw(clientTimeRace);  
		
		if(clientTimeRaceTimeRaceRaw >= normalTimeRaceRaw && clientTimeRaceTimeRaceRaw <= normalTimeRaceEndRaw){
			return true;
		}
		
		return false;
	};
	
	APP.isNormalDeparture = function (normalTimeDeparture, clientTimeDeparture) {
		normalTimeDeparture = APP.parseData(normalTimeDeparture);
		
		var normalTimeDepartureRaw = APP.timeToRaw(normalTimeDeparture); 
		var clientTimeDepartureRaw = APP.timeToRaw(clientTimeDeparture);
		
		if(clientTimeDepartureRaw <= normalTimeDepartureRaw){
			return true;
		}
		
		return false;
	};
	
	APP.isEarlyCheckIn = function(earlyRaceTime, normalTimeRace, clientTimeRace) {
		earlyRaceTime = APP.parseData(earlyRaceTime);
		normalTimeRace = APP.parseData(normalTimeRace);
		
		var earlyRaceTimeRaw = APP.timeToRaw(earlyRaceTime);  
		var normalTimeRaceRaw = APP.timeToRaw(normalTimeRace);  
		var clientTimeRaceRaw = APP.timeToRaw(clientTimeRace);
		
		if(clientTimeRaceRaw >= earlyRaceTimeRaw && clientTimeRaceRaw < normalTimeRaceRaw){
			return true;
		}
		
		return false;
	};
	
	APP.isLateCheckOut = function(lateDepartureTime, normalTimeDeparture, clientTimeDeparture) {
		lateDepartureTime = APP.parseData(lateDepartureTime);
		normalTimeDeparture = APP.parseData(normalTimeDeparture);
		
		var lateDepartureTimeRaw = APP.timeToRaw(lateDepartureTime);  
		var normalTimeDepartureRaw = APP.timeToRaw(normalTimeDeparture);  
		var clientTimeDepartureRaw = APP.timeToRaw(clientTimeDeparture);
		
		if(clientTimeDepartureRaw > normalTimeDepartureRaw && clientTimeDepartureRaw <= lateDepartureTimeRaw){
			return true;
		}
		
		return false;
	};
	
	APP.daysBetween = function (first, second) {

	    // Copy date parts of the timestamps, discarding the time parts.
	    var one = new Date(first.getFullYear(), first.getMonth(), first.getDate());
	    var two = new Date(second.getFullYear(), second.getMonth(), second.getDate());

	    // Do the math.
	    var millisecondsPerDay = 1000 * 60 * 60 * 24;
	    var millisBetween = two.getTime() - one.getTime();
	    var days = millisBetween / millisecondsPerDay;

	    // Round down.
	    return Math.floor(days);
	};
	
	APP.afterLoadingDataEditCtrl = function($scope, $staticStorage, name) {
		if(name == 'ReqServHotel'){
			readReqServHotelStatus($scope);
			checkForAccess($scope);
			$scope.reviewInit();
		}
	};
	
	APP.beforeLoadingDataEditCtrl = function($scope, $staticStorage, modalSettings, name) {
		console.info('beforeLoadingDataEditCtrl: ', name);
		if(modalSettings.isSimple){
			$scope.loading = false;
		}
	};
	
	function specialLogic($scope, $staticStorage, $servicesStorage, toaster, name) {
		if(name == 'ReqServHotel'){
			$scope.taketomyself = function () {
				specialReqServHotelOperationFn($scope, $staticStorage, $servicesStorage, toaster, 'taketomyself');
				$scope.item.status = 1;
				$scope.item.progress = 30;
				readReqServHotelStatus($scope);
			};
			
			$scope.hotelemailsend = function () {
				specialReqServHotelOperationFn($scope, $staticStorage, $servicesStorage, toaster, 'hotelemailsend');
				$scope.item.status = 2;
				$scope.item.progress = 50;
				readReqServHotelStatus($scope);
			};
			
			$scope.emailsend = function () {
				specialReqServHotelOperationFn($scope, $staticStorage, $servicesStorage, toaster, 'emailsend');
				$scope.item.status = 2;
				$scope.item.progress = 50;
				readReqServHotelStatus($scope);
			};
			
			$scope.accept = function () {
				specialReqServHotelOperationFn($scope, $staticStorage, $servicesStorage, toaster, 'accept');
				$scope.item.status = 3;
				$scope.item.progress = 100;
				readReqServHotelStatus($scope);
			};
			
			$scope.decline = function () {
				specialReqServHotelOperationFn($scope, $staticStorage, $servicesStorage, toaster, 'decline');
				$scope.item.status = 4;
				$scope.item.progress = 90;
				readReqServHotelStatus($scope);
			};
			
			$scope.user = { username: "" };
			$scope.progress = { type: "info" };
			$scope.docviewer = new Object();
			
			$staticStorage.UserDao().current_user({ fulldata: true }, function (data) {
				$scope.user.username = data.data;
				checkForAccess($scope);
			});
			
			$scope.reviewDownload = function () {
				console.info('test: ', 'download');
			};
			
			$scope.reviewBackward = function () {
				$scope.docviewer.index--;
				if($scope.docviewer.index <= 0){
					$scope.docviewer.index = 0;
				}
				
				$scope.readDocument();
//				$scope.docviewer.document = $scope.docviewer.data[$scope.docviewer.index];
			};
			
			$scope.reviewForward = function () {
				$scope.docviewer.index++;
				if($scope.docviewer.index >= $scope.docviewer.data.length - 1){
					$scope.docviewer.index = $scope.docviewer.data.length - 1;
				}
				
				$scope.readDocument();
//				$scope.docviewer.document = $scope.docviewer.data[$scope.docviewer.index];
			};
			
			$scope.reviewInit = function () {
				if(typeof $scope.item.relReqServHotelDocDocumentsForHotels === "undefined"){
					$scope.item.relReqServHotelDocDocumentsForHotels = new Array();
				}
				
				$scope.docviewer.data = $scope.item.relReqServHotelDocDocumentsForHotels;
				$scope.docviewer.index = 0;
				$scope.readDocument();
			};
			
			$scope.readDocument = function () {
				if($scope.docviewer.data.length > 0){
					var document = $scope.docviewer.data[$scope.docviewer.index].docdocuments;
					
					if(document.realfile){
						var request = {
							documentId: -1,
							requestServHotelId: $scope.item.id
						};
						
						if(document.hasOwnProperty("id")){
							request.documentId = document.id;
						}
						
						if(request.documentId > -1){
							console.info('request: ', request);
							$staticStorage.DocViewer().view(request, function(response) {
								console.info('response: ', response);
								if(response.success){
									$scope.docviewer.document = response.data;
								}
								else {
									$scope.docviewer.document = response.message;
								}
							});
						}
					}
					else {
						$scope.docviewer.document = document.text;
					}
				}
			};
		}
	}
	
	function checkForAccess($scope) {
		if(typeof $scope.item.usersbyresponseuser == "undefined" || typeof $scope.item.usersbyresponseuser.username == "undefined"){
			$scope.access.ownRequest = true;
			return;
		}
		else {
			$scope.access.ownRequest = false;
		}
		
		if(typeof $scope.user === "undefined"){
			$scope.user = new Object();
			$scope.user.username = "";
		}
		
		if ($scope.item.usersbyresponseuser.username.replace(/\s+/g, '').toLowerCase() == $scope.user.username.replace(/\s+/g, '').toLowerCase()) {
			$scope.access.ownRequest = false;
			$scope.access.myRequest = true;
		}
		else {
			$scope.access.myRequest = false;
		}
	};
	
	function readReqServHotelStatus($scope) {
		if(typeof $scope.progress === "undefined"){
			$scope.progress = new Object();
		}
		
		if($scope.item.status == 4){
			$scope.progress.type = "danger";
		}
		else if($scope.item.status == 3){
			$scope.progress.type = "success";
		}
		else {
			$scope.progress.type = "info";
		}
	};
	
	function specialReqServHotelOperationFn($scope, $staticStorage, $servicesStorage, toaster, name) {
		var item = JSOG.stringify($scope.item)
		,	operationRequest = {
				  id: $scope.item.id
				, entity: item
				, name: name
		};
		
		$scope.loading = true;
		$staticStorage.OperationDao().operation(operationRequest, function (data) {
			$servicesStorage.ReqServHotelDao().showObj($scope.scrollable, function (data) {
				if(data.success){
					toaster.pop('success', "Operation done");
					$scope.item = JSOG.decode(data.data); 
					$scope.$storage.itemReqServHotel = data.data; 
				}
				checkForAccess($scope);
				$scope.loading = false;
			});
		});
	};
	
	APP.checkItem = function(item, modalSettings) {
		if(typeof item === "undefined" || typeof modalSettings === "undefined"){
			return true;
		}
		
		if(typeof modalSettings.item === "undefined" || typeof modalSettings.item.id === "undefined"){
			return true;
		}
		
		if(item.id != modalSettings.item.id){
			return true;
		}
		
		return false;
	};
	
	APP.uniqueArray = function(array) {
		var idStorage = new Object()
		, 	output = new Array();

		angular.forEach(array, function(value, key) {
			var idProperty = value.id;
			if(value.hashid){
				idProperty = value.hashid; 
			}
			
			if(typeof idStorage[idProperty] == "undefined"){
				output.push(value);
				idStorage[idProperty] = idProperty;
			}
		});
		/*
		$.each(array, function(key, value) {
			var idProperty = value.id;
			if(value.hashid){
				idProperty = value.hashid; 
			}
			
			if(typeof idStorage[idProperty] == "undefined"){
				output.push(value);
				idStorage[idProperty] = idProperty;
			}
		});
		*/
		return output;
	};
	
	APP.loadIndex = function(id, data) {
		var index = -1;
		
		if(data.length == 0 || id == null){
			return index;
		}
		
		angular.forEach(data, function(value, key) {
			index++;
			if (value.id == id) {
				return false;
			}
		});
		/*
		$.each(data, function(key, value) {
			index++;
			if (value.id == id) {
				return false;
			}
			
		});
		*/
		return index;
	};
	
	APP.loadItem = function(id, data) {
		var item = new Object();
		
		if(data.length == 0 || id == null){
			return item;
		}
		
		angular.forEach(data, function(value, key) {
			if (value.id == id) {
				item = value;
				return false;
			}
		});
		/*
		$.each(data, function(key, value) {
			if (value.id == id) {
				item = value;
				return false;
			}
			
		});
		*/
		return item;
	};
	
	APP.loadItem2 = function(id, field, data) {
		var item = new Object()
		,	index = -1;
		
		if(data.length == 0 || id == null){
			return item;
		}
		
		angular.forEach(data, function(value, key) {
			if (value[field] == id) {
				item = value;
				index = key;
				
				return false;
			}
		});
		
		return { 
			  item: item
			, index: index
		};
	};
	
	APP.loadtinymceOption = function() {
		return {
				  language: 'ru'
				, plugins: [
				          "advlist autolink lists link charmap print preview hr anchor pagebreak",
				          "searchreplace wordcount visualblocks visualchars code fullscreen",
				          "insertdatetime nonbreaking save table contextmenu directionality",
				          "emoticons paste textcolor colorpicker textpattern",
				          "autoresize"
				  ]
		 		, autoresize_min_height: 400
				, image_advtab: true
				, toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link"
				, toolbar2: "print preview | forecolor backcolor emoticons"
		};
	};
	
	APP.randomNumber = function(start, end) {
		return Math.floor((Math.random() * end) + start);
	};
	
	APP.createPagnation = function(data, numPerPage, totalItems) {
		var result = new Object();
		result.paginationData = new Object(),
		result.totalItems = new Object();
		
		if (typeof(data) 		=== 'undefined' || 
			typeof(numPerPage) 	=== 'undefined' || 
			typeof(totalItems) 	=== 'undefined' || 
			data.length 		<= 0) {
			 
	        return result;
	    }
		
		var paginationData = data.slice(0, numPerPage);
		totalItems = Math.ceil(data.length / numPerPage);
		result.paginationData = paginationData;
		result.totalItems = totalItems;
		
		return result;
	};
	
	APP.debugInfo = function(name) {
		var debugEntity = [
	// 		  'ServHotelListCtrl'
	// 		, 'ServHotelEditCtrl'
	// 		, 'TmCommercialSelectorCtrl'
		];
	
		if(debugEntity.indexOf(name) > -1){
			return true;
		}
		
		return false;
	};
	
	APP.defaultLogic = function(name, settings, stage) {
		var debugEntity = [
	             'ServHotelListCtrl'
	           , 'ServHotelEditCtrl'
	           , 'ServHotelSelectorCtrl'
	    ]
		, $scope = settings.scope;
//		, listName = 'data'+ $scope.ctrl.original
//		, showMessages = false;
		
		if(debugEntity.indexOf(name) == -1){
			showMessages = true;
		}
		
		var listLogic = {
			onSuccess: function(data) {
				if (showMessages = false)
				console.info('onSuccess', name, '#', stage, ':', data.data.length);
				if('complete' == stage){
					if(data.total > 0){
						$scope.setSelectedItem(data.data[0]);
					}
				}
			}
			
			, onError: function(data) {
				if (showMessages = false)
				console.error('onError', name, '#', stage, ':', data.data.length);
			}
			
			, onNullError: function(data) {
				if (showMessages = false)
				console.error('onNullError', name, '#', stage, ':', data.data.length);
			}
		};
		
		var selectorLogic = {
			onSuccess: function(data) {
				if (showMessages = false)
				console.info('onSuccess', name, '#', stage, ':', data.data.length);
			}
			
			, onError: function(data) {
				if (showMessages = false)
				console.error('onError', name, '#', stage, ':', data.data.length);
			}
			
			, onNullError: function(data) {
				if (showMessages = false)
				console.error('onNullError', name, '#', stage, ':', data.data.length);
			}
		};
		
		if (name.indexOf('ListCtrl') > -1) {
			return listLogic;
		}
		else if(name.indexOf('SelectorCtrl') > -1){
			return selectorLogic;
		}
		
		return new Object();
		
	};
	
	APP.debugLogic = function(name, settings, stage) {
		var debugEntity = [
	               'ServHotelListCtrl'
	             , 'ServHotelEditCtrl'
	             , 'ServHotelSelectorCtrl'
	      ]
	  	, $scope = settings.scope
		, listName = 'data'+ $scope.ctrl.original;
	  	
	  	if(debugEntity.indexOf(name) == -1){
	//  		return new Object();
	  	}
	  	
	  	var listLogic = {
	  		onSuccess: function(data) {
	  			$scope.selectedItem = $scope[listName][randomNumber(0, $scope[listName].length - 1)];
	  			$scope.editModalItem($scope.selectedItem.id);
	  			
	//  		$scope.createModalNewItem();
	  		}
	  		
	  		, onError: function(data) {
	  			console.error('onError', '^', name, '#', stage, ':', JSON.stringify(data));
	  		}
	  		
	  		, onNullError: function(data) {
	  			console.error('onNullError', '^', name, '#', stage, ':', JSON.stringify(data));
	  		}
	  	};
	  	
	  	var selectorLogic = {
	  		onSuccess: function(data) {
	  			var max = randomNumber(1, $scope[listName].length - 1);
	  			for (var int = 0; int < max; int++) {
	  				var index = randomNumber(1, $scope[listName].length - 1);
	  				if($scope[listName][index].checked == false){
	  					$scope[listName][index].checked = true;
	  					$scope.onSelectionChanged($scope[listName][index]);
	  				}
	  			}
	  			
	  			$scope.submitFunc();
	  		}
	  		
	  		, onError: function(data) {
	  			console.error('onError', '^', name, '#', stage, ':', JSON.stringify(data));
	  		}
	  		
	  		, onNullError: function(data) {
	  			console.error('onNullError', '^', name, '#', stage, ':', JSON.stringify(data));
	  		}
	  	};
	  	
	  	var editLogic = {
			onSuccess: function(data) {
				$scope.pickItemRelServHotelInfoCommercial();
			}
		
			, onError: function(data) {
				console.error('onError', name, '#', stage, ':', data.data.length);
			}
			
			, onNullError: function(data) {
				console.error('onNullError', name, '#', stage, ':', data.data.length);
			}
		};
	  	
	  	if (name.indexOf('ListCtrl') > -1) {
	  		return listLogic;
	  	}
	  	else if(name.indexOf('SelectorCtrl') > -1){
	  		return selectorLogic;
	  	}
	  	else if(name.indexOf('EditCtrl') > -1){
	  		return editLogic;
	  	}
	  	
	  	return new Object();
	};
	
	APP.timeOutCount = function(name, $staticStorage) {
//		console.log("timeOutCount#name: " + 
//				name
//		);
		
		return $staticStorage.benchmark().batchSize();
		/*
		
		var iOS = false
		,	isAndroid = false
	    ,	p = navigator.platform
	    ,   ua = navigator.userAgent.toLowerCase()
	    ,	timeout = 100;
	
		if( p === 'iPad' || p === 'iPhone' || p === 'iPod' ){
		    iOS = true;
		}
		else if(ua.indexOf("android") > -1){
			isAndroid = true;
		}
		
		if(iOS){
			timeout = 200;
		}
		else if(isAndroid){
			timeout = 200;
		}
		
		return timeout;
		*/
	};
	
	APP.deleteUndefined = function(object) {
		angular.forEach(object, function(value, key) {
			if (typeof value == "undefined") {
				delete object[key];
			}
		});
	};
	
	APP.checkDublicate = function(originalArray, newArray, fieldForCheck, ownerLabel, owner, isUnsaved) {
		var canAdd = true,
			check = true,
			debug = false,
			result = {
				  newArray: new Array()
				, originalArray: new Array()
			};
		
		if (typeof(originalArray) 	=== 'undefined' || 
			typeof(newArray) 		=== 'undefined' || 
			originalArray.length 	<= 0 || 
			newArray.length 		<= 0) {
			
			check = false;
		}
		
		if (typeof(originalArray) === 'undefined') {
			originalArray = new Array();
		}
		
		if (typeof(newArray) === 'undefined') {
			newArray = new Array();
		}
		
		angular.forEach(newArray, function(element, key) {
			if(check){
				angular.forEach(originalArray, function(value2, key2) {
					if(value2[fieldForCheck].label == element.label){
						canAdd = false;
						return false;
					}
					else{
						canAdd = true;
					}
				});
			}
			
			if(canAdd){
				var obj = new Object();
				
				obj[ownerLabel] = {
						  id: owner.id
						, label: owner.label
						, version: owner.version
				};
				obj[fieldForCheck] = {
						  id: element.id
						, label: element.label
						, version: element.version
				};
				
				if(isUnsaved){
					obj[fieldForCheck] = element;
				}
				
				APP.deleteUndefined(obj[ownerLabel]);
				APP.deleteUndefined(obj[fieldForCheck]);
				
				originalArray.push(obj);
			}
		});
		
		result.originalArray = originalArray;
		
		if(debug){
			console.log("result.originalArray: " + 
				JSON.stringify(result.originalArray)
			);
		}
		
		return result.originalArray;
	};
	
	APP.checkDublicate2 = function(originalArray, newArray, field) {
		var canAdd = true
		  , check = true
//		  , debug = false
		  , complexTypes = getComplexType(field)
		  , result = {
					newArray: new Array()
				  , originalArray: new Array()
		  };
		
		if (typeof(newArray) === 'undefined' || 
			newArray.length <= 0) {
			return result.originalArray;
		}
		
		if (typeof(originalArray) === 'undefined' || 
			originalArray.length <= 0) {
			originalArray = new Array();
			check = false;
		}
		
		if (typeof(complexTypes) === 'undefined' || 
			complexTypes.length <= 0	) {
			complexTypes = new Array();
		}
		
		if(originalArray.length == 0){
			angular.forEach(newArray, function(value, key) {
				delete value['@id'];
				value = changeComplexTypes(complexTypes, value);
				originalArray.push(value);
			});
			
			return originalArray; 
		}
		
		angular.forEach(newArray, function(element, key) {
			if(check){
				angular.forEach(originalArray, function(value2, key2) {
					if(value2.id == element.id){
						canAdd = false;
						return false;
					}
					else{
						canAdd = true;
					}
				});
			}
			
			if(canAdd){
				delete element['@id'];
				element = changeComplexTypes(complexTypes, element);
				originalArray.push(element);
			}
		});
		
		return originalArray;
	};
	
	APP.randomBoolean = function() {
		return APP.parseBoolean(APP.randomNumber(0, 1));
	};
	
	APP.parseBoolean = function(integer) {
		if(integer == 0){
			return false;
		}
		else {
			return true;
		}
	};
	
	APP.parseData = function(string) {
		//reg: yyyy-MM-dd HH:mm
		var rawData = string.split(" ");
		
		var date = rawData[0].split("-"); 
		var time = rawData[1].split(":");
		
//		var result = new Date(date[0], date[1]-1, date[2], time[0], time[1]);  
		
		return new Date(date[0], date[1]-1, date[2], time[0], time[1]);;
	};
	
	APP.createCookie = function(name, value, days) {
	    var expires;
	    if (days) {
	        var date = new Date();
	        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	        expires = "; expires=" + date.toGMTString();
	    }
	    else {
	        expires = "";
	    }
	    document.cookie = name + "=" + value + expires + "; path=/";
	};

	APP.getCookie = function getCookie(c_name) {
	    if (document.cookie.length > 0) {
	        c_start = document.cookie.indexOf(c_name + "=");
	        if (c_start != -1) {
	            c_start = c_start + c_name.length + 1;
	            c_end = document.cookie.indexOf(";", c_start);
	            if (c_end == -1) {
	                c_end = document.cookie.length;
	            }
	            return unescape(document.cookie.substring(c_start, c_end));
	        }
	    }
	    return "";
	};
	
	APP.pathToName = function getCookie(name) {
		if (!angular.isDefined(name) || name == null) {
			name = '';
		}
		
		name = name.replace("/", "");
		if (name.length == 0) {
			name = 'root';
		}
		
		return name;
	};
	
//#--------------------------------------------------
	
	
	if ((typeof module !== "undefined" && module !== null) && module.exports) {
		module.exports = APP;
	}
	
	if (typeof window !== "undefined" && window !== null) {
		window.APP = APP;
	}
	
	if (typeof define === 'function' && define.amd) {
			define('APP', new Array(), function() {
			return APP;
		});
	}
	
	return APP;

}).call(this);