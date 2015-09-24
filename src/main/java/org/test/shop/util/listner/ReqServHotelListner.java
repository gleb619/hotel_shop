package org.test.shop.util.listner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.IntStream;

import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.PaymentPrice;
import org.test.shop.model.domain.entity.PaymentTariff;
import org.test.shop.model.domain.entity.RelReqServHotelTmContactEasy;
import org.test.shop.model.domain.entity.ReqServHotel;
import org.test.shop.model.domain.entity.ServHotelRoom;
import org.test.shop.model.domain.entity.TmContactEasy;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.TmContactEasyService;
import org.test.shop.model.service.UsersService;
import org.test.shop.model.service.ReqServHotelService;
import org.test.shop.util.SObjectListner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class ReqServHotelListner {


	/** The users service. */
	@Autowired
	private UsersService usersService;
	@Autowired
	private TmContactEasyService contactEasyService;
	@Autowired
	private ReqServHotelService reqServHotelService;
	@Autowired
	private MessageSource message;
	@Autowired
	private SObjectListner sObjectListner;
	
	/**
	 * Creates the.
	 *
	 * @param item the item
	 * @param sasUser the sas user
	 * @return the req serv hotel
	 */
	public ReqServHotel create(ReqServHotel item, SasUser sasUser) {
		System.out.println("ReqServHotelListner.create()#item: " + item);
		
		item.setProgress(10);
		try {
			if (item.getUsersByRequestUserId() == null) {
				item.setUsersByRequestUserId(usersService.findById(sasUser.getUser().getId(), false));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (item.getPrice() == null || item.getPrice().intValue() <= 0) {
				item.setPrice(new BigDecimal(calculatePrice(item)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (item.getRequestNumber() == null || item.getRequestNumber().toString().replaceAll("\\s+", "").length() == 0) {
				item.setRequestNumber(nameLogic(sasUser));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			sasLeads(sasUser, item);
		} catch (Exception e) {
			
		}
		
		System.err.println("ReqServHotelListner.create()#firm: "
				+ item.getTmContactEasies().get(0).getFirmid()
		);
		
		return item;
	}
	
	private ReqServHotel sasLeads(SasUser sasUser, ReqServHotel item) {
		item.getTmContactEasies().parallelStream().forEach(it -> {
			it = sObjectListner.create(sasUser, it);
		});
		
		return item;
	}
	
	private String nameLogic(SasUser sasUser) {
		ScrollableSettings settings = new ScrollableSettings(sasUser);
		Integer total = 0;
		Integer totalToday = 0;
		
		try {
			total = reqServHotelService.total(settings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			totalToday = reqServHotelService.todayNumber(settings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name = message.getMessage("default.reqservhotel-create-note", null, new Locale("ru"))
				+ "-" + total
				+ "-" + totalToday
				+ "-" + UUID.randomUUID().toString().substring(0, 3);
		
		return name;
	}
	
	
	private Integer calculatePrice(ReqServHotel item) throws Exception {
		System.out.println("ReqServHotelListner.calculatePrice()");
		Integer guestNumber = item.getRoomCount();
		Integer capacity = item.getServHotelRoom().getGuestNumber();
		Integer price = 0;
		
		try {
			List<Integer> roomCapacity = new ArrayList<Integer>();
			
			if (guestNumber > capacity) {
				roomCapacity = findRoomNumber(guestNumber, capacity);
			}
			else {
				roomCapacity.add(capacity);
			}
			
			for (Integer roomcapacity : roomCapacity) {
				price += findRoomCost(roomcapacity, item.getServHotelRoom());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Integer multiplier = guestNumber / roomCapacity;
//		Integer roomCost = 
		
		System.out.println("ReqServHotelListner.calculatePrice()#price: " + price);
		
		return price;
	}
	
	private List<Integer> findRoomNumber(Integer guestNumber, Integer capacity) throws Exception {
		Integer resultDivide = (guestNumber / capacity);
		Integer resultMultiply = capacity * resultDivide;
		List<Integer> list = new ArrayList<Integer>();
		
		if ((guestNumber - resultMultiply) != 0) {
			IntStream.range(0, resultDivide).forEach(it -> {
				list.add(capacity);
			});
			list.add(guestNumber - resultMultiply);
		}
		else {
			IntStream.range(0, resultDivide).forEach(it -> {
				list.add(capacity);
			});
		}
		
		return list;
	}
	
	private Integer findRoomCost(Integer roomCapacity, ServHotelRoom room) throws Exception {
		PaymentTariff tariff = null;
		/*
		if(room.getPaymentTariffs() != null && room.getPaymentTariffs().size() > 0){
			tariff = room.getPaymentTariffs().get(0); 
			
			if (tariff.getPaymentPrices() != null && tariff.getPaymentPrices().size() > 0) {
				for (PaymentPrice price : tariff.getPaymentPrices()) {
					if (price.getHumannumber() == roomCapacity) {
						return price.getValue().intValue(); 
					}
				}
				
				return tariff.getPaymentPrices().get(0).getValue().intValue();
			}
		}
		*/
		return 0;
	}
	
	/**
	 * Update.
	 *
	 * @param item the item
	 * @param settings the settings
	 * @return the req serv hotel
	 */
	public ReqServHotel update(ReqServHotel item, ScrollableSettings settings) throws Exception {
//		if (item.getUsers() == null) {
//			item.setUsers();
//			ResponseUser(settings.getSasUser().getUsername());
			
//		}
		
		return item;
	}
	
}
