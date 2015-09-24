<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4 col-md-3">
			<h1><spring:message code="default.condition-text" /></h1>
        	<hr class="separator">
	        <p><spring:message code="default.condition-text-hint" /></p>
	        <c:if test="${debug}">
	        	<hr class="separator">
	        	<p><spring:message code="default.condition-text-hint-debug" /></p>
	        	<button type="button" class="btn btn-default" wz-next>
					<span><spring:message code="default.agree" /></span>
				</button>
	        </c:if>
        	<hr class="separator visible-xs">
		</div>
		<div class="col-sm-8 col-md-9">
			<div class="scrollable-pane">
				<div>
					<%-- 
					<c:if test="${!debug}">
						<p ng-bind-html="item.conditionText"></p>
					</c:if>
					<c:if test="${debug}">
						<p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget elit in ante aliquam sollicitudin eget a eros. Curabitur urna erat, eleifend id sollicitudin eu, ullamcorper et mi. Fusce commodo eu mi venenatis porttitor. Aenean iaculis turpis quam, sed aliquet risus sollicitudin in. In libero lacus, blandit eu lorem ac, consectetur dignissim eros. Nam auctor, neque vel condimentum ornare, mauris felis feugiat sapien, non tincidunt leo tellus sed libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam aliquam, nunc in viverra mollis, erat orci commodo mi, id blandit erat ipsum in augue. Nam elit ipsum, volutpat eu facilisis eget, semper nec magna. Nam augue risus, scelerisque commodo ultricies eu, rhoncus ut mauris. Interdum et malesuada fames ac ante ipsum primis in faucibus.  Nulla neque neque, elementum eget facilisis eget, imperdiet ut arcu. Ut eu eros blandit, elementum orci at, pretium metus. Nulla nisl turpis, tempor sed pharetra nec, cursus ut nisl. Integer ut enim tortor. Suspendisse id faucibus arcu. Nulla ac laoreet erat. Pellentesque id dictum libero, at interdum tortor. Donec pellentesque est vitae pulvinar fermentum. Suspendisse urna sem, porttitor nec leo non, placerat facilisis quam.  Quisque a egestas ipsum, non ullamcorper magna. Donec feugiat orci odio, eu pellentesque quam tincidunt sed. Sed mi tellus, mattis eu finibus vel, aliquam vulputate felis. Curabitur elit lacus, semper eu viverra vitae, vehicula nec leo. Etiam vitae lectus in nulla lacinia rutrum a non urna. Sed volutpat tempor nibh, vitae cursus arcu. Donec risus nibh, eleifend id odio sit amet, euismod auctor nisl. Nam sit amet erat sagittis, sodales odio ut, pulvinar tellus. Suspendisse pharetra vehicula pellentesque. Pellentesque eu ullamcorper sapien, eu consequat ante. Nunc malesuada euismod tortor a suscipit. In facilisis gravida mollis. Vestibulum purus mi, volutpat eget eleifend quis, vulputate semper ligula. Curabitur enim turpis, lobortis molestie quam a, mattis maximus elit.  Proin dui enim, suscipit at massa at, finibus ullamcorper nibh. Fusce feugiat blandit tortor, in dictum turpis laoreet id. Curabitur lectus ex, feugiat sit amet orci sit amet, dignissim malesuada nulla. Mauris pellentesque lorem quis tincidunt congue. Curabitur aliquam lectus tortor, ut ultrices nisi eleifend ut. Maecenas laoreet eros ac nunc blandit, sed bibendum tortor bibendum. Integer accumsan nisl at condimentum cursus. Donec ut suscipit diam. Proin mollis augue at diam consectetur tempor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc tincidunt auctor quam a vestibulum. Etiam sit amet tempus massa. Nullam rutrum dui nec elit hendrerit consequat. Duis eleifend elit ac felis feugiat, in facilisis enim accumsan. Maecenas quis purus nec massa rhoncus tincidunt ullamcorper nec felis. Nullam tempor lacus quis sagittis malesuada.  Phasellus sodales porta dolor vitae semper. Duis lectus est, pretium at eros vel, dapibus imperdiet est. Duis quis lacus sed nisl congue ultricies. Phasellus semper ipsum vel ipsum facilisis malesuada. Nulla efficitur vulputate nisi a semper. Praesent dictum nibh vel diam bibendum viverra. Curabitur a mauris diam. Aliquam in metus et leo volutpat blandit id at sem. </p>
					</c:if>
					 --%>
					<p ng-bind-html="item.conditionText"></p>
				</div>
			</div>
			<br>
			<hr class="separator">
			<div class="row">
				<div class="col-md-12">
					<label>
						<input type="checkbox" ng-model="details.conditionagree">
						<span><spring:message code="default.agree-with-conditions2" /></span>
					</label>
				</div>
				<div class="col-md-8 col-md-offset-2 center">
					<button type="button" class="btn btn-danger" ng-click="finalCancel()" wz-cancel>
						<span><spring:message code="default.disagree" /></span>
					</button>
					<button type="button" class="btn btn-success" wz-next ng-disabled="!details.conditionagree">
						<span><spring:message code="default.agree" /></span>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>