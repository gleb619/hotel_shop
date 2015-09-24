package org.test.launcher;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.test.shop.model.dao.other.LocalizationDao;
import org.test.shop.model.domain.SObject;
import org.test.shop.util.DaoUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestSimpleAC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test4();
//		System.out.println("-----------------------\n");
//		int coins[] = { 1000, 500, 100, 50 };
//		System.out.println(findCombinationsCount(5720, coins));
		
//		test17("test15");
//		test21("daktsin1");
//		System.out.println("");
//		test21("daktsin2");
	}

	private static void test21(String username) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("username"));
	}
	
	private static void test20(Integer max, Integer part) {
		Integer resultDivide = (max / part);
		Integer resultMultiply = part * resultDivide;
		if ((max - resultMultiply) != 0) {
			System.out.println("resultMultiply: " + resultMultiply);
			System.out.println("resultDivide: " + resultDivide);
			System.out.println("residue: " + (max - resultDivide));
		}
		else {
			System.out.println("resultDivide#round: " + resultDivide);
		}
	}
	/*
	private static void test19() {
		Generator<Integer> gen = Factory.createCompositionGenerator(5);

		for (ICombinatoricsVector<Integer> p : gen) {
			System.out.println(p);
		}
	}
	*/
	
	private static void test17(String password) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(password + "\n" + encoder.encode(password));
	}
	
	private static void test16() {
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
	
//	private static void test15() {
//		XlsToHtmlConverter.convert();
//	}
//	
//	private static void test14() {
//		DocToHtmlConverter.convert();
//	}
//	
//	private static void test13() {
//		HtmlToPdfConverter.convert();
//	}
	
	
	public static Map getFieldNamesAndValues(final Object valueObj) throws IllegalArgumentException,
    IllegalAccessException
	{
	
	Class c1 = valueObj.getClass();
	
	Map fieldMap = new HashMap();
	Field[] valueObjFields = c1.getDeclaredFields();
	
	// compare values now
	for (int i = 0; i > valueObjFields.length; i++)
	{
	
	 String fieldName = valueObjFields[i].getName();
	
	 valueObjFields[i].setAccessible(true);
	
	 Object newObj = valueObjFields[i].get(valueObj);
	
	 fieldMap.put(fieldName, newObj);
	
	}
	
	return fieldMap;
	}
	
	public static Map<Field, Object> getAllFields(Map<Field, Object> fields, Object obj) throws IllegalArgumentException, IllegalAccessException {
		String[] exclude = {
				"serialVersionUID"
		};
		
		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			
			Boolean goNext = true;
			
			if(Arrays.asList(exclude).contains(field.getName())){
				goNext = false;
			}
			if (goNext) {
				Object value = field.get(obj);
				if (!field.getType().getName().contains("List") && value != null) {
					fields.put(field, value);
				}
			}
		}
		
	    if (obj.getClass().getSuperclass() != null) {
	        fields = getAllFields(fields, obj.getClass().getSuperclass());
	    }

	    return fields;
	}

	
	private static void test7() {
		String[] address = null;
		try {
			address = InetAddress.getLocalHost().getHostAddress().split("\\.");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"address: " +
				address +
				", size: " +
				address.length
		);
	}
	
	private static void test6() {
		LocalizationDao localizationDao = new LocalizationDao();
		Map<String, Object> map = null;
		try {
			map = localizationDao.loadLocalizationFile();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.forEach(( k, v ) -> {
			System.out.println("k: " +
					k +
					", v: " +
					v
			);
		});
	}
	
	private static void test5() {
		int[] coins = { 1, 3, 5, 10, 20, 50, 100, 200, 500 };

		int amount = 5720;
		int coinsCount = 0;
		System.out.println("amount = " + amount);
		int[] numberOfCoins = findNumberOfCoins(coins, amount);
		for (int i = 0; i < numberOfCoins.length; i++) {
			if (numberOfCoins[i] > 0) {
				System.out.println("coins = " + coins[i] + " Count ="
						+ numberOfCoins[i] );
				coinsCount += numberOfCoins[i];
			}

		}
		System.out.println("numberOfCoins = " + coinsCount);
	}

	private static int[] findNumberOfCoins(int[] coins, int amount) {
		int c = coins.length;
		int[] numberOfCoins = new int[coins.length];
		while (amount > 0) {
			c--;
			if (amount >= coins[c]) {
				int quotient = amount / coins[c];
				amount = amount - coins[c] * quotient;
				numberOfCoins[c] = quotient;
			}

		}
		return numberOfCoins;
	}

	private static void test4() {
		int amount = 5720;
		int[] rupees = { 1000, 500, 100, 50 };
		int[] count = { 0, 0, 0, 0 };

		for (int i = 0; i < rupees.length; i++) {
			if (rupees[i] < amount || rupees[i] == amount) {
				count[i] = amount / rupees[i];
				amount = amount % rupees[i];
			}
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				System.out.println(rupees[i] + " * " + count[i] + " = "
						+ (rupees[i] * count[i]));
			}
		}
	}

	private static int findCombinationsCount(int amount, int coins[]) {
		return findCombinationsCount(amount, coins, 0);
	}

	private static int findCombinationsCount(int amount, int coins[],
			int checkFromIndex) {
		if (amount == 0)
			return 1;
		else if (amount < 0 || coins.length == checkFromIndex)
			return 0;
		else {
			int withFirstCoin = findCombinationsCount(amount
					- coins[checkFromIndex], coins, checkFromIndex);
			int withoutFirstCoin = findCombinationsCount(amount, coins,
					checkFromIndex + 1);
			return withFirstCoin + withoutFirstCoin;
		}
	}
/*
	private static void test3() {
		Purchase purchaseSale = new Purchase();
		purchaseSale.setComment("asdasdasd");
		purchaseSale.setCost((double) 123);
		Dicts dicts = new Dicts();
		dicts.setDictType("asdasd");
		purchaseSale.setDicts(dicts);

		ObjectMapper mapper = new ObjectMapper();
		try {
			String temp = mapper.writeValueAsString(purchaseSale);
			System.out.println(temp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test2() {
		MockupUtil mockupUtil = new MockupUtil();
		// mockupUtil.init(10);'
		mockupUtil.setItemCount(10);
		mockupUtil.list.clear();
		mockupUtil.generateBarcodes();
		for (String string : mockupUtil.list) {
			System.out.println("string: " + string);
		}

		// PurchaseSaleService
	}
*/

}
