
var crm = angular.module('esmartPatientCare',[]);

crm.controller('testCntrl',['$scope','$parse','$interpolate',function($scope,$parse,$interpolate){
	
	 $scope.a = "10";
	 $scope.b = "20";
	 
	$scope.sum = function(){
	  /*
	  $scope.c=Number($scope.a)+Number($scope.b);
*/	    
		//$scope.c=$scope.$eval("a*b");
		
		/*var func = $parse("a*b");
		$scope.c= func($scope);*/
		
		/*$scope.b = $parse("b").assign($scope,"30");
		var func = $parse("a*b");
		$scope.c= func($scope);*/
		
		var func = $interpolate("a*b");
		$scope.c= func($scope);
		
		
	};
	
	setTimeout(() => {
		$scope.message = "your session has been expired";
	   alert($scope.message);
	   $scope.$digest();
	   
	}, 10000);
	/*$scope.getMessage = function(){
		setTimeout(() => {
			$scope.message = "your session has been expired";
		   alert($scope.message);
		   $scope.$digest();
		}, 2000);
	};*/
	
	
		
}]);

nonAngularSum = function(){
	var scope = angular.element($('#applyId')).scope();
	var a = scope.a;
	  var b = scope.b;
	  scope.c=Number(scope.a)+Number(scope.b);
	  scope.$apply();
};


/*crm.config(["$routeProvider","$locationProvider",function($routeProvider,$locationProvider) {

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
}]);*/

/*crm.controller('testCntrl', ['$rootScope','$scope','$log',function($rootScope,$scope,$log) {
	$scope.a =10;
	$scope.b=20;
	$scope.c=30;
	
*/	
	/*$scope.$watchGroup(['a','b'],function(oldValue,newValue){
		if(oldValue != newValue){
			$scope.c = $scope.a + $scope.b;
		}
	});*/
	
	/*$scope.update = function(){
		$scope.c=$scope.a * 2;
	},*/
	
	/*$scope.$watch('a',function(oldValue,newValue){
		if(oldValue != newValue){
			//$scope.b = $scope.a *10;
			$log.info('digest process for a value changes ');
		}
	});
	
	$scope.$watch('b',function(oldValue,newValue){
		if(oldValue != newValue){
			//$scope.c = $scope.b *10;
			$log.info('digest process for b value changes ');
		}
	});
	
	$scope.$watch('c',function(oldValue,newValue){
		if(oldValue != newValue){
			///$scope.c = $scope.b *10;
			$log.info('digest process for c value changes ');
		}
	});
	
	$rootScope.$watch(function(){
		$log.info('digest process  started ');
	});
	
	$scope.plist = [];
	*//*$scope.patient={
		'pname':'John',
		'Pid':100,
		'mobile':8907654321
	};*/
	
	
	/*$scope.addPatient = function(){
		console.log('i am in add function');
		console.log($scope.patient);
		console.log('collection before modification '+$scope.plist.length);
		
		$scope.plist.push($scope.patient);
		
		
	},
	
	$scope.$watchCollection('plist',function(oldVal,newValue){
		if(oldVal != newValue){
			//$scope.plist.push($scope.patient);
			console.log('collection got modified'+$scope.plist.length);
		}
	});*/
	
	
	
	/*$scope.$watch('patient.mobile',function(oldValue,newValue){
		if(oldValue != newValue){
			$scope.patient.mobile = '+91-'+$scope.patient.mobile;
			console.log('the mobile value got modified '+$scope.patient.mobile);
		}
	},true);
	
	$scope.$watch('patient.mobile', function(oldValue,newValue) {
		if(oldValue != newValue){
			console.log('the mobile value got modified '+$scope.patient.mobile);
		}
	});*/
	
	



