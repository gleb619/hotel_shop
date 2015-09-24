'use strict';

angular.module('shopApp.services', ['ngResource']) 

.factory('currCourseDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/currcourse/:id'
		, view: 				'..' + '/data/currcourseview/:id'
		, list: 				'..' + '/data/currcourse/'
		, listview: 			'..' + '/data/currcourseview/'
		, listScrollable: 		'..' + '/data/currcourse/scrollable/'
		, listviewScrollable: 	'..' + '/data/currcourseview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('currCurrencyDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/currcurrency/:id'
		, view: 				'..' + '/data/currcurrencyview/:id'
		, list: 				'..' + '/data/currcurrency/'
		, listview: 			'..' + '/data/currcurrencyview/'
		, listScrollable: 		'..' + '/data/currcurrency/scrollable/'
		, listviewScrollable: 	'..' + '/data/currcurrencyview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('dictGlobalDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/dictglobal/:id'
		, view: 				'..' + '/data/dictglobalview/:id'
		, list: 				'..' + '/data/dictglobal/'
		, listview: 			'..' + '/data/dictglobalview/'
		, listScrollable: 		'..' + '/data/dictglobal/scrollable/'
		, listviewScrollable: 	'..' + '/data/dictglobalview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('docDocumentsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/docdocuments/:id'
		, view: 				'..' + '/data/docdocumentsview/:id'
		, list: 				'..' + '/data/docdocuments/'
		, listview: 			'..' + '/data/docdocumentsview/'
		, listScrollable: 		'..' + '/data/docdocuments/scrollable/'
		, listviewScrollable: 	'..' + '/data/docdocumentsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('groupGlobalDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/groupglobal/:id'
		, view: 				'..' + '/data/groupglobalview/:id'
		, list: 				'..' + '/data/groupglobal/'
		, listview: 			'..' + '/data/groupglobalview/'
		, listScrollable: 		'..' + '/data/groupglobal/scrollable/'
		, listviewScrollable: 	'..' + '/data/groupglobalview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('infoContactInformationDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/infocontactinformation/:id'
		, view: 				'..' + '/data/infocontactinformationview/:id'
		, list: 				'..' + '/data/infocontactinformation/'
		, listview: 			'..' + '/data/infocontactinformationview/'
		, listScrollable: 		'..' + '/data/infocontactinformation/scrollable/'
		, listviewScrollable: 	'..' + '/data/infocontactinformationview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('infoServicesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/infoservices/:id'
		, view: 				'..' + '/data/infoservicesview/:id'
		, list: 				'..' + '/data/infoservices/'
		, listview: 			'..' + '/data/infoservicesview/'
		, listScrollable: 		'..' + '/data/infoservices/scrollable/'
		, listviewScrollable: 	'..' + '/data/infoservicesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('locationAddressDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/locationaddress/:id'
		, view: 				'..' + '/data/locationaddressview/:id'
		, list: 				'..' + '/data/locationaddress/'
		, listview: 			'..' + '/data/locationaddressview/'
		, listScrollable: 		'..' + '/data/locationaddress/scrollable/'
		, listviewScrollable: 	'..' + '/data/locationaddressview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('locationCitiesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/locationcities/:id'
		, view: 				'..' + '/data/locationcitiesview/:id'
		, list: 				'..' + '/data/locationcities/'
		, listview: 			'..' + '/data/locationcitiesview/'
		, listScrollable: 		'..' + '/data/locationcities/scrollable/'
		, listviewScrollable: 	'..' + '/data/locationcitiesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('locationCountriesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/locationcountries/:id'
		, view: 				'..' + '/data/locationcountriesview/:id'
		, list: 				'..' + '/data/locationcountries/'
		, listview: 			'..' + '/data/locationcountriesview/'
		, listScrollable: 		'..' + '/data/locationcountries/scrollable/'
		, listviewScrollable: 	'..' + '/data/locationcountriesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('locationTypePlacementDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/locationtypeplacement/:id'
		, view: 				'..' + '/data/locationtypeplacementview/:id'
		, list: 				'..' + '/data/locationtypeplacement/'
		, listview: 			'..' + '/data/locationtypeplacementview/'
		, listScrollable: 		'..' + '/data/locationtypeplacement/scrollable/'
		, listviewScrollable: 	'..' + '/data/locationtypeplacementview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentAccountDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymentaccount/:id'
		, view: 				'..' + '/data/paymentaccountview/:id'
		, list: 				'..' + '/data/paymentaccount/'
		, listview: 			'..' + '/data/paymentaccountview/'
		, listScrollable: 		'..' + '/data/paymentaccount/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymentaccountview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentAccountRecordDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymentaccountrecord/:id'
		, view: 				'..' + '/data/paymentaccountrecordview/:id'
		, list: 				'..' + '/data/paymentaccountrecord/'
		, listview: 			'..' + '/data/paymentaccountrecordview/'
		, listScrollable: 		'..' + '/data/paymentaccountrecord/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymentaccountrecordview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentContactDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymentcontact/:id'
		, view: 				'..' + '/data/paymentcontactview/:id'
		, list: 				'..' + '/data/paymentcontact/'
		, listview: 			'..' + '/data/paymentcontactview/'
		, listScrollable: 		'..' + '/data/paymentcontact/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymentcontactview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentContactRecordDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymentcontactrecord/:id'
		, view: 				'..' + '/data/paymentcontactrecordview/:id'
		, list: 				'..' + '/data/paymentcontactrecord/'
		, listview: 			'..' + '/data/paymentcontactrecordview/'
		, listScrollable: 		'..' + '/data/paymentcontactrecord/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymentcontactrecordview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentDetailsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymentdetails/:id'
		, view: 				'..' + '/data/paymentdetailsview/:id'
		, list: 				'..' + '/data/paymentdetails/'
		, listview: 			'..' + '/data/paymentdetailsview/'
		, listScrollable: 		'..' + '/data/paymentdetails/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymentdetailsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentPriceDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymentprice/:id'
		, view: 				'..' + '/data/paymentpriceview/:id'
		, list: 				'..' + '/data/paymentprice/'
		, listview: 			'..' + '/data/paymentpriceview/'
		, listScrollable: 		'..' + '/data/paymentprice/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymentpriceview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('paymentTariffDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/paymenttariff/:id'
		, view: 				'..' + '/data/paymenttariffview/:id'
		, list: 				'..' + '/data/paymenttariff/'
		, listview: 			'..' + '/data/paymenttariffview/'
		, listScrollable: 		'..' + '/data/paymenttariff/scrollable/'
		, listviewScrollable: 	'..' + '/data/paymenttariffview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relAccountContactsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relaccountcontacts/:id'
		, view: 				'..' + '/data/relaccountcontactsview/:id'
		, list: 				'..' + '/data/relaccountcontacts/'
		, listview: 			'..' + '/data/relaccountcontactsview/'
		, listScrollable: 		'..' + '/data/relaccountcontacts/scrollable/'
		, listviewScrollable: 	'..' + '/data/relaccountcontactsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relCruiseContactsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relcruisecontacts/:id'
		, view: 				'..' + '/data/relcruisecontactsview/:id'
		, list: 				'..' + '/data/relcruisecontacts/'
		, listview: 			'..' + '/data/relcruisecontactsview/'
		, listScrollable: 		'..' + '/data/relcruisecontacts/scrollable/'
		, listviewScrollable: 	'..' + '/data/relcruisecontactsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relCruiseDocsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relcruisedocs/:id'
		, view: 				'..' + '/data/relcruisedocsview/:id'
		, list: 				'..' + '/data/relcruisedocs/'
		, listview: 			'..' + '/data/relcruisedocsview/'
		, listScrollable: 		'..' + '/data/relcruisedocs/scrollable/'
		, listviewScrollable: 	'..' + '/data/relcruisedocsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relReqServHotelDocDocumentsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relreqservhoteldocdocuments/:id'
		, view: 				'..' + '/data/relreqservhoteldocdocumentsview/:id'
		, list: 				'..' + '/data/relreqservhoteldocdocuments/'
		, listview: 			'..' + '/data/relreqservhoteldocdocumentsview/'
		, listScrollable: 		'..' + '/data/relreqservhoteldocdocuments/scrollable/'
		, listviewScrollable: 	'..' + '/data/relreqservhoteldocdocumentsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relReqServHotelTmContactEasyDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relreqservhoteltmcontacteasy/:id'
		, view: 				'..' + '/data/relreqservhoteltmcontacteasyview/:id'
		, list: 				'..' + '/data/relreqservhoteltmcontacteasy/'
		, listview: 			'..' + '/data/relreqservhoteltmcontacteasyview/'
		, listScrollable: 		'..' + '/data/relreqservhoteltmcontacteasy/scrollable/'
		, listviewScrollable: 	'..' + '/data/relreqservhoteltmcontacteasyview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelCreditCardsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelcreditcards/:id'
		, view: 				'..' + '/data/relservhotelcreditcardsview/:id'
		, list: 				'..' + '/data/relservhotelcreditcards/'
		, listview: 			'..' + '/data/relservhotelcreditcardsview/'
		, listScrollable: 		'..' + '/data/relservhotelcreditcards/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelcreditcardsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelDocDocumentsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhoteldocdocuments/:id'
		, view: 				'..' + '/data/relservhoteldocdocumentsview/:id'
		, list: 				'..' + '/data/relservhoteldocdocuments/'
		, listview: 			'..' + '/data/relservhoteldocdocumentsview/'
		, listScrollable: 		'..' + '/data/relservhoteldocdocuments/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhoteldocdocumentsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelEntertainmentAndSportDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelentertainmentandsport/:id'
		, view: 				'..' + '/data/relservhotelentertainmentandsportview/:id'
		, list: 				'..' + '/data/relservhotelentertainmentandsport/'
		, listview: 			'..' + '/data/relservhotelentertainmentandsportview/'
		, listScrollable: 		'..' + '/data/relservhotelentertainmentandsport/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelentertainmentandsportview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelFeaturesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelfeatures/:id'
		, view: 				'..' + '/data/relservhotelfeaturesview/:id'
		, list: 				'..' + '/data/relservhotelfeatures/'
		, listview: 			'..' + '/data/relservhotelfeaturesview/'
		, listScrollable: 		'..' + '/data/relservhotelfeatures/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelfeaturesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelImageDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelimage/:id'
		, view: 				'..' + '/data/relservhotelimageview/:id'
		, list: 				'..' + '/data/relservhotelimage/'
		, listview: 			'..' + '/data/relservhotelimageview/'
		, listScrollable: 		'..' + '/data/relservhotelimage/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelimageview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelInfoCommercialDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelinfocommercial/:id'
		, view: 				'..' + '/data/relservhotelinfocommercialview/:id'
		, list: 				'..' + '/data/relservhotelinfocommercial/'
		, listview: 			'..' + '/data/relservhotelinfocommercialview/'
		, listScrollable: 		'..' + '/data/relservhotelinfocommercial/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelinfocommercialview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelInfoHotelServicesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelinfohotelservices/:id'
		, view: 				'..' + '/data/relservhotelinfohotelservicesview/:id'
		, list: 				'..' + '/data/relservhotelinfohotelservices/'
		, listview: 			'..' + '/data/relservhotelinfohotelservicesview/'
		, listScrollable: 		'..' + '/data/relservhotelinfohotelservices/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelinfohotelservicesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelInfoPoliciesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelinfopolicies/:id'
		, view: 				'..' + '/data/relservhotelinfopoliciesview/:id'
		, list: 				'..' + '/data/relservhotelinfopolicies/'
		, listview: 			'..' + '/data/relservhotelinfopoliciesview/'
		, listScrollable: 		'..' + '/data/relservhotelinfopolicies/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelinfopoliciesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelRoomFeaturesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelroomfeatures/:id'
		, view: 				'..' + '/data/relservhotelroomfeaturesview/:id'
		, list: 				'..' + '/data/relservhotelroomfeatures/'
		, listview: 			'..' + '/data/relservhotelroomfeaturesview/'
		, listScrollable: 		'..' + '/data/relservhotelroomfeatures/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelroomfeaturesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelRoomImageDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelroomimage/:id'
		, view: 				'..' + '/data/relservhotelroomimageview/:id'
		, list: 				'..' + '/data/relservhotelroomimage/'
		, listview: 			'..' + '/data/relservhotelroomimageview/'
		, listScrollable: 		'..' + '/data/relservhotelroomimage/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelroomimageview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServHotelServKidsRuleDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservhotelservkidsrule/:id'
		, view: 				'..' + '/data/relservhotelservkidsruleview/:id'
		, list: 				'..' + '/data/relservhotelservkidsrule/'
		, listview: 			'..' + '/data/relservhotelservkidsruleview/'
		, listScrollable: 		'..' + '/data/relservhotelservkidsrule/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservhotelservkidsruleview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServKidsRuleFeaturesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservkidsrulefeatures/:id'
		, view: 				'..' + '/data/relservkidsrulefeaturesview/:id'
		, list: 				'..' + '/data/relservkidsrulefeatures/'
		, listview: 			'..' + '/data/relservkidsrulefeaturesview/'
		, listScrollable: 		'..' + '/data/relservkidsrulefeatures/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservkidsrulefeaturesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relServTransferTmContactDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/relservtransfertmcontact/:id'
		, view: 				'..' + '/data/relservtransfertmcontactview/:id'
		, list: 				'..' + '/data/relservtransfertmcontact/'
		, listview: 			'..' + '/data/relservtransfertmcontactview/'
		, listScrollable: 		'..' + '/data/relservtransfertmcontact/scrollable/'
		, listviewScrollable: 	'..' + '/data/relservtransfertmcontactview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTmOrderDocDocumentsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltmorderdocdocuments/:id'
		, view: 				'..' + '/data/reltmorderdocdocumentsview/:id'
		, list: 				'..' + '/data/reltmorderdocdocuments/'
		, listview: 			'..' + '/data/reltmorderdocdocumentsview/'
		, listScrollable: 		'..' + '/data/reltmorderdocdocuments/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltmorderdocdocumentsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTmOrderInfoServicesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltmorderinfoservices/:id'
		, view: 				'..' + '/data/reltmorderinfoservicesview/:id'
		, list: 				'..' + '/data/reltmorderinfoservices/'
		, listview: 			'..' + '/data/reltmorderinfoservicesview/'
		, listScrollable: 		'..' + '/data/reltmorderinfoservices/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltmorderinfoservicesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTmOrderServGiftsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltmorderservgifts/:id'
		, view: 				'..' + '/data/reltmorderservgiftsview/:id'
		, list: 				'..' + '/data/reltmorderservgifts/'
		, listview: 			'..' + '/data/reltmorderservgiftsview/'
		, listScrollable: 		'..' + '/data/reltmorderservgifts/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltmorderservgiftsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTmOrderTmContactDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltmordertmcontact/:id'
		, view: 				'..' + '/data/reltmordertmcontactview/:id'
		, list: 				'..' + '/data/reltmordertmcontact/'
		, listview: 			'..' + '/data/reltmordertmcontactview/'
		, listScrollable: 		'..' + '/data/reltmordertmcontact/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltmordertmcontactview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTourDocsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltourdocs/:id'
		, view: 				'..' + '/data/reltourdocsview/:id'
		, list: 				'..' + '/data/reltourdocs/'
		, listview: 			'..' + '/data/reltourdocsview/'
		, listScrollable: 		'..' + '/data/reltourdocs/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltourdocsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTourHotelsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltourhotels/:id'
		, view: 				'..' + '/data/reltourhotelsview/:id'
		, list: 				'..' + '/data/reltourhotels/'
		, listview: 			'..' + '/data/reltourhotelsview/'
		, listScrollable: 		'..' + '/data/reltourhotels/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltourhotelsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('relTourServicesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reltourservices/:id'
		, view: 				'..' + '/data/reltourservicesview/:id'
		, list: 				'..' + '/data/reltourservices/'
		, listview: 			'..' + '/data/reltourservicesview/'
		, listScrollable: 		'..' + '/data/reltourservices/scrollable/'
		, listviewScrollable: 	'..' + '/data/reltourservicesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('reqCruiseHotelsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reqcruisehotels/:id'
		, view: 				'..' + '/data/reqcruisehotelsview/:id'
		, list: 				'..' + '/data/reqcruisehotels/'
		, listview: 			'..' + '/data/reqcruisehotelsview/'
		, listScrollable: 		'..' + '/data/reqcruisehotels/scrollable/'
		, listviewScrollable: 	'..' + '/data/reqcruisehotelsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('reqCruiseServicesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reqcruiseservices/:id'
		, view: 				'..' + '/data/reqcruiseservicesview/:id'
		, list: 				'..' + '/data/reqcruiseservices/'
		, listview: 			'..' + '/data/reqcruiseservicesview/'
		, listScrollable: 		'..' + '/data/reqcruiseservices/scrollable/'
		, listviewScrollable: 	'..' + '/data/reqcruiseservicesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('reqHotelRoomsBusyDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reqhotelroomsbusy/:id'
		, view: 				'..' + '/data/reqhotelroomsbusyview/:id'
		, list: 				'..' + '/data/reqhotelroomsbusy/'
		, listview: 			'..' + '/data/reqhotelroomsbusyview/'
		, listScrollable: 		'..' + '/data/reqhotelroomsbusy/scrollable/'
		, listviewScrollable: 	'..' + '/data/reqhotelroomsbusyview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('reqServHotelDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reqservhotel/:id'
		, view: 				'..' + '/data/reqservhotelview/:id'
		, list: 				'..' + '/data/reqservhotel/'
		, listview: 			'..' + '/data/reqservhotelview/'
		, listScrollable: 		'..' + '/data/reqservhotel/scrollable/'
		, listviewScrollable: 	'..' + '/data/reqservhotelview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('reqServHotelRoomBusyDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/reqservhotelroombusy/:id'
		, view: 				'..' + '/data/reqservhotelroombusyview/:id'
		, list: 				'..' + '/data/reqservhotelroombusy/'
		, listview: 			'..' + '/data/reqservhotelroombusyview/'
		, listScrollable: 		'..' + '/data/reqservhotelroombusy/scrollable/'
		, listviewScrollable: 	'..' + '/data/reqservhotelroombusyview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servCruiseDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servcruise/:id'
		, view: 				'..' + '/data/servcruiseview/:id'
		, list: 				'..' + '/data/servcruise/'
		, listview: 			'..' + '/data/servcruiseview/'
		, listScrollable: 		'..' + '/data/servcruise/scrollable/'
		, listviewScrollable: 	'..' + '/data/servcruiseview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servExcursionsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servexcursions/:id'
		, view: 				'..' + '/data/servexcursionsview/:id'
		, list: 				'..' + '/data/servexcursions/'
		, listview: 			'..' + '/data/servexcursionsview/'
		, listScrollable: 		'..' + '/data/servexcursions/scrollable/'
		, listviewScrollable: 	'..' + '/data/servexcursionsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servGiftsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servgifts/:id'
		, view: 				'..' + '/data/servgiftsview/:id'
		, list: 				'..' + '/data/servgifts/'
		, listview: 			'..' + '/data/servgiftsview/'
		, listScrollable: 		'..' + '/data/servgifts/scrollable/'
		, listviewScrollable: 	'..' + '/data/servgiftsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servHotelDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servhotel/:id'
		, view: 				'..' + '/data/servhotelview/:id'
		, list: 				'..' + '/data/servhotel/'
		, listview: 			'..' + '/data/servhotelview/'
		, listScrollable: 		'..' + '/data/servhotel/scrollable/'
		, listviewScrollable: 	'..' + '/data/servhotelview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servHotelRoomDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servhotelroom/:id'
		, view: 				'..' + '/data/servhotelroomview/:id'
		, list: 				'..' + '/data/servhotelroom/'
		, listview: 			'..' + '/data/servhotelroomview/'
		, listScrollable: 		'..' + '/data/servhotelroom/scrollable/'
		, listviewScrollable: 	'..' + '/data/servhotelroomview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servHotelServicesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servhotelservices/:id'
		, view: 				'..' + '/data/servhotelservicesview/:id'
		, list: 				'..' + '/data/servhotelservices/'
		, listview: 			'..' + '/data/servhotelservicesview/'
		, listScrollable: 		'..' + '/data/servhotelservices/scrollable/'
		, listviewScrollable: 	'..' + '/data/servhotelservicesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servInsurancesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servinsurances/:id'
		, view: 				'..' + '/data/servinsurancesview/:id'
		, list: 				'..' + '/data/servinsurances/'
		, listview: 			'..' + '/data/servinsurancesview/'
		, listScrollable: 		'..' + '/data/servinsurances/scrollable/'
		, listviewScrollable: 	'..' + '/data/servinsurancesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servKidsRuleDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servkidsrule/:id'
		, view: 				'..' + '/data/servkidsruleview/:id'
		, list: 				'..' + '/data/servkidsrule/'
		, listview: 			'..' + '/data/servkidsruleview/'
		, listScrollable: 		'..' + '/data/servkidsrule/scrollable/'
		, listviewScrollable: 	'..' + '/data/servkidsruleview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servTicketsAirDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servticketsair/:id'
		, view: 				'..' + '/data/servticketsairview/:id'
		, list: 				'..' + '/data/servticketsair/'
		, listview: 			'..' + '/data/servticketsairview/'
		, listScrollable: 		'..' + '/data/servticketsair/scrollable/'
		, listviewScrollable: 	'..' + '/data/servticketsairview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servTicketsRailDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servticketsrail/:id'
		, view: 				'..' + '/data/servticketsrailview/:id'
		, list: 				'..' + '/data/servticketsrail/'
		, listview: 			'..' + '/data/servticketsrailview/'
		, listScrollable: 		'..' + '/data/servticketsrail/scrollable/'
		, listviewScrollable: 	'..' + '/data/servticketsrailview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servTourDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servtour/:id'
		, view: 				'..' + '/data/servtourview/:id'
		, list: 				'..' + '/data/servtour/'
		, listview: 			'..' + '/data/servtourview/'
		, listScrollable: 		'..' + '/data/servtour/scrollable/'
		, listviewScrollable: 	'..' + '/data/servtourview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servTransferDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servtransfer/:id'
		, view: 				'..' + '/data/servtransferview/:id'
		, list: 				'..' + '/data/servtransfer/'
		, listview: 			'..' + '/data/servtransferview/'
		, listScrollable: 		'..' + '/data/servtransfer/scrollable/'
		, listviewScrollable: 	'..' + '/data/servtransferview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servTransferRouteDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servtransferroute/:id'
		, view: 				'..' + '/data/servtransferrouteview/:id'
		, list: 				'..' + '/data/servtransferroute/'
		, listview: 			'..' + '/data/servtransferrouteview/'
		, listScrollable: 		'..' + '/data/servtransferroute/scrollable/'
		, listviewScrollable: 	'..' + '/data/servtransferrouteview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servTransferRoutePointDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servtransferroutepoint/:id'
		, view: 				'..' + '/data/servtransferroutepointview/:id'
		, list: 				'..' + '/data/servtransferroutepoint/'
		, listview: 			'..' + '/data/servtransferroutepointview/'
		, listScrollable: 		'..' + '/data/servtransferroutepoint/scrollable/'
		, listviewScrollable: 	'..' + '/data/servtransferroutepointview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('servVisasDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/servvisas/:id'
		, view: 				'..' + '/data/servvisasview/:id'
		, list: 				'..' + '/data/servvisas/'
		, listview: 			'..' + '/data/servvisasview/'
		, listScrollable: 		'..' + '/data/servvisas/scrollable/'
		, listviewScrollable: 	'..' + '/data/servvisasview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmAccountDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmaccount/:id'
		, view: 				'..' + '/data/tmaccountview/:id'
		, list: 				'..' + '/data/tmaccount/'
		, listview: 			'..' + '/data/tmaccountview/'
		, listScrollable: 		'..' + '/data/tmaccount/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmaccountview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmAccountAddressesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmaccountaddresses/:id'
		, view: 				'..' + '/data/tmaccountaddressesview/:id'
		, list: 				'..' + '/data/tmaccountaddresses/'
		, listview: 			'..' + '/data/tmaccountaddressesview/'
		, listScrollable: 		'..' + '/data/tmaccountaddresses/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmaccountaddressesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmAccountCommunicationsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmaccountcommunications/:id'
		, view: 				'..' + '/data/tmaccountcommunicationsview/:id'
		, list: 				'..' + '/data/tmaccountcommunications/'
		, listview: 			'..' + '/data/tmaccountcommunicationsview/'
		, listScrollable: 		'..' + '/data/tmaccountcommunications/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmaccountcommunicationsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmAccountDetailsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmaccountdetails/:id'
		, view: 				'..' + '/data/tmaccountdetailsview/:id'
		, list: 				'..' + '/data/tmaccountdetails/'
		, listview: 			'..' + '/data/tmaccountdetailsview/'
		, listScrollable: 		'..' + '/data/tmaccountdetails/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmaccountdetailsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmCommercialDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmcommercial/:id'
		, view: 				'..' + '/data/tmcommercialview/:id'
		, list: 				'..' + '/data/tmcommercial/'
		, listview: 			'..' + '/data/tmcommercialview/'
		, listScrollable: 		'..' + '/data/tmcommercial/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmcommercialview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmContactDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmcontact/:id'
		, view: 				'..' + '/data/tmcontactview/:id'
		, list: 				'..' + '/data/tmcontact/'
		, listview: 			'..' + '/data/tmcontactview/'
		, listScrollable: 		'..' + '/data/tmcontact/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmcontactview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmContactAddressesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmcontactaddresses/:id'
		, view: 				'..' + '/data/tmcontactaddressesview/:id'
		, list: 				'..' + '/data/tmcontactaddresses/'
		, listview: 			'..' + '/data/tmcontactaddressesview/'
		, listScrollable: 		'..' + '/data/tmcontactaddresses/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmcontactaddressesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmContactCommunicationsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmcontactcommunications/:id'
		, view: 				'..' + '/data/tmcontactcommunicationsview/:id'
		, list: 				'..' + '/data/tmcontactcommunications/'
		, listview: 			'..' + '/data/tmcontactcommunicationsview/'
		, listScrollable: 		'..' + '/data/tmcontactcommunications/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmcontactcommunicationsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmContactEasyDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmcontacteasy/:id'
		, view: 				'..' + '/data/tmcontacteasyview/:id'
		, list: 				'..' + '/data/tmcontacteasy/'
		, listview: 			'..' + '/data/tmcontacteasyview/'
		, listScrollable: 		'..' + '/data/tmcontacteasy/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmcontacteasyview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmFirmsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmfirms/:id'
		, view: 				'..' + '/data/tmfirmsview/:id'
		, list: 				'..' + '/data/tmfirms/'
		, listview: 			'..' + '/data/tmfirmsview/'
		, listScrollable: 		'..' + '/data/tmfirms/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmfirmsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmImageDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmimage/:id'
		, view: 				'..' + '/data/tmimageview/:id'
		, list: 				'..' + '/data/tmimage/'
		, listview: 			'..' + '/data/tmimageview/'
		, listScrollable: 		'..' + '/data/tmimage/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmimageview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmIncidentsDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmincidents/:id'
		, view: 				'..' + '/data/tmincidentsview/:id'
		, list: 				'..' + '/data/tmincidents/'
		, listview: 			'..' + '/data/tmincidentsview/'
		, listScrollable: 		'..' + '/data/tmincidents/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmincidentsview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmOrderDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmorder/:id'
		, view: 				'..' + '/data/tmorderview/:id'
		, list: 				'..' + '/data/tmorder/'
		, listview: 			'..' + '/data/tmorderview/'
		, listScrollable: 		'..' + '/data/tmorder/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmorderview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmPoliciesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmpolicies/:id'
		, view: 				'..' + '/data/tmpoliciesview/:id'
		, list: 				'..' + '/data/tmpolicies/'
		, listview: 			'..' + '/data/tmpoliciesview/'
		, listScrollable: 		'..' + '/data/tmpolicies/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmpoliciesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('tmUserInfoDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/tmuserinfo/:id'
		, view: 				'..' + '/data/tmuserinfoview/:id'
		, list: 				'..' + '/data/tmuserinfo/'
		, listview: 			'..' + '/data/tmuserinfoview/'
		, listScrollable: 		'..' + '/data/tmuserinfo/scrollable/'
		, listviewScrollable: 	'..' + '/data/tmuserinfoview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('userRolesDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/userroles/:id'
		, view: 				'..' + '/data/userrolesview/:id'
		, list: 				'..' + '/data/userroles/'
		, listview: 			'..' + '/data/userrolesview/'
		, listScrollable: 		'..' + '/data/userroles/scrollable/'
		, listviewScrollable: 	'..' + '/data/userrolesview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('usersDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/users/:id'
		, view: 				'..' + '/data/usersview/:id'
		, list: 				'..' + '/data/users/'
		, listview: 			'..' + '/data/usersview/'
		, listScrollable: 		'..' + '/data/users/scrollable/'
		, listviewScrollable: 	'..' + '/data/usersview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('otherServicesStoreViewDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/otherservicesstoreview/:id'
		, view: 				'..' + '/data/otherservicesstoreview/:id'
		, list: 				'..' + '/data/otherservicesstoreview/'
		, listview: 			'..' + '/data/otherservicesstoreview/'
		, listScrollable: 		'..' + '/data/otherservicesstoreview/scrollable/'
		, listviewScrollable: 	'..' + '/data/otherservicesstoreview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.factory('shopServHotelViewDao', function ($resource) {
	var urls = {
		  obj: 					'..' + '/data/shopservhotelview/:id'
		, view: 				'..' + '/data/shopservhotelview/:id'
		, list: 				'..' + '/data/shopservhotelview/'
		, listview: 			'..' + '/data/shopservhotelview/'
		, listScrollable: 		'..' + '/data/shopservhotelview/scrollable/'
		, listviewScrollable: 	'..' + '/data/shopservhotelview/scrollable/'
	};

	return $resource(urls.listview, {}, {
		  showObj:   			{ method: 'GET' 		, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.obj			}
		, showView: 			{ method: 'GET'			, params: { id: '@id', initDicts: '@initDicts', initLists: '@initLists' }	, url: urls.view		}
		, create: 				{ method: 'POST'																					, url: urls.list		}
		, update: 				{ method: 'PUT'   		, params: { id: '@id' } 													, url: urls.obj			}
		, remove: 				{ method: 'DELETE'		, params: { id: '@id' } 													, url: urls.obj			}
		, list:  				{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.list 		}
		, listView:  			{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists' }				, url: urls.listview	}
		, listScrollable:  		{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listScrollable  		}
		, listViewScrollable:  	{ method: 'GET'			, params: { initDicts: '@initDicts', initLists: '@initLists', pageNumber: '@pageNumber', pageSize: '@pageSize' },	url: urls.listviewScrollable   	}
	});
})

