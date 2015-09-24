package org.test.shop.controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.Users;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.secure.User;
import org.test.shop.model.service.UsersService;
import org.test.shop.model.service.secure.RestAuthentication;
import org.test.shop.util.SObjectListner;

@Controller
public class UsersController implements Serializable {

	private static final long serialVersionUID = -3928277851313498L;

	@Autowired
	private UsersService usersService;
	@Autowired
	private SObjectListner sObjectListner;
	@Autowired
	private RestAuthentication restAuthentication;
	private Boolean debug = false;

	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Map<String, Object> createRest(@RequestBody Users data, Principal principal) throws Exception {
		return createData(data, JsonOutput.readSasUser(principal));		
	}
	/*
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/users", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> createApi(@PathVariable String key, @RequestBody Users data) throws Exception {
		return createData(data, restAuthentication.readSasUser(key));		
	}
	
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/users", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> updateRest(@RequestBody Users data, Principal principal) throws Exception {
		return updateData(data, JsonOutput.readSasUser(principal));
	}
	
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/users", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> updateApi(@PathVariable String key, @RequestBody Users data) throws Exception {
		return updateData(data, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/users/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Map<String, Object> deleteRest(@PathVariable Integer id, Principal principal) throws Exception {
		return deleteData(id, JsonOutput.readSasUser(principal));
	}
	
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/users/{id}", method = RequestMethod.DELETE, produces = "application/json")
	
	public @ResponseBody Map<String, Object> deleteApi(@PathVariable String key, @PathVariable Integer id) throws Exception {
		return deleteData(id, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "users_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/users/{id}", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewByIdRest(@PathVariable Integer id, ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewByIdData(id, scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "users_id", key = "T(java.util.Objects).hash(#root.methodName, #id, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/users/{id}", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewByIdApi(@PathVariable String key, @PathVariable Integer id, ScrollableSettings scrollableSettings) throws Exception {
		return viewByIdData(id, scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "users", key = "T(java.util.Objects).hash(#root.methodName, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/users", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewData(scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "users", key = "T(java.util.Objects).hash(#root.methodName, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/users", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		return viewData(scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@Cacheable(value = "users_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #principal, #scrollableSettings)")
	@RequestMapping(value = "/data/users/scrollable", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewScrollableRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		return viewScrollableData(scrollableSettings, JsonOutput.readSasUser(principal));
	}
	
	@Cacheable(value = "users_scrollable", key = "T(java.util.Objects).hash(#root.methodName, #key, #scrollableSettings)")
	@RequestMapping(value = "/rest/{key}/users/scrollable", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> viewScrollableApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		return viewScrollableData(scrollableSettings, restAuthentication.readSasUser(key));
	}
	
	@RequestMapping(value = "/data/users/total", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> totalRest(ScrollableSettings scrollableSettings, Principal principal) throws Exception {
		scrollableSettings.setSasUser(JsonOutput.readSasUser(principal));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/rest/{key}/users/total", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> totalApi(@PathVariable String key, ScrollableSettings scrollableSettings) throws Exception {
		scrollableSettings.setSasUser(restAuthentication.readSasUser(key));
		return totalData(scrollableSettings);
	}
	
	@RequestMapping(value = "/data/users/search", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> searchRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		data.setSasUser(JsonOutput.readSasUser(principal));
		return searchData(data);
	}
	
	@RequestMapping(value = "/rest/{key}/users/search", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> searchApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		data.setSasUser(restAuthentication.readSasUser(key));
		return searchData(data);
	}
	
	@RequestMapping(value = "/data/users/findbyexample/{comparetype}", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> findByExampleRest(@PathVariable String comparetype, @RequestBody Users data, Principal principal) throws Exception {
		return findByExampleData(data, comparetype, JsonOutput.readSasUser(principal));
	}
	
	@RequestMapping(value = "/rest/{key}/users/findbyexample/{comparetype}", method = RequestMethod.POST)
	
	public @ResponseBody Map<String, Object> findByExampleApi(@PathVariable String key, @PathVariable String comparetype, @RequestBody Users data) throws Exception {
		return findByExampleData(data, comparetype, restAuthentication.readSasUser(key));
	}
	
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/data/users/reload", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> reloadRest(Principal principal) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@CacheEvict(value = { 
		 "users_id"		, "users"		, "users_scrollable"
		,"usersview_id"	, "usersview"	, "usersview_scrollable" 
	}, allEntries = true)
	@RequestMapping(value = "/rest/{key}/users/reload", method = RequestMethod.GET)
	
	public @ResponseBody Map<String, Object> reloadApi(@PathVariable String key) throws Exception {
		return JsonOutput.mapSuccess();
	}
	
	@RequestMapping(value = "/data/users/popularity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> popularityRest(@RequestBody Users data, Principal principal) throws Exception {
		return popularityData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/users/popularity", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> popularityApi(@PathVariable String key, @RequestBody Users data) throws Exception {
		return popularityData(data, restAuthentication.readSasUser(key));
	}
	
	@RequestMapping(value = "/data/users/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> namedFilterRest(@RequestBody ScrollableSettings data, Principal principal) throws Exception {
		return namedFilterData(data, JsonOutput.readSasUser(principal));
	}

	@RequestMapping(value = "/rest/{key}/users/namedfilter", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	
	public @ResponseBody Map<String, Object> namedFilterApi(@PathVariable String key, @RequestBody ScrollableSettings data) throws Exception {
		return namedFilterData(data, restAuthentication.readSasUser(key));
	}
	*/
//		#-------------------------  LOGIC -------------------------

