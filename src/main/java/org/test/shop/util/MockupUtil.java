package org.test.shop.util;

import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.test.shop.model.domain.SDict;
import org.test.shop.model.domain.SEntity;
import org.test.shop.model.domain.SObject;
import org.test.shop.model.domain.SRequest;
import org.test.shop.model.domain.entity.*;
import org.test.shop.model.service.*;
import org.test.shop.util.data.types.FilesSettings;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class MockupUtil {

	private Map<String, List<?>> listStorage = new LinkedHashMap<String, List<?>>();
	private String defaultDocumentsPath = "D:/TEST_DOCUMENTS";
	private String defaultImagePath = "D:/HOTELS_IMAGE";
	private Map<Class<?>, String> staticListConfig = new HashMap<Class<?>, String>();
	private Map<Class<?>, List<String>> staticList = new HashMap<Class<?>, List<String>>();
	private List<Path> documents = new LinkedList<Path>();
	private List<Path> images = new LinkedList<Path>(); 
	private String output = "";
	private int itemCount = 10;
	public Integer firmid = 1;
	private Boolean traceFlag = true;
	private Boolean sync = true;
	private String serieskey = UUID.randomUUID().toString();

	@Autowired
	private UsersService _usersService;
	@Autowired
	private FilesSettings imageSettings;
	@Autowired
	private MessageSource messageSource;

	public MockupUtil() {
		super();
		
		
		Thread staticListThread = new Thread(() -> {
			staticListConfig.forEach((key, value) -> {
				try {
					staticList.put(key, readStaticList(value));
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});
		
		staticListThread.start();
		
		Thread thread = new Thread(() -> {
			try {
				images = getFileList(defaultImagePath);
			} catch (IOException e) {
				System.err.println("Cannot find: " + defaultImagePath + ", error: " + e.getLocalizedMessage());
			}
			
			try {
				documents = getFileList(defaultDocumentsPath);
			} catch (IOException e) {
				System.err.println("Cannot find: " + defaultDocumentsPath + ", error: " + e.getLocalizedMessage());
			}
		});
		
		thread.start();
	}

	private List<Path> getFileList(String path) throws IOException {
		List<Path> list = new LinkedList<Path>();
		
		Files.walk(Paths.get(path)).forEach(filePath -> {
		    if (Files.isRegularFile(filePath)) {
		        list.add(filePath);
		    }
		});
		
		return list;
	}

	private List<String> readStaticList(String path) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
		return new ArrayList(Arrays.asList(content.split("\n")));
	}

	private Date randomDate() {
		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(1900, 2010);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return gc.getTime();
	}
	
	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	public BigDecimal randBetweenDecimal (Integer start, Integer end) {
		return new BigDecimal(start + (int) Math.round(Math.random() * (end - start))); 
	}
	
	public Boolean randomBoolean() {
		if ((randBetween(1, 100) % 2) == 0) {
			return true;
		}
		else{
			return false;
		}
	}

	private synchronized String randomStringStaticValue(Class<?> clazz) {
		if(staticList.containsKey(clazz)){
			String element = readRandom(staticList.get(clazz));
			if (element != null) {
				staticList.get(clazz).remove(element);
				return element;
			}
			else {
				if (randomBoolean()) {
					return new Faker().name().lastName() + new Faker().address().cityPrefix();
				}
				
				return new Faker().lorem().fixedString(randBetween(10, 30));
			}
		}
		
		return new Faker().lorem().fixedString(randBetween(10, 30));
	}
	
	private synchronized <T> T readRandom(List<T> list) {
		if (list.size() > 0) {
			return (T) list.get(randBetween(0, list.size() - 1));
		}
		
		return null;
	}

	private synchronized List checkListStorage(String arg0) {
		if(listStorage.containsKey(arg0)){
			List<?> result = new LinkedList<>();
			result = listStorage.get(arg0);
			listStorage.remove(arg0);
			return result;
		}
		
		return new LinkedList<>();
	}

	private synchronized List addListStorage(String arg0, List arg1) {
		listStorage.put(arg0, arg1);
		return arg1;
	}

	private <T> T postCheck(T object, Faker faker) {
		
		
		return (T) object;
	}
	
	public String randomCurrCurrency(){
		return "";
	}
	
	public String randomCityName(Faker faker){
		String cityName = "";
		if (randomBoolean()) {
			cityName = faker.address().cityPrefix();
		}
		
		if (randomBoolean()) {
			cityName += faker.address().firstName();
		}
		else {
			cityName += faker.address().lastName();
		}
		
		if (randomBoolean()) {
			cityName += faker.address().citySuffix();
		}
		
		return cityName;
	}

	public Object checkForSentity(Object arg, Faker faker) {
		if (arg instanceof SObject) {
			((SObject) arg).setCreateon(randomDate());	
			((SObject) arg).setFirmid(firmid);	
			((SObject) arg).setModifyon(randomDate());	
			((SObject) arg).setSerieskey(serieskey);
		}
		
		if (arg instanceof SEntity) {
			((SEntity) arg).setLabel(faker.lorem().fixedString(randBetween(10, 30)));
		}
		
		if (arg instanceof SRequest) {
			((SRequest) arg).setLabel(faker.lorem().fixedString(randBetween(10, 30)));
		}
		
		if (arg instanceof SDict) {
			((SDict) arg).setLabel(faker.lorem().fixedString(randBetween(10, 30)));
		}
		
		
		return arg;
	}

	public int getItemCount() {
		return itemCount;
	}
	
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	public synchronized String getOutput() {
		return output;
	}

	public synchronized void setOutput(String output) {
		this.output = getOutput() + output;
	}

	public void reset() {

		CurrCourseFlag = false;
		CurrCurrencyFlag = false;
		DictGlobalFlag = false;
		DocDocumentsFlag = false;
		InfoContactInformationFlag = false;
		InfoPermissionFlag = false;
		LocationAddressFlag = false;
		LocationCitiesFlag = false;
		LocationCountriesFlag = false;
		PaymentDetailsFlag = false;
		PaymentPriceFlag = false;
		PaymentPriceShopFlag = false;
		PaymentTariffFlag = false;
		PaymentTariffShopFlag = false;
		RelMailNewsletterGroupFlag = false;
		RelServHotelDocDocumentsFlag = false;
		RelServHotelImageFlag = false;
		RelServHotelRoomImageFlag = false;
		RelServTransferTmContactFlag = false;
		RelShopPermissionFlag = false;
		RelUserDetailsFlag = false;
		ReqServHotelFlag = false;
		ServHotelFlag = false;
		ServHotelRoomFlag = false;
		ServTransferFlag = false;
		ServTransferRouteFlag = false;
		ServTransferRoutePointFlag = false;
		ShopPermissionFlag = false;
		ShopUserFlag = false;
		TmAccountFlag = false;
		TmContactFlag = false;
		TmContactEasyFlag = false;
		TmFirmsFlag = false;
		TmFirmSettingsFlag = false;
		TmImageFlag = false;
		TmMailNewsletterFlag = false;
		TmMailNewsletterGroupFlag = false;
		TmUserInfoFlag = false;
		UserDetailFlag = false;

	}

	private Boolean CurrCourseFlag = false;
	private Boolean CurrCurrencyFlag = false;
	private Boolean DictGlobalFlag = false;
	private Boolean DocDocumentsFlag = false;
	private Boolean InfoContactInformationFlag = false;
	private Boolean InfoPermissionFlag = false;
	private Boolean LocationAddressFlag = false;
	private Boolean LocationCitiesFlag = false;
	private Boolean LocationCountriesFlag = false;
	private Boolean PaymentDetailsFlag = false;
	private Boolean PaymentPriceFlag = false;
	private Boolean PaymentPriceShopFlag = false;
	private Boolean PaymentTariffFlag = false;
	private Boolean PaymentTariffShopFlag = false;
	private Boolean RelMailNewsletterGroupFlag = false;
	private Boolean RelServHotelDocDocumentsFlag = false;
	private Boolean RelServHotelImageFlag = false;
	private Boolean RelServHotelRoomImageFlag = false;
	private Boolean RelServTransferTmContactFlag = false;
	private Boolean RelShopPermissionFlag = false;
	private Boolean RelUserDetailsFlag = false;
	private Boolean ReqServHotelFlag = false;
	private Boolean ServHotelFlag = false;
	private Boolean ServHotelRoomFlag = false;
	private Boolean ServTransferFlag = false;
	private Boolean ServTransferRouteFlag = false;
	private Boolean ServTransferRoutePointFlag = false;
	private Boolean ShopPermissionFlag = false;
	private Boolean ShopUserFlag = false;
	private Boolean TmAccountFlag = false;
	private Boolean TmContactFlag = false;
	private Boolean TmContactEasyFlag = false;
	private Boolean TmFirmsFlag = false;
	private Boolean TmFirmSettingsFlag = false;
	private Boolean TmImageFlag = false;
	private Boolean TmMailNewsletterFlag = false;
	private Boolean TmMailNewsletterGroupFlag = false;
	private Boolean TmUserInfoFlag = false;
	private Boolean UserDetailFlag = false;

	@Autowired
	private CurrCourseService currcourseService;

	public String mockupForCurrCourse() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForCurrCourse()");
		}
	
		if(CurrCourseFlag){
			return ", { \"text\":\"Data for CurrCourse already generated\" }";
		}
		Faker faker = new Faker();
			try {
				CurrCourse currcourse = new CurrCourse();
				checkForSentity(currcourse, faker);
	
			currcourse.setCourse(randBetween(1, itemCount));	
			currcourse.setCurrencyid(randBetween(1, itemCount));	
			currcourse.setDatecourse(randomDate());
	
				currcourseService.create(postCheck(currcourse, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating CurrCourse: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		CurrCourseFlag = true;
	
		return ", { \"text\":\"Generation data for CurrCourse is done\" }";
	}

	@Autowired
	private CurrCurrencyService currcurrencyService;

	public String mockupForCurrCurrency() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForCurrCurrency()");
		}
	
		if(CurrCurrencyFlag){
			return ", { \"text\":\"Data for CurrCurrency already generated\" }";
		}
		Faker faker = new Faker();
			try {
				CurrCurrency currcurrency = new CurrCurrency();
				checkForSentity(currcurrency, faker);
	
			currcurrency.setCourse(randBetween(1, itemCount));	
			currcurrency.setCurrencyname(faker.lorem().fixedString(randBetween(10, 30)));	
			currcurrency.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			currcurrency.setIsbase(randomBoolean());	
			currcurrency.setIsoCode(faker.lorem().fixedString(randBetween(10, 30)));	
			currcurrency.setNameeng(faker.lorem().fixedString(randBetween(10, 30)));	
			currcurrency.setNameru(faker.lorem().fixedString(randBetween(10, 30)));
	
				currcurrencyService.create(postCheck(currcurrency, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating CurrCurrency: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		CurrCurrencyFlag = true;
	
		return ", { \"text\":\"Generation data for CurrCurrency is done\" }";
	}

	@Autowired
	private DictGlobalService dictglobalService;

	public String mockupForDictGlobal() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForDictGlobal()");
		}
	
		if(DictGlobalFlag){
			return ", { \"text\":\"Data for DictGlobal already generated\" }";
		}
		Faker faker = new Faker();
			try {
				DictGlobal dictglobal = new DictGlobal();
				checkForSentity(dictglobal, faker);
	
			dictglobal.setDictType(faker.lorem().fixedString(randBetween(10, 30)));	
			dictglobal.setDictValue(faker.lorem().fixedString(randBetween(10, 30)));	
			dictglobal.setDictValueAdditional(faker.lorem().fixedString(randBetween(10, 30)));
	
				dictglobalService.create(postCheck(dictglobal, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating DictGlobal: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		DictGlobalFlag = true;
	
		return ", { \"text\":\"Generation data for DictGlobal is done\" }";
	}

	@Autowired
	private DocDocumentsService docdocumentsService;

	public String mockupForDocDocuments() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForDocDocuments()");
		}
	
		if(DocDocumentsFlag){
			return ", { \"text\":\"Data for DocDocuments already generated\" }";
		}
		Faker faker = new Faker();
			try {
				DocDocuments docdocuments = new DocDocuments();
				checkForSentity(docdocuments, faker);
				
				if (randomBoolean()) {
					Path path = documents.get(randBetween(0, documents.size() - 1));
					File file = new File(path.toUri());
			
					docdocuments.setContenttype(Files.probeContentType(path));
					docdocuments.setOriginalfilename(file.getName());
					docdocuments.setExtension(FilenameUtils.getExtension(file.getName()));
					docdocuments.setSize(new Long(file.length()).toString());
					docdocuments.setLabel(UUID.randomUUID().toString() + "." + docdocuments.getExtension());
					docdocuments.setPath(imageSettings.getDocumentsDefaultPath() + "/" + docdocuments.getLabel());	
					Files.write(Paths.get(docdocuments.getPath()), IOUtils.toByteArray(new FileInputStream(file)));
				}
				else {
					docdocuments.setLabel(faker.lorem().fixedString(randBetween(10, 30)));
					docdocuments.setPath(faker.lorem().fixedString(randBetween(10, 30)));	
					docdocuments.setContenttype(faker.lorem().fixedString(randBetween(10, 30)));	
					docdocuments.setExtension(faker.lorem().fixedString(randBetween(10, 30)));	
					docdocuments.setOriginalfilename(faker.lorem().fixedString(randBetween(10, 30)));	
					docdocuments.setSize(faker.lorem().fixedString(randBetween(10, 30)));	
				}
	
				docdocumentsService.create(docdocuments);
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating DocDocuments: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		DocDocumentsFlag = true;
	
		return ", { \"text\":\"Generation data for DocDocuments is done\" }";
	}

	@Autowired
	private InfoContactInformationService infocontactinformationService;

	public String mockupForInfoContactInformation() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForInfoContactInformation()");
		}
	
		if(InfoContactInformationFlag){
			return ", { \"text\":\"Data for InfoContactInformation already generated\" }";
		}
		Faker faker = new Faker();
			try {
				InfoContactInformation infocontactinformation = new InfoContactInformation();
				checkForSentity(infocontactinformation, faker);
	
			infocontactinformation.setContact(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setEmail(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setEmail2(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setEmail3(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setPhone(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setPhone2(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setPhone3(faker.lorem().fixedString(randBetween(10, 30)));	
			infocontactinformation.setWebsite(faker.lorem().fixedString(randBetween(10, 30)));
	
				infocontactinformationService.create(postCheck(infocontactinformation, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating InfoContactInformation: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		InfoContactInformationFlag = true;
	
		return ", { \"text\":\"Generation data for InfoContactInformation is done\" }";
	}

	@Autowired
	private InfoPermissionService infopermissionService;

	public String mockupForInfoPermission() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForInfoPermission()");
		}
	
		if(InfoPermissionFlag){
			return ", { \"text\":\"Data for InfoPermission already generated\" }";
		}
		Faker faker = new Faker();
			try {
				InfoPermission infopermission = new InfoPermission();
				checkForSentity(infopermission, faker);
	
			//DocDocuments mockup start
			List<DocDocuments> list1915170016_2388 = checkListStorage("DocDocuments");
			DocDocuments docdocuments = null;
			if(list1915170016_2388.size() == 0){
				mockupForDocDocuments();
				list1915170016_2388 = addListStorage("DocDocuments", docdocumentsService.findAll());
			}
			if(list1915170016_2388.size() > 0){
				docdocuments = list1915170016_2388.get(randBetween(0, list1915170016_2388.size() - 1));
			}
			//DocDocuments mockup end

			infopermission.setDocDocuments(docdocuments);	
			infopermission.setDescr(faker.lorem().fixedString(randBetween(10, 30)));
	
				infopermissionService.create(postCheck(infopermission, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating InfoPermission: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		InfoPermissionFlag = true;
	
		return ", { \"text\":\"Generation data for InfoPermission is done\" }";
	}

	@Autowired
	private LocationAddressService locationaddressService;

	public String mockupForLocationAddress() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForLocationAddress()");
		}
	
		if(LocationAddressFlag){
			return ", { \"text\":\"Data for LocationAddress already generated\" }";
		}
		Faker faker = new Faker();
			try {
				LocationAddress locationaddress = new LocationAddress();
				checkForSentity(locationaddress, faker);
	
			locationaddress.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			locationaddress.setName(faker.lorem().fixedString(randBetween(10, 30)));	
			locationaddress.setYandexMapPointX(faker.lorem().fixedString(randBetween(10, 30)));	
			locationaddress.setYandexMapPointY(faker.lorem().fixedString(randBetween(10, 30)));
	
				locationaddressService.create(postCheck(locationaddress, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating LocationAddress: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		LocationAddressFlag = true;
	
		return ", { \"text\":\"Generation data for LocationAddress is done\" }";
	}

	@Autowired
	private LocationCitiesService locationcitiesService;

	public String mockupForLocationCities() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForLocationCities()");
		}
	
		if(LocationCitiesFlag){
			return ", { \"text\":\"Data for LocationCities already generated\" }";
		}
		Faker faker = new Faker();
			try {
				LocationCities locationcities = new LocationCities();
				checkForSentity(locationcities, faker);
	
			//LocationCountries mockup start
			List<LocationCountries> list735144448_5818 = checkListStorage("LocationCountries");
			LocationCountries locationcountries = null;
			if(list735144448_5818.size() == 0){
				mockupForLocationCountries();
				list735144448_5818 = addListStorage("LocationCountries", locationcountriesService.findAll());
			}
			if(list735144448_5818.size() > 0){
				locationcountries = list735144448_5818.get(randBetween(0, list735144448_5818.size() - 1));
			}
			//LocationCountries mockup end

			locationcities.setLocationCountries(locationcountries);	
			locationcities.setCityname(faker.lorem().fixedString(randBetween(10, 30)));	
			locationcities.setDescr(faker.lorem().fixedString(randBetween(10, 30)));
	
				locationcitiesService.create(postCheck(locationcities, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating LocationCities: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		LocationCitiesFlag = true;
	
		return ", { \"text\":\"Generation data for LocationCities is done\" }";
	}

	@Autowired
	private LocationCountriesService locationcountriesService;

	public String mockupForLocationCountries() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForLocationCountries()");
		}
	
		if(LocationCountriesFlag){
			return ", { \"text\":\"Data for LocationCountries already generated\" }";
		}
		Faker faker = new Faker();
			try {
				LocationCountries locationcountries = new LocationCountries();
				checkForSentity(locationcountries, faker);
	
			locationcountries.setCountryname(faker.lorem().fixedString(randBetween(10, 30)));	
			locationcountries.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			locationcountries.setIsoCode(faker.lorem().fixedString(randBetween(10, 30)));	
			locationcountries.setNameeng(faker.lorem().fixedString(randBetween(10, 30)));
	
				locationcountriesService.create(postCheck(locationcountries, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating LocationCountries: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		LocationCountriesFlag = true;
	
		return ", { \"text\":\"Generation data for LocationCountries is done\" }";
	}

	@Autowired
	private PaymentDetailsService paymentdetailsService;

	public String mockupForPaymentDetails() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForPaymentDetails()");
		}
	
		if(PaymentDetailsFlag){
			return ", { \"text\":\"Data for PaymentDetails already generated\" }";
		}
		Faker faker = new Faker();
			try {
				PaymentDetails paymentdetails = new PaymentDetails();
				checkForSentity(paymentdetails, faker);
	
			paymentdetails.setBankLocation(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setBin(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setCorrespondentAccount(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setCurrentAccount(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setFullName(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setIin(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setLegalAddress(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setNameOfTheBank(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setNceo(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setPhone(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setPhone2(faker.lorem().fixedString(randBetween(10, 30)));	
			paymentdetails.setPostalAddress(faker.lorem().fixedString(randBetween(10, 30)));
	
				paymentdetailsService.create(postCheck(paymentdetails, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating PaymentDetails: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		PaymentDetailsFlag = true;
	
		return ", { \"text\":\"Generation data for PaymentDetails is done\" }";
	}

	@Autowired
	private PaymentPriceService paymentpriceService;

	public String mockupForPaymentPrice() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForPaymentPrice()");
		}
	
		if(PaymentPriceFlag){
			return ", { \"text\":\"Data for PaymentPrice already generated\" }";
		}
		Faker faker = new Faker();
			try {
				PaymentPrice paymentprice = new PaymentPrice();
				checkForSentity(paymentprice, faker);
	
			//PaymentTariff mockup start
			List<PaymentTariff> list1498215520_9741 = checkListStorage("PaymentTariff");
			PaymentTariff paymenttariff = null;
			if(list1498215520_9741.size() == 0){
				mockupForPaymentTariff();
				list1498215520_9741 = addListStorage("PaymentTariff", paymenttariffService.findAll());
			}
			if(list1498215520_9741.size() > 0){
				paymenttariff = list1498215520_9741.get(randBetween(0, list1498215520_9741.size() - 1));
			}
			//PaymentTariff mockup end

			paymentprice.setPaymentTariff(paymenttariff);	
			paymentprice.setHumannumber(randBetween(1, itemCount));	
			paymentprice.setPrice(randBetweenDecimal(2000, 15000));
	
				paymentpriceService.create(postCheck(paymentprice, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating PaymentPrice: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		PaymentPriceFlag = true;
	
		return ", { \"text\":\"Generation data for PaymentPrice is done\" }";
	}

	@Autowired
	private PaymentPriceShopService paymentpriceshopService;

	public String mockupForPaymentPriceShop() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForPaymentPriceShop()");
		}
	
		if(PaymentPriceShopFlag){
			return ", { \"text\":\"Data for PaymentPriceShop already generated\" }";
		}
		Faker faker = new Faker();
			try {
				PaymentPriceShop paymentpriceshop = new PaymentPriceShop();
				checkForSentity(paymentpriceshop, faker);
	
			//PaymentTariffShop mockup start
			List<PaymentTariffShop> list_1210066912_1506 = checkListStorage("PaymentTariffShop");
			PaymentTariffShop paymenttariffshop = null;
			if(list_1210066912_1506.size() == 0){
				mockupForPaymentTariffShop();
				list_1210066912_1506 = addListStorage("PaymentTariffShop", paymenttariffshopService.findAll());
			}
			if(list_1210066912_1506.size() > 0){
				paymenttariffshop = list_1210066912_1506.get(randBetween(0, list_1210066912_1506.size() - 1));
			}
			//PaymentTariffShop mockup end

			paymentpriceshop.setPaymentTariffShop(paymenttariffshop);	
			paymentpriceshop.setHumannumber(randBetween(1, itemCount));	
			paymentpriceshop.setPrice(randBetweenDecimal(2000, 15000));
	
				paymentpriceshopService.create(postCheck(paymentpriceshop, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating PaymentPriceShop: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		PaymentPriceShopFlag = true;
	
		return ", { \"text\":\"Generation data for PaymentPriceShop is done\" }";
	}

	@Autowired
	private PaymentTariffService paymenttariffService;

	public String mockupForPaymentTariff() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForPaymentTariff()");
		}
	
		if(PaymentTariffFlag){
			return ", { \"text\":\"Data for PaymentTariff already generated\" }";
		}
		Faker faker = new Faker();
			try {
				PaymentTariff paymenttariff = new PaymentTariff();
				checkForSentity(paymenttariff, faker);

	
				paymenttariffService.create(postCheck(paymenttariff, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating PaymentTariff: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		PaymentTariffFlag = true;
	
		return ", { \"text\":\"Generation data for PaymentTariff is done\" }";
	}

	@Autowired
	private PaymentTariffShopService paymenttariffshopService;

	public String mockupForPaymentTariffShop() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForPaymentTariffShop()");
		}
	
		if(PaymentTariffShopFlag){
			return ", { \"text\":\"Data for PaymentTariffShop already generated\" }";
		}
		Faker faker = new Faker();
			try {
				PaymentTariffShop paymenttariffshop = new PaymentTariffShop();
				checkForSentity(paymenttariffshop, faker);
	
			paymenttariffshop.setPercentageOfAllowances(randBetween(1, itemCount));	
			paymenttariffshop.setIsPercentageOfAllowances(randomBoolean());
	
				paymenttariffshopService.create(postCheck(paymenttariffshop, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating PaymentTariffShop: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		PaymentTariffShopFlag = true;
	
		return ", { \"text\":\"Generation data for PaymentTariffShop is done\" }";
	}

	@Autowired
	private RelMailNewsletterGroupService relmailnewslettergroupService;

	public String mockupForRelMailNewsletterGroup() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelMailNewsletterGroup()");
		}
	
		if(RelMailNewsletterGroupFlag){
			return ", { \"text\":\"Data for RelMailNewsletterGroup already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelMailNewsletterGroup relmailnewslettergroup = new RelMailNewsletterGroup();
				checkForSentity(relmailnewslettergroup, faker);
	
			//TmMailNewsletter mockup start
			List<TmMailNewsletter> list1738511218_9323 = checkListStorage("TmMailNewsletter");
			TmMailNewsletter tmmailnewsletter = null;
			if(list1738511218_9323.size() == 0){
				mockupForTmMailNewsletter();
				list1738511218_9323 = addListStorage("TmMailNewsletter", tmmailnewsletterService.findAll());
			}
			if(list1738511218_9323.size() > 0){
				tmmailnewsletter = list1738511218_9323.get(randBetween(0, list1738511218_9323.size() - 1));
			}
			//TmMailNewsletter mockup end

			relmailnewslettergroup.setTmMailNewsletter(tmmailnewsletter);	
			//TmMailNewsletterGroup mockup start
			List<TmMailNewsletterGroup> list1371565536_9637 = checkListStorage("TmMailNewsletterGroup");
			TmMailNewsletterGroup tmmailnewslettergroup = null;
			if(list1371565536_9637.size() == 0){
				mockupForTmMailNewsletterGroup();
				list1371565536_9637 = addListStorage("TmMailNewsletterGroup", tmmailnewslettergroupService.findAll());
			}
			if(list1371565536_9637.size() > 0){
				tmmailnewslettergroup = list1371565536_9637.get(randBetween(0, list1371565536_9637.size() - 1));
			}
			//TmMailNewsletterGroup mockup end

			relmailnewslettergroup.setTmMailNewsletterGroup(tmmailnewslettergroup);
	
				relmailnewslettergroupService.create(postCheck(relmailnewslettergroup, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelMailNewsletterGroup: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelMailNewsletterGroupFlag = true;
	
		return ", { \"text\":\"Generation data for RelMailNewsletterGroup is done\" }";
	}

	@Autowired
	private RelServHotelDocDocumentsService relservhoteldocdocumentsService;

	public String mockupForRelServHotelDocDocuments() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelServHotelDocDocuments()");
		}
	
		if(RelServHotelDocDocumentsFlag){
			return ", { \"text\":\"Data for RelServHotelDocDocuments already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelServHotelDocDocuments relservhoteldocdocuments = new RelServHotelDocDocuments();
				checkForSentity(relservhoteldocdocuments, faker);
	
			//DocDocuments mockup start
			List<DocDocuments> list1915170016_1276 = checkListStorage("DocDocuments");
			DocDocuments docdocuments = null;
			if(list1915170016_1276.size() == 0){
				mockupForDocDocuments();
				list1915170016_1276 = addListStorage("DocDocuments", docdocumentsService.findAll());
			}
			if(list1915170016_1276.size() > 0){
				docdocuments = list1915170016_1276.get(randBetween(0, list1915170016_1276.size() - 1));
			}
			//DocDocuments mockup end

			relservhoteldocdocuments.setDocDocuments(docdocuments);	
			//ServHotel mockup start
			List<ServHotel> list_1712324128_4755 = checkListStorage("ServHotel");
			ServHotel servhotel = null;
			if(list_1712324128_4755.size() == 0){
				mockupForServHotel();
				list_1712324128_4755 = addListStorage("ServHotel", servhotelService.findAll());
			}
			if(list_1712324128_4755.size() > 0){
				servhotel = list_1712324128_4755.get(randBetween(0, list_1712324128_4755.size() - 1));
			}
			//ServHotel mockup end

			relservhoteldocdocuments.setServHotel(servhotel);
	
				relservhoteldocdocumentsService.create(postCheck(relservhoteldocdocuments, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelServHotelDocDocuments: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelServHotelDocDocumentsFlag = true;
	
		return ", { \"text\":\"Generation data for RelServHotelDocDocuments is done\" }";
	}

	@Autowired
	private RelServHotelImageService relservhotelimageService;

	public String mockupForRelServHotelImage() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelServHotelImage()");
		}
	
		if(RelServHotelImageFlag){
			return ", { \"text\":\"Data for RelServHotelImage already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelServHotelImage relservhotelimage = new RelServHotelImage();
				checkForSentity(relservhotelimage, faker);
	
			//ServHotel mockup start
			List<ServHotel> list_1712324128_6062 = checkListStorage("ServHotel");
			ServHotel servhotel = null;
			if(list_1712324128_6062.size() == 0){
				mockupForServHotel();
				list_1712324128_6062 = addListStorage("ServHotel", servhotelService.findAll());
			}
			if(list_1712324128_6062.size() > 0){
				servhotel = list_1712324128_6062.get(randBetween(0, list_1712324128_6062.size() - 1));
			}
			//ServHotel mockup end

			relservhotelimage.setServHotel(servhotel);	
			//TmImage mockup start
			List<TmImage> list727071200_4604 = checkListStorage("TmImage");
			TmImage tmimage = null;
			if(list727071200_4604.size() == 0){
				mockupForTmImage();
				list727071200_4604 = addListStorage("TmImage", tmimageService.findAll());
			}
			if(list727071200_4604.size() > 0){
				tmimage = list727071200_4604.get(randBetween(0, list727071200_4604.size() - 1));
			}
			//TmImage mockup end

			relservhotelimage.setTmImage(tmimage);
	
				relservhotelimageService.create(postCheck(relservhotelimage, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelServHotelImage: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelServHotelImageFlag = true;
	
		return ", { \"text\":\"Generation data for RelServHotelImage is done\" }";
	}

	@Autowired
	private RelServHotelRoomImageService relservhotelroomimageService;

	public String mockupForRelServHotelRoomImage() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelServHotelRoomImage()");
		}
	
		if(RelServHotelRoomImageFlag){
			return ", { \"text\":\"Data for RelServHotelRoomImage already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelServHotelRoomImage relservhotelroomimage = new RelServHotelRoomImage();
				checkForSentity(relservhotelroomimage, faker);
	
			//ServHotelRoom mockup start
			List<ServHotelRoom> list_1012948800_4941 = checkListStorage("ServHotelRoom");
			ServHotelRoom servhotelroom = null;
			if(list_1012948800_4941.size() == 0){
				mockupForServHotelRoom();
				list_1012948800_4941 = addListStorage("ServHotelRoom", servhotelroomService.findAll());
			}
			if(list_1012948800_4941.size() > 0){
				servhotelroom = list_1012948800_4941.get(randBetween(0, list_1012948800_4941.size() - 1));
			}
			//ServHotelRoom mockup end

			relservhotelroomimage.setServHotelRoom(servhotelroom);	
			//TmImage mockup start
			List<TmImage> list727071200_8693 = checkListStorage("TmImage");
			TmImage tmimage = null;
			if(list727071200_8693.size() == 0){
				mockupForTmImage();
				list727071200_8693 = addListStorage("TmImage", tmimageService.findAll());
			}
			if(list727071200_8693.size() > 0){
				tmimage = list727071200_8693.get(randBetween(0, list727071200_8693.size() - 1));
			}
			//TmImage mockup end

			relservhotelroomimage.setTmImage(tmimage);
	
				relservhotelroomimageService.create(postCheck(relservhotelroomimage, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelServHotelRoomImage: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelServHotelRoomImageFlag = true;
	
		return ", { \"text\":\"Generation data for RelServHotelRoomImage is done\" }";
	}

	@Autowired
	private RelServTransferTmContactService relservtransfertmcontactService;

	public String mockupForRelServTransferTmContact() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelServTransferTmContact()");
		}
	
		if(RelServTransferTmContactFlag){
			return ", { \"text\":\"Data for RelServTransferTmContact already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelServTransferTmContact relservtransfertmcontact = new RelServTransferTmContact();
				checkForSentity(relservtransfertmcontact, faker);
	
			//ServTransfer mockup start
			List<ServTransfer> list_2086279454_8280 = checkListStorage("ServTransfer");
			ServTransfer servtransfer = null;
			if(list_2086279454_8280.size() == 0){
				mockupForServTransfer();
				list_2086279454_8280 = addListStorage("ServTransfer", servtransferService.findAll());
			}
			if(list_2086279454_8280.size() > 0){
				servtransfer = list_2086279454_8280.get(randBetween(0, list_2086279454_8280.size() - 1));
			}
			//ServTransfer mockup end

			relservtransfertmcontact.setServTransfer(servtransfer);	
			//TmContact mockup start
			List<TmContact> list772251648_1036 = checkListStorage("TmContact");
			TmContact tmcontact = null;
			if(list772251648_1036.size() == 0){
				mockupForTmContact();
				list772251648_1036 = addListStorage("TmContact", tmcontactService.findAll());
			}
			if(list772251648_1036.size() > 0){
				tmcontact = list772251648_1036.get(randBetween(0, list772251648_1036.size() - 1));
			}
			//TmContact mockup end

			relservtransfertmcontact.setTmContact(tmcontact);
	
				relservtransfertmcontactService.create(postCheck(relservtransfertmcontact, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelServTransferTmContact: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelServTransferTmContactFlag = true;
	
		return ", { \"text\":\"Generation data for RelServTransferTmContact is done\" }";
	}

	@Autowired
	private RelShopPermissionService relshoppermissionService;

	public String mockupForRelShopPermission() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelShopPermission()");
		}
	
		if(RelShopPermissionFlag){
			return ", { \"text\":\"Data for RelShopPermission already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelShopPermission relshoppermission = new RelShopPermission();
				checkForSentity(relshoppermission, faker);
	
			//InfoPermission mockup start
			List<InfoPermission> list_276273254_5464 = checkListStorage("InfoPermission");
			InfoPermission infopermission = null;
			if(list_276273254_5464.size() == 0){
				mockupForInfoPermission();
				list_276273254_5464 = addListStorage("InfoPermission", infopermissionService.findAll());
			}
			if(list_276273254_5464.size() > 0){
				infopermission = list_276273254_5464.get(randBetween(0, list_276273254_5464.size() - 1));
			}
			//InfoPermission mockup end

			relshoppermission.setInfoPermission(infopermission);	
			//ShopPermission mockup start
			List<ShopPermission> list_1436827094_3693 = checkListStorage("ShopPermission");
			ShopPermission shoppermission = null;
			if(list_1436827094_3693.size() == 0){
				mockupForShopPermission();
				list_1436827094_3693 = addListStorage("ShopPermission", shoppermissionService.findAll());
			}
			if(list_1436827094_3693.size() > 0){
				shoppermission = list_1436827094_3693.get(randBetween(0, list_1436827094_3693.size() - 1));
			}
			//ShopPermission mockup end

			relshoppermission.setShopPermission(shoppermission);
	
				relshoppermissionService.create(postCheck(relshoppermission, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelShopPermission: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelShopPermissionFlag = true;
	
		return ", { \"text\":\"Generation data for RelShopPermission is done\" }";
	}

	@Autowired
	private RelUserDetailsService reluserdetailsService;

	public String mockupForRelUserDetails() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForRelUserDetails()");
		}
	
		if(RelUserDetailsFlag){
			return ", { \"text\":\"Data for RelUserDetails already generated\" }";
		}
		Faker faker = new Faker();
			try {
				RelUserDetails reluserdetails = new RelUserDetails();
				checkForSentity(reluserdetails, faker);
	
			//UserDetail mockup start
			List<UserDetail> list415285528_5750 = checkListStorage("UserDetail");
			UserDetail userdetail = null;
			if(list415285528_5750.size() == 0){
				mockupForUserDetail();
				list415285528_5750 = addListStorage("UserDetail", userdetailService.findAll());
			}
			if(list415285528_5750.size() > 0){
				userdetail = list415285528_5750.get(randBetween(0, list415285528_5750.size() - 1));
			}
			//UserDetail mockup end

			reluserdetails.setUserDetail(userdetail);	
			//Users mockup start
			List<Users> list207708448_923 = _usersService.findAll();
			Users users = null;
			if(list207708448_923.size() > 0){
				users = list207708448_923.get(randBetween(0, list207708448_923.size() - 1));
			}
			//Users mockup end

			reluserdetails.setUsers(users);
	
				reluserdetailsService.create(postCheck(reluserdetails, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating RelUserDetails: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		RelUserDetailsFlag = true;
	
		return ", { \"text\":\"Generation data for RelUserDetails is done\" }";
	}

	@Autowired
	private ReqServHotelService reqservhotelService;

	public String mockupForReqServHotel() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForReqServHotel()");
		}
	
		if(ReqServHotelFlag){
			return ", { \"text\":\"Data for ReqServHotel already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ReqServHotel reqservhotel = new ReqServHotel();
				checkForSentity(reqservhotel, faker);
	
			//DocDocuments mockup start
			List<DocDocuments> list_1757494019_9868 = checkListStorage("DocDocuments");
			DocDocuments docdocumentsbydocumentforuserid = null;
			if(list_1757494019_9868.size() == 0){
				mockupForDocDocuments();
				list_1757494019_9868 = addListStorage("DocDocuments", docdocumentsService.findAll());
			}
			if(list_1757494019_9868.size() > 0){
				docdocumentsbydocumentforuserid = list_1757494019_9868.get(randBetween(0, list_1757494019_9868.size() - 1));
			}
			//DocDocuments mockup end

			reqservhotel.setDocDocumentsByDocumentForUserId(docdocumentsbydocumentforuserid);	
			//DocDocuments mockup start
			List<DocDocuments> list_1696371176_7023 = checkListStorage("DocDocuments");
			DocDocuments docdocumentsbydocumentforhotelid = null;
			if(list_1696371176_7023.size() == 0){
				mockupForDocDocuments();
				list_1696371176_7023 = addListStorage("DocDocuments", docdocumentsService.findAll());
			}
			if(list_1696371176_7023.size() > 0){
				docdocumentsbydocumentforhotelid = list_1696371176_7023.get(randBetween(0, list_1696371176_7023.size() - 1));
			}
			//DocDocuments mockup end

			reqservhotel.setDocDocumentsByDocumentForHotelId(docdocumentsbydocumentforhotelid);	
			//PaymentPrice mockup start
			List<PaymentPrice> list2060692838_2198 = checkListStorage("PaymentPrice");
			PaymentPrice paymentprice = null;
			if(list2060692838_2198.size() == 0){
				mockupForPaymentPrice();
				list2060692838_2198 = addListStorage("PaymentPrice", paymentpriceService.findAll());
			}
			if(list2060692838_2198.size() > 0){
				paymentprice = list2060692838_2198.get(randBetween(0, list2060692838_2198.size() - 1));
			}
			//PaymentPrice mockup end

			reqservhotel.setPaymentPrice(paymentprice);	
			//PaymentTariff mockup start
			List<PaymentTariff> list1498215520_5925 = checkListStorage("PaymentTariff");
			PaymentTariff paymenttariff = null;
			if(list1498215520_5925.size() == 0){
				mockupForPaymentTariff();
				list1498215520_5925 = addListStorage("PaymentTariff", paymenttariffService.findAll());
			}
			if(list1498215520_5925.size() > 0){
				paymenttariff = list1498215520_5925.get(randBetween(0, list1498215520_5925.size() - 1));
			}
			//PaymentTariff mockup end

			reqservhotel.setPaymentTariff(paymenttariff);	
			//ServHotel mockup start
			List<ServHotel> list_1712324128_9298 = checkListStorage("ServHotel");
			ServHotel servhotel = null;
			if(list_1712324128_9298.size() == 0){
				mockupForServHotel();
				list_1712324128_9298 = addListStorage("ServHotel", servhotelService.findAll());
			}
			if(list_1712324128_9298.size() > 0){
				servhotel = list_1712324128_9298.get(randBetween(0, list_1712324128_9298.size() - 1));
			}
			//ServHotel mockup end

			reqservhotel.setServHotel(servhotel);	
			//ServHotelRoom mockup start
			List<ServHotelRoom> list_1012948800_5985 = checkListStorage("ServHotelRoom");
			ServHotelRoom servhotelroom = null;
			if(list_1012948800_5985.size() == 0){
				mockupForServHotelRoom();
				list_1012948800_5985 = addListStorage("ServHotelRoom", servhotelroomService.findAll());
			}
			if(list_1012948800_5985.size() > 0){
				servhotelroom = list_1012948800_5985.get(randBetween(0, list_1012948800_5985.size() - 1));
			}
			//ServHotelRoom mockup end

			reqservhotel.setServHotelRoom(servhotelroom);	
			//Users mockup start
			List<Users> list1875755358_4233 = _usersService.findAll();
			Users usersbyrequestuserid = null;
			if(list1875755358_4233.size() > 0){
				usersbyrequestuserid = list1875755358_4233.get(randBetween(0, list1875755358_4233.size() - 1));
			}
			//Users mockup end

			reqservhotel.setUsersByRequestUserId(usersbyrequestuserid);	
			//Users mockup start
			List<Users> list175084382_9577 = _usersService.findAll();
			Users usersbyresponseuserid = null;
			if(list175084382_9577.size() > 0){
				usersbyresponseuserid = list175084382_9577.get(randBetween(0, list175084382_9577.size() - 1));
			}
			//Users mockup end

			reqservhotel.setUsersByResponseUserId(usersbyresponseuserid);	
			reqservhotel.setAccept(randomBoolean());	
			reqservhotel.setDatedifference(faker.lorem().fixedString(randBetween(10, 30)));	
			reqservhotel.setDecline(randomBoolean());	
			reqservhotel.setDeparture(randomDate());	
			reqservhotel.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			reqservhotel.setPaymentType(randomBoolean());	
			reqservhotel.setPrice(randBetweenDecimal(2000, 15000));	
			reqservhotel.setProgress(randBetween(1, itemCount));	
			reqservhotel.setRace(randomDate());	
			reqservhotel.setRoomCount(randBetween(1, itemCount));	
			reqservhotel.setSingleprice(randBetween(1, itemCount));	
			reqservhotel.setTariffcurrency(faker.lorem().fixedString(randBetween(10, 30)));	
			reqservhotel.setRequestNumber(faker.lorem().fixedString(randBetween(10, 30)));	
			reqservhotel.setCancel(randomBoolean());	
			reqservhotel.setConfirm(randomBoolean());	
			reqservhotel.setArchived(randomBoolean());
	
				reqservhotelService.create(postCheck(reqservhotel, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ReqServHotel: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ReqServHotelFlag = true;
	
		return ", { \"text\":\"Generation data for ReqServHotel is done\" }";
	}

	@Autowired
	private ServHotelService servhotelService;

	public String mockupForServHotel() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForServHotel()");
		}
	
		if(ServHotelFlag){
			return ", { \"text\":\"Data for ServHotel already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ServHotel servhotel = new ServHotel();
				checkForSentity(servhotel, faker);
	
			//InfoContactInformation mockup start
			List<InfoContactInformation> list1535539476_8154 = checkListStorage("InfoContactInformation");
			InfoContactInformation infocontactinformation = null;
			if(list1535539476_8154.size() == 0){
				mockupForInfoContactInformation();
				list1535539476_8154 = addListStorage("InfoContactInformation", infocontactinformationService.findAll());
			}
			if(list1535539476_8154.size() > 0){
				infocontactinformation = list1535539476_8154.get(randBetween(0, list1535539476_8154.size() - 1));
			}
			//InfoContactInformation mockup end

			servhotel.setInfoContactInformation(infocontactinformation);	
			//LocationAddress mockup start
			List<LocationAddress> list547216960_8843 = checkListStorage("LocationAddress");
			LocationAddress locationaddress = null;
			if(list547216960_8843.size() == 0){
				mockupForLocationAddress();
				list547216960_8843 = addListStorage("LocationAddress", locationaddressService.findAll());
			}
			if(list547216960_8843.size() > 0){
				locationaddress = list547216960_8843.get(randBetween(0, list547216960_8843.size() - 1));
			}
			//LocationAddress mockup end

			servhotel.setLocationAddress(locationaddress);	
			//LocationCities mockup start
			List<LocationCities> list_664359332_3472 = checkListStorage("LocationCities");
			LocationCities locationcities = null;
			if(list_664359332_3472.size() == 0){
				mockupForLocationCities();
				list_664359332_3472 = addListStorage("LocationCities", locationcitiesService.findAll());
			}
			if(list_664359332_3472.size() > 0){
				locationcities = list_664359332_3472.get(randBetween(0, list_664359332_3472.size() - 1));
			}
			//LocationCities mockup end

			servhotel.setLocationCities(locationcities);	
			//LocationCountries mockup start
			List<LocationCountries> list735144448_654 = checkListStorage("LocationCountries");
			LocationCountries locationcountries = null;
			if(list735144448_654.size() == 0){
				mockupForLocationCountries();
				list735144448_654 = addListStorage("LocationCountries", locationcountriesService.findAll());
			}
			if(list735144448_654.size() > 0){
				locationcountries = list735144448_654.get(randBetween(0, list735144448_654.size() - 1));
			}
			//LocationCountries mockup end

			servhotel.setLocationCountries(locationcountries);	
			//PaymentDetails mockup start
			List<PaymentDetails> list_1978348072_2629 = checkListStorage("PaymentDetails");
			PaymentDetails paymentdetails = null;
			if(list_1978348072_2629.size() == 0){
				mockupForPaymentDetails();
				list_1978348072_2629 = addListStorage("PaymentDetails", paymentdetailsService.findAll());
			}
			if(list_1978348072_2629.size() > 0){
				paymentdetails = list_1978348072_2629.get(randBetween(0, list_1978348072_2629.size() - 1));
			}
			//PaymentDetails mockup end

			servhotel.setPaymentDetails(paymentdetails);	
			servhotel.setBlacklist(randomBoolean());	
			servhotel.setConditionText(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setDescrInternal(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setFavorite(randomBoolean());	
			servhotel.setFreesale(randomBoolean());	
			servhotel.setProblem(randomBoolean());	
			servhotel.setShowonline(randomBoolean());	
			servhotel.setStarcount(randBetween(1, itemCount));	
			servhotel.setSynopsis(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setTimedeparture(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setTimeearlyrace(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setTimelatedeparture(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setTimerace(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotel.setWhereroomsarebooked(faker.lorem().fixedString(randBetween(10, 30)));
	
				servhotelService.create(postCheck(servhotel, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ServHotel: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ServHotelFlag = true;
	
		return ", { \"text\":\"Generation data for ServHotel is done\" }";
	}

	@Autowired
	private ServHotelRoomService servhotelroomService;

	public String mockupForServHotelRoom() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForServHotelRoom()");
		}
	
		if(ServHotelRoomFlag){
			return ", { \"text\":\"Data for ServHotelRoom already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ServHotelRoom servhotelroom = new ServHotelRoom();
				checkForSentity(servhotelroom, faker);
	
			//DictGlobal mockup start
			List<DictGlobal> list_1008974126_3860 = checkListStorage("DictGlobal");
			DictGlobal dictglobal = null;
			if(list_1008974126_3860.size() == 0){
				mockupForDictGlobal();
				list_1008974126_3860 = addListStorage("DictGlobal", dictglobalService.findAll());
			}
			if(list_1008974126_3860.size() > 0){
				dictglobal = list_1008974126_3860.get(randBetween(0, list_1008974126_3860.size() - 1));
			}
			//DictGlobal mockup end

			servhotelroom.setDictGlobal(dictglobal);	
			//PaymentTariff mockup start
			List<PaymentTariff> list_1612236877_6167 = checkListStorage("PaymentTariff");
			PaymentTariff paymenttariffbycosttarriffid = null;
			if(list_1612236877_6167.size() == 0){
				mockupForPaymentTariff();
				list_1612236877_6167 = addListStorage("PaymentTariff", paymenttariffService.findAll());
			}
			if(list_1612236877_6167.size() > 0){
				paymenttariffbycosttarriffid = list_1612236877_6167.get(randBetween(0, list_1612236877_6167.size() - 1));
			}
			//PaymentTariff mockup end

			servhotelroom.setPaymentTariffByCostTarriffId(paymenttariffbycosttarriffid);	
			//PaymentTariff mockup start
			List<PaymentTariff> list772567264_8649 = checkListStorage("PaymentTariff");
			PaymentTariff paymenttariffbyrrtarriffid = null;
			if(list772567264_8649.size() == 0){
				mockupForPaymentTariff();
				list772567264_8649 = addListStorage("PaymentTariff", paymenttariffService.findAll());
			}
			if(list772567264_8649.size() > 0){
				paymenttariffbyrrtarriffid = list772567264_8649.get(randBetween(0, list772567264_8649.size() - 1));
			}
			//PaymentTariff mockup end

			servhotelroom.setPaymentTariffByRrTarriffId(paymenttariffbyrrtarriffid);	
			//PaymentTariffShop mockup start
			List<PaymentTariffShop> list_1210066912_6281 = checkListStorage("PaymentTariffShop");
			PaymentTariffShop paymenttariffshop = null;
			if(list_1210066912_6281.size() == 0){
				mockupForPaymentTariffShop();
				list_1210066912_6281 = addListStorage("PaymentTariffShop", paymenttariffshopService.findAll());
			}
			if(list_1210066912_6281.size() > 0){
				paymenttariffshop = list_1210066912_6281.get(randBetween(0, list_1210066912_6281.size() - 1));
			}
			//PaymentTariffShop mockup end

			servhotelroom.setPaymentTariffShop(paymenttariffshop);	
			//ServHotel mockup start
			List<ServHotel> list_1712324128_6447 = checkListStorage("ServHotel");
			ServHotel servhotel = null;
			if(list_1712324128_6447.size() == 0){
				mockupForServHotel();
				list_1712324128_6447 = addListStorage("ServHotel", servhotelService.findAll());
			}
			if(list_1712324128_6447.size() > 0){
				servhotel = list_1712324128_6447.get(randBetween(0, list_1712324128_6447.size() - 1));
			}
			//ServHotel mockup end

			servhotelroom.setServHotel(servhotel);	
			servhotelroom.setBreakfast(randomBoolean());	
			servhotelroom.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			servhotelroom.setGuestNumber(randBetween(1, itemCount));	
			servhotelroom.setRoomNumber(randBetween(1, itemCount));	
			servhotelroom.setDinner(randomBoolean());	
			servhotelroom.setLunch(randomBoolean());	
			servhotelroom.setDiscount(randBetween(1, itemCount));	
			servhotelroom.setIsDiscount(randomBoolean());	
			servhotelroom.setCommission(randBetween(1, itemCount));	
			servhotelroom.setFresale(randBetween(1, itemCount));	
			servhotelroom.setFresaleToday(randBetween(1, itemCount));	
			servhotelroom.setFresaleEnabled(randomBoolean());	
			servhotelroom.setFresaleStart(randomDate());	
			servhotelroom.setFresaleEnd(randomDate());	
			servhotelroom.setIsCommission(randomBoolean());
	
				servhotelroomService.create(postCheck(servhotelroom, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ServHotelRoom: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ServHotelRoomFlag = true;
	
		return ", { \"text\":\"Generation data for ServHotelRoom is done\" }";
	}

	@Autowired
	private ServTransferService servtransferService;

	public String mockupForServTransfer() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForServTransfer()");
		}
	
		if(ServTransferFlag){
			return ", { \"text\":\"Data for ServTransfer already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ServTransfer servtransfer = new ServTransfer();
				checkForSentity(servtransfer, faker);
	
			//CurrCurrency mockup start
			List<CurrCurrency> list514275430_3393 = checkListStorage("CurrCurrency");
			CurrCurrency currcurrency = null;
			if(list514275430_3393.size() == 0){
				mockupForCurrCurrency();
				list514275430_3393 = addListStorage("CurrCurrency", currcurrencyService.findAll());
			}
			if(list514275430_3393.size() > 0){
				currcurrency = list514275430_3393.get(randBetween(0, list514275430_3393.size() - 1));
			}
			//CurrCurrency mockup end

			servtransfer.setCurrCurrency(currcurrency);	
			//DictGlobal mockup start
			List<DictGlobal> list_398160046_462 = checkListStorage("DictGlobal");
			DictGlobal dictglobalbypaymenttypeid = null;
			if(list_398160046_462.size() == 0){
				mockupForDictGlobal();
				list_398160046_462 = addListStorage("DictGlobal", dictglobalService.findAll());
			}
			if(list_398160046_462.size() > 0){
				dictglobalbypaymenttypeid = list_398160046_462.get(randBetween(0, list_398160046_462.size() - 1));
			}
			//DictGlobal mockup end

			servtransfer.setDictGlobalByPaymentTypeId(dictglobalbypaymenttypeid);	
			//DictGlobal mockup start
			List<DictGlobal> list_826525591_2603 = checkListStorage("DictGlobal");
			DictGlobal dictglobalbytypetransferid = null;
			if(list_826525591_2603.size() == 0){
				mockupForDictGlobal();
				list_826525591_2603 = addListStorage("DictGlobal", dictglobalService.findAll());
			}
			if(list_826525591_2603.size() > 0){
				dictglobalbytypetransferid = list_826525591_2603.get(randBetween(0, list_826525591_2603.size() - 1));
			}
			//DictGlobal mockup end

			servtransfer.setDictGlobalByTypeTransferId(dictglobalbytypetransferid);	
			//DictGlobal mockup start
			List<DictGlobal> list1824470939_1266 = checkListStorage("DictGlobal");
			DictGlobal dictglobalbytransportid = null;
			if(list1824470939_1266.size() == 0){
				mockupForDictGlobal();
				list1824470939_1266 = addListStorage("DictGlobal", dictglobalService.findAll());
			}
			if(list1824470939_1266.size() > 0){
				dictglobalbytransportid = list1824470939_1266.get(randBetween(0, list1824470939_1266.size() - 1));
			}
			//DictGlobal mockup end

			servtransfer.setDictGlobalByTransportId(dictglobalbytransportid);	
			//LocationCities mockup start
			List<LocationCities> list_664359332_7109 = checkListStorage("LocationCities");
			LocationCities locationcities = null;
			if(list_664359332_7109.size() == 0){
				mockupForLocationCities();
				list_664359332_7109 = addListStorage("LocationCities", locationcitiesService.findAll());
			}
			if(list_664359332_7109.size() > 0){
				locationcities = list_664359332_7109.get(randBetween(0, list_664359332_7109.size() - 1));
			}
			//LocationCities mockup end

			servtransfer.setLocationCities(locationcities);	
			//LocationCountries mockup start
			List<LocationCountries> list735144448_2784 = checkListStorage("LocationCountries");
			LocationCountries locationcountries = null;
			if(list735144448_2784.size() == 0){
				mockupForLocationCountries();
				list735144448_2784 = addListStorage("LocationCountries", locationcountriesService.findAll());
			}
			if(list735144448_2784.size() > 0){
				locationcountries = list735144448_2784.get(randBetween(0, list735144448_2784.size() - 1));
			}
			//LocationCountries mockup end

			servtransfer.setLocationCountries(locationcountries);	
			//TmAccount mockup start
			List<TmAccount> list1481973408_9002 = checkListStorage("TmAccount");
			TmAccount tmaccount = null;
			if(list1481973408_9002.size() == 0){
				mockupForTmAccount();
				list1481973408_9002 = addListStorage("TmAccount", tmaccountService.findAll());
			}
			if(list1481973408_9002.size() > 0){
				tmaccount = list1481973408_9002.get(randBetween(0, list1481973408_9002.size() - 1));
			}
			//TmAccount mockup end

			servtransfer.setTmAccount(tmaccount);	
			servtransfer.setDateFrom(randomDate());	
			servtransfer.setDateTo(randomDate());	
			servtransfer.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransfer.setPassengersPhones(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransfer.setPrice(randBetweenDecimal(2000, 15000));	
			servtransfer.setTransferName(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransfer.setVisitTable(faker.lorem().fixedString(randBetween(10, 30)));
	
				servtransferService.create(postCheck(servtransfer, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ServTransfer: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ServTransferFlag = true;
	
		return ", { \"text\":\"Generation data for ServTransfer is done\" }";
	}

	@Autowired
	private ServTransferRouteService servtransferrouteService;

	public String mockupForServTransferRoute() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForServTransferRoute()");
		}
	
		if(ServTransferRouteFlag){
			return ", { \"text\":\"Data for ServTransferRoute already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ServTransferRoute servtransferroute = new ServTransferRoute();
				checkForSentity(servtransferroute, faker);
	
			//CurrCurrency mockup start
			List<CurrCurrency> list514275430_6255 = checkListStorage("CurrCurrency");
			CurrCurrency currcurrency = null;
			if(list514275430_6255.size() == 0){
				mockupForCurrCurrency();
				list514275430_6255 = addListStorage("CurrCurrency", currcurrencyService.findAll());
			}
			if(list514275430_6255.size() > 0){
				currcurrency = list514275430_6255.get(randBetween(0, list514275430_6255.size() - 1));
			}
			//CurrCurrency mockup end

			servtransferroute.setCurrCurrency(currcurrency);	
			//ServTransfer mockup start
			List<ServTransfer> list_2086279454_5703 = checkListStorage("ServTransfer");
			ServTransfer servtransfer = null;
			if(list_2086279454_5703.size() == 0){
				mockupForServTransfer();
				list_2086279454_5703 = addListStorage("ServTransfer", servtransferService.findAll());
			}
			if(list_2086279454_5703.size() > 0){
				servtransfer = list_2086279454_5703.get(randBetween(0, list_2086279454_5703.size() - 1));
			}
			//ServTransfer mockup end

			servtransferroute.setServTransfer(servtransfer);	
			servtransferroute.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransferroute.setDriver(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransferroute.setDriverPhone(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransferroute.setFixedAllowance(randBetweenDecimal(2000, 15000));	
			servtransferroute.setFree(randomBoolean());	
			servtransferroute.setPercentageOfAllowances(randBetweenDecimal(2000, 15000));	
			servtransferroute.setSum(randBetween(1, itemCount));
	
				servtransferrouteService.create(postCheck(servtransferroute, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ServTransferRoute: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ServTransferRouteFlag = true;
	
		return ", { \"text\":\"Generation data for ServTransferRoute is done\" }";
	}

	@Autowired
	private ServTransferRoutePointService servtransferroutepointService;

	public String mockupForServTransferRoutePoint() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForServTransferRoutePoint()");
		}
	
		if(ServTransferRoutePointFlag){
			return ", { \"text\":\"Data for ServTransferRoutePoint already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ServTransferRoutePoint servtransferroutepoint = new ServTransferRoutePoint();
				checkForSentity(servtransferroutepoint, faker);
	
			//ServTransferRoute mockup start
			List<ServTransferRoute> list1871896864_9175 = checkListStorage("ServTransferRoute");
			ServTransferRoute servtransferroute = null;
			if(list1871896864_9175.size() == 0){
				mockupForServTransferRoute();
				list1871896864_9175 = addListStorage("ServTransferRoute", servtransferrouteService.findAll());
			}
			if(list1871896864_9175.size() > 0){
				servtransferroute = list1871896864_9175.get(randBetween(0, list1871896864_9175.size() - 1));
			}
			//ServTransferRoute mockup end

			servtransferroutepoint.setServTransferRoute(servtransferroute);	
			servtransferroutepoint.setFixedAllowance(randBetweenDecimal(2000, 15000));	
			servtransferroutepoint.setFree(randomBoolean());	
			servtransferroutepoint.setPercentageOfAllowances(randBetweenDecimal(2000, 15000));	
			servtransferroutepoint.setPointFrom(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransferroutepoint.setPointTo(faker.lorem().fixedString(randBetween(10, 30)));	
			servtransferroutepoint.setStartOn(randomDate());	
			servtransferroutepoint.setSum(randBetween(1, itemCount));
	
				servtransferroutepointService.create(postCheck(servtransferroutepoint, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ServTransferRoutePoint: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ServTransferRoutePointFlag = true;
	
		return ", { \"text\":\"Generation data for ServTransferRoutePoint is done\" }";
	}

	@Autowired
	private ShopPermissionService shoppermissionService;

	public String mockupForShopPermission() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForShopPermission()");
		}
	
		if(ShopPermissionFlag){
			return ", { \"text\":\"Data for ShopPermission already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ShopPermission shoppermission = new ShopPermission();
				checkForSentity(shoppermission, faker);
	
			shoppermission.setAllocatedFirmId(randBetween(1, itemCount));	
			shoppermission.setPhysicalPerson(randomBoolean());	
			shoppermission.setCorporateCustomer(randomBoolean());	
			shoppermission.setTravelAgency(randomBoolean());	
			shoppermission.setTravelOperator(randomBoolean());	
			shoppermission.setPartner(randomBoolean());
	
				shoppermissionService.create(postCheck(shoppermission, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ShopPermission: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ShopPermissionFlag = true;
	
		return ", { \"text\":\"Generation data for ShopPermission is done\" }";
	}

	@Autowired
	private ShopUserService shopuserService;

	public String mockupForShopUser() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForShopUser()");
		}
	
		if(ShopUserFlag){
			return ", { \"text\":\"Data for ShopUser already generated\" }";
		}
		Faker faker = new Faker();
			try {
				ShopUser shopuser = new ShopUser();
				checkForSentity(shopuser, faker);
	
			shopuser.setActivated(randomBoolean());	
			shopuser.setActivationkey(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setEmail(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setEnabled(randomBoolean());	
			shopuser.setFirstname(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setLastname(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setPassword(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setUsername(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setImageId(randBetween(1, itemCount));	
			shopuser.setToken(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setPhonenumber(faker.lorem().fixedString(randBetween(10, 30)));	
			shopuser.setShopPermissionId(randBetween(1, itemCount));
	
				shopuserService.create(postCheck(shopuser, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating ShopUser: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		ShopUserFlag = true;
	
		return ", { \"text\":\"Generation data for ShopUser is done\" }";
	}

	@Autowired
	private TmAccountService tmaccountService;

	public String mockupForTmAccount() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmAccount()");
		}
	
		if(TmAccountFlag){
			return ", { \"text\":\"Data for TmAccount already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmAccount tmaccount = new TmAccount();
				checkForSentity(tmaccount, faker);
	
			//LocationCountries mockup start
			List<LocationCountries> list735144448_9471 = checkListStorage("LocationCountries");
			LocationCountries locationcountries = null;
			if(list735144448_9471.size() == 0){
				mockupForLocationCountries();
				list735144448_9471 = addListStorage("LocationCountries", locationcountriesService.findAll());
			}
			if(list735144448_9471.size() > 0){
				locationcountries = list735144448_9471.get(randBetween(0, list735144448_9471.size() - 1));
			}
			//LocationCountries mockup end

			tmaccount.setLocationCountries(locationcountries);	
			tmaccount.setAccountFullname(faker.lorem().fixedString(randBetween(10, 30)));	
			tmaccount.setAccountName(faker.lorem().fixedString(randBetween(10, 30)));	
			tmaccount.setDescr(faker.lorem().fixedString(randBetween(10, 30)));
	
				tmaccountService.create(postCheck(tmaccount, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmAccount: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmAccountFlag = true;
	
		return ", { \"text\":\"Generation data for TmAccount is done\" }";
	}

	@Autowired
	private TmContactService tmcontactService;

	public String mockupForTmContact() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmContact()");
		}
	
		if(TmContactFlag){
			return ", { \"text\":\"Data for TmContact already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmContact tmcontact = new TmContact();
				checkForSentity(tmcontact, faker);
	
			//LocationCountries mockup start
			List<LocationCountries> list735144448_9220 = checkListStorage("LocationCountries");
			LocationCountries locationcountries = null;
			if(list735144448_9220.size() == 0){
				mockupForLocationCountries();
				list735144448_9220 = addListStorage("LocationCountries", locationcountriesService.findAll());
			}
			if(list735144448_9220.size() > 0){
				locationcountries = list735144448_9220.get(randBetween(0, list735144448_9220.size() - 1));
			}
			//LocationCountries mockup end

			tmcontact.setLocationCountries(locationcountries);	
			tmcontact.setBirthday(randomDate());	
			tmcontact.setContactName(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontact.setContactPatronymic(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontact.setContactSurname(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontact.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontact.setPassportEndDate(randomDate());	
			tmcontact.setPassportNumber(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontact.setPassportStartDate(randomDate());
	
				tmcontactService.create(postCheck(tmcontact, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmContact: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmContactFlag = true;
	
		return ", { \"text\":\"Generation data for TmContact is done\" }";
	}

	@Autowired
	private TmContactEasyService tmcontacteasyService;

	public String mockupForTmContactEasy() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmContactEasy()");
		}
	
		if(TmContactEasyFlag){
			return ", { \"text\":\"Data for TmContactEasy already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmContactEasy tmcontacteasy = new TmContactEasy();
				checkForSentity(tmcontacteasy, faker);
	
			//LocationCountries mockup start
			List<LocationCountries> list735144448_7253 = checkListStorage("LocationCountries");
			LocationCountries locationcountries = null;
			if(list735144448_7253.size() == 0){
				mockupForLocationCountries();
				list735144448_7253 = addListStorage("LocationCountries", locationcountriesService.findAll());
			}
			if(list735144448_7253.size() > 0){
				locationcountries = list735144448_7253.get(randBetween(0, list735144448_7253.size() - 1));
			}
			//LocationCountries mockup end

			tmcontacteasy.setLocationCountries(locationcountries);	
			//ReqServHotel mockup start
			List<ReqServHotel> list1672836256_6224 = checkListStorage("ReqServHotel");
			ReqServHotel reqservhotel = null;
			if(list1672836256_6224.size() == 0){
				mockupForReqServHotel();
				list1672836256_6224 = addListStorage("ReqServHotel", reqservhotelService.findAll());
			}
			if(list1672836256_6224.size() > 0){
				reqservhotel = list1672836256_6224.get(randBetween(0, list1672836256_6224.size() - 1));
			}
			//ReqServHotel mockup end

			tmcontacteasy.setReqServHotel(reqservhotel);	
			tmcontacteasy.setDescr(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontacteasy.setEmail(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontacteasy.setManFoman(randomBoolean());	
			tmcontacteasy.setPhone(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontacteasy.setIdCard(randomBoolean());	
			tmcontacteasy.setIdentityNumber(faker.lorem().fixedString(randBetween(10, 30)));	
			tmcontacteasy.setPassport(randomBoolean());
	
				tmcontacteasyService.create(postCheck(tmcontacteasy, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmContactEasy: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmContactEasyFlag = true;
	
		return ", { \"text\":\"Generation data for TmContactEasy is done\" }";
	}

	@Autowired
	private TmFirmsService tmfirmsService;

	public String mockupForTmFirms() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmFirms()");
		}
	
		if(TmFirmsFlag){
			return ", { \"text\":\"Data for TmFirms already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmFirms tmfirms = new TmFirms();
				checkForSentity(tmfirms, faker);
	
			tmfirms.setAccountid(randBetween(1, itemCount));	
			tmfirms.setActive(faker.lorem().fixedString(randBetween(10, 30)));	
			tmfirms.setFirmName(faker.lorem().fixedString(randBetween(10, 30)));	
			tmfirms.setLastpay(randomDate());	
			tmfirms.setMounthcount(randBetween(1, itemCount));
	
				tmfirmsService.create(postCheck(tmfirms, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmFirms: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmFirmsFlag = true;
	
		return ", { \"text\":\"Generation data for TmFirms is done\" }";
	}

	@Autowired
	private TmFirmSettingsService tmfirmsettingsService;

	public String mockupForTmFirmSettings() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmFirmSettings()");
		}
	
		if(TmFirmSettingsFlag){
			return ", { \"text\":\"Data for TmFirmSettings already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmFirmSettings tmfirmsettings = new TmFirmSettings();
				checkForSentity(tmfirmsettings, faker);
	
			//DocDocuments mockup start
			List<DocDocuments> list1915170016_3100 = checkListStorage("DocDocuments");
			DocDocuments docdocuments = null;
			if(list1915170016_3100.size() == 0){
				mockupForDocDocuments();
				list1915170016_3100 = addListStorage("DocDocuments", docdocumentsService.findAll());
			}
			if(list1915170016_3100.size() > 0){
				docdocuments = list1915170016_3100.get(randBetween(0, list1915170016_3100.size() - 1));
			}
			//DocDocuments mockup end

			tmfirmsettings.setDocDocuments(docdocuments);	
			tmfirmsettings.setLogoId(randBetween(1, itemCount));	
			tmfirmsettings.setBrand(faker.lorem().fixedString(randBetween(10, 30)));
	
				tmfirmsettingsService.create(postCheck(tmfirmsettings, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmFirmSettings: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmFirmSettingsFlag = true;
	
		return ", { \"text\":\"Generation data for TmFirmSettings is done\" }";
	}

	@Autowired
	private TmImageService tmimageService;

	public String mockupForTmImage() {
		if(TmImageFlag){
			return ", { \"text\":\"Data for TmImage already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmImage tmimage = new TmImage();
				checkForSentity(tmimage, faker);
				Path path = images.get(randBetween(0, images.size() - 1));
				File file = new File(path.toUri());
				
				tmimage.setName(UUID.randomUUID().toString());
				tmimage.setContenttype(Files.probeContentType(path));
				tmimage.setOriginalfilename(file.getName());
				tmimage.setExtension(FilenameUtils.getExtension(file.getName()));
				tmimage.setSize(new Long(file.length()).toString());
				tmimage.setPath(imageSettings.getImageDefaultPath() + "/" + tmimage.getName() + "." + tmimage.getExtension());
				
				Files.write(Paths.get(tmimage.getPath()), IOUtils.toByteArray(new FileInputStream(file)));
	
				tmimageService.create(tmimage);
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmImage: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmImageFlag = true;
	
		return ", { \"text\":\"Generation data for TmImage is done\" }";
	}

	@Autowired
	private TmMailNewsletterService tmmailnewsletterService;

	public String mockupForTmMailNewsletter() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmMailNewsletter()");
		}
	
		if(TmMailNewsletterFlag){
			return ", { \"text\":\"Data for TmMailNewsletter already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmMailNewsletter tmmailnewsletter = new TmMailNewsletter();
				checkForSentity(tmmailnewsletter, faker);
	
			tmmailnewsletter.setSubject(faker.lorem().fixedString(randBetween(10, 30)));	
			tmmailnewsletter.setContent(faker.lorem().fixedString(randBetween(10, 30)));	
			tmmailnewsletter.setBackgroundColor(faker.lorem().fixedString(randBetween(10, 30)));	
			tmmailnewsletter.setBadge(faker.lorem().fixedString(randBetween(10, 30)));	
			tmmailnewsletter.setBadgeType(faker.lorem().fixedString(randBetween(10, 30)));
	
				tmmailnewsletterService.create(postCheck(tmmailnewsletter, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmMailNewsletter: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmMailNewsletterFlag = true;
	
		return ", { \"text\":\"Generation data for TmMailNewsletter is done\" }";
	}

	@Autowired
	private TmMailNewsletterGroupService tmmailnewslettergroupService;

	public String mockupForTmMailNewsletterGroup() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmMailNewsletterGroup()");
		}
	
		if(TmMailNewsletterGroupFlag){
			return ", { \"text\":\"Data for TmMailNewsletterGroup already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmMailNewsletterGroup tmmailnewslettergroup = new TmMailNewsletterGroup();
				checkForSentity(tmmailnewslettergroup, faker);
	
			tmmailnewslettergroup.setEmail(faker.lorem().fixedString(randBetween(10, 30)));	
			tmmailnewslettergroup.setName(faker.lorem().fixedString(randBetween(10, 30)));
	
				tmmailnewslettergroupService.create(postCheck(tmmailnewslettergroup, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmMailNewsletterGroup: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmMailNewsletterGroupFlag = true;
	
		return ", { \"text\":\"Generation data for TmMailNewsletterGroup is done\" }";
	}

	@Autowired
	private TmUserInfoService tmuserinfoService;

	public String mockupForTmUserInfo() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForTmUserInfo()");
		}
	
		if(TmUserInfoFlag){
			return ", { \"text\":\"Data for TmUserInfo already generated\" }";
		}
		Faker faker = new Faker();
			try {
				TmUserInfo tmuserinfo = new TmUserInfo();
				checkForSentity(tmuserinfo, faker);
	
			tmuserinfo.setBrowser(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setBrowserVersion(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setLastLogin(randomDate());	
			tmuserinfo.setPlatform(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setPlatformversion(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setProxyContent(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setRemoteHost(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setUserAgent(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setUserIpAddress(faker.lorem().fixedString(randBetween(10, 30)));	
			tmuserinfo.setUsername(faker.lorem().fixedString(randBetween(10, 30)));
	
				tmuserinfoService.create(postCheck(tmuserinfo, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating TmUserInfo: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		TmUserInfoFlag = true;
	
		return ", { \"text\":\"Generation data for TmUserInfo is done\" }";
	}

	@Autowired
	private UserDetailService userdetailService;

	public String mockupForUserDetail() {
		if(traceFlag){
			System.out.println("MockupUtil.mockupForUserDetail()");
		}
	
		if(UserDetailFlag){
			return ", { \"text\":\"Data for UserDetail already generated\" }";
		}
		Faker faker = new Faker();
			try {
				UserDetail userdetail = new UserDetail();
				checkForSentity(userdetail, faker);
	
			userdetail.setCompanyName(faker.lorem().fixedString(randBetween(10, 30)));	
			userdetail.setCompanySite(faker.lorem().fixedString(randBetween(10, 30)));
	
				userdetailService.create(postCheck(userdetail, faker));
			} catch (Exception e) {
				e.printStackTrace();
				return ", { \"text\":\"Exception wile creating UserDetail: " + 
						e.getLocalizedMessage() + " \" }";
			}
	
		UserDetailFlag = true;
	
		return ", { \"text\":\"Generation data for UserDetail is done\" }";
	}


	public String init(Integer itemCount) {
		this.itemCount = itemCount;
		String output = "";
		
		setOutput(mockupForCurrCourse());
		setOutput(mockupForCurrCurrency());
		setOutput(mockupForDictGlobal());
		setOutput(mockupForDocDocuments());
		setOutput(mockupForInfoContactInformation());
		setOutput(mockupForInfoPermission());
		setOutput(mockupForLocationAddress());
		setOutput(mockupForLocationCities());
		setOutput(mockupForLocationCountries());
		setOutput(mockupForPaymentDetails());
		setOutput(mockupForPaymentPrice());
		setOutput(mockupForPaymentPriceShop());
		setOutput(mockupForPaymentTariff());
		setOutput(mockupForPaymentTariffShop());
		setOutput(mockupForRelMailNewsletterGroup());
		setOutput(mockupForRelServHotelDocDocuments());
		setOutput(mockupForRelServHotelImage());
		setOutput(mockupForRelServHotelRoomImage());
		setOutput(mockupForRelServTransferTmContact());
		setOutput(mockupForRelShopPermission());
		setOutput(mockupForRelUserDetails());
		setOutput(mockupForReqServHotel());
		setOutput(mockupForServHotel());
		setOutput(mockupForServHotelRoom());
		setOutput(mockupForServTransfer());
		setOutput(mockupForServTransferRoute());
		setOutput(mockupForServTransferRoutePoint());
		setOutput(mockupForShopPermission());
		setOutput(mockupForShopUser());
		setOutput(mockupForTmAccount());
		setOutput(mockupForTmContact());
		setOutput(mockupForTmContactEasy());
		setOutput(mockupForTmFirmSettings());
		setOutput(mockupForTmFirms());
		setOutput(mockupForTmImage());
		setOutput(mockupForTmMailNewsletter());
		setOutput(mockupForTmMailNewsletterGroup());
		setOutput(mockupForTmUserInfo());
		setOutput(mockupForUserDetail());

		
		if (output.length() > 1) {
			return "[ " + output.substring(1) + " ]";
		}
		return "[ Please wait ]";
	}

}