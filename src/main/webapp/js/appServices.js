//var crm = angular.module('esmartPatientCare');

/*
 *This login Service will get the user inputted data from controller
 *and making an ajax call to the backed web service by passing these data as
 *an input. once the service will give the success response , then the service 
 *will get the response data and pass it back to the controller where controller
 *will hold this data iin $scope object so that the data will be ready for rrendering
 *in the respective view pages as two-way binding is possible.  

 This is changinging to check the grunt watch
*/

crm.service('authService', ['$http',function($http) {
	return({
		authenticate:function(username,password,cb){
			console.log('user name in service is '+username);
			console.log('password in service is '+password);
			var tokenKey = '';
			var data = 
					{
					    "userName": username,
					    "password": password
					};
			
			$http.post('https://morning-citadel-72344.herokuapp.com/services/authenticationService/authenticateUser',
					data, 
					{
				      headers: {
				    	  'Content-Type':'application/x-www-form-urlencoded'
				      },
				      transformRequest: function(data){
				    	  return $.param(data);
				      }
					})
			.then(function(resp){
				
				console.log('success resp '+JSON.stringify(resp.data));
				tokenKey = resp.data.authMessage;
				console.log('tokenKey in auth service is '+tokenKey);
				return cb(resp.data.authMessage);
			},function(err){
				console.log('err resp '+JSON.stringify(err.data));
				return cb(err.data.authMessage);
			});
		}
	});
}    
]);

