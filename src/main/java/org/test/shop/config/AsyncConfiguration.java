/*
 * 
 */
package org.test.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.test.shop.config.core.async.ExceptionHandlingAsyncTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;


// TODO: Auto-generated Javadoc
/**
 * The Class AsyncConfiguration.
 */
@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConfiguration implements AsyncConfigurer {

    /* (non-Javadoc)
     * @see org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncExecutor()
     */
    @Override
    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(10000);
        executor.setThreadNamePrefix("shop-executor-0-");
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }
    /*
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		AsyncUncaughtExceptionHandler exceptionHandler = new AsyncUncaughtExceptionHandler() {
			
			@Override
			public void handleUncaughtException(Throwable arg0, Method arg1, Object... arg2) {
				
			}
		};
		
		return exceptionHandler;
	}
	*/
}
