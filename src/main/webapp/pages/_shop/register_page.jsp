<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="container edit-container clean">
	<div class="section-divider section-divider-orange">
		<section class="third">
			<div class="back-holder">
				<a role="button" href="#/" class="btn btn-circle-md">
					<i class="fa-3x fa fa-home"></i>
				</a>
				<c:if test="${debug}">
					<a role="button" ng-click="random()" class="btn btn-circle-md">
						<i class="fa-3x  fa fa-random"></i>
					</a>
				</c:if>
			</div>
			<div class="register">
				<tabset class="without-head">
				    <tab active="details.tabs.physicalPerson">
				    	<div class="animated fadeInLeft">
					    	<form name="formRegisterPhysicalPerson" novalidate ng-submit="validateItem(formRegisterPhysicalPerson)" ng-class="details.showHints">
								<div class="register-top-grid">
									<h3><spring:message code="default.personal-information" /></h3>
									<div class="mation">
										<span> <spring:message code="default.first-name" /><label>*</label> </span>
										<input type="text" ng-model="item.firstname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
					
										<span> <spring:message code="default.last-name" /><label>*</label> </span>
										<input type="text" ng-model="item.lastname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
					
										<span> <spring:message code="default.email-address" /><label>*</label> </span>
										<input type="email" name="email" ng-model="item.email" class="form-control" ng-model-options="{ updateOn: 'blur' }" required >
										
										<span> <spring:message code="default.phone-number" /> </span>
										<input type="text" name="phonenumber" ng-model="item.phonenumber" class="form-control" ng-model-options="{ updateOn: 'blur' }" pattern="\d*" maxlength="10">
									</div>
								</div>
								<div class="register-bottom-grid">
									<div class="mation">
										<span> <spring:message code="default.password" /><label>*</label> </span>
										<input type="password" ng-model="item.password" class="form-control" required pattern=".{5,}">
										<span> <spring:message code="default.confirm-password" /><label>*</label> </span>
										<input type="password" ng-model="details.repassword" class="form-control" required re-enter-password="item.password">
									</div>
								</div>
								<div class="register-but">
									<button type="submit" ng-click="saveItem(formRegisterPhysicalPerson)" class="btn-sm btn btn-submit">
										<span> <spring:message code="default.submit" /> </span>
									</button>
								</div>
							</form>
						</div>
				    </tab>
				    <tab active="details.tabs.corporateCustomer">
				    	<div class="animated fadeInLeft">
					    	<form name="formRegisterCorporateCustomer" novalidate ng-submit="validateItem(formRegisterCorporateCustomer)" ng-class="details.showHints">
								<div class="register-top-grid">
									<h3><spring:message code="default.personal-information" /></h3>
									<div class="mation">
										<span> <spring:message code="default.company-name" /><label>*</label> </span>
										<input type="text" ng-model="details.item.companyname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
									</div>
									<hr class="separator">
									<div class="mation">
										<span> <spring:message code="default.first-name" /><label>*</label> </span>
										<input type="text" ng-model="item.firstname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
					
										<span> <spring:message code="default.last-name" /><label>*</label> </span>
										<input type="text" ng-model="item.lastname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
					
										<span> <spring:message code="default.email-address" /><label>*</label> </span>
										<input type="email" name="email" ng-model="item.email" class="form-control" ng-model-options="{ updateOn: 'blur' }" required >
										
										<span> <spring:message code="default.phone-number" /> </span>
										<input type="text" name="phonenumber" ng-model="item.phonenumber" class="form-control" ng-model-options="{ updateOn: 'blur' }" pattern="\d*" maxlength="10" required>
									</div>
								</div>
								<div class="register-bottom-grid">
									<div class="mation">
										<span> <spring:message code="default.password" /><label>*</label> </span>
										<input type="password" ng-model="item.password" class="form-control" required pattern=".{5,}">
										<span> <spring:message code="default.confirm-password" /><label>*</label> </span>
										<input type="password" ng-model="details.repassword" class="form-control" required re-enter-password="item.password">
									</div>
								</div>
								<div class="register-but">
									<button type="submit" ng-click="saveItem(formRegisterCorporateCustomer)" class="btn-sm btn btn-submit">
										<span> <spring:message code="default.submit" /> </span>
									</button>
								</div>
							</form>
						</div>
				    </tab>
				    <tab active="details.tabs.travelAgency">
				    	<div class="animated fadeInLeft">
					    	<form name="formRegisterTravelAgency" novalidate ng-submit="validateItem(formRegisterTravelAgency)" ng-class="details.showHints">
								<div class="register-top-grid">
									<h3><spring:message code="default.personal-information" /></h3>
									<div class="mation">
										<span> <spring:message code="default.company-name" /><label>*</label> </span>
										<input type="text" ng-model="details.item.companyname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
										<span> <spring:message code="default.company-site" /></span>
										<input type="text" ng-model="details.item.companysite" class="form-control" ng-model-options="{ updateOn: 'blur' }">
									</div>
									<hr class="separator">
									<div class="mation">
										<span> <spring:message code="default.first-name" /><label>*</label> </span>
										<input type="text" ng-model="item.firstname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
					
										<span> <spring:message code="default.last-name" /><label>*</label> </span>
										<input type="text" ng-model="item.lastname" class="form-control" ng-model-options="{ updateOn: 'blur' }" required>
					
										<span> <spring:message code="default.email-address" /><label>*</label> </span>
										<input type="email" name="email" ng-model="item.email" class="form-control" ng-model-options="{ updateOn: 'blur' }" required >
										
										<span> <spring:message code="default.phone-number" /> </span>
										<input type="text" name="phonenumber" ng-model="item.phonenumber" class="form-control" ng-model-options="{ updateOn: 'blur' }" pattern="\d*" maxlength="10" required>
									</div>
								</div>
								<div class="register-bottom-grid">
									<div class="mation">
										<span> <spring:message code="default.password" /><label>*</label> </span>
										<input type="password" ng-model="item.password" class="form-control" required pattern=".{5,}">
										<span> <spring:message code="default.confirm-password" /><label>*</label> </span>
										<input type="password" ng-model="details.repassword" class="form-control" required re-enter-password="item.password">
									</div>
								</div>
								<div class="register-but">
									<button type="submit" ng-click="saveItem(formRegisterTravelAgency)" class="btn-sm btn btn-submit">
										<span> <spring:message code="default.submit" /> </span>
									</button>
								</div>
							</form>
						</div>
				    </tab>
				    
				</tabset>    
				
			</div>
		</section>
		<section class="first pad-50 center">
			<a role="button" class="btn btn-circle-md">
				<i class="fa-3x fa fa-info"></i>
			</a>
			<h2>
				<spring:message code="default.registration.header" />
			</h2>
			<br>
			<p>
				<spring:message code="default.registration.hint" />
			</p>
			<br>
			<div class="btn-group" role="group">
				<button type="button" class="btn-sm btn btn-submit-inverted" ng-click="selectTab(details.tabs, 'physicalPerson')">
					<span><spring:message code="default.physical-person" /></span>
				</button>
				<button type="button" class="btn-sm btn btn-submit-inverted" ng-click="selectTab(details.tabs, 'corporateCustomer')">
					<span><spring:message code="default.corporate-customer" /></span>
				</button>
				<button type="button" class="btn-sm btn btn-submit-inverted" ng-click="selectTab(details.tabs, 'travelAgency')">
					<span><spring:message code="default.travel-agency" /></span>
				</button>
			</div>
			<br>
			<br>
			<br>
			<p collapse="!details.tabs.physicalPerson">
				<spring:message code="default.registration.physical-person.hint" />
			</p>
			<p collapse="!details.tabs.corporateCustomer">
				<spring:message code="default.registration.corporate-customer.hint" />
			</p>
			<p collapse="!details.tabs.travelAgency">
				<spring:message code="default.registration.travel-agency.hint" />
			</p>
		</section>
	</div>
</div>
