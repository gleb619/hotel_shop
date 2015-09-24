$(document).ready(function() {
	console.log('ready');
	setTimeout(function() {
		 console.log('timeout');
		 loadManager();
//		 enter();

	}, 1000);
});

$("#enterUser1").on("click", function() {
	loadUser();
	enter();
});

$("#enterManager_test").on("click", function() {
	loadManager();
	enter();
});

function loadBlah() {
	$("#username").val("blah" + getRandomInt(1, 3));
	$("#password").val("blah");
}

function loadUser() {
	$("#username").val("user1");
	$("#password").val("user1");
}

function loadManager() {
	console.log('manager');
	$("#username").val("root1");
	$("#password").val("root1");
}

function enter() {
	$("#submitBtn").click();
}

function getRandomInt(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}
