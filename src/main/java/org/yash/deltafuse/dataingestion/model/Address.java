package org.yash.deltafuse.dataingestion.model;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String street;
	private String landmark;
	private String city;
	private String picode;
	private String dist;
	private String state;
	private String country;
	private String countryCode;

	public Address(int id, String name, String street, String landmark, String city, String picode, String dist,
			String state, String country, String countryCode) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.picode = picode;
		this.dist = dist;
		this.state = state;
		this.country = country;
		this.countryCode = countryCode;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPicode() {
		return picode;
	}

	public void setPicode(String picode) {
		this.picode = picode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", street=" + street + ", landmark=" + landmark + ", city="
				+ city + ", picode=" + picode + ", dist=" + dist + ", state=" + state + ", country=" + country
				+ ", countryCode=" + countryCode + "]";
	}

}
