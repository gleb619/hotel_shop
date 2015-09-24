/*
 * 
 */
package org.test.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;


// TODO: Auto-generated Javadoc
/**
 * The Class MailConfiguration.
 */
@PropertySource("classpath:/mail.properties")
@Configuration
public class MailConfiguration {

    /** The Constant DEFAULT_HOST. */
    private static final String DEFAULT_HOST = "smtp.gmail.com";
    
    /** The Constant DEFAULT_PORT. */
    private static final Integer DEFAULT_PORT = 25;
    
    /** The Constant DEFAULT_USER. */
    private static final String DEFAULT_USER = "test.email.sender041@gmail.com";
    
    /** The Constant DEFAULT_PASSWORD. */
    private static final String DEFAULT_PASSWORD = "test.email.sender04";
    
    /** The Constant DEFAULT_PROTOCOL. */
    private static final String DEFAULT_PROTOCOL = "smtp";
    
    /** The Constant DEFAULT_TLS. */
    private static final Boolean DEFAULT_TLS = true;
    
    /** The Constant DEFAULT_AUTH. */
    private static final Boolean DEFAULT_AUTH = true;
    
    /** The Constant SMTP_AUTH. */
    private static final String SMTP_AUTH = "mail.smtp.auth";
    
    /** The Constant TLS. */
    private static final String TLS = "mail.smtp.starttls.enable";
    
    /** The Constant TRANSPORT_PROTOCOL. */
    private static final String TRANSPORT_PROTOCOL = "mail.transport.protocol";

    /** The env. */
    @Autowired
	private Environment env;

    /**
     * Java mail sender.
     *
     * @return the java mail sender impl
     */
    @Bean
    public JavaMailSenderImpl javaMailSender() {
    	JavaMailSenderImpl sender = new JavaMailSenderImpl();
    	
        String host = 		env.getProperty("mail.host") 		== null ? DEFAULT_HOST 		: env.getProperty("mail.host");
		Integer port = 		env.getProperty("mail.port") 		== null ? DEFAULT_PORT 		: new Integer(env.getProperty("mail.port"));
        String user = 		env.getProperty("mail.user") 		== null ? DEFAULT_USER 		: env.getProperty("mail.user");
        String password = 	env.getProperty("mail.password") 	== null ? DEFAULT_PASSWORD 	: env.getProperty("mail.password");
        String protocol = 	env.getProperty("mail.protocol") 	== null ? DEFAULT_PROTOCOL 	: env.getProperty("mail.protocol");
        Boolean tls = 		env.getProperty("mail.tls") 		== null ? DEFAULT_TLS 		: Boolean.valueOf(env.getProperty("mail.tls"));
        Boolean auth = 		env.getProperty("mail.auth") 		== null ? DEFAULT_AUTH 		: Boolean.valueOf(env.getProperty("mail.auth"));

        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(user);
        sender.setPassword(password);

        Properties sendProperties = new Properties();
        sendProperties.setProperty(SMTP_AUTH, auth.toString());
        sendProperties.setProperty(TLS, tls.toString());
        sendProperties.setProperty(TRANSPORT_PROTOCOL, protocol);
        sender.setJavaMailProperties(sendProperties);
        return sender;
    }
}
