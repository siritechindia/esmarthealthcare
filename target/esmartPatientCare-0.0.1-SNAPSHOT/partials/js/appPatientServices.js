var crmPatient = angular.module('esmartPatient');
crmPatient.service('patientService', ['$http',function($http) {
	console.log('i am in patient service');
	return({
		getAllPatients: function(token, cb){
			var url = 'http://localhost:9090/esmartPatientCare/services/patientService/getAllPatients';
			$http.get(url, {
				headers: {
					'X-Authorization':'bearer '+token
				}
			}).then(function(resp){
				console.log('resp is '+JSON.stringify(resp.data));
				return cb(JSON.stringify(resp.data));
			},function(err){
				console.log('resp is '+JSON.stringify(err.data));
			});
			
		}
	});
}]);

