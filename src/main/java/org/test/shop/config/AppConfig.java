/*
 * 
 */
package org.test.shop.config;


import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.test.shop.util.LogUtil;
import org.test.shop.util.data.types.FilesSettings;

// TODO: Auto-generated Javadoc
/**
 * The Class AppConfig.
 */
@Configuration
@PropertySource("classpath:/files.properties")
@ComponentScan({ "org.test.shop.*" })
@EnableAspectJAutoProxy
@Import({ 
		  DataConfig.class
	    , CacheConfig.class
		, SecurityConfig.class
		, WebMvcConfigurerAdapterConfig.class
		, MailConfiguration.class
		, AsyncConfiguration.class
		, VelocityConfig.class
})
public class AppConfig {

	/** The env. */
	@Autowired
	private Environment env;
	
	/**
	 * Log util.
	 *
	 * @return the log util
	 */
	@Bean
	public LogUtil logUtil() {
		return new LogUtil();
	}
	/*
	@Bean
	public SqlViewCreator sqlViewCreator() {
		return new SqlViewCreator().init();
	}
	 */
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
	
}