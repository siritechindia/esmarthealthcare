/**
 * 
 */
package com.siri.crm.patientCare.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.siri.crm.patientCare.beans.PatientBean;
import com.siri.crm.patientCare.domain.Patient;

/**
 * @author Veera Arun Kumar
 *
 */
@Repository
public interface PatientDao {
	public List<String> getAllPatientNames();
    public Patient getPatientbyId(int patientid);
    public Patient getPatientbyUsername(String userName);
    public List<Patient> getPatientList();
    public boolean deletePatient(int patientid);
    public boolean updatePatient(Patient patientDomin);
    public Patient addPatient(Patient patientDomin);
    public String getassignedDoctor(String userName);
}
