/*
 * 
 */
package org.test.shop.config;

import java.beans.PropertyVetoException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.test.shop.config.debug.Settings;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class DataConfig.
 */
@EnableTransactionManagement
public class DataConfig {

	/** The result map. */
	private Map<String, String> resultMap = new HashMap<String, String>();
	
	/** The debug. */
	private Boolean debug = Settings.DATA_CONFIG.getValue();
	
	/*
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		if(debug){
			dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
			dataSource.setUrl("jdbc:hsqldb:mem:data/store2");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
		}
		else {
			dataSource.setDriverClassName("org.postgresql.Driver");
//			dataSource.setUrl("jdbc:postgresql://192.168.0.53:5432/shop_rcr");
			dataSource.setUrl("jdbc:postgresql://192.168.1.53:5432/shop_rcr");
			dataSource.setUsername("postgres");
			dataSource.setPassword("root");
		}
		
		return dataSource;
	}
	*/
	
	/**
	 * Instantiates a new data config.
	 */
	public DataConfig() {
		super();
		resultMap.put("192.168.1.75", "192.168.1.102");
		resultMap.put("192.168.1.100", "192.168.1.53");
		resultMap.put("192.168.1.106", "192.168.1.53");
		resultMap.put("192.168.0.25", "192.168.0.53");
		resultMap.put("192.168.0.53", "192.168.0.53");
		resultMap.put("127.0.1.1", "192.168.0.53");
	}

	/**
	 * Load ip.
	 *
	 * @return the string
	 */
	private String loadIP() {
		String output = "";
		try {
			String address = InetAddress.getLocalHost().getHostAddress();
			
			output = resultMap.getOrDefault(address, "127.0.0.1");
			System.err.println("CURRENT IP IS: " + address + ", work with: " + output);
//			output = resultMap.getOrDefault(address, "192.168.1.102");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	/**
	 * Data source.
	 *
	 * @return the data source
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		http://www.programcreek.com/java-api-examples/index.php?api=com.mchange.v2.c3p0.ComboPooledDataSource
//		http://www.mchange.com/projects/c3p0/
		
		try {
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://" + loadIP() + ":5432/tourism_rcr");
			dataSource.setUser("postgres");
			dataSource.setPassword("root");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	/**
	 * Additional properties.
	 *
	 * @return the properties
	 */
	private Properties additionalProperties() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		
		if (debug) {
			properties.setProperty("hibernate.show_sql", "true");
//			properties.setProperty("hibernate.hbm2ddl.auto", "update");
//			properties.setProperty("hbm2ddl.auto", "update");
		}
//		else {
//			properties.setProperty("hibernate.cache.use_second_level_cache", "true");
//			properties.setProperty("hibernate.cache.use_query_cache", "true");
//			properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
//			properties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//		}
		
		return properties;
	}
	/*
	@Bean
	public EntityManagerFactory  entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.test.shop.model" });
//		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setPersistenceProvider(new HibernatePersistenceProvider());
		em.setJpaProperties(additionalProperties());
		em.afterPropertiesSet();
		
		return em.getObject();
	}
	*/
	/**
	 * Entity manager factory.
	 *
	 * @return the local container entity manager factory bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "org.test.shop.model" });

//		JpaVendorAdapter vendorAdapter = new HibernatePersistence();
//		JpaVendorAdapter vendorAdapter = new HibernatePersistenceProvider();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		return em;
	}

	/**
	 * Exception translation.
	 *
	 * @return the persistence exception translation post processor
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	/*
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager((EntityManagerFactory) entityManagerFactory());
		transactionManager.setDataSource(dataSource());
		transactionManager.setJpaDialect(new HibernateJpaDialect());
		return transactionManager;
	}
	*/
	/**
	 * Transaction manager.
	 *
	 * @param emf the emf
	 * @return the platform transaction manager
	 */
	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}
	
}
