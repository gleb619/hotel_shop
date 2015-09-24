<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>    
<div>
	
	<ul class="nav nav-tabs nav-justified">
        <li><a href="index#/"><spring:message code="label.TmOrder" /></a></li>
        <li><a href="index#/"><spring:message code="label.TmContacts" /></a></li>
        <li><a href="index#/"><spring:message code="label.TmAccounts" /></a></li>
        <li><a href="index#/"><spring:message code="label.ServTour" /></a></li>
        <li><a href="index#/"><spring:message code="default.Payment" /></a></li>
        <li><a href="index#/"><spring:message code="default.Services" /></a></li>
        <li class="active"><a data-toggle="tab" href="#dictSection"><spring:message code="default.Dict" /></a></li>
        <li><a href="index#/"><spring:message code="label.TmAdvert" /></a></li>
        <li><a href="index#/"><spring:message code="label.DocDocuments" /></a></li>
    </ul>
    <div class="tab-content">
        <div id="dictSection" class="tab-pane fade in active">
            <tabset type="pills">
		    	
		    	<tab>
					<tab-heading>
				    	<spring:message code="label.DictAdvert" />
				  	</tab-heading>
					
					<div ng-controller="DictAdvertListCtrl">
						<br/>
						<%@ include file="DictadvertList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictAirlineCompany" />
				  	</tab-heading>
					
					<div ng-controller="DictAirlineCompanyListCtrl">
						<br/>
						<%@ include file="DictairlinecompanyList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictBanks" />
				  	</tab-heading>
					
					<div ng-controller="DictBanksListCtrl">
						<br/>
						<%@ include file="DictbanksList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictCabinsCategory" />
				  	</tab-heading>
					
					<div ng-controller="DictCabinsCategoryListCtrl">
						<br/>
						<%@ include file="DictcabinscategoryList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictGift" />
				  	</tab-heading>
					
					<div ng-controller="DictGiftListCtrl">
						<br/>
						<%@ include file="DictgiftList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictGlobal" />
				  	</tab-heading>
					
					<div ng-controller="DictGlobalListCtrl">
						<br/>
						<%@ include file="DictglobalList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictMeals" />
				  	</tab-heading>
					
					<div ng-controller="DictMealsListCtrl">
						<br/>
						<%@ include file="DictmealsList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictOrderStatus" />
				  	</tab-heading>
					
					<div ng-controller="DictOrderStatusListCtrl">
						<br/>
						<%@ include file="DictorderstatusList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictPaymentMethod" />
				  	</tab-heading>
					
					<div ng-controller="DictPaymentMethodListCtrl">
						<br/>
						<%@ include file="DictpaymentmethodList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictPlacement" />
				  	</tab-heading>
					
					<div ng-controller="DictPlacementListCtrl">
						<br/>
						<%@ include file="DictplacementList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictServicesIdentificator" />
				  	</tab-heading>
					
					<div ng-controller="DictServicesIdentificatorListCtrl">
						<br/>
						<%@ include file="DictservicesidentificatorList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTransport" />
				  	</tab-heading>
					
					<div ng-controller="DictTransportListCtrl">
						<br/>
						<%@ include file="DicttransportList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeAir" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeAirListCtrl">
						<br/>
						<%@ include file="DicttypeairList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeBug" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeBugListCtrl">
						<br/>
						<%@ include file="DicttypebugList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeBusy" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeBusyListCtrl">
						<br/>
						<%@ include file="DicttypebusyList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeDoc" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeDocListCtrl">
						<br/>
						<%@ include file="DicttypedocList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeInsurance" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeInsuranceListCtrl">
						<br/>
						<%@ include file="DicttypeinsuranceList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeMessage" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeMessageListCtrl">
						<br/>
						<%@ include file="DicttypemessageList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypePlane" />
				  	</tab-heading>
					
					<div ng-controller="DictTypePlaneListCtrl">
						<br/>
						<%@ include file="DicttypeplaneList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeRoom" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeRoomListCtrl">
						<br/>
						<%@ include file="DicttyperoomList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeTourist" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeTouristListCtrl">
						<br/>
						<%@ include file="DicttypetouristList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeTrain" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeTrainListCtrl">
						<br/>
						<%@ include file="DicttypetrainList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeTransfer" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeTransferListCtrl">
						<br/>
						<%@ include file="DicttypetransferList.jsp"%>
					</div>
				</tab>
				<tab>
					<tab-heading>
				    	<spring:message code="label.DictTypeVisa" />
				  	</tab-heading>
					
					<div ng-controller="DictTypeVisaListCtrl">
						<br/>
						<%@ include file="DicttypevisaList.jsp"%>
					</div>
				</tab>

		    </tabset>
        </div>
    </div>
</div>