/*
 * 
 */
package org.test.shop.controller.other;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

import org.test.shop.controller.data.types.ShopRequest;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.ReqServHotel;
import org.test.shop.model.domain.entity.secure.User;
import org.test.shop.model.domain.entity.view.ShopServHotel2View;
import org.test.shop.model.service.ReqServHotelService;
import org.test.shop.model.service.secure.UserService;
import org.test.shop.model.service.view.ShopServHotel2ViewService;
import org.test.shop.util.SObjectListner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilsController.
 */
@Controller
public class UtilsController implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -809617992116533245L;
	
	/** The message source. */
	@Autowired
    private MessageSource messageSource;
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	@Autowired
	private SObjectListner sObjectListner;
	
	@Autowired
	private ShopServHotel2ViewService shopServHotel2ViewService;
	@Autowired
	private ReqServHotelService reqservhotelService;

	/**
	 * Current user.
	 *
	 * @param data the data
	 * @param principal the principal
	 * @return the map
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/user/activate/{key}", method = RequestMethod.GET)
	public ModelAndView activateUser(@PathVariable String key) throws Exception {
		
		User user = null;
		try {
			user = userService.findByActivationKey(key);
			
			if (user != null) {
				user.setEnabled(true);
				user.setActivationKey(null);
				user.setActivated(true);
				userService.update(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:../../d/404");
		}
		
		System.out.println("UtilsController.activateUser()#user: " + user);
		
		if(user != null){
			return new ModelAndView("redirect:../../d/index3#/login_page");
		}
		else {
			return new ModelAndView("redirect:../../d/404");
		}
	}
	
	@RequestMapping(value = "/data/current-user", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, Object> currentUser(@RequestBody String data, Principal principal) throws Exception {
		
		try {
			return JsonOutput.mapSingle(JsonOutput.readSasUser(principal).getUsername());
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while getting current user: "
					+ e.getLocalizedMessage());
		}
	}
	
	@RequestMapping(value = "/data/shopservhotelview/custom-search", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> customSearch(@RequestBody ShopRequest data, ScrollableSettings settings, Principal principal) throws Exception {
		try {
			if (data == null) {
				return JsonOutput.mapError("Request is null");
			}
			
			ShopServHotel2View example = data.validate();
			
			settings.setSasUser(JsonOutput.readSasUser(principal));
			return JsonOutput.map(sObjectListner.view(settings.getSasUser(), shopServHotel2ViewService.findByExample(example, data.formattedDellimitter(), settings)));
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving shopservhotelview from database: "
					+ e.getLocalizedMessage());
		}
	}
	
	@RequestMapping(value = "/data/shopservhotel2view/search2", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> viewShopservhotelview2(@RequestBody String data, ScrollableSettings settings, Principal principal) throws Exception {
		try {
			ShopServHotel2View example = new ShopServHotel2View();
			example.setCityname(data);
			example.setCountryname(data);
			example.setDescr(data);
			example.setLabel(data);
			
			settings.setSasUser(JsonOutput.readSasUser(principal));
			return JsonOutput.map(sObjectListner.view(settings.getSasUser(), shopServHotel2ViewService.findByExample(example, " OR ", settings)));
			
		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while retrieving shopservhotelview from database: "
					+ e.getLocalizedMessage());
		}
	}
	
	/**
	 * Online users.
	 *
	 * @return the map
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/online-users", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public @ResponseBody Map<String, Object> onlineUsers() throws Exception {
		return JsonOutput.map(userService.getOnlineUsers());
	}
	
	@CacheEvict(value = { "reqservhotel_id", "reqservhotel", "reqservhotel_scrollable" }, allEntries = true)
	@RequestMapping(value = "/data/reqservhotel/custom", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasAnyRole('ROLE_GUEST', 'ROLE_USER', 'ROLE_MANAGER')")
	public @ResponseBody Map<String, Object> createReqServHotel( @RequestBody(required = false) ReqServHotel data, ScrollableSettings settings, Principal principal) throws Exception {
		System.out.println("-------------------");
		try {
			settings.setSasUser(JsonOutput.readSasUser(principal));
//			data = sObjectListner.create(settings.getSasUser(), data);
			
			System.out.println("-------------------");
			System.out.println("ReqServHotelController.create()#data: " + data);
			
			if (sObjectListner.isSync(data)) {
				data = sObjectListner.create(settings.getSasUser(), data);
				return JsonOutput.map(updateSync(data));
			}
			else {
				ReqServHotel reqServHotel = data;
				Thread thread = new Thread(() -> {
					updateAsync(sObjectListner.create(settings.getSasUser(), reqServHotel));
				});
				thread.start();
				
				return JsonOutput.mapSuccess();
			}
			
//			return JsonOutput.map(reqservhotelService.update(data.preInitList()));

		} catch (Exception e) {
			e.printStackTrace();
			return JsonOutput.mapError("Error while creating reqservhotel: "
					+ e.getLocalizedMessage());
		}
	}
	
	
	private ReqServHotel updateSync(ReqServHotel arg0){
		System.out.println("UtilsController.updateSync()");
		return reqservhotelService.update(arg0.preInitList());
	}
	
	@Async
	private void updateAsync(ReqServHotel arg0){
		System.out.println("UtilsController.updateAsync()");
		updateSync(arg0);
	}
	
}
