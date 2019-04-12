package com.cognizant.Airport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planes_details")
public class PlaneDetails {
	@Id
	@Column(name="plane_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planeId;
	@Column(name="owner_id")
	private int ownerId;
	@Column(name="owner_first_name")
	private String ownerFirstName;
	@Column(name="owner_last_name")
	private String ownerLastName;
	@Column(name="owner_contact")
	private int ownerContact;
	@Column(name="owner_email")
	private String ownerEmail;
	@Column(name="plane_type")
	private String planeType;
	@Column(name="plane_capacity")
	private int planeCapacity;
	
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public int getOwnerContact() {
		return ownerContact;
	}
	public void setOwnerContact(int ownerContact) {
		this.ownerContact = ownerContact;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public int getPlaneCapacity() {
		return planeCapacity;
	}
	public void setPlaneCapacity(int planeCapacity) {
		this.planeCapacity = planeCapacity;
	}
	
	@Override
	public String toString() {
		return "PlaneDetails [planeId=" + planeId + ", ownerId=" + ownerId + ", ownerFirstName=" + ownerFirstName
				+ ", ownerLastName=" + ownerLastName + ", ownerContact=" + ownerContact + ", ownerEmail=" + ownerEmail
				+ ", planeType=" + planeType + ", planeCapacity=" + planeCapacity + "]";
	}
	
	
	
}
