package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.PaymentDetailsDao;
import org.test.shop.model.domain.entity.PaymentDetails;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentDetailsService {

	@Autowired
	private PaymentDetailsDao paymentdetailsDao;

	@Transactional
	public PaymentDetails create(PaymentDetails data) {
		return paymentdetailsDao.create(data);
	}

	@Transactional
	public PaymentDetails update(PaymentDetails data) {
		return paymentdetailsDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentdetailsDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentDetails data) {
		paymentdetailsDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentdetailsDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentdetailsDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentdetailsDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetails> namedFilter(ScrollableSettings settings) {
		return paymentdetailsDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetails> search(ScrollableSettings settings){
		return  paymentdetailsDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetails> findByExample(PaymentDetails example, String delimitter, ScrollableSettings settings) {
		return paymentdetailsDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentDetails> findByExample2(PaymentDetails example, DateCompare type) {
		return paymentdetailsDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetails> findAll() {
		return paymentdetailsDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentDetails> findAll(ScrollableSettings settings) {
		return paymentdetailsDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetails> findAllScrollable(ScrollableSettings settings) {
		return paymentdetailsDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentDetails findById(ScrollableSettings scrollableSettings) {
		return paymentdetailsDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentDetails findById(Object key, Boolean initAll) {
		return paymentdetailsDao.findById(key, initAll);
	}
	
	
}
