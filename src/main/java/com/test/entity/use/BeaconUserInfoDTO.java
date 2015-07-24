package com.test.entity.use;

public class BeaconUserInfoDTO extends DTO{
	
	String userId;
	Double lat;
	Double lng;
	
	
	public BeaconUserInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BeaconUserInfoDTO(String userId, Double lat, Double lng) {
		super();
		this.userId = userId;
		this.lat = lat;
		this.lng = lng;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	
	
}
