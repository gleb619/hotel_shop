package org.test.shop.config.settings;

import java.util.Map;
import java.util.LinkedHashMap;

import org.test.shop.model.domain.entity.*;
import org.test.shop.model.domain.entity.view.*;

public interface RelationSettings {

	public class Items {
		public static final Map<String, Class<?>> map = new LinkedHashMap<String, Class<?>>() {
			private static final long serialVersionUID = -2513169964654898L;
			{
				put("currcourse", CurrCourse.class);
				put("currcurrency", CurrCurrency.class);
				put("dictglobal", DictGlobal.class);
				put("docdocuments", DocDocuments.class);
				put("infocontactinformation", InfoContactInformation.class);
				put("infopermission", InfoPermission.class);
				put("locationaddress", LocationAddress.class);
				put("locationcities", LocationCities.class);
				put("locationcountries", LocationCountries.class);
				put("paymentdetails", PaymentDetails.class);
				put("paymentprice", PaymentPrice.class);
				put("paymentpriceshop", PaymentPriceShop.class);
				put("paymenttariff", PaymentTariff.class);
				put("paymenttariffshop", PaymentTariffShop.class);
				put("relmailnewslettergroup", RelMailNewsletterGroup.class);
				put("relservhoteldocdocuments", RelServHotelDocDocuments.class);
				put("relservhotelimage", RelServHotelImage.class);
				put("relservhotelroomimage", RelServHotelRoomImage.class);
				put("relservtransfertmcontact", RelServTransferTmContact.class);
				put("relshoppermission", RelShopPermission.class);
				put("reluserdetails", RelUserDetails.class);
				put("reqservhotel", ReqServHotel.class);
				put("servhotel", ServHotel.class);
				put("servhotelroom", ServHotelRoom.class);
				put("servtransfer", ServTransfer.class);
				put("servtransferroute", ServTransferRoute.class);
				put("servtransferroutepoint", ServTransferRoutePoint.class);
				put("shoppermission", ShopPermission.class);
				put("shopuser", ShopUser.class);
				put("tmaccount", TmAccount.class);
				put("tmcontact", TmContact.class);
				put("tmcontacteasy", TmContactEasy.class);
				put("tmfirms", TmFirms.class);
				put("tmfirmsettings", TmFirmSettings.class);
				put("tmimage", TmImage.class);
				put("tmmailnewsletter", TmMailNewsletter.class);
				put("tmmailnewslettergroup", TmMailNewsletterGroup.class);
				put("tmuserinfo", TmUserInfo.class);
				put("userdetail", UserDetail.class);
				put("userroles", UserRoles.class);
				put("users", Users.class);
				put("currcourseview", CurrCourseView.class);
				put("currcurrencyview", CurrCurrencyView.class);
				put("dictglobalview", DictGlobalView.class);
				put("docdocumentsview", DocDocumentsView.class);
				put("infocontactinformationview", InfoContactInformationView.class);
				put("infopermissionview", InfoPermissionView.class);
				put("locationaddressview", LocationAddressView.class);
				put("locationcitiesview", LocationCitiesView.class);
				put("locationcountriesview", LocationCountriesView.class);
				put("mailnotebookview", MailNotebookView.class);
				put("paymentdetailsview", PaymentDetailsView.class);
				put("paymentpriceshopsimpleview", PaymentPriceShopSimpleView.class);
				put("paymentpriceshopview", PaymentPriceShopView.class);
				put("paymentpricesimpleview", PaymentPriceSimpleView.class);
				put("paymentpriceview", PaymentPriceView.class);
				put("paymenttariffshopsimpleview", PaymentTariffShopSimpleView.class);
				put("paymenttariffshopview", PaymentTariffShopView.class);
				put("paymenttariffsimpleview", PaymentTariffSimpleView.class);
				put("paymenttariffview", PaymentTariffView.class);
				put("relmailnewslettergroupview", RelMailNewsletterGroupView.class);
				put("relservhoteldocdocumentsview", RelServHotelDocDocumentsView.class);
				put("relservhotelimagesimpleview", RelServHotelImageSimpleView.class);
				put("relservhotelimageview", RelServHotelImageView.class);
				put("relservhotelroomimagesimpleview", RelServHotelRoomImageSimpleView.class);
				put("relservhotelroomimageview", RelServHotelRoomImageView.class);
				put("relservtransfertmcontactview", RelServTransferTmContactView.class);
				put("relshoppermissionview", RelShopPermissionView.class);
				put("reluserdetailsview", RelUserDetailsView.class);
				put("reqservhotelarchivedview", ReqServHotelArchivedView.class);
				put("reqservhotelopenview", ReqServHotelOpenView.class);
				put("reqservhotelprocessedview", ReqServHotelProcessedView.class);
				put("reqservhotelview", ReqServHotelView.class);
				put("servhotelroomview", ServHotelRoomView.class);
				put("servhotelsimpleview", ServHotelSimpleView.class);
				put("servhotelview", ServHotelView.class);
				put("servtransferroutepointview", ServTransferRoutePointView.class);
				put("servtransferrouteview", ServTransferRouteView.class);
				put("servtransferview", ServTransferView.class);
				put("shophotelimagesview", ShopHotelImagesView.class);
				put("shophotelroomimagesview", ShopHotelRoomImagesView.class);
				put("shoppermissionview", ShopPermissionView.class);
				put("shoproomtarriffcorporaterateview", ShopRoomTarriffCorporateRateView.class);
				put("shoproomtarriffgeneralrateview", ShopRoomTarriffGeneralRateView.class);
				put("shoproomtarrifforiginalrateview", ShopRoomTarriffOriginalRateView.class);
				put("shoproomview", ShopRoomView.class);
				put("shopservhotel2view", ShopServHotel2View.class);
				put("shopuserview", ShopUserView.class);
				put("staticgeolocationview", StaticGeoLocationView.class);
				put("tmaccountview", TmAccountView.class);
				put("tmcontacteasyview", TmContactEasyView.class);
				put("tmcontactview", TmContactView.class);
				put("tmfirmsettingsview", TmFirmSettingsView.class);
				put("tmfirmsview", TmFirmsView.class);
				put("tmimageview", TmImageView.class);
				put("tmmailnewslettergroupview", TmMailNewsletterGroupView.class);
				put("tmmailnewsletterview", TmMailNewsletterView.class);
				put("tmuserinfoview", TmUserInfoView.class);
				put("userdetailview", UserDetailView.class);
				put("userregistrationrequestview", UserRegistrationRequestView.class);
				put("userrolesview", UserRolesView.class);
				put("usersview", UsersView.class);;
			}
		};
	}
	
}
