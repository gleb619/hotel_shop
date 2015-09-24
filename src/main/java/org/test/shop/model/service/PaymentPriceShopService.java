package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.PaymentPriceShopDao;
import org.test.shop.model.domain.entity.PaymentPriceShop;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentPriceShopService {

	@Autowired
	private PaymentPriceShopDao paymentpriceshopDao;

	@Transactional
	public PaymentPriceShop create(PaymentPriceShop data) {
		return paymentpriceshopDao.create(data);
	}

	@Transactional
	public PaymentPriceShop update(PaymentPriceShop data) {
		return paymentpriceshopDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentpriceshopDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentPriceShop data) {
		paymentpriceshopDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentpriceshopDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentpriceshopDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentpriceshopDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShop> namedFilter(ScrollableSettings settings) {
		return paymentpriceshopDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShop> search(ScrollableSettings settings){
		return  paymentpriceshopDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShop> findByExample(PaymentPriceShop example, String delimitter, ScrollableSettings settings) {
		return paymentpriceshopDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentPriceShop> findByExample2(PaymentPriceShop example, DateCompare type) {
		return paymentpriceshopDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShop> findAll() {
		return paymentpriceshopDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShop> findAll(ScrollableSettings settings) {
		return paymentpriceshopDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShop> findAllScrollable(ScrollableSettings settings) {
		return paymentpriceshopDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentPriceShop findById(ScrollableSettings scrollableSettings) {
		return paymentpriceshopDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentPriceShop findById(Object key, Boolean initAll) {
		return paymentpriceshopDao.findById(key, initAll);
	}
	
	
}
