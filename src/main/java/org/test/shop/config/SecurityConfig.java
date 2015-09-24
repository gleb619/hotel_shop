/*
 * 
 */
package org.test.shop.config;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.test.shop.config.debug.Settings;
import org.test.shop.model.domain.entity.TmUserInfo;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.service.TmUserInfoService;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfig.
 */
@Configuration
//@EnableWebMvcSecurity
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** The debug. */
	private Boolean debug = Settings.SECURITY_CONFIG.getValue();
	
	/** The user details service. */
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	/** The data source. */
	@Autowired
	private DataSource dataSource;
	
	/** The user info service. */
	@Autowired
	private TmUserInfoService userInfoService;

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if (debug) {
			http
				.authorizeRequests()
				.antMatchers("/**")
				.permitAll()
				.anyRequest().authenticated();
		}
		else {
			http
//				.sessionManagement()
//					.sessionFixation()
//						.migrateSession()
//					.enableSessionUrlRewriting(true)
//						.maximumSessions(5)
//						.maxSessionsPreventsLogin(true)
//						.sessionRegistry(sessionRegistry())
//						.expiredUrl("/login?logout") 
//					.and().invalidSessionUrl("/login?error")
//				.and()
					.authorizeRequests()
//						.antMatchers("/resources/**", "/login")
//						.permitAll()
//						.antMatchers("/d/**")
//						.access("hasRole('ROLE_USER')")
//						.antMatchers("/data/**")
//						.access("hasRole('ROLE_USER')")
//						.antMatchers("/admin/**")
//						.access("hasRole('ROLE_ADMIN')")
						.antMatchers("/**")
						.permitAll()
//						.access("isAuthenticated()")
					.anyRequest().authenticated();
		}
		
		http
			.formLogin()
			.defaultSuccessUrl("/d/index3", false)
			.loginPage("/login")
			.failureUrl("/login?error")
//			.failureHandler(failureLogin())
//			.successHandler(successLogin())
			.and().logout()
			.logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID")
			.and().exceptionHandling().accessDeniedPage("/403")
			.and()