.service('$servicesStorage', function (currCourseDao, currCurrencyDao, dictGlobalDao, docDocumentsDao, groupGlobalDao, infoContactInformationDao, infoServicesDao, locationAddressDao, locationCitiesDao, locationCountriesDao, locationTypePlacementDao, paymentAccountDao, paymentAccountRecordDao, paymentContactDao, paymentContactRecordDao, paymentDetailsDao, paymentPriceDao, paymentTariffDao, relAccountContactsDao, relCruiseContactsDao, relCruiseDocsDao, relReqServHotelDocDocumentsDao, relReqServHotelTmContactEasyDao, relServHotelCreditCardsDao, relServHotelDocDocumentsDao, relServHotelEntertainmentAndSportDao, relServHotelFeaturesDao, relServHotelImageDao, relServHotelInfoCommercialDao, relServHotelInfoHotelServicesDao, relServHotelInfoPoliciesDao, relServHotelRoomFeaturesDao, relServHotelRoomImageDao, relServHotelServKidsRuleDao, relServKidsRuleFeaturesDao, relServTransferTmContactDao, relTmOrderDocDocumentsDao, relTmOrderInfoServicesDao, relTmOrderServGiftsDao, relTmOrderTmContactDao, relTourDocsDao, relTourHotelsDao, relTourServicesDao, reqCruiseHotelsDao, reqCruiseServicesDao, reqHotelRoomsBusyDao, reqServHotelDao, reqServHotelRoomBusyDao, servCruiseDao, servExcursionsDao, servGiftsDao, servHotelDao, servHotelRoomDao, servHotelServicesDao, servInsurancesDao, servKidsRuleDao, servTicketsAirDao, servTicketsRailDao, servTourDao, servTransferDao, servTransferRouteDao, servTransferRoutePointDao, servVisasDao, tmAccountDao, tmAccountAddressesDao, tmAccountCommunicationsDao, tmAccountDetailsDao, tmCommercialDao, tmContactDao, tmContactAddressesDao, tmContactCommunicationsDao, tmContactEasyDao, tmFirmsDao, tmImageDao, tmIncidentsDao, tmOrderDao, tmPoliciesDao, tmUserInfoDao, userRolesDao, usersDao, otherServicesStoreViewDao, shopServHotelViewDao) {
	return {
		CurrCourseDao: function() {
			return currCourseDao;
		}
		, CurrCurrencyDao: function() {
			return currCurrencyDao;
		}
		, DictGlobalDao: function() {
			return dictGlobalDao;
		}
		, DocDocumentsDao: function() {
			return docDocumentsDao;
		}
		, GroupGlobalDao: function() {
			return groupGlobalDao;
		}
		, InfoContactInformationDao: function() {
			return infoContactInformationDao;
		}
		, InfoServicesDao: function() {
			return infoServicesDao;
		}
		, LocationAddressDao: function() {
			return locationAddressDao;
		}
		, LocationCitiesDao: function() {
			return locationCitiesDao;
		}
		, LocationCountriesDao: function() {
			return locationCountriesDao;
		}
		, LocationTypePlacementDao: function() {
			return locationTypePlacementDao;
		}
		, PaymentAccountDao: function() {
			return paymentAccountDao;
		}
		, PaymentAccountRecordDao: function() {
			return paymentAccountRecordDao;
		}
		, PaymentContactDao: function() {
			return paymentContactDao;
		}
		, PaymentContactRecordDao: function() {
			return paymentContactRecordDao;
		}
		, PaymentDetailsDao: function() {
			return paymentDetailsDao;
		}
		, PaymentPriceDao: function() {
			return paymentPriceDao;
		}
		, PaymentTariffDao: function() {
			return paymentTariffDao;
		}
		, RelAccountContactsDao: function() {
			return relAccountContactsDao;
		}
		, RelCruiseContactsDao: function() {
			return relCruiseContactsDao;
		}
		, RelCruiseDocsDao: function() {
			return relCruiseDocsDao;
		}
		, RelReqServHotelDocDocumentsDao: function() {
			return relReqServHotelDocDocumentsDao;
		}
		, RelReqServHotelTmContactEasyDao: function() {
			return relReqServHotelTmContactEasyDao;
		}
		, RelServHotelCreditCardsDao: function() {
			return relServHotelCreditCardsDao;
		}
		, RelServHotelDocDocumentsDao: function() {
			return relServHotelDocDocumentsDao;
		}
		, RelServHotelEntertainmentAndSportDao: function() {
			return relServHotelEntertainmentAndSportDao;
		}
		, RelServHotelFeaturesDao: function() {
			return relServHotelFeaturesDao;
		}
		, RelServHotelImageDao: function() {
			return relServHotelImageDao;
		}
		, RelServHotelInfoCommercialDao: function() {
			return relServHotelInfoCommercialDao;
		}
		, RelServHotelInfoHotelServicesDao: function() {
			return relServHotelInfoHotelServicesDao;
		}
		, RelServHotelInfoPoliciesDao: function() {
			return relServHotelInfoPoliciesDao;
		}
		, RelServHotelRoomFeaturesDao: function() {
			return relServHotelRoomFeaturesDao;
		}
		, RelServHotelRoomImageDao: function() {
			return relServHotelRoomImageDao;
		}
		, RelServHotelServKidsRuleDao: function() {
			return relServHotelServKidsRuleDao;
		}
		, RelServKidsRuleFeaturesDao: function() {
			return relServKidsRuleFeaturesDao;
		}
		, RelServTransferTmContactDao: function() {
			return relServTransferTmContactDao;
		}
		, RelTmOrderDocDocumentsDao: function() {
			return relTmOrderDocDocumentsDao;
		}
		, RelTmOrderInfoServicesDao: function() {
			return relTmOrderInfoServicesDao;
		}
		, RelTmOrderServGiftsDao: function() {
			return relTmOrderServGiftsDao;
		}
		, RelTmOrderTmContactDao: function() {
			return relTmOrderTmContactDao;
		}
		, RelTourDocsDao: function() {
			return relTourDocsDao;
		}
		, RelTourHotelsDao: function() {
			return relTourHotelsDao;
		}
		, RelTourServicesDao: function() {
			return relTourServicesDao;
		}
		, ReqCruiseHotelsDao: function() {
			return reqCruiseHotelsDao;
		}
		, ReqCruiseServicesDao: function() {
			return reqCruiseServicesDao;
		}
		, ReqHotelRoomsBusyDao: function() {
			return reqHotelRoomsBusyDao;
		}
		, ReqServHotelDao: function() {
			return reqServHotelDao;
		}
		, ReqServHotelRoomBusyDao: function() {
			return reqServHotelRoomBusyDao;
		}
		, ServCruiseDao: function() {
			return servCruiseDao;
		}
		, ServExcursionsDao: function() {
			return servExcursionsDao;
		}
		, ServGiftsDao: function() {
			return servGiftsDao;
		}
		, ServHotelDao: function() {
			return servHotelDao;
		}
		, ServHotelRoomDao: function() {
			return servHotelRoomDao;
		}
		, ServHotelServicesDao: function() {
			return servHotelServicesDao;
		}
		, ServInsurancesDao: function() {
			return servInsurancesDao;
		}
		, ServKidsRuleDao: function() {
			return servKidsRuleDao;
		}
		, ServTicketsAirDao: function() {
			return servTicketsAirDao;
		}
		, ServTicketsRailDao: function() {
			return servTicketsRailDao;
		}
		, ServTourDao: function() {
			return servTourDao;
		}
		, ServTransferDao: function() {
			return servTransferDao;
		}
		, ServTransferRouteDao: function() {
			return servTransferRouteDao;
		}
		, ServTransferRoutePointDao: function() {
			return servTransferRoutePointDao;
		}
		, ServVisasDao: function() {
			return servVisasDao;
		}
		, TmAccountDao: function() {
			return tmAccountDao;
		}
		, TmAccountAddressesDao: function() {
			return tmAccountAddressesDao;
		}
		, TmAccountCommunicationsDao: function() {
			return tmAccountCommunicationsDao;
		}
		, TmAccountDetailsDao: function() {
			return tmAccountDetailsDao;
		}
		, TmCommercialDao: function() {
			return tmCommercialDao;
		}
		, TmContactDao: function() {
			return tmContactDao;
		}
		, TmContactAddressesDao: function() {
			return tmContactAddressesDao;
		}
		, TmContactCommunicationsDao: function() {
			return tmContactCommunicationsDao;
		}
		, TmContactEasyDao: function() {
			return tmContactEasyDao;
		}
		, TmFirmsDao: function() {
			return tmFirmsDao;
		}
		, TmImageDao: function() {
			return tmImageDao;
		}
		, TmIncidentsDao: function() {
			return tmIncidentsDao;
		}
		, TmOrderDao: function() {
			return tmOrderDao;
		}
		, TmPoliciesDao: function() {
			return tmPoliciesDao;
		}
		, TmUserInfoDao: function() {
			return tmUserInfoDao;
		}
		, UserRolesDao: function() {
			return userRolesDao;
		}
		, UsersDao: function() {
			return usersDao;
		}
		, OtherServicesStoreViewDao: function() {
			return otherServicesStoreViewDao;
		}
		, ShopServHotelViewDao: function() {
			return shopServHotelViewDao;
		}

	};
});

