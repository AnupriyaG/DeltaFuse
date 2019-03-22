package org.yash.deltafuse.dataingestion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="HighDemand")
public class HighDemand implements Serializable {

	/*public HighDemand(String imei, String productName, String model, String os, String ram, String display,
			String camera, String sim, String processor, String storage, String battery, String faceCamera,
			String charging, String price, int sell, int rating) {
		super();
		this.imei = imei;
		this.productName = productName;
		this.model = model;
		this.os = os;
		this.ram = ram;
		this.display = display;
		this.camera = camera;
		this.sim = sim;
		this.processor = processor;
		this.storage = storage;
		this.battery = battery;
		this.faceCamera = faceCamera;
		this.charging = charging;
		this.price = price;
		this.sell = sell;
		this.rating = rating;
	}*/
	private static final long serialVersionUID = -6217927370102085080L;
	
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	@Id
	private String imei;
	
	@Column(name="productName")
	private String productName;

	@Column(name="model")
	private String model;

	@Column(name="os")
	private String os;

	@Column(name="ram")
	private String ram;

	@Column(name="display")
	private String display;

	@Column(name="camera")
	private String camera;

	@Column(name="sim")
	private String sim;

	@Column(name="processor")
	private String processor;

	@Column(name="storage")
	private String storage;

	@Column(name="battery")
	private String battery;

	@Column(name="faceCamera")
	private String faceCamera;

	@Column(name="charging")
	private String charging;

	@Column(name="price")
	private String price;

	@Column(name="sale")
	private int sale;
	
	
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getFaceCamera() {
		return faceCamera;
	}
	public void setFaceCamera(String faceCamera) {
		this.faceCamera = faceCamera;
	}
	public String getCharging() {
		return charging;
	}
	public void setCharging(String charging) {
		this.charging = charging;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	private int rating;

}
