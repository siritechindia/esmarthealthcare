/**
 * 
 */
package com.siri.crm.patientCare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.siri.crm.patientCare.domain.Doctor;
import com.siri.crm.patientCare.domain.Patient;

/**
 * @author Veera Arun Kumar
 *
 */

@Repository
public class PatientDaoImpl implements PatientDao {
	
	@Autowired
	private HibernateTemplate hibernatetemplate;
	
	public List<String> getAllPatientNames() {
		SessionFactory sessionFactory=hibernatetemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select p.firstName from Patient p");
		List<String> patientNames=query.list();
		if(patientNames!=null)
		{
			return patientNames;
		}
		
		return patientNames;
	}

	public Patient getPatientbyId(int patientid) {
		SessionFactory sessionFactory=hibernatetemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
		Patient patient=(Patient) session.load(Patient.class, patientid);
		return patient;		
	}

	public Patient getPatientbyUsername(String userName) {
		SessionFactory sessionFactory=hibernatetemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Patient where userName=:username");
		query.setParameter("username", userName);
		Patient patient=(Patient) query.uniqueResult();
		return patient;
		}

	public List<Patient> getPatientList() {
		SessionFactory sessionFactory=hibernatetemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Patient");
		List<Patient> patientList=query.list();
		if(patientList!=null)
		{
			return patientList;
		}
		
		return patientList;
	}

	public boolean deletePatient(int patientid) {
		boolean flag=false;
		SessionFactory sf = hibernatetemplate.getSessionFactory();
		Session ses = sf.openSession();
		Query query=ses.createQuery("delete Patient where patientId=:userid");
		query.setParameter("userid", patientid);
		int i=(Integer) query.executeUpdate();
		
		ses.beginTransaction().commit();
		if(i >0)
		   {
			   System.out.println(patientid+" record was sucessfully deleted ::::::: ");
			   flag=true;
			   
		   }
		   else
		   {
			   System.out.println(patientid+" record was not deleted......");
			   flag=false;
			   ses.beginTransaction().rollback();
		   }

	return flag;
	}

	public boolean isAuthenticated(String username,String password){
		boolean isAuthenticated = false;
		try{
			System.out.println("user name"+username);
			System.out.println("password is:\t"+password);
			
			SessionFactory sf = hibernatetemplate.getSessionFactory();
			Session ses = sf.openSession();
			String query = "from Patient  where userName= :pname";
			Query q = ses.createQuery(query);
			q.setParameter("pname", username);
			Patient p = (Patient)q.uniqueResult();
			System.out.println("patient existed:\t"+p.getPatientId());
			if(p!= null && p.getPassword().equals(password)){
				isAuthenticated = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return isAuthenticated;
	}
	public Patient updatePatient(Patient patientDomin) {
		SessionFactory sf = hibernatetemplate.getSessionFactory();
		Session ses = sf.openSession();
		ses.update(patientDomin);
		ses.beginTransaction().commit();
		return patientDomin;
	}

	public Patient addPatient(Patient patientDomin) {
		SessionFactory sf = hibernatetemplate.getSessionFactory();
		Session ses = sf.openSession();
		ses.save(patientDomin);
		ses.beginTransaction().commit();
		return patientDomin;
	}
	
	public String getassignedDoctor(String userName) {

		SessionFactory sf = hibernatetemplate.getSessionFactory();
		Session ses = sf.openSession();
		
		Query query=ses.createQuery("FROM Patient where patientName=:userName");
		query.setParameter("userName", userName);
		
		Patient patient= (Patient) query.uniqueResult();
		Doctor doctor=patient.getAssignDoctor();
		String doctorName=doctor.getFname();
		
		return doctorName;
	}

	public Doctor getDoctorById(int id) {
		SessionFactory sessionFactory=hibernatetemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
		Doctor doctor=(Doctor) session.load(Doctor.class, id);
		return doctor;
	}


}
