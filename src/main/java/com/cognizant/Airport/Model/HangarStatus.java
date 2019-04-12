package com.cognizant.Airport.Model;

import javax.persistence.CascadeType;
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
@Table(name="hangar_status")
public class HangarStatus {

	public HangarStatus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HangarStatus [hangarDetails=" + hangarDetails + ", managerid=" + managerid + ", status=" + status
				+ ", occupancyFD=" + occupancyFD + ", occupancyTD=" + occupancyTD + ", availableFD=" + availableFD
				+ ", availableTD=" + availableTD + "]";
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
    @JoinColumn(name="hangar_id")
	HangarDetails hangarDetails;

	
   /* @ManyToOne(fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
    @JoinColumn(name="pr_br_fk")
       ProductBrands productBrands;*/
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="manager_id")
	private String managerid;
	
	
	@Column(name="status")
	private String status;
	
	@Column(name="occupancy_from_date")
	private String occupancyFD;
	
	
	@Column(name="occupancy_till_date")
	private String occupancyTD;
	
	@Column(name="available_from_date")
	private String availableFD;
	
	@Column(name="available_till_date")
	private String availableTD;

	public HangarDetails getHangarDetails() {
		return hangarDetails;
	}

	public void setHangarDetails(HangarDetails hangarDetails) {
		this.hangarDetails = hangarDetails;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOccupancyFD() {
		return occupancyFD;
	}

	public void setOccupancyFD(String occupancyFD) {
		this.occupancyFD = occupancyFD;
	}

	public String getOccupancyTD() {
		return occupancyTD;
	}

	public void setOccupancyTD(String occupancyTD) {
		this.occupancyTD = occupancyTD;
	}

	public String getAvailableFD() {
		return availableFD;
	}

	public void setAvailableFD(String availableFD) {
		this.availableFD = availableFD;
	}

	public String getAvailableTD() {
		return availableTD;
	}

	public void setAvailableTD(String availableTD) {
		this.availableTD = availableTD;
	}
}
