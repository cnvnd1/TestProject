package com.test.dto;



public class BeaconWithUserIdDTO {
	
	private String beaconId;
	private Double lat;
	private Double lng;
	private String userId;
	private String mTime;
	
	public String getBeaconId() {
		return beaconId;
	}
	public void setBeaconId(String beaconId) {
		this.beaconId = beaconId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getmTime() {
		return mTime;
	}
	public void setmTime(String mTime) {
		this.mTime = mTime;
	}
	public BeaconWithUserIdDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BeaconWithUserIdDTO(String beaconId, Double lat, Double lng,
			String userId, String mTime) {
		super();
		this.beaconId = beaconId;
		this.lat = lat;
		this.lng = lng;
		this.userId = userId;
		this.mTime = mTime;
	}
	@Override
	public String toString() {
		return "BeaconWithUserIdDTO [beaconId=" + beaconId + ", lat=" + lat
				+ ", lng=" + lng + ", userId=" + userId + ", mTime=" + mTime
				+ "]";
	}
	
	
	
	
}
