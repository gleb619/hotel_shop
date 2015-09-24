package org.test.shop.controller.view;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.view.ShopServHotel2View;
import org.test.shop.model.service.secure.RestAuthentication;
import org.test.shop.model.service.view.ShopServHotel2ViewService;
import org.test.shop.util.SObjectListner;

@Controller
public class ShopServHotel2ViewController implements Serializable {

	private static final long serialVersionUID = -4165513685393461L;

	@Autowired
	private ShopServHotel2ViewService shopservhotel2viewService;
	@Autowired
	private SObjectListner sObjectListner;
	@Autowired
	private RestAuthentication restAuthentication;
	private Boolean debug = false;

	@Cacheable(value = "shopservhotel2view_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #principal, #settings)")
	@RequestMapping(value = "/data/shopservhotel2view/{id}", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewById(
			@PathVariable String id, ScrollableSettings settings,
			Principal principal) throws Exception {
		ShopServHotel2View shopservhotel2view = null;
		try {
			settings.setSasUser(JsonOutput.readSasUser(principal));
			try {
				Integer idRaw = new Integer(id);
				settings.setId(idRaw);
			} catch (NumberFormatException e) {
				settings.setId(id);
				e.printStackTrace();
			}
			shopservhotel2view = sObjectListner.viewById(settings.getSasUser(), shopservhotel2viewService.findById(settings));

		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving shopservhotel2view from database: "
					+ e.getLocalizedMessage());
		}

		if (shopservhotel2view == null) {
			return JsonOutput.mapError("Error, Cant find data for " + id);
		} else {
			return JsonOutput.mapSingle(shopservhotel2view);
		}
	}

	@Cacheable(value = "shopservhotel2view", key = "T(java.util.Objects).hash(#root.methodName, #principal, #settings)")
	@RequestMapping(value = "/data/shopservhotel2view", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> view(
			ScrollableSettings settings, Principal principal) throws Exception {
		try {

			settings.setSasUser(JsonOutput.readSasUser(principal));
			return JsonOutput.map(sObjectListner.view(settings.getSasUser(), shopservhotel2viewService.findAll(settings)));

		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving shopservhotel2view from database: "
					+ e.getLocalizedMessage());
		}
	}

	@Cacheable(value = "shopservhotel2view_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #principal, #settings)")
	@RequestMapping(value = "/data/shopservhotel2view/scrollable", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewScrollable(
			ScrollableSettings settings, Principal principal) throws Exception {
		try {
			settings.setSasUser(JsonOutput.readSasUser(principal));
			return JsonOutput.map(sObjectListner.viewScrollable(settings.getSasUser(), shopservhotel2viewService.findAllScrollable(settings)));

		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving shopservhotel2view from database: "
					+ e.getLocalizedMessage());
		}
	}
	
	@RequestMapping(value = "/data/shopservhotel2view/total", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> totalRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		scrollableSettings.setSasUser(JsonOutput.readSasUser(principal));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/rest/{key}/shopservhotel2view/total", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'shopservhotel2view')")
	public @ResponseBody Map<String, Object> totalApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		scrollableSettings.setSasUser(restAuthentication.readSasUser(key));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/data/shopservhotel2view/search", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> searchRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		data.setSasUser(JsonOutput.readSasUser(principal));
		return searchData(data);
	}
	
	@RequestMapping(value = "/rest/{key}/shopservhotel2view/search", method = RequestMethod.POST)
	@PreAuthorize(value = "hasPermission(#key, 'shopservhotel2view')")
	public @ResponseBody Map<String, Object> searchApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		data.setSasUser(restAuthentication.readSasUser(key));
		return searchData(data);
	}
	
	@RequestMapping(value = "/data/shopservhotel2view/findbyexample/{comparetype}", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> findByExampleRest(@PathVariable String comparetype, @RequestBody ShopServHotel2View data, Principal principal) throws Exception {
		return findByExampleData(data, comparetype, JsonOutput.readSasUser(principal));
	}
	
	@RequestMapping(value = "/rest/{key}/shopservhotel2view/findbyexample/{comparetype}", method = RequestMethod.POST)
	@PreAuthorize(value = "hasPermission(#key, 'shopservhotel2view')")
	public @ResponseBody Map<String, Object> findByExampleApi(@PathVariable String key, @PathVariable String comparetype, @RequestBody ShopServHotel2View data) throws Exception {
		return findByExampleData(data, comparetype, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "shopservhotel2view_id"		, "shopservhotel2view"		, "shopservhotel2view_scrollable"
		,"shopservhotel2viewview_id"	, "shopservhotel2viewview"	, "shopservhotel2viewview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/shopservhotel2view/reload", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> reloadRest(Principal principal) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@CacheEvict(value = { 
		 "shopservhotel2view_id"		, "shopservhotel2view"		, "shopservhotel2view_scrollable"
		,"shopservhotel2viewview_id"	, "shopservhotel2viewview"	, "shopservhotel2viewview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/shopservhotel2view/reload", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'shopservhotel2view')")
	public @ResponseBody Map<String, Object> reloadApi(@PathVariable String key) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@RequestMapping(value = "/data/shopservhotel2view/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> namedFilterRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		return namedFilterData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/shopservhotel2view/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'shopservhotel2view')")
	public @ResponseBody Map<String, Object> namedFilterApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		return namedFilterData(data, restAuthentication.readSasUser(key));
	}
	
//		#-------------------------  LOGIC -------------------------

	private Map<String, Object> namedFilterData(ScrollableSettings data, SasUser sasUser){
		List<ShopServHotel2View> shopservhotel2viewList = new ArrayList<ShopServHotel2View>();
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			data.setSasUser(sasUser);
			shopservhotel2viewList = shopservhotel2viewService.namedFilter(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to filter by name shopservhotel2view: " + e.getMessage());
		}
		
		if (shopservhotel2viewList == null) {
			return JsonOutput.mapError("Can't find data");
		} else if (shopservhotel2viewList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(shopservhotel2viewList);
		}
	}
	
	private Map<String, Object> findByExampleData(ShopServHotel2View data, String comparetype, SasUser sasUser) {
		ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
		List<ShopServHotel2View> list = new ArrayList<ShopServHotel2View>();
				
		try {
			list = shopservhotel2viewService.findByExample(data, comparetype, scrollableSettings);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while findByExample shopservhotel2view: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> searchData(ScrollableSettings data) {
		List<ShopServHotel2View> list = new ArrayList<ShopServHotel2View>();
		try {
			list = shopservhotel2viewService.search(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while search shopservhotel2view: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> totalData(ScrollableSettings scrollableSettings){
		try {
			return JsonOutput.mapSingle(shopservhotel2viewService.total(scrollableSettings));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving total from database: " + e.getMessage());
		}
	}

}
