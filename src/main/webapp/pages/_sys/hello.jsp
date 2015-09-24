<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="resources/images/favicon.png" type="image/x-icon">
	<script type="text/javascript"
		src="../resources/js/jquery/lorem-ipsum.js"></script>
	<title>Main Page</title>
</head>
<body>
	<br />

	<div class="scrollable">
		<div class="scrollable-content section myPanel">
			<div class="jumbotron">
				<h2>
					Title: <label class="ipsum-word"></label>
				</h2>
				<p class="lead">
					Description: <label class="ipsum-word"></label>
				</p>
			</div>

			<c:url value="/login?logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<sec:authorize access="isRememberMe()">
				<h2># This user is login by: "Remember Me Cookies".</h2>
			</sec:authorize>

			<sec:authorize access="isFullyAuthenticated()">
				<h2># This user is login by: username / password.</h2>
			</sec:authorize>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h2>
					# User: ${pageContext.request.userPrincipal.name} | <a
						href="javascript:formSubmit()"> Logout</a>
				</h2>
			</c:if>

			<div class="row marketing">

		<div class="col-lg-6">
			<h4><a href="#/CurrcourseList">Currcourse</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/CurrcurrencyList">Currcurrency</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictadvertList">Dictadvert</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DictairlinecompanyList">Dictairlinecompany</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictbanksList">Dictbanks</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictcabinscategoryList">Dictcabinscategory</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DictgiftList">Dictgift</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictglobalList">Dictglobal</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictmealsList">Dictmeals</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DictorderstatusList">Dictorderstatus</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictpaymentmethodList">Dictpaymentmethod</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DictplacementList">Dictplacement</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DictservicesidentificatorList">Dictservicesidentificator</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttransportList">Dicttransport</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypeairList">Dicttypeair</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DicttypebugList">Dicttypebug</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypebusyList">Dicttypebusy</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypedocList">Dicttypedoc</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DicttypeinsuranceList">Dicttypeinsurance</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypemessageList">Dicttypemessage</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypeplaneList">Dicttypeplane</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DicttyperoomList">Dicttyperoom</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypetouristList">Dicttypetourist</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypetrainList">Dicttypetrain</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/DicttypetransferList">Dicttypetransfer</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DicttypevisaList">Dicttypevisa</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/DocdocumentsList">Docdocuments</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/GroupaccountList">Groupaccount</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/GroupcontactList">Groupcontact</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/GroupglobalList">Groupglobal</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/GrouphotelroomsList">Grouphotelrooms</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/GrouptourList">Grouptour</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/LocationcitiesList">Locationcities</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/LocationcountriesList">Locationcountries</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/LogList">Log</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/PaymentaccountList">Paymentaccount</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/PaymentaccountrecordList">Paymentaccountrecord</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/PaymentcontactList">Paymentcontact</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/PaymentcontactrecordList">Paymentcontactrecord</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/RelaccountcontactsList">Relaccountcontacts</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ReladvertbidList">Reladvertbid</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelcruisecontactsList">Relcruisecontacts</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/RelcruisedocsList">Relcruisedocs</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelcruisehotelsList">Relcruisehotels</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelcruiseservicesList">Relcruiseservices</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/RelhotelroomsbusyList">Relhotelroomsbusy</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelorderclientList">Relorderclient</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelorderdocsList">Relorderdocs</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/RelordergiftList">Relordergift</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelorderhotelsList">Relorderhotels</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/RelorderservicesList">Relorderservices</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/ReltourdocsList">Reltourdocs</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ReltourhotelsList">Reltourhotels</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ReltourservicesList">Reltourservices</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/ServcruiseList">Servcruise</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServexcursionsList">Servexcursions</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServgiftsList">Servgifts</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/ServhotelroomsList">Servhotelrooms</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServhotelsList">Servhotels</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServhotelsresortList">Servhotelsresort</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/ServinsurancesList">Servinsurances</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServticketsairList">Servticketsair</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServticketsrailList">Servticketsrail</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/ServtourList">Servtour</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServtransfersList">Servtransfers</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/ServvisasList">Servvisas</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/TmaccountaddressesList">Tmaccountaddresses</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmaccountcommunicationsList">Tmaccountcommunications</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmaccountdetailsList">Tmaccountdetails</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/TmaccountsList">Tmaccounts</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmadvertList">Tmadvert</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmcontactaddressesList">Tmcontactaddresses</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/TmcontactcommunicationsList">Tmcontactcommunications</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmcontactsList">Tmcontacts</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmfirmsList">Tmfirms</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/TmincidentsList">Tmincidents</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmorderList">Tmorder</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/TmuserinfoList">Tmuserinfo</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">
			<h4><a href="#/TmusersList">Tmusers</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/UserrolesList">Userroles</a></h4>
			<div class="ipsum"/>

			<h4><a href="#/UsersList">Users</a></h4>
			<div class="ipsum"/>

		</div>
		<div class="col-lg-6">		</div>

			</div><!-- End of marketing -->
		</div><!-- End of scrollable-content -->
	</div><!-- End of scrollable -->

	<script type="text/javascript">
		$(document).ready(function() {
			$('.ipsum').lorem({
				type : 'paragraphs',
				amount : '1',
				ptags : true
			});
			$('.ipsum-word').lorem({
				type : 'words',
				amount : '2',
				ptags : true
			});

		});
		
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
</body>
</html>