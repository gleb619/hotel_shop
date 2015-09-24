package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentPriceShopViewDao;
import org.test.shop.model.domain.entity.view.PaymentPriceShopView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentPriceShopViewService {

	@Autowired
	private PaymentPriceShopViewDao paymentpriceshopviewDao;

	@Transactional
	public PaymentPriceShopView create(PaymentPriceShopView data) {
		return paymentpriceshopviewDao.create(data);
	}

	@Transactional
	public PaymentPriceShopView update(PaymentPriceShopView data) {
		return paymentpriceshopviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymentpriceshopviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentPriceShopView data) {
		paymentpriceshopviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymentpriceshopviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymentpriceshopviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymentpriceshopviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> namedFilter(ScrollableSettings settings) {
		return paymentpriceshopviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> search(ScrollableSettings settings){
		return  paymentpriceshopviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> findByExample(PaymentPriceShopView example, String delimitter, ScrollableSettings settings) {
		return paymentpriceshopviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> findByExample2(PaymentPriceShopView example, DateCompare type) {
		return paymentpriceshopviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> findAll() {
		return paymentpriceshopviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> findAll(ScrollableSettings settings) {
		return paymentpriceshopviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentPriceShopView> findAllScrollable(ScrollableSettings settings) {
		return paymentpriceshopviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentPriceShopView findById(ScrollableSettings scrollableSettings) {
		return paymentpriceshopviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentPriceShopView findById(Object key, Boolean initAll) {
		return paymentpriceshopviewDao.findById(key, initAll);
	}
	
	
}
