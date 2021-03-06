/**
 * 
 */
package com.siri.crm.patientCare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.crm.patientCare.beans.PatientBean;
import com.siri.crm.patientCare.dao.PatientDao;
import com.siri.crm.patientCare.domain.Patient;


/**
 * @author Veera Arun Kumar
 *
 */

@Service 
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;
	
	public List<PatientBean> getPatientList() {
		System.out.println("in patient status srvice");
		List<PatientBean> patientList = new ArrayList<PatientBean>();
		List<Patient> patientDomianList = patientDao.getPatientList();
				if (patientDomianList != null) {
			for (Patient patientDomin : patientDomianList) {
				PatientBean patientBean = (PatientBean) mapDominToBean(patientDomin);
				patientList.add(patientBean);
			}
		}

		return patientList;
	}

	public PatientBean addPatient(PatientBean patientBean) {
		Patient patientDomin=mapBeanToDomin(patientBean);
		patientDomin = patientDao.addPatient(patientDomin);
		patientBean=mapDominToBean(patientDomin);
				return patientBean;
	}

	public List<String> getAllPatientNames() {
		List<String> patientNamesList=patientDao.getAllPatientNames();		
		return patientNamesList;
	}

	public Patient mapBeanToDomin(PatientBean patientBean) {
		Patient patientDomin=new Patient();
		if(patientBean.getFirstName() != null){
			patientDomin.setFirstName(patientBean.getFirstName());
		}
		if(patientBean.getMiddleName() != null){
			patientDomin.setMiddleName(patientBean.getMiddleName());
		}
	   if(patientBean.getLastName() != null){
		   patientDomin.setLastName(patientBean.getLastName());
	   }
		if(patientBean.getConfirmPassword() != null){
			patientDomin.setConfirmPassword(patientBean.getConfirmPassword());
		}
		if(patientBean.getPassword() != null){
			patientDomin.setPassword(patientBean.getPassword());
		}
		if(patientBean.getMobileNumber() != null){
			patientDomin.setMobileNumber(patientBean.getMobileNumber());
		}
		if(patientBean.getPhoneNumber() != null){
			patientDomin.setPhoneNumber(patientBean.getPhoneNumber());
		}
		if(patientBean.getUserName() != null){
			patientDomin.setUserName(patientBean.getUserName());
		}
		
		if(patientBean.getPatientId() !=0){
			patientDomin.setPatientId(patientBean.getPatientId());
		}
		if(patientBean.getEmailId() != null){
			patientDomin.setEmail(patientBean.getEmailId());
		}
		
		if(patientBean.getCountry() != null){
			patientDomin.setCountry(patientBean.getCountry());
		}
		if(patientBean.getState() != null){
			patientDomin.setState(patientBean.getState());
		}
		if(patientBean.getZipcode() != null){
			patientDomin.setZipCode(patientBean.getZipcode());
		}
		
		
		
		return patientDomin;
	}

	public PatientBean mapDominToBean(Patient patientDomin) {
		PatientBean patientBean=new PatientBean();
		patientBean.setFirstName(patientDomin.getFirstName());
		patientBean.setLastName(patientDomin.getLastName());
		patientBean.setConfirmPassword(patientDomin.getConfirmPassword());
		patientBean.setPassword(patientDomin.getPassword());
		patientBean.setMobileNumber(patientDomin.getMobileNumber());
		patientBean.setUserName(patientDomin.getUserName());
		patientBean.setPatientId(patientDomin.getPatientId());
		patientBean.setMiddleName(patientDomin.getMiddleName());
		patientBean.setEmailId(patientDomin.getEmail());
		patientBean.setState(patientDomin.getState());
		patientBean.setZipcode(patientDomin.getZipCode());
		patientBean.setCountry(patientDomin.getCountry());
		patientBean.setMobileNumber(patientDomin.getMobileNumber());
		patientBean.setPhoneNumber(patientDomin.getPhoneNumber());
		return patientBean;
	}

	public boolean deletePatient(int patientid) {
	boolean flag=false;
		flag=patientDao.deletePatient(patientid);
		return flag;
	}

	public PatientBean updatePatient(PatientBean patientBean) {
		// TODO Auto-generated method stub
		Patient pat = patientDao.updatePatient(mapBeanToDomin(patientBean));
		
		return mapDominToBean(pat);
		
	}

	public PatientBean getPatientById(int patientId) {
		Patient patient=patientDao.getPatientbyId(patientId);
		PatientBean patientBean=mapDominToBean(patient);
		return patientBean;
	}

	public PatientBean getPatientByName(String userName) {
		Patient patient=patientDao.getPatientbyUsername(userName);
		PatientBean patientBean=mapDominToBean(patient);
		return patientBean;
	}
	
	public String getAssignDoctor(String userName)
	{
		String assignDoctorName=patientDao.getassignedDoctor(userName);
		System.out.println(assignDoctorName);
		return assignDoctorName;
	}

	public boolean isAuthentiocated(String username, String password) {
		return patientDao.isAuthenticated(username, password);
	}

	

}
