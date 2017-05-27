var crm = angular.module('esmartPatientCare');

crm.config(["$routeProvider","$locationProvider",'$httpProvider',function($routeProvider,$locationProvider,$httpProvider) {
	
	$httpProvider.interceptors.push('httpRequestInterceptor');
	
$locationProvider.hashPrefix('');
	$routeProvider.when('/getOutPatient', {
		templateUrl: "patientDetails.html",
		controller: "patientCntrl"
		
	}).when('/secure', {
		templateUrl: "partials/patientDashBoard.html"
	});
}]);

crm.factory('httpRequestInterceptor', function($q) {
	return{
	  request:function(config){
		  console.log('request started....'+config.url);
		  console.log('config object is'+JSON.stringify(config));
		  if (config.url.indexOf('.html') === -1 && config.url.toLowerCase().indexOf('http') !== 0) {
              //config.url = gateKeeper.baseUrl + config.url;
			  console.log('config.url....'+config.url);
          }
		  return config;
	  }	,
	  requestError:function(rejection){
		  console.log('rejected');
		  $q.reject(rejection);
	  },
	  response: function(result){
		  console.log('data for '+JSON.stringify(result)+' was recieved');
	  },
	  responseError:function(resp){
		  console.log('response error started');
		  $q.reject(resp);
	  }
	};
});