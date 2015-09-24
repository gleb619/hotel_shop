package org.test.shop.config.listner;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
 
	private final static Integer SESSION_PERIOD = (int) TimeUnit.HOURS.toSeconds(1);
	
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(SESSION_PERIOD);
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        
    }

}
