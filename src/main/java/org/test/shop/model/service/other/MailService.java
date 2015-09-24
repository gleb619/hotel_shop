/*
 * 
 */
package org.test.shop.model.service.other;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.CharEncoding;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.test.shop.model.domain.entity.Users;
import org.test.shop.model.service.data.types.MailSetting;

@Service
public class MailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private MessageSource messageSource;
    @Autowired
	private VelocityEngine engine;
    
    @Async
    public void sendActivationEmail(Users users) {
    	try {
    		MailSetting mailSetting = new MailSetting();
    		Map<String, Object> model = new HashMap<String, Object>();
    		
    		model.put("greeting", messageSource.getMessage("default.email.greeting", null, LocaleContextHolder.getLocale()));
    		model.put("mainmessage", messageSource.getMessage("default.email.mainmessage", null, LocaleContextHolder.getLocale()));
    		model.put("signature", messageSource.getMessage("default.email.signature", null, LocaleContextHolder.getLocale()));
    		model.put("title", messageSource.getMessage("default.email.title", null, LocaleContextHolder.getLocale()));
    		model.put("activationlink", messageSource.getMessage("default.email.activationlink", null, LocaleContextHolder.getLocale()));
    		
    		model.put("url", "http://178.88.186.230:8080/shop-rcr-server");
    		model.put("activationkey", users.getActivationkey());
    		
    		System.out.println("MailService.sendActivationEmail#"
    				+ "\n\t Email: " + users.getEmail()
    				+ "\n\t From: " + javaMailSender.getUsername()
    				+ "\n\t locale: " + LocaleContextHolder.getLocale()
    				+ "\n\t title: " + messageSource.getMessage("default.email.title", null, LocaleContextHolder.getLocale())
    		);
    		
    		mailSetting.setTo(users.getEmail());
    		mailSetting.setFrom(javaMailSender.getUsername());
    		mailSetting.setSubject(messageSource.getMessage("default.email.title", null, LocaleContextHolder.getLocale()));
    		mailSetting.setContent(VelocityEngineUtils.mergeTemplateIntoString(this.engine,"email.activation.vm", "UTF-8", model));
    		mailSetting.setIsHtml(true);
    		mailSetting.setIsMultipart(true);
    		
			sendEmail(mailSetting);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /*
    @Async
    public void sendReqServHotel(ReqServHotel reqServHotel, MailSetting mailSetting) {
    	System.out.println("MailService.sendReqServHotel()");
//    	Map<String, File> files = ConverterUtil.convert(reqServHotel);
    	Map<String, File> files = new HashMap<String, File>();
    	
    	for (DocDocuments docDocuments : mailSetting.getDocDocuments()) {
    		files.putAll(ConverterUtil.convertReqServHotelConverter(docDocuments, reqServHotel));
		}
    	
    	try {
			sendEmail(mailSetting.getTo(), mailSetting.getFrom(), reqServHotel.getLabel(), reqServHotel.getDescr(), true, true, files);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    */
    @Async
    public void sendEmail(MailSetting mailSetting) throws Exception {
    	sendEmail(mailSetting.getTo(), mailSetting.getFrom(), mailSetting.getSubject(), mailSetting.getContent(), mailSetting.getIsMultipart(), mailSetting.getIsHtml(), mailSetting.getFiles());
    }
    
    @Async
    public void sendEmail(String to, String from, String subject, String content, boolean isMultipart, boolean isHtml, Map<String, File> files) throws Exception {
    	System.out.println("MailService.sendEmail()");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
            message.setTo(to);
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(content, isHtml);
            
            if (files != null && files.size() > 0) {
            	for (String key : files.keySet()) {
					FileSystemResource file = new FileSystemResource(files.get(key));
					message.addAttachment(key, file);
				}
			}
            
            System.out.println("MailService.sendEmail()#send");
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
