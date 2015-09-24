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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.shop.controller.data.types.JsonOutput;
import org.test.shop.model.domain.entity.other.Localization;
import org.test.shop.model.service.other.LocalizationService;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalizationController.
 */
@Controller
public class LocalizationController {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5457866426627479250L;

	/** The localization service. */
	@Autowired
	private LocalizationService localizationService;

	/**
	 * Creates the.
	 *
	 * @param data the data
	 * @return the map< string,? extends object>
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/data/localization", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> create(
			@RequestBody(required = false) List<Localization> data)
			throws Exception {

		try {
			return JsonOutput.map(localizationService.create(data));

		} catch (Exception e) {
			return JsonOutput.mapError("Error while creating Localization: "
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
	@RequestMapping(value = "/data/localization", method = RequestMethod.GET)
	@PreAuthorize(value = "hasRole('ROLE_USER')")
	public @ResponseBody Map<String, ? extends Object> view(
			@RequestParam(required = false) Integer start,
			@RequestParam(required = false) Integer limit) throws Exception {
		try {
			List<Localization> localization = new LinkedList<Localization>();

			if (start != null && limit != null) {
				// localization = localizationService.findAll(start, limit);
			} else {
				localization = localizationService.findAll();
			}

			return JsonOutput.mapWithHeader(localization, Localization.class);

		} catch (Exception e) {
			return JsonOutput.mapError("Error retrieving Localization from database."
					+ e.getLocalizedMessage());
		}
	}

}
