package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentTariffShopViewDao;
import org.test.shop.model.domain.entity.view.PaymentTariffShopView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentTariffShopViewService {

	@Autowired
	private PaymentTariffShopViewDao paymenttariffshopviewDao;

	@Transactional
	public PaymentTariffShopView create(PaymentTariffShopView data) {
		return paymenttariffshopviewDao.create(data);
	}

	@Transactional
	public PaymentTariffShopView update(PaymentTariffShopView data) {
		return paymenttariffshopviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymenttariffshopviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentTariffShopView data) {
		paymenttariffshopviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymenttariffshopviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymenttariffshopviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymenttariffshopviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> namedFilter(ScrollableSettings settings) {
		return paymenttariffshopviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> search(ScrollableSettings settings){
		return  paymenttariffshopviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> findByExample(PaymentTariffShopView example, String delimitter, ScrollableSettings settings) {
		return paymenttariffshopviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> findByExample2(PaymentTariffShopView example, DateCompare type) {
		return paymenttariffshopviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> findAll() {
		return paymenttariffshopviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> findAll(ScrollableSettings settings) {
		return paymenttariffshopviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopView> findAllScrollable(ScrollableSettings settings) {
		return paymenttariffshopviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentTariffShopView findById(ScrollableSettings scrollableSettings) {
		return paymenttariffshopviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentTariffShopView findById(Object key, Boolean initAll) {
		return paymenttariffshopviewDao.findById(key, initAll);
	}
	
	
}
