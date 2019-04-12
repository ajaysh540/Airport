package com.cognizant.Airport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_details")
public class AdminDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer adminId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private String dob;

	@Column(name = "contact")
	private int contact;

	@Column(name = "alt_contact")
	private int altContact;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private int status;

	@Override
	public String toString() {
		return "AdminDetails [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", dob=" + dob + ", contact=" + contact + ", altContact=" + altContact
				+ ", email=" + email + ", pass=" + password + ", status=" + status + "]";
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public int getAltContact() {
		return altContact;
	}

	public void setAltContact(int altContact) {
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

}
