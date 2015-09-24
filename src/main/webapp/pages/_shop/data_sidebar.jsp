<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<div class="sub-cate">
	<div class=" top-nav rsidebar span_1_of_left" ng-class="::{ 'animated bounceInLeft': animation.power }">
		<h5 class="cate">
			<span>Детальный поиск</span>
			<i class="fa fa-search pull-left"></i>
			<!-- <i class="fa fa-times  pull-right"></i> -->
		</h5>
		<div class="menu">
			<form class="form-horizontal small-form">
				<fieldset>
					<div class="form-group">
						<label for="inputName" class="col-md-12 control-label">Название</label>
						<div class="col-md-12">
							<input type="text" class="form-control input-sm" id="inputName" ng-model="customsearch.name"
								placeholder="Введите название отеля">
						</div>
					</div>
					
					<div class="form-group">
						<label for="starSelect" class="col-md-12 control-label">Кол-во звезд</label>
						<div class="col-md-12">
							<select class="form-control input-sm" id="starSelect" ng-model="customsearch.startCount">
								<option>5</option>
								<option>4</option>
								<option>3</option>
								<option>2</option>
								<option>1</option>
							</select>
						</div>
					</div>
					<!-- 
					<div class="form-group">
						<label for="countrySelect" class="col-md-12 control-label">Star count</label>
						<div class="col-md-12">
							<select class="form-control" id="countrySelect" ng-model="customsearch.countryname">
							</select>
						</div>
					</div>
					-->
					
					<div class="form-group">
						<label for="citySelect" class="col-md-12 control-label">Город</label>
						<div class="col-md-12">
						<!-- 
							<select class="form-control input-sm" id="citySelect" ng-model="customsearch.cityname"
								ng-options="item for item in cities">
								ng-options="item for item in cities track by $index" >
								<option ng-repeat="item in ::cities track by $index">{{ ::item }}</option>
							</select>
							 -->
						
							<select class="form-control input-sm" id="citySelect" ng-model="customsearch.cityname"
								ng-options="item for item in cities">
							</select>
							
						</div>
					</div>
					<div class="form-group">
						<label for="textArea" class="col-md-12 control-label">Доп. информация</label>
						<div class="col-md-12">
							<textarea class="form-control input-sm" rows="3" id="textArea" ng-model="customsearch.text"></textarea>
							<span class="help-block small">Введите дополнительную инфомацию для поиска</span>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-12">
							<label class="form-input">
								<input type="checkbox" ng-model="customsearch.freesale" class="small">
								Свободная продажа
							</label>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-12 control-label">Тип поиска</label>
						<div class="col-md-12">
							<div class="radio">
								<label class="form-input"> 
									<input type="radio" name="optionsRadios" value="AND" ng-model="customsearch.dellimitter" checked> 
									Подробный поиск(совпадение всех значений)
								</label>
							</div>
							<div class="radio">
								<label class="form-input"> 
									<input type="radio" name="optionsRadios" value="OR" ng-model="customsearch.dellimitter"> 
									Неточный поиск(любое из значений)
								</label>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-10 col-lg-offset-1">
							<button type="button" class="btn-sm btn btn-primary btn-block" ng-click="customSearch()">
								<span>Поиск</span>
							</button>
						</div>
						<div class="col-md-10 col-lg-offset-1">
							<button type="button" class="btn-sm btn btn-default btn-block" ng-click="clear()">
								<span>Очистить</span>
							</button>
						</div>
					</div>
					
					
					<c:if test="${debug}">
						<div class="form-group">
							<div class="col-md-10 col-lg-offset-1">
								<a target="_blank" class="btn btn-default btn-sm" href="../data/shopservhotel2view">
									JSON DATA
								</a>
							</div>
						</div>
					</c:if>
				</fieldset>
			</form>
		</div>
		</div>
		
		<!-- 
		<ul class="menu">
			<li class="item1"><a href="#">
					Curabitur sapien<img class="arrow-img" src="images/arrow1.png"
						alt="" />
				</a>
				<ul class="cute">
					<li class="subitem1"><a href="product.html">Cute Kittens </a>
					</li>
					<li class="subitem2"><a href="product.html">Strange Stuff
						</a></li>
					<li class="subitem3"><a href="product.html">Automatic
							Fails </a></li>
				</ul></li>
			<li class="item2"><a href="#">
					Dignissim purus <img class="arrow-img " src="images/arrow1.png"
						alt="" />
				</a>
				<ul class="cute">
					<li class="subitem1"><a href="product.html">Cute Kittens </a>
					</li>
					<li class="subitem2"><a href="product.html">Strange Stuff
						</a></li>
					<li class="subitem3"><a href="product.html">Automatic
							Fails </a></li>
				</ul></li>
			<li class="item3"><a href="#">
					Ultrices id du<img class="arrow-img img-arrow"
						src="images/arrow1.png" alt="" />
				</a>
				<ul class="cute">
					<li class="subitem1"><a href="product.html">Cute Kittens </a>
					</li>
					<li class="subitem2"><a href="product.html">Strange Stuff
						</a></li>
					<li class="subitem3"><a href="product.html">Automatic
							Fails</a></li>
				</ul></li>
			<li class="item4"><a href="#">
					Cras iacaus rhone <img class="arrow-img img-left-arrow"
						src="images/arrow1.png" alt="" />
				</a>
				<ul class="cute">
					<li class="subitem1"><a href="product.html">Cute Kittens </a>
					</li>
					<li class="subitem2"><a href="product.html">Strange Stuff
						</a></li>
					<li class="subitem3"><a href="product.html">Automatic
							Fails </a></li>
				</ul></li>
			<li>
				<ul class="kid-menu">
					<li><a href="product.html">Tempus pretium</a></li>
					<li><a href="product.html">Dignissim neque</a></li>
					<li><a href="product.html">Ornared id aliquet</a></li>
				</ul>
			</li>
			<ul class="kid-menu ">
				<li><a href="product.html">Commodo sit</a></li>
				<li><a href="product.html">Urna ac tortor sc</a></li>
				<li><a href="product.html">Ornared id aliquet</a></li>
				<li><a href="product.html">Urna ac tortor sc</a></li>
				<li><a href="product.html">Eget nisi laoreet</a></li>
				<li><a href="product.html">Faciisis ornare</a></li>
				<li class="menu-kid-left"><a href="contact.html">Contact us</a>
				</li>
			</ul>
		</ul>
	</div>
	initiate accordion
	<script type="text/javascript">
		$(function() {
			var menu_ul = $('.menu > li > ul'), menu_a = $('.menu > li > a');
			menu_ul.hide();
			menu_a.click(function(e) {
				e.preventDefault();
				if (!$(this).hasClass('active')) {
					menu_a.removeClass('active');
					menu_ul.filter(':visible').slideUp('normal');
					$(this).addClass('active').next().stop(true, true)
							.slideDown('normal');
				} else {
					$(this).removeClass('active');
					$(this).next().stop(true, true).slideUp('normal');
				}
			});

		});
	</script>
	<div class=" chain-grid menu-chain">
		<a href="single.html">
			<img class="img-responsive chain" src="images/wat.jpg" alt=" " />
		</a>
		<div class="grid-chain-bottom chain-watch">
			<span class="actual dolor-left-grid">300$</span>
			<span class="reducedfrom">500$</span>
			<h6>
				<a href="single.html">Lorem ipsum dolor</a>
			</h6>
		</div>
	</div>
	<a class="view-all all-product" href="product.html">
		VIEW ALL PRODUCTS
		<span> </span>
	</a>
	 -->
</div>