package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentPriceShopSimpleViewDao;
import org.test.shop.model.domain.entity.view.PaymentPriceShopSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentPriceShopSimpleViewService {

	@Autowired
	private PaymentPriceShopSimpleViewDao paymentpriceshopsimpleviewDao;

	@Transactional
	public PaymentPriceShopSimpleView create(PaymentPriceShopSimpleView data) {
		return paymentpriceshopsimpleviewDao.create(data);
	}

	@Transactional
	public PaymentPriceShopSimpleView update(PaymentPriceShopSimpleView data) {
		return paymentpriceshopsimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentpriceshopsimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentPriceShopSimpleView data) {
		paymentpriceshopsimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentpriceshopsimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentpriceshopsimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentpriceshopsimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> namedFilter(ScrollableSettings settings) {
		return paymentpriceshopsimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> search(ScrollableSettings settings){
		return  paymentpriceshopsimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> findByExample(PaymentPriceShopSimpleView example, String delimitter, ScrollableSettings settings) {
		return paymentpriceshopsimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> findByExample2(PaymentPriceShopSimpleView example, DateCompare type) {
		return paymentpriceshopsimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> findAll() {
		return paymentpriceshopsimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> findAll(ScrollableSettings settings) {
		return paymentpriceshopsimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopSimpleView> findAllScrollable(ScrollableSettings settings) {
		return paymentpriceshopsimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentPriceShopSimpleView findById(ScrollableSettings scrollableSettings) {
		return paymentpriceshopsimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentPriceShopSimpleView findById(Object key, Boolean initAll) {
		return paymentpriceshopsimpleviewDao.findById(key, initAll);
	}
	
	
}
