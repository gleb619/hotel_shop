package org.test.shop.model.service.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.dao.view.ShopServHotel2ViewDao;
import org.test.shop.model.domain.entity.view.ShopServHotel2View;
import org.test.shop.util.data.types.DateCompare;

@Service
@Transactional
public class ShopServHotel2ViewService {

	@Autowired
	private ShopServHotel2ViewDao shopservhotel2viewDao;

	@Transactional
	public ShopServHotel2View create(ShopServHotel2View data) {
		return shopservhotel2viewDao.create(data);
	}

	@Transactional
	public ShopServHotel2View update(ShopServHotel2View data) {
		return shopservhotel2viewDao.update(data);
	}
	
	@Transactional
	public Boolean delete(Object id) {
		return shopservhotel2viewDao.delete(id);
	}

	@Transactional
	public void popularity(ShopServHotel2View data) {
		shopservhotel2viewDao.popularity(data);
	}
	
	@Transactional
	public void popularityByKey(Object data) {
		shopservhotel2viewDao.popularityByKey(data);
	}
	
	@Transactional(readOnly = true)
	public Integer todayNumber(ScrollableSettings settings) throws Exception {
		return shopservhotel2viewDao.todayNumber(settings);
	}
	
	@Transactional(readOnly = true)
	public Integer total(ScrollableSettings settings) throws Exception {
		return shopservhotel2viewDao.total(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopServHotel2View> namedFilter(ScrollableSettings settings) {
		return shopservhotel2viewDao.namedFilter(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopServHotel2View> search(ScrollableSettings settings){
		return  shopservhotel2viewDao.search(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopServHotel2View> findByExample(ShopServHotel2View example, String delimitter, ScrollableSettings settings) {
		return shopservhotel2viewDao.findByExample(example, delimitter, settings);
	}
	
	@Transactional(readOnly = true)
	public List<ShopServHotel2View> findByExample2(ShopServHotel2View example, DateCompare type) {
		return shopservhotel2viewDao.findByExample2(example, type);
	}

	@Transactional(readOnly = true)
	public List<ShopServHotel2View> findAll() {
		return shopservhotel2viewDao.findAll(new ScrollableSettings());
	}

	@Transactional(readOnly = true)
	public List<ShopServHotel2View> findAll(ScrollableSettings settings) {
		return shopservhotel2viewDao.findAll(settings);
	}

	@Transactional(readOnly = true)
	public List<ShopServHotel2View> findAllScrollable(ScrollableSettings settings) {
		return shopservhotel2viewDao.findAllScrollable(settings);
	}

	@Transactional(readOnly = true)
	public ShopServHotel2View findById(ScrollableSettings scrollableSettings) {
		return shopservhotel2viewDao.findById(scrollableSettings);
	}
	
	@Transactional(readOnly = true)
	public ShopServHotel2View findById(Object key, Boolean initAll) {
		return shopservhotel2viewDao.findById(key, initAll);
	}
	
	
}