//			.rememberMe().key("secret").tokenValiditySeconds(1209600).and()
			.rememberMe().disable()
			.csrf().disable()
		    .headers()
			.frameOptions() 
			    .disable();
			;

	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	/**
	 * Configure global.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
//		auth.inMemoryAuthentication().withUser("root").password("root").roles("USER", "ADMIN");
//		auth.inMemoryAuthentication().withUser("test").password("test").roles("USER");
//		auth.inMemoryAuthentication().withUser("user1").password("user1").roles("USER");
//		auth.inMemoryAuthentication().withUser("user2").password("user2").roles("USER");
		auth.userDetailsService(userDetailsService).passwordEncoder( passwordEncoder());
	}

	/**
	 * Password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
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
	
	/*
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		jdbcTokenRepositoryImpl.setDataSource(dataSource);

		return jdbcTokenRepositoryImpl;
	}
	*/
	
	public AuthenticationFailureHandler failureLogin(){
		AuthenticationFailureHandler handler = new AuthenticationFailureHandler() {
			
			@Override
			public void onAuthenticationFailure(HttpServletRequest arg0,
					HttpServletResponse arg1, AuthenticationException arg2)
					throws IOException, ServletException {
				
				System.out.println("SecurityConfig.failureLogin()#httpservletrequest\n"
						+ ReflectionToStringBuilder.toString(arg0, ToStringStyle.SIMPLE_STYLE)
						+ "\n----------------"
						+ "\ngetQueryString: " + arg0.getQueryString()
						+ "\ngetRequestURI: " + arg0.getRequestURI()
						+ "\ngetServletPath: " + arg0.getServletPath()
						+ "\ngetRequestURL: " + arg0.getRequestURL()
						+ "\n\n"
				);
				
				 arg1.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		         arg1.sendRedirect("login");  
				
			}
		}; 
		
		return handler;
	}
	
	/**
	 * Success login.
	 *
	 * @return the authentication success handler
	 */
	public AuthenticationSuccessHandler successLogin() {
		AuthenticationSuccessHandler handler = new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2) throws IOException, ServletException {
				
				System.out.println("SecurityConfig.successLogin().new AuthenticationSuccessHandler() {...}.onAuthenticationSuccess()#arg2: " + arg2);
				
				Thread userInfo = new Thread(() -> {
					try {
						userInfo(arg0, arg2);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				
				if (!debug) {
//					userInfo.start();
				}
				
	            arg1.setStatus(HttpServletResponse.SC_OK);
	            arg1.sendRedirect(readLandingPage(arg2));  
			}
			
			private String readLandingPage(Authentication arg2) {
				SasUser sasUser = (SasUser) arg2.getPrincipal();
				String landingPage = sasUser.getUser().getLandingPage();
				if (landingPage == null || landingPage.length() == 0) {
					landingPage = "d/index3";
				}
				
				return landingPage;
			}
			
			@Async
			private void userInfo(HttpServletRequest arg0, Authentication arg2) throws Exception {
				if (arg0 == null || arg2 == null) {
					return;
				}
				
				SasUser sasUser = (SasUser) arg2.getPrincipal();
				TmUserInfo info = new TmUserInfo();
				
				String proxyContent = arg0.getHeader("x-forwarded-for"); 
				String[] browserinfo = {
						 "Chrome"
						, "1"
						, "Windows"
				};
				try {
					browserinfo = readBrowserInfo(arg0.getHeader("user-agent"));
				} catch (Exception e1) {
					String headers = "";
					for (String header : Collections.list(arg0.getHeaderNames())) {
						headers += header + "\n";
					}
					System.err.println("headers: " + headers);
					System.err.println("--------------------------");
					System.err.println("Error while read browser info:\n\t" + arg0.getHeader("user-agent"));
					System.err.println("--------------------------");
					e1.printStackTrace();
				}

				info.setFirmid(sasUser.getUser().getFirmid());
				info.setBrowser(browserinfo[0]);
				info.setBrowserVersion(browserinfo[1]);
				info.setUserAgent(arg0.getHeader("user-agent"));
				info.setLastLogin(new Date());
				info.setUserIpAddress(arg0.getRemoteAddr());
				info.setRemoteHost(arg0.getRemoteHost());
				info.setProxyContent(proxyContent);
				info.setUsername(sasUser.getUsername());
				info.setPlatform(browserinfo[2]);
				
				try {
					userInfoService.create(info);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		return handler;
	}
	
	/**
	 * Read browser info.
	 *
	 * @param information the information
	 * @return the string[]
	 * @throws Exception the exception
	 */
	private String[] readBrowserInfo(String information) throws Exception {
		String os = "";
		String browsername = "";
		String browserversion = "";
		String browser = information;
		String[] result = { 
				  "Chrome"
				, "1"
				, "Windows"
		}; 
		
		if (browser.toLowerCase().indexOf("windows") >= 0) {
			os = "Windows";
		} else if (browser.toLowerCase().indexOf("mac") >= 0) {
			os = "Mac";
		} else if (browser.toLowerCase().indexOf("x11") >= 0) {
			os = "Unix";
		} else if (browser.toLowerCase().indexOf("android") >= 0) {
			os = "Android";
		} else if (browser.toLowerCase().indexOf("iphone") >= 0) {
			os = "IPhone";
		} else {
			os = "UnKnown, More-Info: " + browser;
		}
		
		if (browser.contains("MSIE")) {
			String subsString = browser.substring(browser.indexOf("MSIE"));
			String info[] = (subsString.split(";")[0]).split(" ");
			browsername = info[0];
			browserversion = info[1];
		} else if (browser.contains("Firefox")) {

			String subsString = browser.substring(browser.indexOf("Firefox"));
			String info[] = (subsString.split(" ")[0]).split("/");
			browsername = info[0];
			browserversion = info[1];
		} else if (browser.contains("Chrome")) {

			String subsString = browser.substring(browser.indexOf("Chrome"));
			String info[] = (subsString.split(" ")[0]).split("/");
			browsername = info[0];
			browserversion = info[1];
		} else if (browser.contains("Opera")) {

			String subsString = browser.substring(browser.indexOf("Opera"));
			String info[] = (subsString.split(" ")[0]).split("/");
			browsername = info[0];
			browserversion = info[1];
		} else if (browser.contains("Safari")) {

			String subsString = browser.substring(browser.indexOf("Safari"));
			String info[] = (subsString.split(" ")[0]).split("/");
			browsername = info[0];
			browserversion = info[1];
		}
		
//		String[] asd = {};
		result[0] = browsername;
		result[1] = browserversion;
		result[2] = os;
		
		return result;
	}
	
}