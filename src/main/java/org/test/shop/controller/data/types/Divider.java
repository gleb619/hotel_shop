package org.test.shop.controller.data.types;

import java.util.List;

public interface Divider<FROM> {

	public FROM divide(FROM from);
	public Result divide(List<FROM> from);
	
	public interface Result {
	
		public Object result();
		
	}
	
}
