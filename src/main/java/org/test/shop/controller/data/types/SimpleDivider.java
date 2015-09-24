package org.test.shop.controller.data.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.test.shop.model.domain.entity.view.ShopServHotel2View;

public class SimpleDivider implements Divider<ShopServHotel2View> {

	private Map<String, List<ShopServHotel2View>> cityHolder = new HashMap<String, List<ShopServHotel2View>>();
	
	@Override
	public ShopServHotel2View divide(ShopServHotel2View from) {
		return from;
	}

	@Override
	public Divider.Result divide(List<ShopServHotel2View> from) {
		
		try {
			from.forEach(it -> {
				checkCity(it.getCityname()).add(divide(it));
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SimpleResult();
	}
	
	private List<ShopServHotel2View> checkCity(String city) {
		if (!cityHolder.containsKey(city)) {
			cityHolder.put(city, new ArrayList<ShopServHotel2View>());
		}
		
		return cityHolder.get(city);
	}
	
	public class SimpleResult implements Divider.Result {

		@Override
		public Object result() {
			
			ArrayList<Object> result = new ArrayList<Object>();
			cityHolder.keySet().forEach(it -> {
				result.add(new DividedResult(it, cityHolder.get(it)));
			});
			
			return result;
		}
		
	}

}
