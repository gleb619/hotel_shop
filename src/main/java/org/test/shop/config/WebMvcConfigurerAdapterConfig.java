/*
 * 
 */
package org.test.shop.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.test.shop.config.debug.Settings;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

// TODO: Auto-generated Javadoc
/**
 * The Class WebMvcConfigurerAdapterConfig.
 */
@EnableWebMvc
public class WebMvcConfigurerAdapterConfig extends WebMvcConfigurerAdapter {

	/** The debug. */
	private Boolean debug = Settings.WEB_MVC_CONFIGURER_ADAPTER_CONFIG.getValue();
//	private static String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
	private static String DATE_FORMAT = "yyyy-MM-dd HH:mm";

	/**
	 * Jackson message converter.
	 *
	 * @return the mapping jackson2 http message converter
	 */
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

		ObjectMapper mapper = new ObjectMapper();
		
		Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        
        mapper.registerModule(hibernate4Module);
//      mapper.registerModule(new Hibernate3Module());
//		mapper.registerModule(new Jdk7Module());
//		mapper.registerModule(new Jdk8Module());
//		mapper.registerModule(new JSR310Module());
		
//		SimpleModule  module = new SimpleModule();
//		module.addDeserializer(ServHotel.class, new JSOGRefDeserializer());
//		module.addDeserializer(SObject.class, new JSOGRefDeserializer());
//		module.addDeserializer(SView.class, new JSOGRefDeserializer());
//		mapper.registerModule(module);
		
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
        mapper.setDateFormat(dateFormat);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
		
		if (debug) {
			messageConverter.setPrettyPrint(true);
		}

		messageConverter.setObjectMapper(mapper);
		return messageConverter;
	}
	
	/**
	 * String message converter.
	 *
	 * @return the string http message converter
	 */
	public StringHttpMessageConverter stringMessageConverter() {
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		
		return stringHttpMessageConverter;
	}
	
	/**
	 * Buffered image http message converter.
	 *
	 * @return the buffered image http message converter
	 */
	public BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter() {
		BufferedImageHttpMessageConverter bufferedImageHttpMessageConverter = new BufferedImageHttpMessageConverter();
		return bufferedImageHttpMessageConverter;
	}
	 
	/**
	 * Mapper.
	 *
	 * @return the object mapper
	 */
	@Bean(name = "mapper")
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		
		Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        
        mapper.registerModule(hibernate4Module);
		
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        
        return mapper;
	}
	
	
	/**
	 * Locale change interceptor.
	 *
	 * @return the locale change interceptor
	 */
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
	 * View resolver.
	 *
	 * @return the internal resource view resolver
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setCache(true);
		
		return viewResolver;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureMessageConverters(java.util.List)
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(bufferedImageHttpMessageConverter());
		converters.add(stringMessageConverter());
		converters.add(jacksonMessageConverter());
		super.configureMessageConverters(converters);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/").setCachePeriod(31556926);
	}
	
}

