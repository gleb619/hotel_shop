<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Single :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/etalage.css" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); 
	 function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script src="js/jquery.min.js"></script>

<script src="js/jquery.etalage.min.js"></script>
<script>
	jQuery(document).ready(function($) {  
		$('#etalage') .etalage({
			thumb_image_width : 300,
			thumb_image_height : 400,
			source_image_width : 900,
			source_image_height : 1200,
			show_hint : true,
			click_callback : function(
					image_anchor, instance_id) {
				alert('Callback example:\nYou clicked on an image with the anchor: "'
						+ image_anchor
						+ '"\n(in Etalage instance: "'
						+ instance_id + '")');
			}
		});
	});
</script>

</head>
<body>
	<!--header-->
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-left">
					<ul class="support">
						<li>
							<a href="#">
								<label> </label>
							</a>
						</li>
						<li>
							<a href="#">
								24x7 live
								<span class="live"> support</span>
							</a>
						</li>
					</ul>
					<ul class="support">
						<li class="van">
							<a href="#">
								<label> </label>
							</a>
						</li>
						<li>
							<a href="#">
								Free shipping
								<span class="live">on order over 500</span>
							</a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="top-header-right">
					<div class="down-top">
						<select class="in-drop">
							<option value="English" class="in-of">English</option>
							<option value="Japanese" class="in-of">Japanese</option>
							<option value="French" class="in-of">French</option>
							<option value="German" class="in-of">German</option>
						</select>
					</div>
					<div class="down-top top-down">
						<select class="in-drop">

							<option value="Dollar" class="in-of">Dollar</option>
							<option value="Yen" class="in-of">Yen</option>
							<option value="Euro" class="in-of">Euro</option>
						</select>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="index.html">
							<img src="images/logo.png" alt=" " />
						</a>
					</div>
					<div class="search">
						<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
						<input type="submit" value="SEARCH">

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="header-bottom-right">
					<div class="account">
						<a href="login.html">
							<span> </span>
							YOUR ACCOUNT
						</a>
					</div>
					<ul class="login">
						<li>
							<a href="login.html">
								<span> </span>
								LOGIN
							</a>
						</li>
						|
						<li>
							<a href="register.html">SIGNUP</a>
						</li>
					</ul>
					<div class="cart">
						<a href="#">
							<span> </span>
							CART
						</a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---->
	<!-- Main container -->
	<div class="container">

		<div class=" single_top">
			<div class="single_grid">
				<!-- Images container -->
				<div class="grid images_3_of_2">
					<ul id="etalage">
						<li>
							<a href="optionallink.html">
								<img class="etalage_thumb_image" src="images/s4.jpg" class="img-responsive" /> 
								<img class="etalage_source_image" src="images/si4.jpg" class="img-responsive" title="" />
							</a>
						</li>
						<li>
							<img class="etalage_thumb_image" src="images/s2.jpg" class="img-responsive" /> 
							<img class="etalage_source_image" src="images/si2.jpg" class="img-responsive" title="" />
						</li>
						<li>
							<img class="etalage_thumb_image" src="images/s3.jpg" class="img-responsive" /> 
							<img class="etalage_source_image" src="images/si3.jpg" class="img-responsive" />
						</li>
						<li>
							<img class="etalage_thumb_image" src="images/s1.jpg" class="img-responsive" /> 
							<img class="etalage_source_image" src="images/si1.jpg" class="img-responsive" />
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<!-- Images container -->
				
				<!-- Description pane -->
				<div class="desc1 span_3_of_2">

					<h4>Lorem ipsum dolor sit amet, consectetur adipisicing elit</h4>
					<div class="cart-b">
						<div class="left-n ">$329.58</div>
						<a class="now-get get-cart-in" href="#">ADD TO CART</a>
						<div class="clearfix"></div>
					</div>
					<h6>100 items in stock</h6>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
						dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
						commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
						pariatur.</p>
					<div class="share">
						<h5>Share Product :</h5>
						<ul class="share_nav">
							<li>
								<a href="#">
									<img src="images/facebook.png" title="facebook">
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/twitter.png" title="Twiiter">
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/rss.png" title="Rss">
								</a>
							</li>
							<li>
								<a href="#">
									<img src="images/gpluse.png" title="Google+">
								</a>
							</li>
						</ul>
					</div>


				</div>
				<!-- Description pane -->
				
				<div class="clearfix"></div>
			</div>
			
			<!-- Commercial -->
			<ul id="flexiselDemo1">
				<li>
					<img src="images/pi.jpg" />
					<div class="grid-flex">
						<a href="#">Bloch</a>
						<p>Rs 850</p>
					</div>
				</li>
				<li>
					<img src="images/pi1.jpg" />
					<div class="grid-flex">
						<a href="#">Capzio</a>
						<p>Rs 850</p>
					</div>
				</li>
				<li>
					<img src="images/pi2.jpg" />
					<div class="grid-flex">
						<a href="#">Zumba</a>
						<p>Rs 850</p>
					</div>
				</li>
				<li>
					<img src="images/pi3.jpg" />
					<div class="grid-flex">
						<a href="#">Bloch</a>
						<p>Rs 850</p>
					</div>
				</li>
				<li>
					<img src="images/pi4.jpg" />
					<div class="grid-flex">
						<a href="#">Capzio</a>
						<p>Rs 850</p>
					</div>
				</li>
			</ul>
			<!-- Commercial -->
			

			<!-- Condition text -->
			<div class="toogle">
			<!-- Condition text -->
				<h3 class="m_3">Product Details</h3>
				<p class="m_text">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod
					tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
					ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit
					in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et
					iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam
					liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim
					assum.</p>
			</div>
			
		</div>

		<!---->
		
		<div class="clearfix"></div>
	</div>
	<!---->
	
	<!-- Footer -->
	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="latter">
					<h6>NEWS-LETTER</h6>
					<div class="sub-left-right">
						<form>
							<input type="text" value="Enter email here" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Enter email here';}" /> <input type="submit" value="SUBSCRIBE" />
						</form>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="latter-right">
					<p>FOLLOW US</p>
					<ul class="face-in-to">
						<li>
							<a href="#">
								<span> </span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="facebook-in"> </span>
							</a>
						</li>
						<div class="clearfix"></div>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="footer-bottom-cate">
					<h6>CATEGORIES</h6>
					<ul>
						<li>
							<a href="#">Curabitur sapien</a>
						</li>
						<li>
							<a href="#">Dignissim purus</a>
						</li>
						<li>
							<a href="#">Tempus pretium</a>
						</li>
						<li>
							<a href="#">Dignissim neque</a>
						</li>
						<li>
							<a href="#">Ornared id aliquet</a>
						</li>
						<li>
							<a href="#">Ultrices id du</a>
						</li>
						<li>
							<a href="#">Commodo sit</a>
						</li>
						<li>
							<a href="#">Urna ac tortor sc</a>
						</li>
						<li>
							<a href="#">Ornared id aliquet</a>
						</li>
						<li>
							<a href="#">Urna ac tortor sc</a>
						</li>
						<li>
							<a href="#">Eget nisi laoreet</a>
						</li>
						<li>
							<a href="#">Faciisis ornare</a>
						</li>
					</ul>
				</div>
				<div class="footer-bottom-cate bottom-grid-cat">
					<h6>FEATURE PROJECTS</h6>
					<ul>
						<li>
							<a href="#">Curabitur sapien</a>
						</li>
						<li>
							<a href="#">Dignissim purus</a>
						</li>
						<li>
							<a href="#">Tempus pretium</a>
						</li>
						<li>
							<a href="#">Dignissim neque</a>
						</li>
						<li>
							<a href="#">Ornared id aliquet</a>
						</li>
						<li>
							<a href="#">Ultrices id du</a>
						</li>
						<li>
							<a href="#">Commodo sit</a>
						</li>
					</ul>
				</div>
				<div class="footer-bottom-cate">
					<h6>TOP BRANDS</h6>
					<ul>
						<li>
							<a href="#">Curabitur sapien</a>
						</li>
						<li>
							<a href="#">Dignissim purus</a>
						</li>
						<li>
							<a href="#">Tempus pretium</a>
						</li>
						<li>
							<a href="#">Dignissim neque</a>
						</li>
						<li>
							<a href="#">Ornared id aliquet</a>
						</li>
						<li>
							<a href="#">Ultrices id du</a>
						</li>
						<li>
							<a href="#">Commodo sit</a>
						</li>
						<li>
							<a href="#">Urna ac tortor sc</a>
						</li>
						<li>
							<a href="#">Ornared id aliquet</a>
						</li>
						<li>
							<a href="#">Urna ac tortor sc</a>
						</li>
						<li>
							<a href="#">Eget nisi laoreet</a>
						</li>
						<li>
							<a href="#">Faciisis ornare</a>
						</li>
					</ul>
				</div>
				<div class="footer-bottom-cate cate-bottom">
					<h6>OUR ADDERSS</h6>
					<ul>
						<li>Aliquam metus dui.</li>
						<li>orci, ornareidquet</li>
						<li>ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
						<li class="temp">
							<p class="footer-class">
								Design by
								<a href="http://w3layouts.com/" target="_blank">W3layouts</a>
							</p>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- Footer -->
</body>
</html>