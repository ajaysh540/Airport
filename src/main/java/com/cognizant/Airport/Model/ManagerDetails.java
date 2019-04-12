package com.cognizant.Airport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager_details")
public class ManagerDetails {

	private ManagerDetails() {

	}

	private static ManagerDetails managerDetails;

	public static ManagerDetails getManagerDetails() {
		if (managerDetails == null) {
			managerDetails = new ManagerDetails();
		}
		return managerDetails;
	}

	@Override
	public String toString() {
		return "ManagerDetails [managerId=" + managerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", dob=" + dob + ", contact=" + contact + ", altcontact="
				+ altContact + ", email=" + email + ", password=" + password + ", status=" + status + "]";
	}

	@Id
	@Column(name = "manager_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int managerId;
	
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "gender")
	String gender;
	
	@Column(name = "dob", nullable = true)
	String dob;

	@Column(name = "contact")
	long contact;
	
	@Column(name = "alt_contact", nullable = true)
	Long altContact;
	
	@Column(name = "email", nullable = true)
	String email;
	
	@Column(name = "password")
	String password;
	
	@Column(name = "status")
	int status;

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public Long getAltContact() {
		return altContact;
	}

	public void setAltContact(Long altContact) {
		this.altContact = altContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static void setManagerDetails(ManagerDetails managerDetails) {
		ManagerDetails.managerDetails = managerDetails;
	}



}
