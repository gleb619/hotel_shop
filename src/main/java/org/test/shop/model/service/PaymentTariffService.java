package org.test.shop.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.PaymentTariffDao;
import org.test.shop.model.domain.entity.PaymentTariff;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentTariffService {

	@Autowired
	private PaymentTariffDao paymenttariffDao;

	@Transactional
	public PaymentTariff create(PaymentTariff data) {
		return paymenttariffDao.create(data);
	}

	@Transactional
	public PaymentTariff update(PaymentTariff data) {
		return paymenttariffDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymenttariffDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentTariff data) {
		paymenttariffDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymenttariffDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymenttariffDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymenttariffDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariff> namedFilter(ScrollableSettings settings) {
		return paymenttariffDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariff> search(ScrollableSettings settings){
		return  paymenttariffDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariff> findByExample(PaymentTariff example, String delimitter, ScrollableSettings settings) {
		return paymenttariffDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentTariff> findByExample2(PaymentTariff example, DateCompare type) {
		return paymenttariffDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariff> findAll() {
		return paymenttariffDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentTariff> findAll(ScrollableSettings settings) {
		return paymenttariffDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariff> findAllScrollable(ScrollableSettings settings) {
		return paymenttariffDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentTariff findById(ScrollableSettings scrollableSettings) {
		return paymenttariffDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentTariff findById(Object key, Boolean initAll) {
		return paymenttariffDao.findById(key, initAll);
	}
	
	
}
