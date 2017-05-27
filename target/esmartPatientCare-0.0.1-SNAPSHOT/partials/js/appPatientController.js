var crmPatient = angular.module('esmartPatient');
crmPatient.controller('patientCntrl', ['$scope','patientService','authService',function($scope,patientService,authService) {
	console.log('token in patinet cntrol from scope is'+$scope.tokenKey);
	console.log("data from is "+authService.tokenKey);
	patientService.getAllPatients($scope.tokenKey, function(resp) {
		console.log('resp came from patinet service '+resp);
		$scope.patientList = JSON.parse(resp);
	});
}]);

crmPatient.controller('deletePatientCntrl', ['$scope','$routeParams',function($scope,$routeParams) {
	console.log('patient Id in Patient controller '+$routeParams.patientId);
}]);


