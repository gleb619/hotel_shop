package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.PaymentTariffViewDao;
import org.test.shop.model.domain.entity.view.PaymentTariffView;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class PaymentTariffViewService {

	@Autowired
	private PaymentTariffViewDao paymenttariffviewDao;

	@Transactional
	public PaymentTariffView create(PaymentTariffView data) {
		return paymenttariffviewDao.create(data);
	}

	@Transactional
	public PaymentTariffView update(PaymentTariffView data) {
		return paymenttariffviewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return paymenttariffviewDao.delete(id);
	}

	@Transactional
	public void popularity(PaymentTariffView data) {
		paymenttariffviewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		paymenttariffviewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return paymenttariffviewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return paymenttariffviewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffView> namedFilter(ScrollableSettings settings) {
		return paymenttariffviewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffView> search(ScrollableSettings settings){
		return  paymenttariffviewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffView> findByExample(PaymentTariffView example, String delimitter, ScrollableSettings settings) {
		return paymenttariffviewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<PaymentTariffView> findByExample2(PaymentTariffView example, DateCompare type) {
		return paymenttariffviewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffView> findAll() {
		return paymenttariffviewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffView> findAll(ScrollableSettings settings) {
		return paymenttariffviewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<PaymentTariffView> findAllScrollable(ScrollableSettings settings) {
		return paymenttariffviewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public PaymentTariffView findById(ScrollableSettings scrollableSettings) {
		return paymenttariffviewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public PaymentTariffView findById(Object key, Boolean initAll) {
		return paymenttariffviewDao.findById(key, initAll);
	}
	
	
}
