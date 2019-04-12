package com.cognizant.Airport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hangar_details")
public class HangarDetails {

	public HangarDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="hangar_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hangarId;
	
	
	@Column(name="manager_id")
	private String managerId;
	
	@Column(name="manager_address1")
	private String managerAddress1;

	@Column(name="manager_address2")
	private String managerAddress2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipCode;

	public int getHangarId() {
		return hangarId;
	}

	public void setHangarId(int hangarId) {
		this.hangarId = hangarId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerAddress1() {
		return managerAddress1;
	}

	public void setManagerAddress1(String managerAddress1) {
		this.managerAddress1 = managerAddress1;
	}

	public String getManagerAddress2() {
		return managerAddress2;
	}

	public void setManagerAddress2(String managerAddress2) {
		this.managerAddress2 = managerAddress2;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "HangarDetails [hangarId=" + hangarId + ", managerId=" + managerId + ", managerAddress1="
				+ managerAddress1 + ", managerAddress2=" + managerAddress2 + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
	
	
}
