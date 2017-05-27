

crm.factory('authFactory', ['$http',function($http) {
	return(
	    {
	    	authenticate:function(username,password,cb){
	    		console.log('user name in Factory is '+username);
				console.log('password in Factory is '+password);
				var tokenKey = '';
				var data = 
						{
						    "userName": username,
						    "password": password
						};
				
				$http.post('http://localhost:9090/esmartPatientCare/services/authenticationService/authenticateUser',
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
					console.log('tokenKey in auth Factory is '+tokenKey);
					return cb(resp.data.authMessage);
				},function(err){
					console.log('err resp '+JSON.stringify(err.data));
					return cb(err.data.authMessage);
				});
	    		
	    	}
	    });
	
}]);