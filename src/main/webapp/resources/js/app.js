'use strict';

angular.module('shopApp', [
	  'ngRoute'        
	, 'ngSanitize'     
	, 'ngStorage' 
	, 'toaster' 
  	, 'ui.bootstrap'
  	, 'shopApp.filters'
  	, 'shopApp.services'
  	, 'shopApp.services.static'
  	, 'shopApp.controllers.static'
  	, 'shopApp.directives'
  	, 'mgo-angular-wizard'
  	, 'infinite-scroll'
// 	, 'textAngular'
//  	, 'angularFileUpload'
])
.config(function ($routeProvider, $httpProvider) {

	$routeProvider.when('/', 						{ templateUrl: 'main' });
	$routeProvider.when('/hotel_detail/:id',		{ templateUrl: 'hotel_detail' });
	$routeProvider.when('/hotel_detail_old/:id',	{ templateUrl: 'hotel_detail_vol_1' });
	$routeProvider.when('/register_page',			{ templateUrl: 'register_page' , controller: 'UserRegistrationCtrl' });
	
	$routeProvider.when('/landscape_detail/:id',	{ templateUrl: 'landscape_detail' });
	$routeProvider.when('/all_modules', 			{ templateUrl: 'all_modules' });
	$routeProvider.when('/layout_3', 				{ templateUrl: 'layout_3' });
	$routeProvider.when('/standart_layout', 		{ templateUrl: 'standart_layout' });
	$routeProvider.when('/standart_payment', 		{ templateUrl: 'standart_payment' });
	$routeProvider.when('/standart_services', 		{ templateUrl: 'standart_services' });
	$routeProvider.when('/hello', 					{ templateUrl: 'hello'			, controller: 'IndexCtrl' });
	$routeProvider.when('/shop_landscape', 			{ templateUrl: 'shop_landscape' });
	$routeProvider.when('/shophotel-big', 			{ templateUrl: 'shophotel-big' });
	$routeProvider.when('/shophotel-medium',		{ templateUrl: 'shophotel-medium' });
	$routeProvider.when('/shophotel-small', 		{ templateUrl: 'shophotel-small' });
	$routeProvider.when('/shophotel-small-2', 		{ templateUrl: 'shophotel-small-2' });
	$routeProvider.when('/servhotelDetail', 		{ templateUrl: 'servhotelDetail' });
	$routeProvider.when('/dict', 					{ templateUrl: 'dict' });
	$routeProvider.when('/help', 					{ templateUrl: 'help' });
	$routeProvider.when('/upload', 					{ templateUrl: 'upload' });
	$routeProvider.when('/upload2', 				{ templateUrl: 'upload2' });
	$routeProvider.when('/logs', 					{ templateUrl: 'logs'			, controller: 'LogsListCtrl' });
	$routeProvider.when('/timeline', 				{ templateUrl: 'timeline'		, controller: 'TimelineCtrl' });
	$routeProvider.when('/gantt', 					{ templateUrl: 'gantt'			, controller: 'GanttCtrl' });
	$routeProvider.when('/localization', 			{ templateUrl: 'localization'	, controller: 'LocalizationListCtrl' });

	$routeProvider.when('/CurrcourseList', {templateUrl: 'CurrcourseList', controller: 'CurrCourseListCtrl'	});
	$routeProvider.when('/CurrcourseEdit/:id', {templateUrl: 'CurrcourseEdit', controller: 'CurrCourseEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcourse' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcourseCreate', {templateUrl: 'CurrcourseEdit', controller: 'CurrCourseEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcourse' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcurrencyList', {templateUrl: 'CurrcurrencyList', controller: 'CurrCurrencyListCtrl'	});
	$routeProvider.when('/CurrcurrencyEdit/:id', {templateUrl: 'CurrcurrencyEdit', controller: 'CurrCurrencyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcurrency' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcurrencyCreate', {templateUrl: 'CurrcurrencyEdit', controller: 'CurrCurrencyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcurrency' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DictglobalList', {templateUrl: 'DictglobalList', controller: 'DictGlobalListCtrl'	});
	$routeProvider.when('/DictglobalEdit/:id', {templateUrl: 'DictglobalEdit', controller: 'DictGlobalEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'dictglobal' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DictglobalCreate', {templateUrl: 'DictglobalEdit', controller: 'DictGlobalEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'dictglobal' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DocdocumentsList', {templateUrl: 'DocdocumentsList', controller: 'DocDocumentsListCtrl'	});
	$routeProvider.when('/DocdocumentsEdit/:id', {templateUrl: 'DocdocumentsEdit', controller: 'DocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'docdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DocdocumentsCreate', {templateUrl: 'DocdocumentsEdit', controller: 'DocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'docdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/GroupglobalList', {templateUrl: 'GroupglobalList', controller: 'GroupGlobalListCtrl'	});
	$routeProvider.when('/GroupglobalEdit/:id', {templateUrl: 'GroupglobalEdit', controller: 'GroupGlobalEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'groupglobal' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/GroupglobalCreate', {templateUrl: 'GroupglobalEdit', controller: 'GroupGlobalEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'groupglobal' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfocontactinformationList', {templateUrl: 'InfocontactinformationList', controller: 'InfoContactInformationListCtrl'	});
	$routeProvider.when('/InfocontactinformationEdit/:id', {templateUrl: 'InfocontactinformationEdit', controller: 'InfoContactInformationEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infocontactinformation' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfocontactinformationCreate', {templateUrl: 'InfocontactinformationEdit', controller: 'InfoContactInformationEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infocontactinformation' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfoservicesList', {templateUrl: 'InfoservicesList', controller: 'InfoServicesListCtrl'	});
	$routeProvider.when('/InfoservicesEdit/:id', {templateUrl: 'InfoservicesEdit', controller: 'InfoServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infoservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfoservicesCreate', {templateUrl: 'InfoservicesEdit', controller: 'InfoServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infoservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationaddressList', {templateUrl: 'LocationaddressList', controller: 'LocationAddressListCtrl'	});
	$routeProvider.when('/LocationaddressEdit/:id', {templateUrl: 'LocationaddressEdit', controller: 'LocationAddressEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationaddress' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationaddressCreate', {templateUrl: 'LocationaddressEdit', controller: 'LocationAddressEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationaddress' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcitiesList', {templateUrl: 'LocationcitiesList', controller: 'LocationCitiesListCtrl'	});
	$routeProvider.when('/LocationcitiesEdit/:id', {templateUrl: 'LocationcitiesEdit', controller: 'LocationCitiesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcities' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcitiesCreate', {templateUrl: 'LocationcitiesEdit', controller: 'LocationCitiesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcities' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcountriesList', {templateUrl: 'LocationcountriesList', controller: 'LocationCountriesListCtrl'	});
	$routeProvider.when('/LocationcountriesEdit/:id', {templateUrl: 'LocationcountriesEdit', controller: 'LocationCountriesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcountries' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcountriesCreate', {templateUrl: 'LocationcountriesEdit', controller: 'LocationCountriesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcountries' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationtypeplacementList', {templateUrl: 'LocationtypeplacementList', controller: 'LocationTypePlacementListCtrl'	});
	$routeProvider.when('/LocationtypeplacementEdit/:id', {templateUrl: 'LocationtypeplacementEdit', controller: 'LocationTypePlacementEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationtypeplacement' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationtypeplacementCreate', {templateUrl: 'LocationtypeplacementEdit', controller: 'LocationTypePlacementEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationtypeplacement' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountList', {templateUrl: 'PaymentaccountList', controller: 'PaymentAccountListCtrl'	});
	$routeProvider.when('/PaymentaccountEdit/:id', {templateUrl: 'PaymentaccountEdit', controller: 'PaymentAccountEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccount' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountCreate', {templateUrl: 'PaymentaccountEdit', controller: 'PaymentAccountEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccount' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountrecordList', {templateUrl: 'PaymentaccountrecordList', controller: 'PaymentAccountRecordListCtrl'	});
	$routeProvider.when('/PaymentaccountrecordEdit/:id', {templateUrl: 'PaymentaccountrecordEdit', controller: 'PaymentAccountRecordEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccountrecord' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountrecordCreate', {templateUrl: 'PaymentaccountrecordEdit', controller: 'PaymentAccountRecordEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccountrecord' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactList', {templateUrl: 'PaymentcontactList', controller: 'PaymentContactListCtrl'	});
	$routeProvider.when('/PaymentcontactEdit/:id', {templateUrl: 'PaymentcontactEdit', controller: 'PaymentContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactCreate', {templateUrl: 'PaymentcontactEdit', controller: 'PaymentContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactrecordList', {templateUrl: 'PaymentcontactrecordList', controller: 'PaymentContactRecordListCtrl'	});
	$routeProvider.when('/PaymentcontactrecordEdit/:id', {templateUrl: 'PaymentcontactrecordEdit', controller: 'PaymentContactRecordEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontactrecord' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactrecordCreate', {templateUrl: 'PaymentcontactrecordEdit', controller: 'PaymentContactRecordEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontactrecord' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentdetailsList', {templateUrl: 'PaymentdetailsList', controller: 'PaymentDetailsListCtrl'	});
	$routeProvider.when('/PaymentdetailsEdit/:id', {templateUrl: 'PaymentdetailsEdit', controller: 'PaymentDetailsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentdetails' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentdetailsCreate', {templateUrl: 'PaymentdetailsEdit', controller: 'PaymentDetailsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentdetails' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentpriceList', {templateUrl: 'PaymentpriceList', controller: 'PaymentPriceListCtrl'	});
	$routeProvider.when('/PaymentpriceEdit/:id', {templateUrl: 'PaymentpriceEdit', controller: 'PaymentPriceEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentprice' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentpriceCreate', {templateUrl: 'PaymentpriceEdit', controller: 'PaymentPriceEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentprice' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymenttariffList', {templateUrl: 'PaymenttariffList', controller: 'PaymentTariffListCtrl'	});
	$routeProvider.when('/PaymenttariffEdit/:id', {templateUrl: 'PaymenttariffEdit', controller: 'PaymentTariffEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymenttariff' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymenttariffCreate', {templateUrl: 'PaymenttariffEdit', controller: 'PaymentTariffEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymenttariff' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelaccountcontactsList', {templateUrl: 'RelaccountcontactsList', controller: 'RelAccountContactsListCtrl'	});
	$routeProvider.when('/RelaccountcontactsEdit/:id', {templateUrl: 'RelaccountcontactsEdit', controller: 'RelAccountContactsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relaccountcontacts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelaccountcontactsCreate', {templateUrl: 'RelaccountcontactsEdit', controller: 'RelAccountContactsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relaccountcontacts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisecontactsList', {templateUrl: 'RelcruisecontactsList', controller: 'RelCruiseContactsListCtrl'	});
	$routeProvider.when('/RelcruisecontactsEdit/:id', {templateUrl: 'RelcruisecontactsEdit', controller: 'RelCruiseContactsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisecontacts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisecontactsCreate', {templateUrl: 'RelcruisecontactsEdit', controller: 'RelCruiseContactsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisecontacts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisedocsList', {templateUrl: 'RelcruisedocsList', controller: 'RelCruiseDocsListCtrl'	});
	$routeProvider.when('/RelcruisedocsEdit/:id', {templateUrl: 'RelcruisedocsEdit', controller: 'RelCruiseDocsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisedocs' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisedocsCreate', {templateUrl: 'RelcruisedocsEdit', controller: 'RelCruiseDocsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisedocs' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteldocdocumentsList', {templateUrl: 'RelreqservhoteldocdocumentsList', controller: 'RelReqServHotelDocDocumentsListCtrl'	});
	$routeProvider.when('/RelreqservhoteldocdocumentsEdit/:id', {templateUrl: 'RelreqservhoteldocdocumentsEdit', controller: 'RelReqServHotelDocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteldocdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteldocdocumentsCreate', {templateUrl: 'RelreqservhoteldocdocumentsEdit', controller: 'RelReqServHotelDocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteldocdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteltmcontacteasyList', {templateUrl: 'RelreqservhoteltmcontacteasyList', controller: 'RelReqServHotelTmContactEasyListCtrl'	});
	$routeProvider.when('/RelreqservhoteltmcontacteasyEdit/:id', {templateUrl: 'RelreqservhoteltmcontacteasyEdit', controller: 'RelReqServHotelTmContactEasyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteltmcontacteasy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteltmcontacteasyCreate', {templateUrl: 'RelreqservhoteltmcontacteasyEdit', controller: 'RelReqServHotelTmContactEasyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteltmcontacteasy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelcreditcardsList', {templateUrl: 'RelservhotelcreditcardsList', controller: 'RelServHotelCreditCardsListCtrl'	});
	$routeProvider.when('/RelservhotelcreditcardsEdit/:id', {templateUrl: 'RelservhotelcreditcardsEdit', controller: 'RelServHotelCreditCardsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelcreditcards' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelcreditcardsCreate', {templateUrl: 'RelservhotelcreditcardsEdit', controller: 'RelServHotelCreditCardsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelcreditcards' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhoteldocdocumentsList', {templateUrl: 'RelservhoteldocdocumentsList', controller: 'RelServHotelDocDocumentsListCtrl'	});
	$routeProvider.when('/RelservhoteldocdocumentsEdit/:id', {templateUrl: 'RelservhoteldocdocumentsEdit', controller: 'RelServHotelDocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhoteldocdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhoteldocdocumentsCreate', {templateUrl: 'RelservhoteldocdocumentsEdit', controller: 'RelServHotelDocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhoteldocdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelentertainmentandsportList', {templateUrl: 'RelservhotelentertainmentandsportList', controller: 'RelServHotelEntertainmentAndSportListCtrl'	});
	$routeProvider.when('/RelservhotelentertainmentandsportEdit/:id', {templateUrl: 'RelservhotelentertainmentandsportEdit', controller: 'RelServHotelEntertainmentAndSportEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelentertainmentandsport' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelentertainmentandsportCreate', {templateUrl: 'RelservhotelentertainmentandsportEdit', controller: 'RelServHotelEntertainmentAndSportEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelentertainmentandsport' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelfeaturesList', {templateUrl: 'RelservhotelfeaturesList', controller: 'RelServHotelFeaturesListCtrl'	});
	$routeProvider.when('/RelservhotelfeaturesEdit/:id', {templateUrl: 'RelservhotelfeaturesEdit', controller: 'RelServHotelFeaturesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelfeatures' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelfeaturesCreate', {templateUrl: 'RelservhotelfeaturesEdit', controller: 'RelServHotelFeaturesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelfeatures' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelimageList', {templateUrl: 'RelservhotelimageList', controller: 'RelServHotelImageListCtrl'	});
	$routeProvider.when('/RelservhotelimageEdit/:id', {templateUrl: 'RelservhotelimageEdit', controller: 'RelServHotelImageEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelimage' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelimageCreate', {templateUrl: 'RelservhotelimageEdit', controller: 'RelServHotelImageEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelimage' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfocommercialList', {templateUrl: 'RelservhotelinfocommercialList', controller: 'RelServHotelInfoCommercialListCtrl'	});
	$routeProvider.when('/RelservhotelinfocommercialEdit/:id', {templateUrl: 'RelservhotelinfocommercialEdit', controller: 'RelServHotelInfoCommercialEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfocommercial' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfocommercialCreate', {templateUrl: 'RelservhotelinfocommercialEdit', controller: 'RelServHotelInfoCommercialEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfocommercial' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfohotelservicesList', {templateUrl: 'RelservhotelinfohotelservicesList', controller: 'RelServHotelInfoHotelServicesListCtrl'	});
	$routeProvider.when('/RelservhotelinfohotelservicesEdit/:id', {templateUrl: 'RelservhotelinfohotelservicesEdit', controller: 'RelServHotelInfoHotelServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfohotelservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfohotelservicesCreate', {templateUrl: 'RelservhotelinfohotelservicesEdit', controller: 'RelServHotelInfoHotelServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfohotelservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfopoliciesList', {templateUrl: 'RelservhotelinfopoliciesList', controller: 'RelServHotelInfoPoliciesListCtrl'	});
	$routeProvider.when('/RelservhotelinfopoliciesEdit/:id', {templateUrl: 'RelservhotelinfopoliciesEdit', controller: 'RelServHotelInfoPoliciesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfopolicies' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfopoliciesCreate', {templateUrl: 'RelservhotelinfopoliciesEdit', controller: 'RelServHotelInfoPoliciesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfopolicies' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomfeaturesList', {templateUrl: 'RelservhotelroomfeaturesList', controller: 'RelServHotelRoomFeaturesListCtrl'	});
	$routeProvider.when('/RelservhotelroomfeaturesEdit/:id', {templateUrl: 'RelservhotelroomfeaturesEdit', controller: 'RelServHotelRoomFeaturesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomfeatures' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomfeaturesCreate', {templateUrl: 'RelservhotelroomfeaturesEdit', controller: 'RelServHotelRoomFeaturesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomfeatures' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomimageList', {templateUrl: 'RelservhotelroomimageList', controller: 'RelServHotelRoomImageListCtrl'	});
	$routeProvider.when('/RelservhotelroomimageEdit/:id', {templateUrl: 'RelservhotelroomimageEdit', controller: 'RelServHotelRoomImageEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomimage' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomimageCreate', {templateUrl: 'RelservhotelroomimageEdit', controller: 'RelServHotelRoomImageEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomimage' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelservkidsruleList', {templateUrl: 'RelservhotelservkidsruleList', controller: 'RelServHotelServKidsRuleListCtrl'	});
	$routeProvider.when('/RelservhotelservkidsruleEdit/:id', {templateUrl: 'RelservhotelservkidsruleEdit', controller: 'RelServHotelServKidsRuleEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelservkidsrule' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelservkidsruleCreate', {templateUrl: 'RelservhotelservkidsruleEdit', controller: 'RelServHotelServKidsRuleEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelservkidsrule' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservkidsrulefeaturesList', {templateUrl: 'RelservkidsrulefeaturesList', controller: 'RelServKidsRuleFeaturesListCtrl'	});
	$routeProvider.when('/RelservkidsrulefeaturesEdit/:id', {templateUrl: 'RelservkidsrulefeaturesEdit', controller: 'RelServKidsRuleFeaturesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservkidsrulefeatures' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservkidsrulefeaturesCreate', {templateUrl: 'RelservkidsrulefeaturesEdit', controller: 'RelServKidsRuleFeaturesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservkidsrulefeatures' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservtransfertmcontactList', {templateUrl: 'RelservtransfertmcontactList', controller: 'RelServTransferTmContactListCtrl'	});
	$routeProvider.when('/RelservtransfertmcontactEdit/:id', {templateUrl: 'RelservtransfertmcontactEdit', controller: 'RelServTransferTmContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservtransfertmcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservtransfertmcontactCreate', {templateUrl: 'RelservtransfertmcontactEdit', controller: 'RelServTransferTmContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservtransfertmcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderdocdocumentsList', {templateUrl: 'ReltmorderdocdocumentsList', controller: 'RelTmOrderDocDocumentsListCtrl'	});
	$routeProvider.when('/ReltmorderdocdocumentsEdit/:id', {templateUrl: 'ReltmorderdocdocumentsEdit', controller: 'RelTmOrderDocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderdocdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderdocdocumentsCreate', {templateUrl: 'ReltmorderdocdocumentsEdit', controller: 'RelTmOrderDocDocumentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderdocdocuments' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderinfoservicesList', {templateUrl: 'ReltmorderinfoservicesList', controller: 'RelTmOrderInfoServicesListCtrl'	});
	$routeProvider.when('/ReltmorderinfoservicesEdit/:id', {templateUrl: 'ReltmorderinfoservicesEdit', controller: 'RelTmOrderInfoServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderinfoservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderinfoservicesCreate', {templateUrl: 'ReltmorderinfoservicesEdit', controller: 'RelTmOrderInfoServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderinfoservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderservgiftsList', {templateUrl: 'ReltmorderservgiftsList', controller: 'RelTmOrderServGiftsListCtrl'	});
	$routeProvider.when('/ReltmorderservgiftsEdit/:id', {templateUrl: 'ReltmorderservgiftsEdit', controller: 'RelTmOrderServGiftsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderservgifts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderservgiftsCreate', {templateUrl: 'ReltmorderservgiftsEdit', controller: 'RelTmOrderServGiftsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderservgifts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmordertmcontactList', {templateUrl: 'ReltmordertmcontactList', controller: 'RelTmOrderTmContactListCtrl'	});
	$routeProvider.when('/ReltmordertmcontactEdit/:id', {templateUrl: 'ReltmordertmcontactEdit', controller: 'RelTmOrderTmContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmordertmcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmordertmcontactCreate', {templateUrl: 'ReltmordertmcontactEdit', controller: 'RelTmOrderTmContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmordertmcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourdocsList', {templateUrl: 'ReltourdocsList', controller: 'RelTourDocsListCtrl'	});
	$routeProvider.when('/ReltourdocsEdit/:id', {templateUrl: 'ReltourdocsEdit', controller: 'RelTourDocsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourdocs' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourdocsCreate', {templateUrl: 'ReltourdocsEdit', controller: 'RelTourDocsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourdocs' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourhotelsList', {templateUrl: 'ReltourhotelsList', controller: 'RelTourHotelsListCtrl'	});
	$routeProvider.when('/ReltourhotelsEdit/:id', {templateUrl: 'ReltourhotelsEdit', controller: 'RelTourHotelsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourhotels' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourhotelsCreate', {templateUrl: 'ReltourhotelsEdit', controller: 'RelTourHotelsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourhotels' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourservicesList', {templateUrl: 'ReltourservicesList', controller: 'RelTourServicesListCtrl'	});
	$routeProvider.when('/ReltourservicesEdit/:id', {templateUrl: 'ReltourservicesEdit', controller: 'RelTourServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourservicesCreate', {templateUrl: 'ReltourservicesEdit', controller: 'RelTourServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruisehotelsList', {templateUrl: 'ReqcruisehotelsList', controller: 'ReqCruiseHotelsListCtrl'	});
	$routeProvider.when('/ReqcruisehotelsEdit/:id', {templateUrl: 'ReqcruisehotelsEdit', controller: 'ReqCruiseHotelsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruisehotels' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruisehotelsCreate', {templateUrl: 'ReqcruisehotelsEdit', controller: 'ReqCruiseHotelsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruisehotels' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruiseservicesList', {templateUrl: 'ReqcruiseservicesList', controller: 'ReqCruiseServicesListCtrl'	});
	$routeProvider.when('/ReqcruiseservicesEdit/:id', {templateUrl: 'ReqcruiseservicesEdit', controller: 'ReqCruiseServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruiseservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruiseservicesCreate', {templateUrl: 'ReqcruiseservicesEdit', controller: 'ReqCruiseServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruiseservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqhotelroomsbusyList', {templateUrl: 'ReqhotelroomsbusyList', controller: 'ReqHotelRoomsBusyListCtrl'	});
	$routeProvider.when('/ReqhotelroomsbusyEdit/:id', {templateUrl: 'ReqhotelroomsbusyEdit', controller: 'ReqHotelRoomsBusyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqhotelroomsbusy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqhotelroomsbusyCreate', {templateUrl: 'ReqhotelroomsbusyEdit', controller: 'ReqHotelRoomsBusyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqhotelroomsbusy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelList', {templateUrl: 'ReqservhotelList', controller: 'ReqServHotelListCtrl'	});
	$routeProvider.when('/ReqservhotelEdit/:id', {templateUrl: 'ReqservhotelEdit', controller: 'ReqServHotelEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotel' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelCreate', {templateUrl: 'ReqservhotelEdit', controller: 'ReqServHotelEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotel' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelroombusyList', {templateUrl: 'ReqservhotelroombusyList', controller: 'ReqServHotelRoomBusyListCtrl'	});
	$routeProvider.when('/ReqservhotelroombusyEdit/:id', {templateUrl: 'ReqservhotelroombusyEdit', controller: 'ReqServHotelRoomBusyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotelroombusy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelroombusyCreate', {templateUrl: 'ReqservhotelroombusyEdit', controller: 'ReqServHotelRoomBusyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotelroombusy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServcruiseList', {templateUrl: 'ServcruiseList', controller: 'ServCruiseListCtrl'	});
	$routeProvider.when('/ServcruiseEdit/:id', {templateUrl: 'ServcruiseEdit', controller: 'ServCruiseEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servcruise' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServcruiseCreate', {templateUrl: 'ServcruiseEdit', controller: 'ServCruiseEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servcruise' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServexcursionsList', {templateUrl: 'ServexcursionsList', controller: 'ServExcursionsListCtrl'	});
	$routeProvider.when('/ServexcursionsEdit/:id', {templateUrl: 'ServexcursionsEdit', controller: 'ServExcursionsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servexcursions' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServexcursionsCreate', {templateUrl: 'ServexcursionsEdit', controller: 'ServExcursionsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servexcursions' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServgiftsList', {templateUrl: 'ServgiftsList', controller: 'ServGiftsListCtrl'	});
	$routeProvider.when('/ServgiftsEdit/:id', {templateUrl: 'ServgiftsEdit', controller: 'ServGiftsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servgifts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServgiftsCreate', {templateUrl: 'ServgiftsEdit', controller: 'ServGiftsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servgifts' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelList', {templateUrl: 'ServhotelList', controller: 'ServHotelListCtrl'	});
	$routeProvider.when('/ServhotelEdit/:id', {templateUrl: 'ServhotelEdit', controller: 'ServHotelEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotel' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelCreate', {templateUrl: 'ServhotelEdit', controller: 'ServHotelEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotel' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelroomList', {templateUrl: 'ServhotelroomList', controller: 'ServHotelRoomListCtrl'	});
	$routeProvider.when('/ServhotelroomEdit/:id', {templateUrl: 'ServhotelroomEdit', controller: 'ServHotelRoomEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelroom' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelroomCreate', {templateUrl: 'ServhotelroomEdit', controller: 'ServHotelRoomEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelroom' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelservicesList', {templateUrl: 'ServhotelservicesList', controller: 'ServHotelServicesListCtrl'	});
	$routeProvider.when('/ServhotelservicesEdit/:id', {templateUrl: 'ServhotelservicesEdit', controller: 'ServHotelServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelservicesCreate', {templateUrl: 'ServhotelservicesEdit', controller: 'ServHotelServicesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelservices' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServinsurancesList', {templateUrl: 'ServinsurancesList', controller: 'ServInsurancesListCtrl'	});
	$routeProvider.when('/ServinsurancesEdit/:id', {templateUrl: 'ServinsurancesEdit', controller: 'ServInsurancesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servinsurances' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServinsurancesCreate', {templateUrl: 'ServinsurancesEdit', controller: 'ServInsurancesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servinsurances' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServkidsruleList', {templateUrl: 'ServkidsruleList', controller: 'ServKidsRuleListCtrl'	});
	$routeProvider.when('/ServkidsruleEdit/:id', {templateUrl: 'ServkidsruleEdit', controller: 'ServKidsRuleEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servkidsrule' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServkidsruleCreate', {templateUrl: 'ServkidsruleEdit', controller: 'ServKidsRuleEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servkidsrule' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsairList', {templateUrl: 'ServticketsairList', controller: 'ServTicketsAirListCtrl'	});
	$routeProvider.when('/ServticketsairEdit/:id', {templateUrl: 'ServticketsairEdit', controller: 'ServTicketsAirEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsair' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsairCreate', {templateUrl: 'ServticketsairEdit', controller: 'ServTicketsAirEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsair' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsrailList', {templateUrl: 'ServticketsrailList', controller: 'ServTicketsRailListCtrl'	});
	$routeProvider.when('/ServticketsrailEdit/:id', {templateUrl: 'ServticketsrailEdit', controller: 'ServTicketsRailEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsrail' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsrailCreate', {templateUrl: 'ServticketsrailEdit', controller: 'ServTicketsRailEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsrail' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtourList', {templateUrl: 'ServtourList', controller: 'ServTourListCtrl'	});
	$routeProvider.when('/ServtourEdit/:id', {templateUrl: 'ServtourEdit', controller: 'ServTourEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtour' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtourCreate', {templateUrl: 'ServtourEdit', controller: 'ServTourEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtour' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferList', {templateUrl: 'ServtransferList', controller: 'ServTransferListCtrl'	});
	$routeProvider.when('/ServtransferEdit/:id', {templateUrl: 'ServtransferEdit', controller: 'ServTransferEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransfer' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferCreate', {templateUrl: 'ServtransferEdit', controller: 'ServTransferEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransfer' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferrouteList', {templateUrl: 'ServtransferrouteList', controller: 'ServTransferRouteListCtrl'	});
	$routeProvider.when('/ServtransferrouteEdit/:id', {templateUrl: 'ServtransferrouteEdit', controller: 'ServTransferRouteEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferroute' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferrouteCreate', {templateUrl: 'ServtransferrouteEdit', controller: 'ServTransferRouteEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferroute' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferroutepointList', {templateUrl: 'ServtransferroutepointList', controller: 'ServTransferRoutePointListCtrl'	});
	$routeProvider.when('/ServtransferroutepointEdit/:id', {templateUrl: 'ServtransferroutepointEdit', controller: 'ServTransferRoutePointEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferroutepoint' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferroutepointCreate', {templateUrl: 'ServtransferroutepointEdit', controller: 'ServTransferRoutePointEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferroutepoint' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServvisasList', {templateUrl: 'ServvisasList', controller: 'ServVisasListCtrl'	});
	$routeProvider.when('/ServvisasEdit/:id', {templateUrl: 'ServvisasEdit', controller: 'ServVisasEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servvisas' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServvisasCreate', {templateUrl: 'ServvisasEdit', controller: 'ServVisasEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servvisas' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountList', {templateUrl: 'TmaccountList', controller: 'TmAccountListCtrl'	});
	$routeProvider.when('/TmaccountEdit/:id', {templateUrl: 'TmaccountEdit', controller: 'TmAccountEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccount' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountCreate', {templateUrl: 'TmaccountEdit', controller: 'TmAccountEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccount' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountaddressesList', {templateUrl: 'TmaccountaddressesList', controller: 'TmAccountAddressesListCtrl'	});
	$routeProvider.when('/TmaccountaddressesEdit/:id', {templateUrl: 'TmaccountaddressesEdit', controller: 'TmAccountAddressesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountaddresses' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountaddressesCreate', {templateUrl: 'TmaccountaddressesEdit', controller: 'TmAccountAddressesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountaddresses' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountcommunicationsList', {templateUrl: 'TmaccountcommunicationsList', controller: 'TmAccountCommunicationsListCtrl'	});
	$routeProvider.when('/TmaccountcommunicationsEdit/:id', {templateUrl: 'TmaccountcommunicationsEdit', controller: 'TmAccountCommunicationsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountcommunications' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountcommunicationsCreate', {templateUrl: 'TmaccountcommunicationsEdit', controller: 'TmAccountCommunicationsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountcommunications' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountdetailsList', {templateUrl: 'TmaccountdetailsList', controller: 'TmAccountDetailsListCtrl'	});
	$routeProvider.when('/TmaccountdetailsEdit/:id', {templateUrl: 'TmaccountdetailsEdit', controller: 'TmAccountDetailsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountdetails' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountdetailsCreate', {templateUrl: 'TmaccountdetailsEdit', controller: 'TmAccountDetailsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountdetails' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcommercialList', {templateUrl: 'TmcommercialList', controller: 'TmCommercialListCtrl'	});
	$routeProvider.when('/TmcommercialEdit/:id', {templateUrl: 'TmcommercialEdit', controller: 'TmCommercialEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcommercial' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcommercialCreate', {templateUrl: 'TmcommercialEdit', controller: 'TmCommercialEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcommercial' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactList', {templateUrl: 'TmcontactList', controller: 'TmContactListCtrl'	});
	$routeProvider.when('/TmcontactEdit/:id', {templateUrl: 'TmcontactEdit', controller: 'TmContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactCreate', {templateUrl: 'TmcontactEdit', controller: 'TmContactEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontact' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactaddressesList', {templateUrl: 'TmcontactaddressesList', controller: 'TmContactAddressesListCtrl'	});
	$routeProvider.when('/TmcontactaddressesEdit/:id', {templateUrl: 'TmcontactaddressesEdit', controller: 'TmContactAddressesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactaddresses' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactaddressesCreate', {templateUrl: 'TmcontactaddressesEdit', controller: 'TmContactAddressesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactaddresses' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactcommunicationsList', {templateUrl: 'TmcontactcommunicationsList', controller: 'TmContactCommunicationsListCtrl'	});
	$routeProvider.when('/TmcontactcommunicationsEdit/:id', {templateUrl: 'TmcontactcommunicationsEdit', controller: 'TmContactCommunicationsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactcommunications' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactcommunicationsCreate', {templateUrl: 'TmcontactcommunicationsEdit', controller: 'TmContactCommunicationsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactcommunications' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontacteasyList', {templateUrl: 'TmcontacteasyList', controller: 'TmContactEasyListCtrl'	});
	$routeProvider.when('/TmcontacteasyEdit/:id', {templateUrl: 'TmcontacteasyEdit', controller: 'TmContactEasyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontacteasy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontacteasyCreate', {templateUrl: 'TmcontacteasyEdit', controller: 'TmContactEasyEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontacteasy' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmfirmsList', {templateUrl: 'TmfirmsList', controller: 'TmFirmsListCtrl'	});
	$routeProvider.when('/TmfirmsEdit/:id', {templateUrl: 'TmfirmsEdit', controller: 'TmFirmsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmfirms' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmfirmsCreate', {templateUrl: 'TmfirmsEdit', controller: 'TmFirmsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmfirms' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmimageList', {templateUrl: 'TmimageList', controller: 'TmImageListCtrl'	});
	$routeProvider.when('/TmimageEdit/:id', {templateUrl: 'TmimageEdit', controller: 'TmImageEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmimage' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmimageCreate', {templateUrl: 'TmimageEdit', controller: 'TmImageEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmimage' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmincidentsList', {templateUrl: 'TmincidentsList', controller: 'TmIncidentsListCtrl'	});
	$routeProvider.when('/TmincidentsEdit/:id', {templateUrl: 'TmincidentsEdit', controller: 'TmIncidentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmincidents' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmincidentsCreate', {templateUrl: 'TmincidentsEdit', controller: 'TmIncidentsEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmincidents' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmorderList', {templateUrl: 'TmorderList', controller: 'TmOrderListCtrl'	});
	$routeProvider.when('/TmorderEdit/:id', {templateUrl: 'TmorderEdit', controller: 'TmOrderEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmorder' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmorderCreate', {templateUrl: 'TmorderEdit', controller: 'TmOrderEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmorder' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmpoliciesList', {templateUrl: 'TmpoliciesList', controller: 'TmPoliciesListCtrl'	});
	$routeProvider.when('/TmpoliciesEdit/:id', {templateUrl: 'TmpoliciesEdit', controller: 'TmPoliciesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmpolicies' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmpoliciesCreate', {templateUrl: 'TmpoliciesEdit', controller: 'TmPoliciesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmpolicies' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmuserinfoList', {templateUrl: 'TmuserinfoList', controller: 'TmUserInfoListCtrl'	});
	$routeProvider.when('/TmuserinfoEdit/:id', {templateUrl: 'TmuserinfoEdit', controller: 'TmUserInfoEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmuserinfo' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmuserinfoCreate', {templateUrl: 'TmuserinfoEdit', controller: 'TmUserInfoEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmuserinfo' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UserrolesList', {templateUrl: 'UserrolesList', controller: 'UserRolesListCtrl'	});
	$routeProvider.when('/UserrolesEdit/:id', {templateUrl: 'UserrolesEdit', controller: 'UserRolesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'userroles' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UserrolesCreate', {templateUrl: 'UserrolesEdit', controller: 'UserRolesEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'userroles' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UsersList', {templateUrl: 'UsersList', controller: 'UsersListCtrl'	});
	$routeProvider.when('/UsersEdit/:id', {templateUrl: 'UsersEdit', controller: 'UsersEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'users' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UsersCreate', {templateUrl: 'UsersEdit', controller: 'UsersEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'users' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcourseviewList', {templateUrl: 'CurrcourseviewList', controller: 'CurrCourseViewListCtrl'	});
	$routeProvider.when('/CurrcourseviewEdit/:id', {templateUrl: 'CurrcourseviewEdit', controller: 'CurrCourseViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcourseview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcourseviewCreate', {templateUrl: 'CurrcourseviewEdit', controller: 'CurrCourseViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcourseview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcurrencyviewList', {templateUrl: 'CurrcurrencyviewList', controller: 'CurrCurrencyViewListCtrl'	});
	$routeProvider.when('/CurrcurrencyviewEdit/:id', {templateUrl: 'CurrcurrencyviewEdit', controller: 'CurrCurrencyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcurrencyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/CurrcurrencyviewCreate', {templateUrl: 'CurrcurrencyviewEdit', controller: 'CurrCurrencyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'currcurrencyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DictglobalviewList', {templateUrl: 'DictglobalviewList', controller: 'DictGlobalViewListCtrl'	});
	$routeProvider.when('/DictglobalviewEdit/:id', {templateUrl: 'DictglobalviewEdit', controller: 'DictGlobalViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'dictglobalview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DictglobalviewCreate', {templateUrl: 'DictglobalviewEdit', controller: 'DictGlobalViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'dictglobalview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DocdocumentsviewList', {templateUrl: 'DocdocumentsviewList', controller: 'DocDocumentsViewListCtrl'	});
	$routeProvider.when('/DocdocumentsviewEdit/:id', {templateUrl: 'DocdocumentsviewEdit', controller: 'DocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'docdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/DocdocumentsviewCreate', {templateUrl: 'DocdocumentsviewEdit', controller: 'DocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'docdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/GroupglobalviewList', {templateUrl: 'GroupglobalviewList', controller: 'GroupGlobalViewListCtrl'	});
	$routeProvider.when('/GroupglobalviewEdit/:id', {templateUrl: 'GroupglobalviewEdit', controller: 'GroupGlobalViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'groupglobalview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/GroupglobalviewCreate', {templateUrl: 'GroupglobalviewEdit', controller: 'GroupGlobalViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'groupglobalview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfocontactinformationviewList', {templateUrl: 'InfocontactinformationviewList', controller: 'InfoContactInformationViewListCtrl'	});
	$routeProvider.when('/InfocontactinformationviewEdit/:id', {templateUrl: 'InfocontactinformationviewEdit', controller: 'InfoContactInformationViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infocontactinformationview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfocontactinformationviewCreate', {templateUrl: 'InfocontactinformationviewEdit', controller: 'InfoContactInformationViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infocontactinformationview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfoservicesviewList', {templateUrl: 'InfoservicesviewList', controller: 'InfoServicesViewListCtrl'	});
	$routeProvider.when('/InfoservicesviewEdit/:id', {templateUrl: 'InfoservicesviewEdit', controller: 'InfoServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infoservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/InfoservicesviewCreate', {templateUrl: 'InfoservicesviewEdit', controller: 'InfoServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'infoservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationaddressviewList', {templateUrl: 'LocationaddressviewList', controller: 'LocationAddressViewListCtrl'	});
	$routeProvider.when('/LocationaddressviewEdit/:id', {templateUrl: 'LocationaddressviewEdit', controller: 'LocationAddressViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationaddressview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationaddressviewCreate', {templateUrl: 'LocationaddressviewEdit', controller: 'LocationAddressViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationaddressview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcitiesviewList', {templateUrl: 'LocationcitiesviewList', controller: 'LocationCitiesViewListCtrl'	});
	$routeProvider.when('/LocationcitiesviewEdit/:id', {templateUrl: 'LocationcitiesviewEdit', controller: 'LocationCitiesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcitiesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcitiesviewCreate', {templateUrl: 'LocationcitiesviewEdit', controller: 'LocationCitiesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcitiesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcountriesviewList', {templateUrl: 'LocationcountriesviewList', controller: 'LocationCountriesViewListCtrl'	});
	$routeProvider.when('/LocationcountriesviewEdit/:id', {templateUrl: 'LocationcountriesviewEdit', controller: 'LocationCountriesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcountriesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationcountriesviewCreate', {templateUrl: 'LocationcountriesviewEdit', controller: 'LocationCountriesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationcountriesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationtypeplacementviewList', {templateUrl: 'LocationtypeplacementviewList', controller: 'LocationTypePlacementViewListCtrl'	});
	$routeProvider.when('/LocationtypeplacementviewEdit/:id', {templateUrl: 'LocationtypeplacementviewEdit', controller: 'LocationTypePlacementViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationtypeplacementview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/LocationtypeplacementviewCreate', {templateUrl: 'LocationtypeplacementviewEdit', controller: 'LocationTypePlacementViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'locationtypeplacementview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/OtherservicesstoreviewList', {templateUrl: 'OtherservicesstoreviewList', controller: 'OtherServicesStoreViewListCtrl'	});
	$routeProvider.when('/OtherservicesstoreviewEdit/:id', {templateUrl: 'OtherservicesstoreviewEdit', controller: 'OtherServicesStoreViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'otherservicesstoreview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/OtherservicesstoreviewCreate', {templateUrl: 'OtherservicesstoreviewEdit', controller: 'OtherServicesStoreViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'otherservicesstoreview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountrecordviewList', {templateUrl: 'PaymentaccountrecordviewList', controller: 'PaymentAccountRecordViewListCtrl'	});
	$routeProvider.when('/PaymentaccountrecordviewEdit/:id', {templateUrl: 'PaymentaccountrecordviewEdit', controller: 'PaymentAccountRecordViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccountrecordview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountrecordviewCreate', {templateUrl: 'PaymentaccountrecordviewEdit', controller: 'PaymentAccountRecordViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccountrecordview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountviewList', {templateUrl: 'PaymentaccountviewList', controller: 'PaymentAccountViewListCtrl'	});
	$routeProvider.when('/PaymentaccountviewEdit/:id', {templateUrl: 'PaymentaccountviewEdit', controller: 'PaymentAccountViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccountview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentaccountviewCreate', {templateUrl: 'PaymentaccountviewEdit', controller: 'PaymentAccountViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentaccountview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactrecordviewList', {templateUrl: 'PaymentcontactrecordviewList', controller: 'PaymentContactRecordViewListCtrl'	});
	$routeProvider.when('/PaymentcontactrecordviewEdit/:id', {templateUrl: 'PaymentcontactrecordviewEdit', controller: 'PaymentContactRecordViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontactrecordview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactrecordviewCreate', {templateUrl: 'PaymentcontactrecordviewEdit', controller: 'PaymentContactRecordViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontactrecordview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactviewList', {templateUrl: 'PaymentcontactviewList', controller: 'PaymentContactViewListCtrl'	});
	$routeProvider.when('/PaymentcontactviewEdit/:id', {templateUrl: 'PaymentcontactviewEdit', controller: 'PaymentContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentcontactviewCreate', {templateUrl: 'PaymentcontactviewEdit', controller: 'PaymentContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentdetailsviewList', {templateUrl: 'PaymentdetailsviewList', controller: 'PaymentDetailsViewListCtrl'	});
	$routeProvider.when('/PaymentdetailsviewEdit/:id', {templateUrl: 'PaymentdetailsviewEdit', controller: 'PaymentDetailsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentdetailsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentdetailsviewCreate', {templateUrl: 'PaymentdetailsviewEdit', controller: 'PaymentDetailsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentdetailsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentpriceviewList', {templateUrl: 'PaymentpriceviewList', controller: 'PaymentPriceViewListCtrl'	});
	$routeProvider.when('/PaymentpriceviewEdit/:id', {templateUrl: 'PaymentpriceviewEdit', controller: 'PaymentPriceViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentpriceview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymentpriceviewCreate', {templateUrl: 'PaymentpriceviewEdit', controller: 'PaymentPriceViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymentpriceview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymenttariffviewList', {templateUrl: 'PaymenttariffviewList', controller: 'PaymentTariffViewListCtrl'	});
	$routeProvider.when('/PaymenttariffviewEdit/:id', {templateUrl: 'PaymenttariffviewEdit', controller: 'PaymentTariffViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymenttariffview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/PaymenttariffviewCreate', {templateUrl: 'PaymenttariffviewEdit', controller: 'PaymentTariffViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'paymenttariffview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelaccountcontactsviewList', {templateUrl: 'RelaccountcontactsviewList', controller: 'RelAccountContactsViewListCtrl'	});
	$routeProvider.when('/RelaccountcontactsviewEdit/:id', {templateUrl: 'RelaccountcontactsviewEdit', controller: 'RelAccountContactsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relaccountcontactsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelaccountcontactsviewCreate', {templateUrl: 'RelaccountcontactsviewEdit', controller: 'RelAccountContactsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relaccountcontactsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisecontactsviewList', {templateUrl: 'RelcruisecontactsviewList', controller: 'RelCruiseContactsViewListCtrl'	});
	$routeProvider.when('/RelcruisecontactsviewEdit/:id', {templateUrl: 'RelcruisecontactsviewEdit', controller: 'RelCruiseContactsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisecontactsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisecontactsviewCreate', {templateUrl: 'RelcruisecontactsviewEdit', controller: 'RelCruiseContactsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisecontactsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisedocsviewList', {templateUrl: 'RelcruisedocsviewList', controller: 'RelCruiseDocsViewListCtrl'	});
	$routeProvider.when('/RelcruisedocsviewEdit/:id', {templateUrl: 'RelcruisedocsviewEdit', controller: 'RelCruiseDocsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisedocsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelcruisedocsviewCreate', {templateUrl: 'RelcruisedocsviewEdit', controller: 'RelCruiseDocsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relcruisedocsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteldocdocumentsviewList', {templateUrl: 'RelreqservhoteldocdocumentsviewList', controller: 'RelReqServHotelDocDocumentsViewListCtrl'	});
	$routeProvider.when('/RelreqservhoteldocdocumentsviewEdit/:id', {templateUrl: 'RelreqservhoteldocdocumentsviewEdit', controller: 'RelReqServHotelDocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteldocdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteldocdocumentsviewCreate', {templateUrl: 'RelreqservhoteldocdocumentsviewEdit', controller: 'RelReqServHotelDocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteldocdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteltmcontacteasyviewList', {templateUrl: 'RelreqservhoteltmcontacteasyviewList', controller: 'RelReqServHotelTmContactEasyViewListCtrl'	});
	$routeProvider.when('/RelreqservhoteltmcontacteasyviewEdit/:id', {templateUrl: 'RelreqservhoteltmcontacteasyviewEdit', controller: 'RelReqServHotelTmContactEasyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteltmcontacteasyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelreqservhoteltmcontacteasyviewCreate', {templateUrl: 'RelreqservhoteltmcontacteasyviewEdit', controller: 'RelReqServHotelTmContactEasyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relreqservhoteltmcontacteasyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelcreditcardsviewList', {templateUrl: 'RelservhotelcreditcardsviewList', controller: 'RelServHotelCreditCardsViewListCtrl'	});
	$routeProvider.when('/RelservhotelcreditcardsviewEdit/:id', {templateUrl: 'RelservhotelcreditcardsviewEdit', controller: 'RelServHotelCreditCardsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelcreditcardsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelcreditcardsviewCreate', {templateUrl: 'RelservhotelcreditcardsviewEdit', controller: 'RelServHotelCreditCardsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelcreditcardsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhoteldocdocumentsviewList', {templateUrl: 'RelservhoteldocdocumentsviewList', controller: 'RelServHotelDocDocumentsViewListCtrl'	});
	$routeProvider.when('/RelservhoteldocdocumentsviewEdit/:id', {templateUrl: 'RelservhoteldocdocumentsviewEdit', controller: 'RelServHotelDocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhoteldocdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhoteldocdocumentsviewCreate', {templateUrl: 'RelservhoteldocdocumentsviewEdit', controller: 'RelServHotelDocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhoteldocdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelentertainmentandsportviewList', {templateUrl: 'RelservhotelentertainmentandsportviewList', controller: 'RelServHotelEntertainmentAndSportViewListCtrl'	});
	$routeProvider.when('/RelservhotelentertainmentandsportviewEdit/:id', {templateUrl: 'RelservhotelentertainmentandsportviewEdit', controller: 'RelServHotelEntertainmentAndSportViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelentertainmentandsportview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelentertainmentandsportviewCreate', {templateUrl: 'RelservhotelentertainmentandsportviewEdit', controller: 'RelServHotelEntertainmentAndSportViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelentertainmentandsportview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelfeaturesviewList', {templateUrl: 'RelservhotelfeaturesviewList', controller: 'RelServHotelFeaturesViewListCtrl'	});
	$routeProvider.when('/RelservhotelfeaturesviewEdit/:id', {templateUrl: 'RelservhotelfeaturesviewEdit', controller: 'RelServHotelFeaturesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelfeaturesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelfeaturesviewCreate', {templateUrl: 'RelservhotelfeaturesviewEdit', controller: 'RelServHotelFeaturesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelfeaturesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelimageviewList', {templateUrl: 'RelservhotelimageviewList', controller: 'RelServHotelImageViewListCtrl'	});
	$routeProvider.when('/RelservhotelimageviewEdit/:id', {templateUrl: 'RelservhotelimageviewEdit', controller: 'RelServHotelImageViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelimageview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelimageviewCreate', {templateUrl: 'RelservhotelimageviewEdit', controller: 'RelServHotelImageViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelimageview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfocommercialviewList', {templateUrl: 'RelservhotelinfocommercialviewList', controller: 'RelServHotelInfoCommercialViewListCtrl'	});
	$routeProvider.when('/RelservhotelinfocommercialviewEdit/:id', {templateUrl: 'RelservhotelinfocommercialviewEdit', controller: 'RelServHotelInfoCommercialViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfocommercialview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfocommercialviewCreate', {templateUrl: 'RelservhotelinfocommercialviewEdit', controller: 'RelServHotelInfoCommercialViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfocommercialview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfohotelservicesviewList', {templateUrl: 'RelservhotelinfohotelservicesviewList', controller: 'RelServHotelInfoHotelServicesViewListCtrl'	});
	$routeProvider.when('/RelservhotelinfohotelservicesviewEdit/:id', {templateUrl: 'RelservhotelinfohotelservicesviewEdit', controller: 'RelServHotelInfoHotelServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfohotelservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfohotelservicesviewCreate', {templateUrl: 'RelservhotelinfohotelservicesviewEdit', controller: 'RelServHotelInfoHotelServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfohotelservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfopoliciesviewList', {templateUrl: 'RelservhotelinfopoliciesviewList', controller: 'RelServHotelInfoPoliciesViewListCtrl'	});
	$routeProvider.when('/RelservhotelinfopoliciesviewEdit/:id', {templateUrl: 'RelservhotelinfopoliciesviewEdit', controller: 'RelServHotelInfoPoliciesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfopoliciesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelinfopoliciesviewCreate', {templateUrl: 'RelservhotelinfopoliciesviewEdit', controller: 'RelServHotelInfoPoliciesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelinfopoliciesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomfeaturesviewList', {templateUrl: 'RelservhotelroomfeaturesviewList', controller: 'RelServHotelRoomFeaturesViewListCtrl'	});
	$routeProvider.when('/RelservhotelroomfeaturesviewEdit/:id', {templateUrl: 'RelservhotelroomfeaturesviewEdit', controller: 'RelServHotelRoomFeaturesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomfeaturesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomfeaturesviewCreate', {templateUrl: 'RelservhotelroomfeaturesviewEdit', controller: 'RelServHotelRoomFeaturesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomfeaturesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomimageviewList', {templateUrl: 'RelservhotelroomimageviewList', controller: 'RelServHotelRoomImageViewListCtrl'	});
	$routeProvider.when('/RelservhotelroomimageviewEdit/:id', {templateUrl: 'RelservhotelroomimageviewEdit', controller: 'RelServHotelRoomImageViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomimageview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelroomimageviewCreate', {templateUrl: 'RelservhotelroomimageviewEdit', controller: 'RelServHotelRoomImageViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelroomimageview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelservkidsruleviewList', {templateUrl: 'RelservhotelservkidsruleviewList', controller: 'RelServHotelServKidsRuleViewListCtrl'	});
	$routeProvider.when('/RelservhotelservkidsruleviewEdit/:id', {templateUrl: 'RelservhotelservkidsruleviewEdit', controller: 'RelServHotelServKidsRuleViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelservkidsruleview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservhotelservkidsruleviewCreate', {templateUrl: 'RelservhotelservkidsruleviewEdit', controller: 'RelServHotelServKidsRuleViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservhotelservkidsruleview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservkidsrulefeaturesviewList', {templateUrl: 'RelservkidsrulefeaturesviewList', controller: 'RelServKidsRuleFeaturesViewListCtrl'	});
	$routeProvider.when('/RelservkidsrulefeaturesviewEdit/:id', {templateUrl: 'RelservkidsrulefeaturesviewEdit', controller: 'RelServKidsRuleFeaturesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservkidsrulefeaturesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservkidsrulefeaturesviewCreate', {templateUrl: 'RelservkidsrulefeaturesviewEdit', controller: 'RelServKidsRuleFeaturesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservkidsrulefeaturesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservtransfertmcontactviewList', {templateUrl: 'RelservtransfertmcontactviewList', controller: 'RelServTransferTmContactViewListCtrl'	});
	$routeProvider.when('/RelservtransfertmcontactviewEdit/:id', {templateUrl: 'RelservtransfertmcontactviewEdit', controller: 'RelServTransferTmContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservtransfertmcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/RelservtransfertmcontactviewCreate', {templateUrl: 'RelservtransfertmcontactviewEdit', controller: 'RelServTransferTmContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'relservtransfertmcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderdocdocumentsviewList', {templateUrl: 'ReltmorderdocdocumentsviewList', controller: 'RelTmOrderDocDocumentsViewListCtrl'	});
	$routeProvider.when('/ReltmorderdocdocumentsviewEdit/:id', {templateUrl: 'ReltmorderdocdocumentsviewEdit', controller: 'RelTmOrderDocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderdocdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderdocdocumentsviewCreate', {templateUrl: 'ReltmorderdocdocumentsviewEdit', controller: 'RelTmOrderDocDocumentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderdocdocumentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderinfoservicesviewList', {templateUrl: 'ReltmorderinfoservicesviewList', controller: 'RelTmOrderInfoServicesViewListCtrl'	});
	$routeProvider.when('/ReltmorderinfoservicesviewEdit/:id', {templateUrl: 'ReltmorderinfoservicesviewEdit', controller: 'RelTmOrderInfoServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderinfoservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderinfoservicesviewCreate', {templateUrl: 'ReltmorderinfoservicesviewEdit', controller: 'RelTmOrderInfoServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderinfoservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderservgiftsviewList', {templateUrl: 'ReltmorderservgiftsviewList', controller: 'RelTmOrderServGiftsViewListCtrl'	});
	$routeProvider.when('/ReltmorderservgiftsviewEdit/:id', {templateUrl: 'ReltmorderservgiftsviewEdit', controller: 'RelTmOrderServGiftsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderservgiftsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmorderservgiftsviewCreate', {templateUrl: 'ReltmorderservgiftsviewEdit', controller: 'RelTmOrderServGiftsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmorderservgiftsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmordertmcontactviewList', {templateUrl: 'ReltmordertmcontactviewList', controller: 'RelTmOrderTmContactViewListCtrl'	});
	$routeProvider.when('/ReltmordertmcontactviewEdit/:id', {templateUrl: 'ReltmordertmcontactviewEdit', controller: 'RelTmOrderTmContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmordertmcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltmordertmcontactviewCreate', {templateUrl: 'ReltmordertmcontactviewEdit', controller: 'RelTmOrderTmContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltmordertmcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourdocsviewList', {templateUrl: 'ReltourdocsviewList', controller: 'RelTourDocsViewListCtrl'	});
	$routeProvider.when('/ReltourdocsviewEdit/:id', {templateUrl: 'ReltourdocsviewEdit', controller: 'RelTourDocsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourdocsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourdocsviewCreate', {templateUrl: 'ReltourdocsviewEdit', controller: 'RelTourDocsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourdocsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourhotelsviewList', {templateUrl: 'ReltourhotelsviewList', controller: 'RelTourHotelsViewListCtrl'	});
	$routeProvider.when('/ReltourhotelsviewEdit/:id', {templateUrl: 'ReltourhotelsviewEdit', controller: 'RelTourHotelsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourhotelsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourhotelsviewCreate', {templateUrl: 'ReltourhotelsviewEdit', controller: 'RelTourHotelsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourhotelsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourservicesviewList', {templateUrl: 'ReltourservicesviewList', controller: 'RelTourServicesViewListCtrl'	});
	$routeProvider.when('/ReltourservicesviewEdit/:id', {templateUrl: 'ReltourservicesviewEdit', controller: 'RelTourServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReltourservicesviewCreate', {templateUrl: 'ReltourservicesviewEdit', controller: 'RelTourServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reltourservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruisehotelsviewList', {templateUrl: 'ReqcruisehotelsviewList', controller: 'ReqCruiseHotelsViewListCtrl'	});
	$routeProvider.when('/ReqcruisehotelsviewEdit/:id', {templateUrl: 'ReqcruisehotelsviewEdit', controller: 'ReqCruiseHotelsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruisehotelsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruisehotelsviewCreate', {templateUrl: 'ReqcruisehotelsviewEdit', controller: 'ReqCruiseHotelsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruisehotelsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruiseservicesviewList', {templateUrl: 'ReqcruiseservicesviewList', controller: 'ReqCruiseServicesViewListCtrl'	});
	$routeProvider.when('/ReqcruiseservicesviewEdit/:id', {templateUrl: 'ReqcruiseservicesviewEdit', controller: 'ReqCruiseServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruiseservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqcruiseservicesviewCreate', {templateUrl: 'ReqcruiseservicesviewEdit', controller: 'ReqCruiseServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqcruiseservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqhotelroomsbusyviewList', {templateUrl: 'ReqhotelroomsbusyviewList', controller: 'ReqHotelRoomsBusyViewListCtrl'	});
	$routeProvider.when('/ReqhotelroomsbusyviewEdit/:id', {templateUrl: 'ReqhotelroomsbusyviewEdit', controller: 'ReqHotelRoomsBusyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqhotelroomsbusyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqhotelroomsbusyviewCreate', {templateUrl: 'ReqhotelroomsbusyviewEdit', controller: 'ReqHotelRoomsBusyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqhotelroomsbusyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelroombusyviewList', {templateUrl: 'ReqservhotelroombusyviewList', controller: 'ReqServHotelRoomBusyViewListCtrl'	});
	$routeProvider.when('/ReqservhotelroombusyviewEdit/:id', {templateUrl: 'ReqservhotelroombusyviewEdit', controller: 'ReqServHotelRoomBusyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotelroombusyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelroombusyviewCreate', {templateUrl: 'ReqservhotelroombusyviewEdit', controller: 'ReqServHotelRoomBusyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotelroombusyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelviewList', {templateUrl: 'ReqservhotelviewList', controller: 'ReqServHotelViewListCtrl'	});
	$routeProvider.when('/ReqservhotelviewEdit/:id', {templateUrl: 'ReqservhotelviewEdit', controller: 'ReqServHotelViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotelview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ReqservhotelviewCreate', {templateUrl: 'ReqservhotelviewEdit', controller: 'ReqServHotelViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'reqservhotelview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServcruiseviewList', {templateUrl: 'ServcruiseviewList', controller: 'ServCruiseViewListCtrl'	});
	$routeProvider.when('/ServcruiseviewEdit/:id', {templateUrl: 'ServcruiseviewEdit', controller: 'ServCruiseViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servcruiseview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServcruiseviewCreate', {templateUrl: 'ServcruiseviewEdit', controller: 'ServCruiseViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servcruiseview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServexcursionsviewList', {templateUrl: 'ServexcursionsviewList', controller: 'ServExcursionsViewListCtrl'	});
	$routeProvider.when('/ServexcursionsviewEdit/:id', {templateUrl: 'ServexcursionsviewEdit', controller: 'ServExcursionsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servexcursionsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServexcursionsviewCreate', {templateUrl: 'ServexcursionsviewEdit', controller: 'ServExcursionsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servexcursionsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServgiftsviewList', {templateUrl: 'ServgiftsviewList', controller: 'ServGiftsViewListCtrl'	});
	$routeProvider.when('/ServgiftsviewEdit/:id', {templateUrl: 'ServgiftsviewEdit', controller: 'ServGiftsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servgiftsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServgiftsviewCreate', {templateUrl: 'ServgiftsviewEdit', controller: 'ServGiftsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servgiftsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelroomviewList', {templateUrl: 'ServhotelroomviewList', controller: 'ServHotelRoomViewListCtrl'	});
	$routeProvider.when('/ServhotelroomviewEdit/:id', {templateUrl: 'ServhotelroomviewEdit', controller: 'ServHotelRoomViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelroomview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelroomviewCreate', {templateUrl: 'ServhotelroomviewEdit', controller: 'ServHotelRoomViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelroomview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelservicesviewList', {templateUrl: 'ServhotelservicesviewList', controller: 'ServHotelServicesViewListCtrl'	});
	$routeProvider.when('/ServhotelservicesviewEdit/:id', {templateUrl: 'ServhotelservicesviewEdit', controller: 'ServHotelServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelservicesviewCreate', {templateUrl: 'ServhotelservicesviewEdit', controller: 'ServHotelServicesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelservicesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelviewList', {templateUrl: 'ServhotelviewList', controller: 'ServHotelViewListCtrl'	});
	$routeProvider.when('/ServhotelviewEdit/:id', {templateUrl: 'ServhotelviewEdit', controller: 'ServHotelViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServhotelviewCreate', {templateUrl: 'ServhotelviewEdit', controller: 'ServHotelViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servhotelview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServinsurancesviewList', {templateUrl: 'ServinsurancesviewList', controller: 'ServInsurancesViewListCtrl'	});
	$routeProvider.when('/ServinsurancesviewEdit/:id', {templateUrl: 'ServinsurancesviewEdit', controller: 'ServInsurancesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servinsurancesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServinsurancesviewCreate', {templateUrl: 'ServinsurancesviewEdit', controller: 'ServInsurancesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servinsurancesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServkidsruleviewList', {templateUrl: 'ServkidsruleviewList', controller: 'ServKidsRuleViewListCtrl'	});
	$routeProvider.when('/ServkidsruleviewEdit/:id', {templateUrl: 'ServkidsruleviewEdit', controller: 'ServKidsRuleViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servkidsruleview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServkidsruleviewCreate', {templateUrl: 'ServkidsruleviewEdit', controller: 'ServKidsRuleViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servkidsruleview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsairviewList', {templateUrl: 'ServticketsairviewList', controller: 'ServTicketsAirViewListCtrl'	});
	$routeProvider.when('/ServticketsairviewEdit/:id', {templateUrl: 'ServticketsairviewEdit', controller: 'ServTicketsAirViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsairview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsairviewCreate', {templateUrl: 'ServticketsairviewEdit', controller: 'ServTicketsAirViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsairview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsrailviewList', {templateUrl: 'ServticketsrailviewList', controller: 'ServTicketsRailViewListCtrl'	});
	$routeProvider.when('/ServticketsrailviewEdit/:id', {templateUrl: 'ServticketsrailviewEdit', controller: 'ServTicketsRailViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsrailview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServticketsrailviewCreate', {templateUrl: 'ServticketsrailviewEdit', controller: 'ServTicketsRailViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servticketsrailview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtourviewList', {templateUrl: 'ServtourviewList', controller: 'ServTourViewListCtrl'	});
	$routeProvider.when('/ServtourviewEdit/:id', {templateUrl: 'ServtourviewEdit', controller: 'ServTourViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtourview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtourviewCreate', {templateUrl: 'ServtourviewEdit', controller: 'ServTourViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtourview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferroutepointviewList', {templateUrl: 'ServtransferroutepointviewList', controller: 'ServTransferRoutePointViewListCtrl'	});
	$routeProvider.when('/ServtransferroutepointviewEdit/:id', {templateUrl: 'ServtransferroutepointviewEdit', controller: 'ServTransferRoutePointViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferroutepointview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferroutepointviewCreate', {templateUrl: 'ServtransferroutepointviewEdit', controller: 'ServTransferRoutePointViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferroutepointview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferrouteviewList', {templateUrl: 'ServtransferrouteviewList', controller: 'ServTransferRouteViewListCtrl'	});
	$routeProvider.when('/ServtransferrouteviewEdit/:id', {templateUrl: 'ServtransferrouteviewEdit', controller: 'ServTransferRouteViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferrouteview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferrouteviewCreate', {templateUrl: 'ServtransferrouteviewEdit', controller: 'ServTransferRouteViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferrouteview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferviewList', {templateUrl: 'ServtransferviewList', controller: 'ServTransferViewListCtrl'	});
	$routeProvider.when('/ServtransferviewEdit/:id', {templateUrl: 'ServtransferviewEdit', controller: 'ServTransferViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServtransferviewCreate', {templateUrl: 'ServtransferviewEdit', controller: 'ServTransferViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servtransferview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServvisasviewList', {templateUrl: 'ServvisasviewList', controller: 'ServVisasViewListCtrl'	});
	$routeProvider.when('/ServvisasviewEdit/:id', {templateUrl: 'ServvisasviewEdit', controller: 'ServVisasViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servvisasview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ServvisasviewCreate', {templateUrl: 'ServvisasviewEdit', controller: 'ServVisasViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'servvisasview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ShopservhotelviewList', {templateUrl: 'ShopservhotelviewList', controller: 'ShopServHotelViewListCtrl'	});
	$routeProvider.when('/ShopservhotelviewEdit/:id', {templateUrl: 'ShopservhotelviewEdit', controller: 'ShopServHotelViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'shopservhotelview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/ShopservhotelviewCreate', {templateUrl: 'ShopservhotelviewEdit', controller: 'ShopServHotelViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'shopservhotelview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountaddressesviewList', {templateUrl: 'TmaccountaddressesviewList', controller: 'TmAccountAddressesViewListCtrl'	});
	$routeProvider.when('/TmaccountaddressesviewEdit/:id', {templateUrl: 'TmaccountaddressesviewEdit', controller: 'TmAccountAddressesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountaddressesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountaddressesviewCreate', {templateUrl: 'TmaccountaddressesviewEdit', controller: 'TmAccountAddressesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountaddressesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountcommunicationsviewList', {templateUrl: 'TmaccountcommunicationsviewList', controller: 'TmAccountCommunicationsViewListCtrl'	});
	$routeProvider.when('/TmaccountcommunicationsviewEdit/:id', {templateUrl: 'TmaccountcommunicationsviewEdit', controller: 'TmAccountCommunicationsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountcommunicationsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountcommunicationsviewCreate', {templateUrl: 'TmaccountcommunicationsviewEdit', controller: 'TmAccountCommunicationsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountcommunicationsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountdetailsviewList', {templateUrl: 'TmaccountdetailsviewList', controller: 'TmAccountDetailsViewListCtrl'	});
	$routeProvider.when('/TmaccountdetailsviewEdit/:id', {templateUrl: 'TmaccountdetailsviewEdit', controller: 'TmAccountDetailsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountdetailsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountdetailsviewCreate', {templateUrl: 'TmaccountdetailsviewEdit', controller: 'TmAccountDetailsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountdetailsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountviewList', {templateUrl: 'TmaccountviewList', controller: 'TmAccountViewListCtrl'	});
	$routeProvider.when('/TmaccountviewEdit/:id', {templateUrl: 'TmaccountviewEdit', controller: 'TmAccountViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmaccountviewCreate', {templateUrl: 'TmaccountviewEdit', controller: 'TmAccountViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmaccountview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcommercialviewList', {templateUrl: 'TmcommercialviewList', controller: 'TmCommercialViewListCtrl'	});
	$routeProvider.when('/TmcommercialviewEdit/:id', {templateUrl: 'TmcommercialviewEdit', controller: 'TmCommercialViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcommercialview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcommercialviewCreate', {templateUrl: 'TmcommercialviewEdit', controller: 'TmCommercialViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcommercialview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactaddressesviewList', {templateUrl: 'TmcontactaddressesviewList', controller: 'TmContactAddressesViewListCtrl'	});
	$routeProvider.when('/TmcontactaddressesviewEdit/:id', {templateUrl: 'TmcontactaddressesviewEdit', controller: 'TmContactAddressesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactaddressesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactaddressesviewCreate', {templateUrl: 'TmcontactaddressesviewEdit', controller: 'TmContactAddressesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactaddressesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactcommunicationsviewList', {templateUrl: 'TmcontactcommunicationsviewList', controller: 'TmContactCommunicationsViewListCtrl'	});
	$routeProvider.when('/TmcontactcommunicationsviewEdit/:id', {templateUrl: 'TmcontactcommunicationsviewEdit', controller: 'TmContactCommunicationsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactcommunicationsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactcommunicationsviewCreate', {templateUrl: 'TmcontactcommunicationsviewEdit', controller: 'TmContactCommunicationsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactcommunicationsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontacteasyviewList', {templateUrl: 'TmcontacteasyviewList', controller: 'TmContactEasyViewListCtrl'	});
	$routeProvider.when('/TmcontacteasyviewEdit/:id', {templateUrl: 'TmcontacteasyviewEdit', controller: 'TmContactEasyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontacteasyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontacteasyviewCreate', {templateUrl: 'TmcontacteasyviewEdit', controller: 'TmContactEasyViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontacteasyview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactviewList', {templateUrl: 'TmcontactviewList', controller: 'TmContactViewListCtrl'	});
	$routeProvider.when('/TmcontactviewEdit/:id', {templateUrl: 'TmcontactviewEdit', controller: 'TmContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmcontactviewCreate', {templateUrl: 'TmcontactviewEdit', controller: 'TmContactViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmcontactview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmfirmsviewList', {templateUrl: 'TmfirmsviewList', controller: 'TmFirmsViewListCtrl'	});
	$routeProvider.when('/TmfirmsviewEdit/:id', {templateUrl: 'TmfirmsviewEdit', controller: 'TmFirmsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmfirmsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmfirmsviewCreate', {templateUrl: 'TmfirmsviewEdit', controller: 'TmFirmsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmfirmsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmimageviewList', {templateUrl: 'TmimageviewList', controller: 'TmImageViewListCtrl'	});
	$routeProvider.when('/TmimageviewEdit/:id', {templateUrl: 'TmimageviewEdit', controller: 'TmImageViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmimageview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmimageviewCreate', {templateUrl: 'TmimageviewEdit', controller: 'TmImageViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmimageview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmincidentsviewList', {templateUrl: 'TmincidentsviewList', controller: 'TmIncidentsViewListCtrl'	});
	$routeProvider.when('/TmincidentsviewEdit/:id', {templateUrl: 'TmincidentsviewEdit', controller: 'TmIncidentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmincidentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmincidentsviewCreate', {templateUrl: 'TmincidentsviewEdit', controller: 'TmIncidentsViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmincidentsview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmorderviewList', {templateUrl: 'TmorderviewList', controller: 'TmOrderViewListCtrl'	});
	$routeProvider.when('/TmorderviewEdit/:id', {templateUrl: 'TmorderviewEdit', controller: 'TmOrderViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmorderview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmorderviewCreate', {templateUrl: 'TmorderviewEdit', controller: 'TmOrderViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmorderview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmpoliciesviewList', {templateUrl: 'TmpoliciesviewList', controller: 'TmPoliciesViewListCtrl'	});
	$routeProvider.when('/TmpoliciesviewEdit/:id', {templateUrl: 'TmpoliciesviewEdit', controller: 'TmPoliciesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmpoliciesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmpoliciesviewCreate', {templateUrl: 'TmpoliciesviewEdit', controller: 'TmPoliciesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmpoliciesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmuserinfoviewList', {templateUrl: 'TmuserinfoviewList', controller: 'TmUserInfoViewListCtrl'	});
	$routeProvider.when('/TmuserinfoviewEdit/:id', {templateUrl: 'TmuserinfoviewEdit', controller: 'TmUserInfoViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmuserinfoview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/TmuserinfoviewCreate', {templateUrl: 'TmuserinfoviewEdit', controller: 'TmUserInfoViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'tmuserinfoview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UserrolesviewList', {templateUrl: 'UserrolesviewList', controller: 'UserRolesViewListCtrl'	});
	$routeProvider.when('/UserrolesviewEdit/:id', {templateUrl: 'UserrolesviewEdit', controller: 'UserRolesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'userrolesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UserrolesviewCreate', {templateUrl: 'UserrolesviewEdit', controller: 'UserRolesViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'userrolesview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UsersviewList', {templateUrl: 'UsersviewList', controller: 'UsersViewListCtrl'	});
	$routeProvider.when('/UsersviewEdit/:id', {templateUrl: 'UsersviewEdit', controller: 'UsersViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "edit"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'usersview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	$routeProvider.when('/UsersviewCreate', {templateUrl: 'UsersviewEdit', controller: 'UsersViewEditCtrl',
		resolve: { 
			modalSettings: function(){ 
				return {
					  mode: "create"
					, isModal: false
					, editItem: {}
					, editItemId: -1
					, excludeList: [ 'usersview' ]
				}; 
			}
			, $modalInstance: function() {
				return {};
			}
		}  
	});
	
	$routeProvider.when('/:name', { 
		templateUrl: function(params) { 
			return params.name; 
		}
	});
	
	$routeProvider.otherwise({ redirectTo: '/' });

	$httpProvider.interceptors.push(function ($q, $rootScope, $location, toaster) {
        return {
        	request: function(request) {
//        		console.info('request: ', request);
        	
				return request;
			}
        	, response: function(response) { 
//        		console.info('response: ', response);
        	
        		if (typeof response.data === 'string') {
                    if (response.data.indexOf instanceof Function && response.data.indexOf('<body id="loginpage0"') != -1) {
                    	window.location.replace("../login?logout");
                    }
                }
        		
        		return response;
        	}
            , responseError: function(rejection) {
        		console.info('rejection: ', rejection);
        		
        		var status = rejection.status;
        		var config = rejection.config;
        		var method = config.method;
        		var url = config.url;
      
				toaster.pop('error', "An error has occurred", method + " on " + url + " failed with status " + status);
              
        		return $q.reject(rejection);
        	}
        };
	});

//	$httpProvider.defaults.cache = false;

	$httpProvider.defaults.useXDomain = true;
	$httpProvider.defaults.withCredentials = true;
	delete $httpProvider.defaults.headers.common["X-Requested-With"];
	$httpProvider.defaults.headers.common["Accept"] = "application/json";
	$httpProvider.defaults.headers.common["Content-Type"] = "application/json";
  
})
.constant("APP_INFO", {
      name: "shop-crm"
    , version: "1.0.0.1"
    , simple_version: 0.12
    , debug: true
    , prefix: "shop"
});

