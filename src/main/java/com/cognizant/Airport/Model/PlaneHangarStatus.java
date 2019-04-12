package com.cognizant.Airport.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="plane_hangar_details")
public class PlaneHangarStatus {
	
	@Id
	@Column(name="S_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="planes_plane_id")
	private PlaneDetails planeDetails;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="hangar_hangar_id")
	private HangarDetails hangarDetails;

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public PlaneDetails getPlaneDetails() {
		return planeDetails;
	}

	public void setPlaneDetails(PlaneDetails planeDetails) {
		this.planeDetails = planeDetails;
	}

	public HangarDetails getHangarDetails() {
		return hangarDetails;
	}

	public void setHangarDetails(HangarDetails hangarDetails) {
		this.hangarDetails = hangarDetails;
	}

	public PlaneHangarStatus(Integer sNo, PlaneDetails planeDetails, HangarDetails hangarDetails) {
		super();
		this.sNo = sNo;
		this.planeDetails = planeDetails;
		this.hangarDetails = hangarDetails;
	}

	public PlaneHangarStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PlaneHangarStatus [sNo=" + sNo + ", planeDetails=" + planeDetails + ", hangarDetails=" + hangarDetails
				+ "]";
	}

}
