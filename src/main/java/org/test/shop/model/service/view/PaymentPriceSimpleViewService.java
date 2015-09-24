package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentPriceSimpleViewDao;
import org.test.shop.model.domain.entity.view.PaymentPriceSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentPriceSimpleViewService {

	@Autowired
	private PaymentPriceSimpleViewDao paymentpricesimpleviewDao;

	@Transactional
	public PaymentPriceSimpleView create(PaymentPriceSimpleView data) {
		return paymentpricesimpleviewDao.create(data);
	}

	@Transactional
	public PaymentPriceSimpleView update(PaymentPriceSimpleView data) {
		return paymentpricesimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentpricesimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentPriceSimpleView data) {
		paymentpricesimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentpricesimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentpricesimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentpricesimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> namedFilter(ScrollableSettings settings) {
		return paymentpricesimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> search(ScrollableSettings settings){
		return  paymentpricesimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> findByExample(PaymentPriceSimpleView example, String delimitter, ScrollableSettings settings) {
		return paymentpricesimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> findByExample2(PaymentPriceSimpleView example, DateCompare type) {
		return paymentpricesimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> findAll() {
		return paymentpricesimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> findAll(ScrollableSettings settings) {
		return paymentpricesimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceSimpleView> findAllScrollable(ScrollableSettings settings) {
		return paymentpricesimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentPriceSimpleView findById(ScrollableSettings scrollableSettings) {
		return paymentpricesimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentPriceSimpleView findById(Object key, Boolean initAll) {
		return paymentpricesimpleviewDao.findById(key, initAll);
	}
	
	
}
