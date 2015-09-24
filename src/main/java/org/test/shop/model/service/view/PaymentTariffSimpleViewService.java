package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentTariffSimpleViewDao;
import org.test.shop.model.domain.entity.view.PaymentTariffSimpleView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentTariffSimpleViewService {

	@Autowired
	private PaymentTariffSimpleViewDao paymenttariffsimpleviewDao;

	@Transactional
	public PaymentTariffSimpleView create(PaymentTariffSimpleView data) {
		return paymenttariffsimpleviewDao.create(data);
	}

	@Transactional
	public PaymentTariffSimpleView update(PaymentTariffSimpleView data) {
		return paymenttariffsimpleviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymenttariffsimpleviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentTariffSimpleView data) {
		paymenttariffsimpleviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymenttariffsimpleviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymenttariffsimpleviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymenttariffsimpleviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> namedFilter(ScrollableSettings settings) {
		return paymenttariffsimpleviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> search(ScrollableSettings settings){
		return  paymenttariffsimpleviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> findByExample(PaymentTariffSimpleView example, String delimitter, ScrollableSettings settings) {
		return paymenttariffsimpleviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> findByExample2(PaymentTariffSimpleView example, DateCompare type) {
		return paymenttariffsimpleviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> findAll() {
		return paymenttariffsimpleviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> findAll(ScrollableSettings settings) {
		return paymenttariffsimpleviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffSimpleView> findAllScrollable(ScrollableSettings settings) {
		return paymenttariffsimpleviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentTariffSimpleView findById(ScrollableSettings scrollableSettings) {
		return paymenttariffsimpleviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentTariffSimpleView findById(Object key, Boolean initAll) {
		return paymenttariffsimpleviewDao.findById(key, initAll);
	}
	
	
}
