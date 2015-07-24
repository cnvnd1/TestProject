package com.test.entity.use;


public class TimePerLocationDTO extends DTO{
	
	Double lat;
	Double lng;
	
	public TimePerLocationDTO(Double lat, Double lng,String mTime) {
		super(mTime);
		this.lat = lat;
		this.lng = lng;
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
