<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="container">
	<div class="account_grid">
		<div class="login-right">
			<h3>Зарегистрированные клиенты</h3>
			<p>Если у вас есть аккаунт у нас, пожалуйста, войдите.</p>
			<form role="form" method="POST" action="<c:url value='/login'/>" id="loginform" name="loginform">
				<div>
					<span>
						Адрес Электронной Почты<label>*</label>
					</span>
					<input type="text" id="username" name="username" placeholder="<spring:message code="default.email"/>" >
				</div>
				<div>
					<span>
						Пароль<label>*</label>
					</span>
					<input id="password" name="password" type="password" placeholder="<spring:message code="default.password"/>">
				</div>
				<input type="submit" value="Войти">
				<a class="forgot" href="#">Забыли Пароль?</a>
			</form>
			<div class="sending">
				<span>Отправка...</span>
			</div>
		</div>
		<div class="login-left">
			<h3>НОВЫЕ КЛИЕНТЫ</h3>
			<p>Создавая учетную запись в нашем магазине, вы сможете пройти через процесс оформления заказа быстрее, хранить несколько адресов доставки, просматривать и отслеживать заказы в вашем аккаунте и более.</p>
			<a class="acount-btn" href="#/register_page">Создать аккаунт</a>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
	
	<script>
		$(function() {
			$("#loginform").on("submit", function(e) {
				e.preventDefault();
				$.ajax({
					url : $(this).attr("action"),
					type : 'POST',
					data : $(this).serialize(),
					beforeSend : function() {
						$(".sending").show();
						$("#loginform").hide();
					},
					success : function(data) {
						location.reload();
					},
					error: function(error) {
						$(".sending").html(error);
					}
				});
			});
		});
	</script>
	
</div>


