/**
 * 
 */
package com.siri.crm.patientCare.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vegirouthumanikanta
 *
 */
/*@XmlRootElement(name="patientDetails")
@XmlAccessorType(XmlAccessType.FIELD)*/
public class PatientBean implements Serializable {

	//@XmlElement
	private int patientId;
	//@XmlElement
	private String firstName;
	//@XmlElement
	private String middleName;
	//@XmlElement
	private String lastName;
	//@XmlElement
	private String gender;
	//@XmlElement
    private String dob;
	//@XmlElement
    private String bloodGroup;
	//@XmlElement
    private String homeTownAddress;
	//@XmlElement
    private String city;
    private String state;
    private String country;
    private Integer zipcode;
    private Long mobileNumber;
    private Integer phoneNumber;
    private String emailId;
    private String userName;
    private String password;
    private String confirmPassword;
    private String filePath; 
    
    
    
    
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "PatientBean [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dob=" + dob + ", bloodGroup=" + bloodGroup + ", homeTownAddress="
				+ homeTownAddress + ", city=" + city + ", state=" + state + ", country=" + country + ", zipcode="
				+ zipcode + ", mobileNumber=" + mobileNumber + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId
				+ ", userName=" + userName + ", password=" + password + ", filePath=" + filePath + "]";
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getHomeTownAddress() {
		return homeTownAddress;
	}
	public void setHomeTownAddress(String homeTownAddress) {
		this.homeTownAddress = homeTownAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
    
}
