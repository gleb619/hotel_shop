/*
 * 
 */
package org.test.shop.controller.other;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.model.domain.entity.other.Localization;
import org.test.shop.model.domain.entity.other.Log;
import org.test.shop.model.service.other.LogsService;

// TODO: Auto-generated Javadoc
/**
 * The Class LogsController.
 */
@Controller
public class LogsController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5457866426627479250L;
	
	/** The Log service. */
	@Autowired
	private LogsService LogService;

	/**
	 * Creates the.
	 *
	 * @param data the data
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> create(
			@RequestBody(required = false) Log data) throws Exception {

		try {
			return JsonOutput.map(LogService.create(data));

		} catch (Exception e) {
			return JsonOutput.mapError("Error while creating Log: "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Delete.
	 *
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs", method = RequestMethod.DELETE, produces = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> delete() throws Exception {
		
		try {
			return JsonOutput.mapSuccess();

		} catch (Exception e) {
			return JsonOutput.mapError("Error trying to delete Log. "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> deleteById(
			@PathVariable Integer id) throws Exception {

		try {
			return JsonOutput.map(LogService.delete(id));

		} catch (Exception e) {
			return JsonOutput.mapError("Error trying to deleteById Log. "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Update.
	 *
	 * @param data the data
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> update(
			@RequestBody Log data) throws Exception {

		try {
			return JsonOutput.map(LogService.update(data));

		} catch (Exception e) {
			return JsonOutput.mapError("Error trying to update Log. "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Update by id.
	 *
	 * @param data the data
	 * @param id the id
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> updateById(
			@RequestBody Log data, @PathVariable Integer id)
			throws Exception {

		try {
			return JsonOutput.map(LogService.update(data));

		} catch (Exception e) {
			return JsonOutput.mapError("Error trying to update Log. "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * View by id.
	 *
	 * @param id the id
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs/{id}",  method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> viewById(
			@PathVariable String id) throws Exception {
		try {
			Log Log = LogService.findById(new Integer(id));
			if(Log == null){
				return JsonOutput.mapError("Cant find data for " + id);
			}

			return JsonOutput.mapSingle(Log);

		} catch (Exception e) {
			return JsonOutput.mapError("Error retrieving Log from database."
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * View.
	 *
	 * @param start the start
	 * @param limit the limit
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/logs", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> view(
			@RequestParam(required = false) Integer start,
			@RequestParam(required = false) Integer limit) throws Exception {
		try {
			List<Log> Logs = new LinkedList<Log>();

			if (start != null && limit != null) {
				Logs = LogService.findAll(start, limit);
			} else {
				Logs = LogService.findAll();
			}

			return JsonOutput.mapWithHeader(Logs, Log.class);

		} catch (Exception e) {
			return JsonOutput.mapError("Error retrieving Log from database."
					+ e.getLocalizedMessage());
		}
	}

}
