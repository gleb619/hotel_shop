package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentPriceViewDao;
import org.test.shop.model.domain.entity.view.PaymentPriceView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentPriceViewService {

	@Autowired
	private PaymentPriceViewDao paymentpriceviewDao;

	@Transactional
	public PaymentPriceView create(PaymentPriceView data) {
		return paymentpriceviewDao.create(data);
	}

	@Transactional
	public PaymentPriceView update(PaymentPriceView data) {
		return paymentpriceviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentpriceviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentPriceView data) {
		paymentpriceviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentpriceviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentpriceviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentpriceviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceView> namedFilter(ScrollableSettings settings) {
		return paymentpriceviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceView> search(ScrollableSettings settings){
		return  paymentpriceviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceView> findByExample(PaymentPriceView example, String delimitter, ScrollableSettings settings) {
		return paymentpriceviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentPriceView> findByExample2(PaymentPriceView example, DateCompare type) {
		return paymentpriceviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceView> findAll() {
		return paymentpriceviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceView> findAll(ScrollableSettings settings) {
		return paymentpriceviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceView> findAllScrollable(ScrollableSettings settings) {
		return paymentpriceviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentPriceView findById(ScrollableSettings scrollableSettings) {
		return paymentpriceviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentPriceView findById(Object key, Boolean initAll) {
		return paymentpriceviewDao.findById(key, initAll);
	}
	
	
}
