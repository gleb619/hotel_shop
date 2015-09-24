/*
 * 
 */
package org.test.shop.controller.secure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;






import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import org.test.shop.config.debug.Settings;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class MainController.
 */
@Controller
public class MainController {

	private Boolean showCalendar = false;
	
	private Boolean debug = Settings.MAIN_CONTROLLER.getValue();
	
	@Autowired
	private ServletContext servletContext;
	
	private List<String> _public = new ArrayList<String>();
	private List<String> _sys = new ArrayList<String>();
	private List<String> _data = new ArrayList<String>();
	private List<String> _security = new ArrayList<String>();
	private List<String> _shop = new ArrayList<String>();
	
	@PostConstruct
	public void init() {
		_public = findFiles("pages/_public");
		_sys = findFiles("pages/_sys");
		_data = findFiles("pages/_data");
		_security = findFiles("pages/_security");
		_shop = findFiles("pages/_shop");
	}
	
	private List<String> findFiles(String path) {
		List<String> list = new ArrayList<String>();
		String pathForFind = servletContext.getRealPath("/") + "/" + path;
		
		try {
			Files.walk(Paths.get(pathForFind)).forEach(filePath -> {
			    if (Files.isRegularFile(filePath)) {
			    	list.add(new File(filePath.toString()).getName().replaceAll("\\..*", ""));
			    }
			});
		} catch (IOException e) {
			System.err.println("MainController.findFiles():ERROR: " + e.getMessage());
		}
		
		return list;
	}
	
	private String checkName(String arg0, HttpServletRequest request){
		String result = "";
		
		if (arg0 == null || arg0.length() <= 0) {
			result = "_sys/blank";
		}
		else if (_security.contains(arg0)) {
			if (request.isUserInRole("ROLE_ADMIN")) {
				result = "_security/" + arg0;
			}
			else {
				result = "_sys/403";
			}
		}
		else if (_shop.contains(arg0)) {
			result = "_shop/" + arg0;
		}
		else if (_public.contains(arg0)) {
			result = "_public/" + arg0;
		}
		else if (_sys.contains(arg0)) {
			result = "_sys/" + arg0;
		}
		else if (_data.contains(arg0)) {
			result = "_data/" + arg0;
		}
		else if (arg0.contains("FragmentSelector")) {
			result = "fragment/selector/" + arg0;
		}
		else if (arg0.contains("FragmentLedit")) {
			result = "fragment/ledit/" + arg0;
		}
		else if (arg0.contains("FragmentEdit")) {
			result = "fragment/edit/" + arg0;
		}
		else if (arg0.contains("FragmentList")) {
			result = "fragment/list/" + arg0;
		}
		else if (arg0.contains("FragmentMedit")) {
			result = "fragment/medit/" + arg0;
		}
		else if (arg0.contains("List")) {
			result = "list/" + arg0;
		}
		else if (arg0.contains("Edit")) {
			result = "edit/" + arg0;
		}
		else if (arg0.contains("Create")) {
			result = "create/" + arg0;
		}
		else {
			result = arg0;
		}
		
		return result;
	}
	
	
	// for 403 access denied page
	/**
	 * Accesss denied.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName(checkName("403", request));
		return model;

	}

	/**
	 * Not found.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public ModelAndView notFound(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName(checkName("404", request));
		return model;

	}

	/**
	 * Admin page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public ModelAndView adminPage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName(checkName("admin", request));

		return model;

	}

	/**
	 * Default page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value = { "/", "/welcome**", "/hello**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage(HttpServletRequest request) {

		Locale locale = LocaleContextHolder.getLocale();
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Main page");
		model.addObject("description", "This is default page!");
		model.addObject("lang", locale.toString());
		
//		model.addObject("result", generateDataRaw(3, false, "{ \"OUTPUT\":") + " }");
		model.setViewName(checkName("home", request));

		return model;

	}
	/*
	@RequestMapping(value = "/public/{page}", method = RequestMethod.GET)
	public ModelAndView publicPage(@PathVariable String page, HttpServletRequest request) {
		return privatePage(page, request);
	}
	
	@RequestMapping(value = "/public/{page}/{index}", method = RequestMethod.GET)
	public ModelAndView publicPageWithIndex(@PathVariable String page, @PathVariable String index, HttpServletRequest request) {
		return privatePageWithIndex(page, index, request);
	}
	*/
	@RequestMapping(value = "/{key}/{page}", method = RequestMethod.GET)
	public ModelAndView sasPage(@PathVariable String key, @PathVariable String page, HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("debug", debug);
		model.addObject("key", key);
		model.setViewName(checkName(page, request));
		
		return model;
		
	}
	
	@RequestMapping(value = "/d/{page}", method = RequestMethod.GET)
//	@PreAuthorize("isAuthenticated()")
	public ModelAndView privatePage(@PathVariable String page, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
//		Locale locale = LocaleContextHolder.getLocale();
		if (page.contains("index") || page.contains("index2")) {
			model.addObject("showCalendar", showCalendar);
		}
		model.addObject("debug", debug);
		model.addObject("key", "c231edae");
		model.setViewName(checkName(page, request));

		return model;

	}

	@RequestMapping(value = "/d/{page}/{index}", method = RequestMethod.GET)
//	@PreAuthorize("isAuthenticated()")
	public ModelAndView privatePageWithIndex(@PathVariable String page, @PathVariable String index
			, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
//		Locale locale = LocaleContextHolder.getLocale();
		if (page.contains("index") || page.contains("index2")) {
			model.addObject("showCalendar", showCalendar);
		}
		model.addObject("index", index);
		model.addObject("key", "c231edae");
		model.addObject("debug", debug);
		// model.addObject("message", "This page is for ROLE_ADMIN only!, " +
		// page);

		model.setViewName(checkName(page, request));

		return model;

	}

	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession()
				.getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	/**
	 * Login.
	 *
	 * @param error the error
	 * @param logout the logout
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "redirectTo", required = false) String redirectTo,
			HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView();
		
		if (logout != null) {
			try {
				HttpSession session = request.getSession(false);
				session.invalidate();
				SecurityContextHolder.clearContext();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (redirectTo != null) {
			model.setViewName("redirect:" + redirectTo);
		}
		else {
			if (error != null) {
				model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
			}
			if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			}
			model.addObject("debug", debug);
			model.addObject("login", Settings.LOGIN.getValue());
		
			model.setViewName(checkName("login", request));
		}
		
		return model;

	}

	/**
	 * Debug mode.
	 *
	 * @param model the model
	 * @param name the name
	 * @return the map
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/debugmode/{name}", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody Map<String, Boolean> debugMode(ModelMap model
			, @PathVariable String name) throws Exception {
		Map<String, Boolean> modelMap = new HashMap<String, Boolean>(1);
		Boolean isDebug = false;
		try {
			isDebug = Settings.valueOf(name).getValue();
			if (debug) {
				System.out.println("isDebug for " + name +": " +
					isDebug
				);
			}
		} catch (IllegalArgumentException | NullPointerException  e) {
			
		}
		
		modelMap.put("debug", isDebug);
		return modelMap;
	}
	
	/**
	 * Default error.
	 *
	 * @param req the req
	 * @param exception the exception
	 * @return the model and view
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView defaultError(HttpServletRequest req, Exception exception) {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.severe("Request: " + req.getRequestURL() + " raised " + exception);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(checkName("error", req));
		return mav;

	}

}