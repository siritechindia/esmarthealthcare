var crm = angular.module('esmartPatientCare',['ngRoute']);


crm.config(["$routeProvider","$locationProvider",function($routeProvider,$locationProvider) {

	//$httpProvider.interceptors.push('httpRequestInterceptor');
	
	$locationProvider.hashPrefix('');
	$routeProvider.when('/getLogin', {
		templateUrl: "partials/login.html",
		controller: "authCntrl"
	}).when('/getSignUp', {
		templateUrl: "partials/signUp.html"
	}).when('/getAboutUs', {
		templateUrl: "partials/aboutUs.html"
	}).when('/getContactUs', {
		templateUrl: "partials/contact.html"
	}).when('/getHomePage', {
		templateUrl: "index.html"
	}).when('/loginSuccess', {
		templateUrl: "partials/patientDashBoard.html",
		controller: "patientCntrl"
	}).when('/deletePatient/:patientId', {
		templateUrl: "partials/patientDashBoard.html",
		controller: "deletePatientCntrl"
	}).when('/getOutPatient', {
		templateUrl: "patientDetails.html",
		controller: "patientCntrl"
		
	}).when('/secure', {
		templateUrl: "partials/patientDashBoard.html"
	}).when('/getOutPatient', {
		templateUrl: "patientDetails.html",
		controller: "patientCntrl"
	});
}]);


