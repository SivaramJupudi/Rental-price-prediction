package com.rental.rental_price_backend.model;


import jakarta.persistence.*;

@Entity
public class property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int bhk;
	private int size;
	private int floor;
	private String areaType;
	private String city;
	private String furnishingStatus;
	private String tenantPreferred;
	private int bathroom;
	private double rent;

	// Getters and setters
	public Long getId() { return id; }

	public int getBhk() { return bhk; }
	public void setBhk(int bhk) { this.bhk = bhk; }

	public int getSize() { return size; }
	public void setSize(int size) { this.size = size; }

	public int getFloor() { return floor; }
	public void setFloor(int floor) { this.floor = floor; }

	public String getAreaType() { return areaType; }
	public void setAreaType(String areaType) { this.areaType = areaType; }

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }

	public String getFurnishingStatus() { return furnishingStatus; }
	public void setFurnishingStatus(String furnishingStatus) { this.furnishingStatus = furnishingStatus; }

	public String getTenantPreferred() { return tenantPreferred; }
	public void setTenantPreferred(String tenantPreferred) { this.tenantPreferred = tenantPreferred; }

	public int getBathroom() { return bathroom; }
	public void setBathroom(int bathroom) { this.bathroom = bathroom; }

	public double getRent() { return rent; }
	public void setRent(double rent) { this.rent = rent; }
}
