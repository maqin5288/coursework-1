package com.example.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 8300462418568787643L;

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "street_address", length = 45, nullable = false)
	private String streetAddress;

	@Column(name = "apartment_number", length = 45)
	private String apartmentNumber;

	@Column(name = "city", length = 45, nullable = false)
	private String city;

	@Column(name = "state", length = 45, nullable = false)
	private String state;

	@Column(name = "zip", nullable = false)
	private Integer zip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
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

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id: ");
		builder.append(this.id);
		builder.append(", streetAddress: ");
		builder.append(this.streetAddress);
		builder.append(", apartmentNumber: ");
		builder.append(this.apartmentNumber);
		builder.append(", city: ");
		builder.append(this.city);
		builder.append(", state: ");
		builder.append(this.state);
		builder.append(", zip: ");
		builder.append(this.zip);
		return builder.toString();
	}

}
