package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentTariffShopSimpleViewDao;
import org.test.shop.model.domain.entity.view.PaymentTariffShopSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentTariffShopSimpleViewService {

	@Autowired
	private PaymentTariffShopSimpleViewDao paymenttariffshopsimpleviewDao;

	@Transactional
	public PaymentTariffShopSimpleView create(PaymentTariffShopSimpleView data) {
		return paymenttariffshopsimpleviewDao.create(data);
	}

	@Transactional
	public PaymentTariffShopSimpleView update(PaymentTariffShopSimpleView data) {
		return paymenttariffshopsimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymenttariffshopsimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentTariffShopSimpleView data) {
		paymenttariffshopsimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymenttariffshopsimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymenttariffshopsimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymenttariffshopsimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> namedFilter(ScrollableSettings settings) {
		return paymenttariffshopsimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> search(ScrollableSettings settings){
		return  paymenttariffshopsimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> findByExample(PaymentTariffShopSimpleView example, String delimitter, ScrollableSettings settings) {
		return paymenttariffshopsimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> findByExample2(PaymentTariffShopSimpleView example, DateCompare type) {
		return paymenttariffshopsimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> findAll() {
		return paymenttariffshopsimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> findAll(ScrollableSettings settings) {
		return paymenttariffshopsimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffShopSimpleView> findAllScrollable(ScrollableSettings settings) {
		return paymenttariffshopsimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentTariffShopSimpleView findById(ScrollableSettings scrollableSettings) {
		return paymenttariffshopsimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentTariffShopSimpleView findById(Object key, Boolean initAll) {
		return paymenttariffshopsimpleviewDao.findById(key, initAll);
	}
	
	
}
