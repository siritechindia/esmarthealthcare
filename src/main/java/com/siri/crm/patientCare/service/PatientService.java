/**
 * 
 */
package com.siri.crm.patientCare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siri.crm.patientCare.beans.PatientBean;
import com.siri.crm.patientCare.domain.Patient;

/**
 * @author Veera Arun Kumar
 *
 */
@Service
public interface PatientService {
	public List<PatientBean> getPatientList();
	public  PatientBean addPatient(PatientBean patientBean);
	public List<String> getAllPatientNames();
	public Patient mapBeanToDomin(PatientBean patientBean);
	public PatientBean mapDominToBean(Patient patientDomin);
	public boolean deletePatient(int patientid);
	public PatientBean updatePatient(PatientBean patientBean);
	public PatientBean getPatientById(int patientId);
	public PatientBean getPatientByName(String userName);
	public String getAssignDoctor(String userName);	
	public boolean isAuthentiocated(String username,String password);
}
