/**
 * 
 */
package com.siri.crm.patientCare.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Veera Arun Kumar
 *
 */
@Entity
@Table(name="EsmartUserProfile")
public class ManageUserProfile implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 3478894579655944069L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileId;
	private String fname;
	private String mname;
	private String lname;
	private String gender;
	private String dob;
	private String deptName;
	private String filePath;
	@OneToOne
	@JoinColumn(name="esmartUser_Role")
	private Role role;
	private String userId;
	private String password;
	private String confirmPwd;
	private long mobileNum;
	private boolean isAccountLocked = true;
	private String email;
	private String specialization;
	
	
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}	
	
	public boolean isAccountLocked() {
		return isAccountLocked;
	}
	public void setAccountLocked(boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}
	@Override
	public String toString() {
		return "ManageUserProfile [profileId=" + profileId + ", fname=" + fname + ", mname=" + mname + ", lname="
				+ lname + ", gender=" + gender + ", dob=" + dob + ", deptName=" + deptName + ", filePath=" + filePath
				+ ", role=" + role + ", userId=" + userId + ", password=" + password + ", confirmPwd=" + confirmPwd
				+ ", mobileNum=" + mobileNum + ", isAccountLocked=" + isAccountLocked + ", email=" + email + "]";
	}
	
	
}
