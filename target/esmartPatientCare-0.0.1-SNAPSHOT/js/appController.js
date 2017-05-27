var crm = angular.module('esmartPatientCare');
var tokenKey = null;
/*
This LoginController will get the data ssubitted 
from login.html and making a call to service 
by submitting this data
*/
crm.controller('authCntrl', ['$scope','$window','$location','authFactory',function($scope,$window,$location,authFactory) {
	console.log("i am in login controller");
	$scope.login = function(){
		this.accessToken = '';
		var userName = $scope.uname;
		var userPass = $scope.upass;
		console.log("user name is "+userName);
		console.log("password is "+userPass);
		if(userName != null && userPass != null){
			authFactory.authenticate(userName,userPass,function(resp){
				console.log("response in contr "+resp);
				/*$scope.token = resp;*/
				//$rootScope.tokenKey = resp;
				accessToken = resp;
				console.log('accessToken is '+accessToken);
				if(accessToken != null){
					//$rootScope.contextPath='http://localhost:9090/esmartPatientCare';
					//$location.path('/secure');
					
					$scope.$apply(function () {
			            $scope.tokenKey = accessToken;
			        });
					$window.location.href='./#/secure';
					
					//$location.path('/secure')
				}else{
					$scope.isLoginFailed=true;
					$location.path('/getLogin');
				}
			});
		}else{
			//$scope.isLoginFailed=true;
			$location.path('/getLogin');
		}
			
			
		
	};
}]);


