/**
 * 
 */
package com.siri.crm.patientCare.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Veera Arun Kumar
 *
 */
@Entity
@Table(name="patient")
public class Patient implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private Long mobileNumber;
	private String userName;
	private String state;
	private String country;
	private int zipCode;
	private String email;
	private int phoneNumber;
	
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="profileId",fetch=FetchType.EAGER)
	private List<ManageUserProfile> assigndoctor;
	*/
	/*@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "assignDoctor")
	private List<ManageUserProfile> assignDoctor;
	
	
	public List<ManageUserProfile> getAssignDoctor() {
		return assignDoctor;
	}
	public void setAssignDoctor(List<ManageUserProfile> assignDoctor) {
		this.assignDoctor = assignDoctor;
	}*/
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@OneToOne
	@JoinColumn(name="assignDoctor")
	private Doctor assignDoctor;

	
	
	public Doctor getAssignDoctor() {
		return assignDoctor;
	}
	public void setAssignDoctor(Doctor assignDoctor) {
		this.assignDoctor = assignDoctor;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	}
