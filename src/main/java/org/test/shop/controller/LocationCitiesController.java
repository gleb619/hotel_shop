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
import org.test.shop.model.domain.entity.LocationCities;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.LocationCitiesService;
import org.test.shop.model.service.secure.RestAuthentication;
import org.test.shop.util.SObjectListner;

@Controller
public class LocationCitiesController implements Serializable {

	private static final long serialVersionUID = -4958862578185847L;

	@Autowired
	private LocationCitiesService locationcitiesService;
	@Autowired
	private SObjectListner sObjectListner;
	@Autowired
	private RestAuthentication restAuthentication;
	private Boolean debug = false;

	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcities", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> createRest(@RequestBody LocationCities data, Principal principal) throws Exception {
		return createData(data, JsonOutput.readSasUser(principal));		
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcities", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> createApi(@PathVariable String key, @RequestBody LocationCities data) throws Exception {
		return createData(data, restAuthentication.readSasUser(key));		
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcities", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> updateRest(@RequestBody LocationCities data, Principal principal) throws Exception {
		return updateData(data, JsonOutput.readSasUser(principal));
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcities", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> updateApi(@PathVariable String key, @RequestBody LocationCities data) throws Exception {
		return updateData(data, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcities/{id}", method = RequestMethod.DELETE, produces = "application/json")
	
	public @ResponseBody Map<String, Object> deleteRest(@PathVariable Integer id, Principal principal) throws Exception {
		return deleteData(id, JsonOutput.readSasUser(principal));
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcities/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> deleteApi(@PathVariable String key, @PathVariable Integer id) throws Exception {
		return deleteData(id, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "locationcities_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/locationcities/{id}", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewByIdRest(@PathVariable Integer id, ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewByIdData(id, scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "locationcities_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/locationcities/{id}", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> viewByIdApi(@PathVariable String key, @PathVariable Integer id, ScrollableSettings scrollableSettings) throws Exception {
		return viewByIdData(id, scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "locationcities", key = "T(java.util.Objects).hash(#root.methodName, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/locationcities", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewData(scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "locationcities", key = "T(java.util.Objects).hash(#root.methodName, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/locationcities", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> viewApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		return viewData(scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "locationcities_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/locationcities/scrollable", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewScrollableRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewScrollableData(scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "locationcities_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/locationcities/scrollable", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> viewScrollableApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		return viewScrollableData(scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@RequestMapping(value = "/data/locationcities/total", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> totalRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		scrollableSettings.setSasUser(JsonOutput.readSasUser(principal));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/rest/{key}/locationcities/total", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> totalApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		scrollableSettings.setSasUser(restAuthentication.readSasUser(key));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/data/locationcities/search", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> searchRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		data.setSasUser(JsonOutput.readSasUser(principal));
		return searchData(data);
	}
	
	@RequestMapping(value = "/rest/{key}/locationcities/search", method = RequestMethod.POST)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> searchApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		data.setSasUser(restAuthentication.readSasUser(key));
		return searchData(data);
	}
	
	@RequestMapping(value = "/data/locationcities/findbyexample/{comparetype}", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> findByExampleRest(@PathVariable String comparetype, @RequestBody LocationCities data, Principal principal) throws Exception {
		return findByExampleData(data, comparetype, JsonOutput.readSasUser(principal));
	}
	
	@RequestMapping(value = "/rest/{key}/locationcities/findbyexample/{comparetype}", method = RequestMethod.POST)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> findByExampleApi(@PathVariable String key, @PathVariable String comparetype, @RequestBody LocationCities data) throws Exception {
		return findByExampleData(data, comparetype, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/locationcities/reload", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> reloadRest(Principal principal) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@CacheEvict(value = { 
		 "locationcities_id"		, "locationcities"		, "locationcities_scrollable"
		,"locationcitiesview_id"	, "locationcitiesview"	, "locationcitiesview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/locationcities/reload", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> reloadApi(@PathVariable String key) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@RequestMapping(value = "/data/locationcities/popularity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> popularityRest(@RequestBody LocationCities data, Principal principal) throws Exception {
		return popularityData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/locationcities/popularity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> popularityApi(@PathVariable String key, @RequestBody LocationCities data) throws Exception {
		return popularityData(data, restAuthentication.readSasUser(key));
	}
	
	@RequestMapping(value = "/data/locationcities/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> namedFilterRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		return namedFilterData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/locationcities/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'locationcities')")
	public @ResponseBody Map<String, Object> namedFilterApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		return namedFilterData(data, restAuthentication.readSasUser(key));
	}
	
//		#-------------------------  LOGIC -------------------------

	private Map<String, Object> namedFilterData(ScrollableSettings data, SasUser sasUser){
		List<LocationCities> locationcitiesList = new ArrayList<LocationCities>();
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			data.setSasUser(sasUser);
			locationcitiesList = locationcitiesService.namedFilter(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to filter by name locationcities: " + e.getMessage());
		}
		
		if (locationcitiesList == null) {
			return JsonOutput.mapError("Can't find data");
		} else if (locationcitiesList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(locationcitiesList);
		}
	}

	private Map<String, Object> popularityData(LocationCities data, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			locationcitiesService.popularity(data.preInitList());
			
			return JsonOutput.mapSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to populate locationcities: " + e.getMessage());
		}
	}

	private Map<String, Object> findByExampleData(LocationCities data, String comparetype, SasUser sasUser) {
		ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
		List<LocationCities> list = new ArrayList<LocationCities>();
				
		try {
			list = locationcitiesService.findByExample(data, comparetype, scrollableSettings);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while findByExample locationcities: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> searchData(ScrollableSettings data) {
		List<LocationCities> list = new ArrayList<LocationCities>();
		try {
			list = locationcitiesService.search(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while search locationcities: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> createData(LocationCities data, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			
			if(data.getId() != null){
				return updateData(data, sasUser);
			}
			
			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			data = sObjectListner.preCreate(scrollableSettings.getSasUser(), data);
			data = sObjectListner.create(scrollableSettings.getSasUser(), locationcitiesService.create(data.preInitList()));
			data = sObjectListner.postCreate(scrollableSettings.getSasUser(), data);
			
			return JsonOutput.mapSingle(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while creating locationcities: " + e.getMessage());
		}
	}
	
	private Map<String, Object> updateData(LocationCities data, SasUser sasUser){
	
		LocationCities locationcities = null;
		try {
			if (debug) {
				return JsonOutput.map(data);
			}

			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			data = sObjectListner.preUpdate(scrollableSettings.getSasUser(), data);
			data = sObjectListner.update(scrollableSettings.getSasUser(), locationcitiesService.update(data.preInitList()));
			data = sObjectListner.postUpdate(scrollableSettings.getSasUser(), data);
			locationcities = data;
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to update locationcities: " + e.getMessage());
		}
		
		if (locationcities == null) {
			return JsonOutput.mapError("Can't find data");
		} else {
			return JsonOutput.mapSingle(locationcities);
		}
	}
	
	private Map<String, Object> deleteData(Object id, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			sObjectListner.preDelete(scrollableSettings.getSasUser(), LocationCities.class, id);
			sObjectListner.delete(scrollableSettings.getSasUser(), locationcitiesService.delete(id));
			sObjectListner.postDelete(scrollableSettings.getSasUser(), LocationCities.class, id);
			
			return JsonOutput.mapSuccess();
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to delete locationcities: " + e.getMessage());
		}
	}
	
	private Map<String, Object> viewByIdData(Object id, ScrollableSettings scrollableSettings, SasUser sasUser){
		LocationCities locationcities = null;
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			scrollableSettings.setId(id);
			locationcities = sObjectListner.viewById(scrollableSettings.getSasUser(), locationcitiesService.findById(scrollableSettings));
			locationcities = sObjectListner.postViewById(scrollableSettings.getSasUser(), locationcities);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to viewById locationcities: " + e.getMessage());
		}
		
		if (locationcities == null) {
			return JsonOutput.mapError("Error, Can't find data for " + id);
		} else {
			return JsonOutput.mapSingle(locationcities);
		}
	}

	private Map<String, Object> viewData(ScrollableSettings scrollableSettings, SasUser sasUser){
		List<LocationCities> locationcitiesList = new ArrayList<LocationCities>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			locationcitiesList = sObjectListner.view(scrollableSettings.getSasUser(), locationcitiesService.findAll(scrollableSettings));
			locationcitiesList = sObjectListner.postView(scrollableSettings.getSasUser(), locationcitiesList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to view locationcities: " + e.getMessage());
		}
		
		if (locationcitiesList == null) {
			return JsonOutput.mapError("Error, Can't find data");
		} else if (locationcitiesList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(locationcitiesList);
		}
	}
	
	private Map<String, Object> viewScrollableData(ScrollableSettings scrollableSettings, SasUser sasUser){
		List<LocationCities> locationcitiesList = new ArrayList<LocationCities>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			locationcitiesList = sObjectListner.viewScrollable(scrollableSettings.getSasUser(), locationcitiesService.findAllScrollable(scrollableSettings));
			locationcitiesList = sObjectListner.postViewScrollable(scrollableSettings.getSasUser(), locationcitiesList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to viewScrollable locationcities: " + e.getMessage());
		}
		
		if (locationcitiesList == null) {
			return JsonOutput.mapError("Error, Can't find data");
		} else if (locationcitiesList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(locationcitiesList);
		}
	}

	private Map<String, Object> totalData(ScrollableSettings scrollableSettings){
		try {
			return JsonOutput.mapSingle(locationcitiesService.total(scrollableSettings));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving total from database: " + e.getMessage());
		}
	}

}