	private Map<String, Object> namedFilterData(ScrollableSettings data, SasUser sasUser){
		List<Users> usersList = new ArrayList<Users>();
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			data.setSasUser(sasUser);
			usersList = usersService.namedFilter(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to filter by name users: " + e.getMessage());
		}
		
		if (usersList == null) {
			return JsonOutput.mapError("Can't find data");
		} else if (usersList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(usersList);
		}
	}

	private Map<String, Object> popularityData(Users data, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			usersService.popularity(data.preInitList());
			
			return JsonOutput.mapSuccess();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to populate users: " + e.getMessage());
		}
	}

	private Map<String, Object> findByExampleData(Users data, String comparetype, SasUser sasUser) {
		ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
		List<Users> list = new ArrayList<Users>();
				
		try {
			list = usersService.findByExample(data, comparetype, scrollableSettings);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while findByExample users: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> searchData(ScrollableSettings data) {
		List<Users> list = new ArrayList<Users>();
		try {
			list = usersService.search(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while search users: " + e.getMessage());
		}
		
		return JsonOutput.map(list);
	}

	private Map<String, Object> createData(Users data, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.map(data);
			}
			
			if(data.getId() != null){
				return updateData(data, sasUser);
			}
			
			if (sasUser == null) {
				Set<GrantedAuthority> setAuths = new LinkedHashSet<GrantedAuthority>();
				setAuths.add(new SimpleGrantedAuthority("ROLE_GUEST"));
				List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(setAuths);
				
				sasUser = new SasUser("shop", "shop", grantedAuthorities);
				User user = new User();
				user.setFirmid(1);
				user.setUsername("shop");
				sasUser.setUser(user);
			}
			
			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			data = sObjectListner.preCreate(scrollableSettings.getSasUser(), data);
			data = sObjectListner.create(scrollableSettings.getSasUser(), usersService.create(data.preInitList()));
			data = sObjectListner.postCreate(scrollableSettings.getSasUser(), data);
			
			return JsonOutput.mapSingle(data);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while creating users: " + e.getMessage());
		}
	}
	
	private Map<String, Object> updateData(Users data, SasUser sasUser){
	
		Users users = null;
		try {
			if (debug) {
				return JsonOutput.map(data);
			}

			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			data = sObjectListner.preUpdate(scrollableSettings.getSasUser(), data);
			data = sObjectListner.update(scrollableSettings.getSasUser(), usersService.update(data.preInitList()));
			data = sObjectListner.postUpdate(scrollableSettings.getSasUser(), data);
			users = data;
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to update users: " + e.getMessage());
		}
		
		if (users == null) {
			return JsonOutput.mapError("Can't find data");
		} else {
			return JsonOutput.mapSingle(users);
		}
	}
	
	private Map<String, Object> deleteData(Object id, SasUser sasUser){
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			ScrollableSettings scrollableSettings = new ScrollableSettings(sasUser);
			sObjectListner.preDelete(scrollableSettings.getSasUser(), Users.class, id);
			sObjectListner.delete(scrollableSettings.getSasUser(), usersService.delete(id));
			sObjectListner.postDelete(scrollableSettings.getSasUser(), Users.class, id);
			
			return JsonOutput.mapSuccess();
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to delete users: " + e.getMessage());
		}
	}
	
	private Map<String, Object> viewByIdData(Object id, ScrollableSettings scrollableSettings, SasUser sasUser){
		Users users = null;
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			scrollableSettings.setId(id);
			users = sObjectListner.viewById(scrollableSettings.getSasUser(), usersService.findById(scrollableSettings));
			users = sObjectListner.postViewById(scrollableSettings.getSasUser(), users);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to viewById users: " + e.getMessage());
		}
		
		if (users == null) {
			return JsonOutput.mapError("Error, Can't find data for " + id);
		} else {
			return JsonOutput.mapSingle(users);
		}
	}

	private Map<String, Object> viewData(ScrollableSettings scrollableSettings, SasUser sasUser){
		List<Users> usersList = new ArrayList<Users>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			usersList = sObjectListner.view(scrollableSettings.getSasUser(), usersService.findAll(scrollableSettings));
			usersList = sObjectListner.postView(scrollableSettings.getSasUser(), usersList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to view users: " + e.getMessage());
		}
		
		if (usersList == null) {
			return JsonOutput.mapError("Error, Can't find data");
		} else if (usersList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(usersList);
		}
	}
	
	private Map<String, Object> viewScrollableData(ScrollableSettings scrollableSettings, SasUser sasUser){
		List<Users> usersList = new ArrayList<Users>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			scrollableSettings.setSasUser(sasUser);
			usersList = sObjectListner.viewScrollable(scrollableSettings.getSasUser(), usersService.findAllScrollable(scrollableSettings));
			usersList = sObjectListner.postViewScrollable(scrollableSettings.getSasUser(), usersList);
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error, trying to viewScrollable users: " + e.getMessage());
		}
		
		if (usersList == null) {
			return JsonOutput.mapError("Error, Can't find data");
		} else if (usersList.size() == 0) {
			return JsonOutput.mapWarning("Warning, Can't find data");
		} else {
			return JsonOutput.map(usersList);
		}
	}

	private Map<String, Object> totalData(ScrollableSettings scrollableSettings){
		try {
			return JsonOutput.mapSingle(usersService.total(scrollableSettings));
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving total from database: " + e.getMessage());
		}
	}

}
