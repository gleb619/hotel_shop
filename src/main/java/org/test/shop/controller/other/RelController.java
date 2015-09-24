package org.test.shop.controller.other;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.SRel;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.other.RelService;
import org.test.shop.model.service.secure.RestAuthentication;
import org.test.shop.util.SObjectListner;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RelController implements Serializable {

	private static final long serialVersionUID = -2738715657519164L;

	@Autowired
	private RelService service;
	@Autowired
	private SObjectListner sObjectListner;
	@Autowired
	private RestAuthentication restAuthentication;
	@Autowired
	@Qualifier("mapper")
	private ObjectMapper mapper;
	private Boolean debug = false;
	
	@RequestMapping(value = "/data/{relation}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> createRest(@PathVariable String relation, @RequestBody String data, Principal principal) throws Exception {
		return createData(data, JsonOutput.readSasUser(principal), relation);		
	}
	
	@RequestMapping(value = "/rest/{key}/{relation}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'servhotel')")
	public @ResponseBody Map<String, Object> createApi(@PathVariable String key, @PathVariable String relation, @RequestBody String data) throws Exception {
		return createData(data, restAuthentication.readSasUser(key), relation);		
	}
	
	@RequestMapping(value = "/data/{relation}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> updateRest(@PathVariable String relation, @RequestBody String data, Principal principal) throws Exception {
		return updateData(data, JsonOutput.readSasUser(principal), relation);
	}
	
	@RequestMapping(value = "/rest/{key}/{relation}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'servhotel')")
	public @ResponseBody Map<String, Object> updateApi(@PathVariable String key, @PathVariable String relation, @RequestBody String data) throws Exception {
		return updateData(data, restAuthentication.readSasUser(key), relation);
	}
	
	@RequestMapping(value = "/data/{relation}/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> deleteRest(@PathVariable String relation, @PathVariable Integer id, Principal principal) throws Exception {
		return deleteData(id, JsonOutput.readSasUser(principal), relation);
	}
	
	@RequestMapping(value = "/rest/{key}/{relation}/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@PreAuthorize(value = "hasPermission(#key, 'servhotel')")
	public @ResponseBody Map<String, Object> deleteApi(@PathVariable String key, @PathVariable String relation, @PathVariable Integer id) throws Exception {
		return deleteData(id, restAuthentication.readSasUser(key), relation);
	}
	
	@RequestMapping(value = "/data/{relation}/{id}", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> viewById(@PathVariable String relation, @PathVariable Integer id, ScrollableSettings settings, Principal principal) throws Exception {
		return viewByIdData(id, settings, JsonOutput.readSasUser(principal), relation);
	}
	
	@RequestMapping(value = "/rest/{key}/{relation}/{id}", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'servhotel')")
	public @ResponseBody Map<String, Object> viewById(@PathVariable String key, @PathVariable String relation, @PathVariable Integer id, ScrollableSettings settings) throws Exception {
		return viewByIdData(id, settings, restAuthentication.readSasUser(key), relation);
	}
	
	@RequestMapping(value = "/data/{relation}", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> viewRest(@PathVariable String relation, ScrollableSettings settings, Principal principal) throws Exception {
		return viewData(settings, JsonOutput.readSasUser(principal), relation);
	}
	
	@RequestMapping(value = "/rest/{key}/{relation}", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'servhotel')")
	public @ResponseBody Map<String, Object> viewApi(@PathVariable String key, @PathVariable String relation, ScrollableSettings settings) throws Exception {
		return viewData(settings, restAuthentication.readSasUser(key), relation);
	}
	
	@RequestMapping(value = "/data/{relation}/scrollable", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> viewScrollableRest(@PathVariable String relation, ScrollableSettings settings, Principal principal) throws Exception {
		return viewScrollableData(settings, JsonOutput.readSasUser(principal), relation);
	}
	
	@RequestMapping(value = "/rest/{key}/{relation}/scrollable", method = RequestMethod.GET)
	@PreAuthorize(value = "hasPermission(#key, 'servhotel')")
	public @ResponseBody Map<String, Object> viewScrollableApi(@PathVariable String key, @PathVariable String relation, ScrollableSettings settings) throws Exception {
		return viewScrollableData(settings, restAuthentication.readSasUser(key), relation);
	}
	
//		#-------------------------  LOGIC -------------------------

	private Class<?> readRelationType(String name) {
//		return RelationSettings.Items.map.getOrDefault(name.toLowerCase(), null);
		return null;
	}
	
	private Map<String, Object> createData(String data, SasUser sasUser, String relation){
		Class<?> clazz = readRelationType(relation);
		SRel object = null;
		
		try {
			object = (SRel) mapper.readValue(data, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (debug) {
				return JsonOutput.map(object);
			}

			ScrollableSettings settings = new ScrollableSettings(sasUser);
			object = sObjectListner.preCreate(settings.getSasUser(), object);
			object = sObjectListner.create(settings.getSasUser(), service.create(object.preInitList()));
			object = sObjectListner.postCreate(settings.getSasUser(), object);
			
			return JsonOutput.map(object);
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();
			}
			return JsonOutput.mapError("Error while creating servhotel: " + e.getMessage());
		}
	}
	
	private Map<String, Object> updateData(String data, SasUser sasUser, String relation){
		Class<?> clazz = readRelationType(relation);
		SRel object = null;
		
		try {
			object = (SRel) mapper.readValue(data, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (debug) {
				return JsonOutput.map(object);
			}

			ScrollableSettings settings = new ScrollableSettings(sasUser);
			object = sObjectListner.preUpdate(settings.getSasUser(), object);
			object = sObjectListner.update(settings.getSasUser(), service.update(object.preInitList()));
			object = sObjectListner.postUpdate(settings.getSasUser(), object);
			
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();
			}
			return JsonOutput.mapError("Error, trying to update servhotel: " + e.getMessage());
		}
		
		if (object == null) {
			return JsonOutput.mapError("Cant find data ");
		} else {
			return JsonOutput.mapSingle(object);
		}
	}
	
	private Map<String, Object> deleteData(Object id, SasUser sasUser, String relation){
		Class<?> clazz = readRelationType(relation);
		
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			ScrollableSettings settings = new ScrollableSettings(sasUser);
			sObjectListner.preDelete(settings.getSasUser(), clazz, id);
			sObjectListner.delete(settings.getSasUser(), service.delete(id, clazz));
			sObjectListner.postDelete(settings.getSasUser(), clazz, id);
			
			return JsonOutput.mapSuccess();
			
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();
			}
			return JsonOutput.mapError("Error, trying to delete servhotel: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> viewByIdData(Object id, ScrollableSettings settings, SasUser sasUser, String relation){
		Class<? extends SRel> clazz = (Class<? extends SRel>) readRelationType(relation);
		SRel object = null;
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			settings.setSasUser(sasUser);
			settings.setId(id);
			object = sObjectListner.viewById(settings.getSasUser(), service.findById(settings, clazz));
			object = sObjectListner.postViewById(settings.getSasUser(), object);
			
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();
			}
			return JsonOutput.mapError("Error, trying to viewById: " + e.getMessage());
		}
		
		if (object == null) {
			return JsonOutput.mapError("Error, Cant find data for " + id);
		} else {
			return JsonOutput.mapSingle(object);
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> viewData(ScrollableSettings settings, SasUser sasUser, String relation){
		Class<? extends SRel> clazz = (Class<? extends SRel>) readRelationType(relation);
		List<SRel> list = new ArrayList<SRel>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			settings.setSasUser(sasUser);
			list = (List<SRel>) sObjectListner.view(settings.getSasUser(), service.findAll(settings, clazz));
			list = sObjectListner.postView(settings.getSasUser(), list);
			
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();
			}
			return JsonOutput.mapError("Error, trying to view: " + e.getMessage());
		}
		
		if (list == null) {
			return JsonOutput.mapError("Error, Cant find data");
		} else if (list.size() == 0) {
			return JsonOutput.mapWarning("Warning, Cant find data");
		} else {
			return JsonOutput.map(list);
		}
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> viewScrollableData(ScrollableSettings settings, SasUser sasUser, String relation){
		Class<? extends SRel> clazz = (Class<? extends SRel>) readRelationType(relation);
		List<SRel> list = new ArrayList<SRel>();
		try {
			if (debug) {
				return JsonOutput.mapSuccess();
			}

			settings.setSasUser(sasUser);
			list = (List<SRel>) sObjectListner.viewScrollable(settings.getSasUser(), service.findAllScrollable(settings, clazz));
			list = sObjectListner.postViewScrollable(settings.getSasUser(), list);
			
		} catch (Exception e) {
			if (debug) {
				e.printStackTrace();
			}
			return JsonOutput.mapError("Error, trying to viewScrollable servhotel: " + e.getMessage());
		}
		
		if (list == null) {
			return JsonOutput.mapError("Error, Cant find data");
		} else if (list.size() == 0) {
			return JsonOutput.mapWarning("Warning, Cant find data");
		} else {
			return JsonOutput.map(list);
		}
	}

}
