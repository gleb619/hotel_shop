/*
 * 
 */
package org.test.shop.config;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;















import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.test.shop.util.data.types.FilesSettings;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;


// TODO: Auto-generated Javadoc
/**
 * The Class TestConfig.
 */
@ComponentScan({ "org.test.shop.model.*", "org.test.shop.util" })
@PropertySource("classpath:/files.properties")
@Configuration
@EnableTransactionManagement
@Import({ 
      AsyncConfiguration.class
})
@Profile("Test")
public class TestConfig {

	/** The debug. */
	private Boolean debug = false;
	
	/** The env. */
	@Autowired
	private Environment env;
	
	@Bean(name = "mapper")
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		
		Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        
        mapper.registerModule(hibernate4Module);
		
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("YYYY-MM-dd hh:mm:ss"));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        
        return mapper;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");

		return localeChangeInterceptor;
	}

	/**
	 * Message source.
	 *
	 * @return the reloadable resource bundle message source
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("classpath:messages");
		messageSource.setBasenames("classpath:defmessages", "classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.clearCache();
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setFallbackToSystemLocale(false);

		return messageSource;
	}

	/**
	 * Session locale resolver.
	 *
	 * @return the session locale resolver
	 */
	@Bean(name = "localeResolver")
	public SessionLocaleResolver sessionLocaleResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("ru"));

		return localeResolver;
	}
	
	/**
	 * Data source.
	 *
	 * @return the driver manager data source
	 */
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
			dataSource.setDriverClassName("org.postgresql.Driver");
//			dataSource.setUrl("jdbc:postgresql://192.168.0.53:5432/shop_rcr");
			dataSource.setUrl("jdbc:postgresql://192.168.1.102:5432/shop_rcr");
			dataSource.setUsername("postgres");
			dataSource.setPassword("root");
		
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
		
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.PostgreSQLDialect");
		
		return properties;
	}

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
	
	/**
	 * Image settings.
	 *
	 * @return the files settings
	 */
	@Bean
	public FilesSettings imageSettings() {
		FilesSettings filesSettings = new FilesSettings();
		if (SystemUtils.IS_OS_WINDOWS) {
			filesSettings.setImageDefaultPath(env.getProperty("image.default.windows.path"));
			filesSettings.setDocumentsDefaultPath(env.getProperty("documents.default.windows.path"));
		}
		else {
			filesSettings.setImageDefaultPath(env.getProperty("image.default.linux.path"));
			filesSettings.setDocumentsDefaultPath(env.getProperty("documents.default.linux.path"));
			
		}
		
		return filesSettings;
	}
	
	/**
	 * Session registry.
	 *
	 * @return the session registry
	 */
	@Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
	
}
