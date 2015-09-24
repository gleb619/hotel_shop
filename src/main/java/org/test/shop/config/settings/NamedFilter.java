package org.test.shop.config.settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;


public interface NamedFilter {

	public class Items {
		private static Query query;
		private static Class<?> classForOutput;
		public static final Map<Class<?>, List<Class<?>>> sharedQueries = new LinkedHashMap<Class<?>, List<Class<?>>>() {
			private static final long serialVersionUID = 1741651504677689194L;

		{
			
		}};
		
		public static final Map<Class<?>, List<Query>> map = new LinkedHashMap<Class<?>, List<Query>>() {
			private static final long serialVersionUID = 4741651504397689194L;
			{
			}
		};
		
		public static String byName(String name, Class<?> clazz) {
			query = new Query(null, "SELECT #SHORTNAME FROM #TABLENAME #SHORTNAME");
			
			if (!map.containsKey(clazz)) {
				clazz = checkSharedQuery(clazz);
			}
			
			if (map.containsKey(clazz)) {
				List<Query> queries = map.get(clazz);
				queries.parallelStream().forEach(it -> {
					if (name.toLowerCase().replaceAll("\\s+", "").equals(it.getName().toLowerCase().replaceAll("\\s+", ""))) {
						query = it;
					}
				});
			}
			
			return query.getQuery();
		}
		
		private static Class<?> checkSharedQuery(Class<?> classForCheck){
			classForOutput = null;
			sharedQueries.forEach((key, value) -> {
				value.parallelStream().forEach(it -> {
					if (it == classForCheck) {
						classForOutput = key;
					}
				});
			});
			
			return classForOutput;
		}
	}
	
	public class Query {

		private String name;
		private String query;

		public Query(String name, String query) {
			super();
			this.name = name;
			this.query = query;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getQuery() {
			return query;
		}

		public void setQuery(String query) {
			this.query = query;
		}

	}
	
}
