package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.PaymentTariffShopDao;
import org.test.shop.model.domain.entity.PaymentTariffShop;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentTariffShopService {

	@Autowired
	private PaymentTariffShopDao paymenttariffshopDao;

	@Transactional
	public PaymentTariffShop create(PaymentTariffShop data) {
		return paymenttariffshopDao.create(data);
	}

	@Transactional
	public PaymentTariffShop update(PaymentTariffShop data) {
		return paymenttariffshopDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymenttariffshopDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentTariffShop data) {
		paymenttariffshopDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymenttariffshopDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymenttariffshopDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymenttariffshopDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShop> namedFilter(ScrollableSettings settings) {
		return paymenttariffshopDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShop> search(ScrollableSettings settings){
		return  paymenttariffshopDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShop> findByExample(PaymentTariffShop example, String delimitter, ScrollableSettings settings) {
		return paymenttariffshopDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentTariffShop> findByExample2(PaymentTariffShop example, DateCompare type) {
		return paymenttariffshopDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShop> findAll() {
		return paymenttariffshopDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShop> findAll(ScrollableSettings settings) {
		return paymenttariffshopDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShop> findAllScrollable(ScrollableSettings settings) {
		return paymenttariffshopDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentTariffShop findById(ScrollableSettings scrollableSettings) {
		return paymenttariffshopDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentTariffShop findById(Object key, Boolean initAll) {
		return paymenttariffshopDao.findById(key, initAll);
	}
	
	
}
