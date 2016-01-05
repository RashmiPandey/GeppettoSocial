/**
 * @author Rashmi
 * @date Jan'04 2016
 * 
 */


var app = angular.module("SocialLoginActivity", [ 'facebook','ngRoute', 'ngCookies',
		'ui.bootstrap' ]);

app.config([ '$routeProvider','FacebookProvider', function($routeProvider,FacebookProvider) {
	FacebookProvider.init('1619632164961533');
	$routeProvider.when("/", {
		redirectTo : "/en-US/social"
	}).when("/en-US/social", {
		templateUrl : "app/views/en-US/user/sociallogin.html",
		controller : "LoginCtrl"
	}).when("/en-US/social/success", {
		templateUrl : "app/views/en-US/user/sociallogin_success.html",
		controller : "LoginCtrl"
	}).when("/en-US/social/failure", {
		templateUrl : "app/views/en-US/user/sociallogin_failure.html",
		controller : "LoginCtrl"
	}).otherwise({
		redirectTo : "/en-US/social"
	});
} ]);

app.run([ '$log', function($log) {
	$log.debug("Started loading the application.!");
} ]);