package org.test.launcher;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestDC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createPassword("root1");
		createPassword("user2");
		createPassword("manager2");
	}
	
	private static void createPassword(String text) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Password: " + encoder.encode(text));
		System.out.println("-------------");
	}

}
