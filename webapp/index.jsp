<html>
<head>
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

</head>
<body class="blue-grey lighten-5">
	<nav class="blue-grey darken-2">
		<div class="nav-wrapper">
			<div class="col s12">
				<a href="#" class="brand-logo"><img src="images/logo-small.png" />PreSale<span
					style="color: #ee6e73" class="badge hide-on-small-only">Beta</span></a>
				<a href="#" data-activates="mobile-options" class="button-collapse"><i
					class="mdi-navigation-menu"></i></a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Trend</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
				<ul class="side-nav" id="mobile-options">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Trend</a></li>
					<li><a href="#">JavaScript</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="row">
		<div class="col m8">
			<p class="flow-text hide-on-small-only">One common flaw we've seen in many
				frameworks is a lack of support for truly responsive text. While
				elements on the page resize fluidly, text still resizes on a fixed
				basis. To ameliorate this problem, for text heavy pages, we've
				created a class that fluidly scales text size and line-height to
				optimize readability for the user. Line length stays between 45-80
				characters and line height scales to be larger on smaller screens.

				To see Flow Text in action, slowly resize your browser and watch the
				size of this text body change! Use the button above to toggle off/on
				flow-text to see the difference!</p>
		</div>
		<div class="col m4 hide-on-small-only">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title">Login</span>
					<div class="row">
						<div class="input-field col s12">
							<input id="username" type="text" class="validate"> <label
								for="username">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="password" type="password" class="validate"> <label
								for="password">Password</label>
						</div>
					</div>
				</div>
				<div class="card-action">
					<button class="btn waves-effect waves-light " type="submit"
						name="action">
						Submit <i class="mdi-content-send right"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="col s12 hide-on-med-and-up">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title">Login</span>
					<div class="row">
						<div class="input-field col s12">
							<input id="username" type="text" class="validate"> <label
								for="username">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="password" type="password" class="validate"> <label
								for="password">Password</label>
						</div>
					</div>
				</div>
				<div class="card-action">
					<button class="btn waves-effect waves-light" type="submit"
						name="action">
						Submit <i class="mdi-content-send right"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".button-collapse").sideNav();
		});
	</script>
</body>
</html>
