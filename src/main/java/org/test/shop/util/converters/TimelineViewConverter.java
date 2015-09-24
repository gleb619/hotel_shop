/*
 * 
 */
package org.test.shop.util.converters;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.test.shop.model.domain.entity.other.TimelineView;

// TODO: Auto-generated Javadoc
/**
 * The Class TimelineViewConverter.
 */
public class TimelineViewConverter {

	/** The index. */
	private static Integer index = 0;
	
	/** The invert. */
	private static Boolean invert = true;
	
	/**
	 * Invert.
	 *
	 * @return the boolean
	 */
	private static Boolean invert() {
		invert = !invert;
		return invert;
	}
	
	
	/**
	 * Convert.
	 *
	 * @param timelineViews the timeline views
	 * @param messageSource the message source
	 * @param locale the locale
	 * @return the list
	 */
	public static List<TimelineView> convert(List<TimelineView> timelineViews, MessageSource messageSource, Locale locale) {
		index = 0;
		LocalDate today = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		for (TimelineView it : timelineViews) {
			try {
				it = convertData(messageSource, locale, today, it);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			index++;
		}

		return timelineViews;
	}


	private static TimelineView convertData(MessageSource messageSource, Locale locale, LocalDate today, TimelineView it) throws Exception {
		LocalDate dateFrom = null;
		it.setInvert(invert());
		
//			if ((index & 1) == 0) {
//				it.setInvert(false);
//			} else {
//				it.setInvert(true);
//			}

		it.setIcon("fa fa-lg fa-puzzle-piece");
		
		if(!it.getInvert()){
			it.setIcon(it.getIcon() + " fa-flip-horizontal");
		}

		it.setBadge("default");
		
		try {
			if (it.getModifyon() == null) {
				dateFrom = it.getCreateon().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				it.setBadge("success");
			}
			else if (it.getModifyon().after(it.getCreateon())) {
				dateFrom = it.getModifyon().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				it.setBadge("info");
			} else {
				dateFrom = it.getCreateon().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				it.setBadge("default");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String title = messageSource.getMessage( "label." + it.getModule(), null, locale);
		if (title == null) {
			messageSource.getMessage("label." + it.getModule() + "View", null, locale);
		}
		if (title == null) {
			title = it.getModule();
		}

		it.setTitle(title);
		
		
		try {
			Period period = Period.between(dateFrom, today);
			Integer year = period.getYears(); 
			Integer month = period.getMonths(); 
			Integer day = period.getDays();
			String gone = "";

			if(year <= 0){
				year = null;
			}
			else {
				gone += year.toString() + " " + messageSource.getMessage("default.years", null, locale) + " ";
			}
			
			if(month <= 0){
				month = null;
			}
			else {
				gone += month.toString() + " " + messageSource.getMessage("default.months", null, locale) + " ";
			}
			
			if(day <= 0){
				day = null;
			}
			else {
				gone += day.toString() + " " + messageSource.getMessage("default.days", null, locale) + " ";
			}
			
			if(gone.length() <= 0){
				gone = messageSource.getMessage("default.today", null, locale);
			}
			
			gone += " " + messageSource.getMessage("default.passed", null, locale);
			it.setGone(gone);
		} catch (NoSuchMessageException e) {
			e.printStackTrace();
		}
		
		return it;
	}

}
