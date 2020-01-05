package com.adpearance.datacollectionexercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String vin;

	private String make;

	private String model;

	private Integer year;

	// Url of the webpage for the specific car
	@Column(name="vpd_url")
	private String vdpUrl;

	@Column(name="image_url")
	private String imageUrl;

	private Float price;

	private Float msrp;

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getVin() { return vin; }

	public void setVin(String vin) { this.vin = vin; }

	public String getMake() { return make; }

	public void setMake(String make) { this.make = make; }

	public String getModel() { return model; }

	public void setModel(String model) { this.model = model; }

	public Integer getYear() { return year; }

	public void setYear(Integer year) { this.year = year; }

	public String getVdpUrl() { return vdpUrl; }

	public void setVdpUrl(String vdpUrl) { this.vdpUrl = vdpUrl; }

	public String getImageUrl() { return imageUrl; }

	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

	public Float getPrice() { return price; }

	public void setPrice(Float price) { this.price = price; }

	public Float getMsrp() { return msrp; }

	public void setMsrp(Float msrp) { this.msrp = msrp; }
}
