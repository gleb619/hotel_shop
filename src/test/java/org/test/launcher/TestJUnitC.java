package org.test.launcher;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.test.shop.config.TestConfig;
import org.test.shop.controller.data.types.ScrollableSettings;
import org.test.shop.model.domain.entity.secure.SasUser;
import org.test.shop.model.domain.entity.secure.User;
import org.test.shop.model.domain.entity.secure.UserRole;
import org.test.shop.model.service.secure.UserService;
import org.test.shop.util.SObjectListner;
import org.test.shop.util.SObjectUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {
	TestConfig.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false) 
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true) 
@Transactional
@ActiveProfiles("Test")
public class TestJUnitC {

	@Autowired
	private UserService userService;
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private SObjectUtil sObjectListner;
	
	private String separator = "**********************************";
	
	
//	@Test
	public void testCreateUser() {
		createUser("root1", "root1", 1, "test.client.mail06@yandex.ru", "ROLE_USER", "ROLE_ADMIN", "ROLE_DEBUG");
		createUser("test",  "test",  1, "test.client.mail05@yandex.ru", "ROLE_USER");
		createUser("user1", "user1", 1, "test.client.mail05@yandex.ru", "ROLE_USER");
		createUser("user2", "user2", 2, "test.client.mail05@yandex.ru", "ROLE_GUEST");
		createUser("root2", "root2", 2, "test.client.mail06@yandex.ru", "ROLE_USER", "ROLE_ADMIN", "ROLE_DEBUG");
		createUser("root3", "root3", 3, "test.client.mail06@yandex.ru", "ROLE_USER", "ROLE_ADMIN");
		createUser("daktsin1", "daktsin1", 1, "test.client.mail07@yandex.ru", "ROLE_USER", "ROLE_ADMIN");
		createUser("daktsin2", "daktsin2", 1, "test.client.mail07@yandex.ru", "ROLE_USER", "ROLE_ADMIN");
		createUser("daktsin3", "daktsin3", 2, "test.client.mail07@yandex.ru", "ROLE_USER", "ROLE_ADMIN");
		assertNotNull(true);
	}

	private void createUser(String username, String password, Integer firmId, String email, String... roles) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = new User(username, encoder.encode(password), true);
		user.setLastName(username);
		user.setFirstName(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
		user.setEmail(email);
		
		for (String role : roles) {
			UserRole userRole = new UserRole(user, role);
			user.getUserRole().add(userRole);
			
		}
		
		user.setFirmid(firmId);
		
		try {
			userService.create(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("-------------------");
		}
	}
	
}
