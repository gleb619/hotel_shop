package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.PaymentPriceDao;
import org.test.shop.model.domain.entity.PaymentPrice;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentPriceService {

	@Autowired
	private PaymentPriceDao paymentpriceDao;

	@Transactional
	public PaymentPrice create(PaymentPrice data) {
		return paymentpriceDao.create(data);
	}

	@Transactional
	public PaymentPrice update(PaymentPrice data) {
		return paymentpriceDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentpriceDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentPrice data) {
		paymentpriceDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentpriceDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentpriceDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentpriceDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPrice> namedFilter(ScrollableSettings settings) {
		return paymentpriceDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPrice> search(ScrollableSettings settings){
		return  paymentpriceDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPrice> findByExample(PaymentPrice example, String delimitter, ScrollableSettings settings) {
		return paymentpriceDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentPrice> findByExample2(PaymentPrice example, DateCompare type) {
		return paymentpriceDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentPrice> findAll() {
		return paymentpriceDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentPrice> findAll(ScrollableSettings settings) {
		return paymentpriceDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPrice> findAllScrollable(ScrollableSettings settings) {
		return paymentpriceDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentPrice findById(ScrollableSettings scrollableSettings) {
		return paymentpriceDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentPrice findById(Object key, Boolean initAll) {
		return paymentpriceDao.findById(key, initAll);
	}
	
	
}
