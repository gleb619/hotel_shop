package org.test.shop.controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.LocationCountries;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.LocationCountriesService;
import org.test.shop.model.service.secure.RestAuthentication;
import org.test.shop.util.SObjectListner;

@Controller
public class LocationCountriesController implements Serializable {

	private static final long serialVersionUID = -8648736343587636L;

	@Autowired
	private LocationCountriesService locationcountriesService;
	@Autowired
	private SObjectListner sObjectListner;
	@Autowired
	private RestAuthentication restAuthentication;
	private Boolean debug = false;

	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcountries", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> createRest(@RequestBody LocationCountries data, Principal principal) throws Exception {
		return createData(data, JsonOutput.readSasUser(principal));		
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcountries", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> createApi(@PathVariable String key, @RequestBody LocationCountries data) throws Exception {
		return createData(data, restAuthentication.readSasUser(key));		
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcountries", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> updateRest(@RequestBody LocationCountries data, Principal principal) throws Exception {
		return updateData(data, JsonOutput.readSasUser(principal));
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcountries", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> updateApi(@PathVariable String key, @RequestBody LocationCountries data) throws Exception {
		return updateData(data, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcountries/{id}", method = RequestMethod.DELETE, produces = "application/json")
	
	public @ResponseBody Map<String, Object> deleteRest(@PathVariable Integer id, Principal principal) throws Exception {
		return deleteData(id, JsonOutput.readSasUser(principal));
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcountries/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> deleteApi(@PathVariable String key, @PathVariable Integer id) throws Exception {
		return deleteData(id, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "locationcountries_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/locationcountries/{id}", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewByIdRest(@PathVariable Integer id, ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewByIdData(id, scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "locationcountries_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/locationcountries/{id}", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> viewByIdApi(@PathVariable String key, @PathVariable Integer id, ScrollableSettings scrollableSettings) throws Exception {
		return viewByIdData(id, scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "locationcountries", key = "T(java.util.Objects).hash(#root.methodName, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/locationcountries", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewData(scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "locationcountries", key = "T(java.util.Objects).hash(#root.methodName, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/locationcountries", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> viewApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		return viewData(scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "locationcountries_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/locationcountries/scrollable", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewScrollableRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewScrollableData(scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "locationcountries_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/locationcountries/scrollable", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> viewScrollableApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		return viewScrollableData(scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@RequestMapping(value = "/data/locationcountries/total", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> totalRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		scrollableSettings.setSasUser(JsonOutput.readSasUser(principal));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/rest/{key}/locationcountries/total", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> totalApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		scrollableSettings.setSasUser(restAuthentication.readSasUser(key));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/data/locationcountries/search", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> searchRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		data.setSasUser(JsonOutput.readSasUser(principal));
		return searchData(data);
	}
	
	@RequestMapping(value = "/rest/{key}/locationcountries/search", method = RequestMethod.POST)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> searchApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		data.setSasUser(restAuthentication.readSasUser(key));
		return searchData(data);
	}
	
	@RequestMapping(value = "/data/locationcountries/findbyexample/{comparetype}", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> findByExampleRest(@PathVariable String comparetype, @RequestBody LocationCountries data, Principal principal) throws Exception {
		return findByExampleData(data, comparetype, JsonOutput.readSasUser(principal));
	}
	
	@RequestMapping(value = "/rest/{key}/locationcountries/findbyexample/{comparetype}", method = RequestMethod.POST)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> findByExampleApi(@PathVariable String key, @PathVariable String comparetype, @RequestBody LocationCountries data) throws Exception {
		return findByExampleData(data, comparetype, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcountries/reload", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> reloadRest(Principal principal) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@CacheEvict(value = { 
		 "locationcountries_id"		, "locationcountries"		, "locationcountries_scrollable"
		,"locationcountriesview_id"	, "locationcountriesview"	, "locationcountriesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcountries/reload", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> reloadApi(@PathVariable String key) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@RequestMapping(value = "/data/locationcountries/popularity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> popularityRest(@RequestBody LocationCountries data, Principal principal) throws Exception {
		return popularityData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/locationcountries/popularity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> popularityApi(@PathVariable String key, @RequestBody LocationCountries data) throws Exception {
		return popularityData(data, restAuthentication.readSasUser(key));
	}
	
	@RequestMapping(value = "/data/locationcountries/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> namedFilterRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		return namedFilterData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/locationcountries/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcountries')")
	public @ResponseBody Map<String, Object> namedFilterApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		return namedFilterData(data, restAuthentication.readSasUser(key));
	}
	
//		#-------------------------  LOGIC -------------------------

	private Map<String, Object> namedFilterData(ScrollableSettings data, SasUser sasUser){
		List<LocationCountries> locationcountriesList = new ArrayList<LocationCountries>();
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			data.setSasUser(sasUser);
			locationcountriesList = locationcountriesService.namedFilter(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to filter by name locationcountries: " + e.getMessage());
		}
		
		if (locationcountriesList == null) {
			return JsonOutput.mapError("Can't find data");
		} else if (locationcountriesList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(locationcountriesList);
		}
	}

	private Map<String, Object> popularityData(LocationCountries data, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			locationcountriesService.popularity(data.preInitList());
			
			return JsonOutput.mapSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to populate locationcountries: " + e.getMessage());
		}
	}

	private Map<String, Object> findByExampleData(LocationCountries data, String comparetype, SasUser sasUser) {
		ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
		List<LocationCountries> list = new ArrayList<LocationCountries>();
				
		try {
			list = locationcountriesService.findByExample(data, comparetype, scrollableSettings);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while findByExample locationcountries: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> searchData(ScrollableSettings data) {
		List<LocationCountries> list = new ArrayList<LocationCountries>();
		try {
			list = locationcountriesService.search(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while search locationcountries: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> createData(LocationCountries data, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			
			if(data.getId() != null){
				return updateData(data, sasUser);
			}
			
			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			data = sObjectListner.preCreate(scrollableSettings.getSasUser(), data);
			data = sObjectListner.create(scrollableSettings.getSasUser(), locationcountriesService.create(data.preInitList()));
			data = sObjectListner.postCreate(scrollableSettings.getSasUser(), data);
			
			return JsonOutput.mapSingle(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while creating locationcountries: " + e.getMessage());
		}
	}
	
	private Map<String, Object> updateData(LocationCountries data, SasUser sasUser){
	
		LocationCountries locationcountries = null;
		try {
			if (debug) {
				return JsonOutput.map(data);
			}

			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			data = sObjectListner.preUpdate(scrollableSettings.getSasUser(), data);
			data = sObjectListner.update(scrollableSettings.getSasUser(), locationcountriesService.update(data.preInitList()));
			data = sObjectListner.postUpdate(scrollableSettings.getSasUser(), data);
			locationcountries = data;
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to update locationcountries: " + e.getMessage());
		}
		
		if (locationcountries == null) {
			return JsonOutput.mapError("Can't find data");
		} else {
			return JsonOutput.mapSingle(locationcountries);
		}
	}
	
	private Map<String, Object> deleteData(Object id, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			sObjectListner.preDelete(scrollableSettings.getSasUser(), LocationCountries.class, id);
			sObjectListner.delete(scrollableSettings.getSasUser(), locationcountriesService.delete(id));
			sObjectListner.postDelete(scrollableSettings.getSasUser(), LocationCountries.class, id);
			
			return JsonOutput.mapSuccess();
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to delete locationcountries: " + e.getMessage());
		}
	}
	
	private Map<String, Object> viewByIdData(Object id, ScrollableSettings scrollableSettings, SasUser sasUser){
		LocationCountries locationcountries = null;
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			scrollableSettings.setId(id);
			locationcountries = sObjectListner.viewById(scrollableSettings.getSasUser(), locationcountriesService.findById(scrollableSettings));
			locationcountries = sObjectListner.postViewById(scrollableSettings.getSasUser(), locationcountries);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to viewById locationcountries: " + e.getMessage());
		}
		
		if (locationcountries == null) {
			return JsonOutput.mapError("Error, Can't find data for " + id);
		} else {
			return JsonOutput.mapSingle(locationcountries);
		}
	}

	private Map<String, Object> viewData(ScrollableSettings scrollableSettings, SasUser sasUser){
		List<LocationCountries> locationcountriesList = new ArrayList<LocationCountries>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			locationcountriesList = sObjectListner.view(scrollableSettings.getSasUser(), locationcountriesService.findAll(scrollableSettings));
			locationcountriesList = sObjectListner.postView(scrollableSettings.getSasUser(), locationcountriesList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to view locationcountries: " + e.getMessage());
		}
		
		if (locationcountriesList == null) {
			return JsonOutput.mapError("Error, Can't find data");
		} else if (locationcountriesList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(locationcountriesList);
		}
	}
	
	private Map<String, Object> viewScrollableData(ScrollableSettings scrollableSettings, SasUser sasUser){
		List<LocationCountries> locationcountriesList = new ArrayList<LocationCountries>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			locationcountriesList = sObjectListner.viewScrollable(scrollableSettings.getSasUser(), locationcountriesService.findAllScrollable(scrollableSettings));
			locationcountriesList = sObjectListner.postViewScrollable(scrollableSettings.getSasUser(), locationcountriesList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to viewScrollable locationcountries: " + e.getMessage());
		}
		
		if (locationcountriesList == null) {
			return JsonOutput.mapError("Error, Can't find data");
		} else if (locationcountriesList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(locationcountriesList);
		}
	}

	private Map<String, Object> totalData(ScrollableSettings scrollableSettings){
		try {
			return JsonOutput.mapSingle(locationcountriesService.total(scrollableSettings));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving total from database: " + e.getMessage());
		}
	}

}
