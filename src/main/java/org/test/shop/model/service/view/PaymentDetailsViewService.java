package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentDetailsViewDao;
import org.test.shop.model.domain.entity.view.PaymentDetailsView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentDetailsViewService {

	@Autowired
	private PaymentDetailsViewDao paymentdetailsviewDao;

	@Transactional
	public PaymentDetailsView create(PaymentDetailsView data) {
		return paymentdetailsviewDao.create(data);
	}

	@Transactional
	public PaymentDetailsView update(PaymentDetailsView data) {
		return paymentdetailsviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentdetailsviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentDetailsView data) {
		paymentdetailsviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentdetailsviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentdetailsviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentdetailsviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetailsView> namedFilter(ScrollableSettings settings) {
		return paymentdetailsviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetailsView> search(ScrollableSettings settings){
		return  paymentdetailsviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetailsView> findByExample(PaymentDetailsView example, String delimitter, ScrollableSettings settings) {
		return paymentdetailsviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentDetailsView> findByExample2(PaymentDetailsView example, DateCompare type) {
		return paymentdetailsviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetailsView> findAll() {
		return paymentdetailsviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentDetailsView> findAll(ScrollableSettings settings) {
		return paymentdetailsviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentDetailsView> findAllScrollable(ScrollableSettings settings) {
		return paymentdetailsviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentDetailsView findById(ScrollableSettings scrollableSettings) {
		return paymentdetailsviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentDetailsView findById(Object key, Boolean initAll) {
		return paymentdetailsviewDao.findById(key, initAll);
	}
	
	
}
