package com.test.entity.use;

public class IndividualLocationDTO {
	
	private String indvUserid;
	private double indvLat;
	private double indvLng;
	private String indvMtime;
	
	
	public IndividualLocationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndividualLocationDTO(String indvUserid, double indvLat,
			double indvLng, String indvMtime) {
		super();
		this.indvUserid = indvUserid;
		this.indvLat = indvLat;
		this.indvLng = indvLng;
		this.indvMtime = indvMtime;
	}

	public String getIndvUserid() {
		return indvUserid;
	}

	public void setIndvUserid(String indvUserid) {
		this.indvUserid = indvUserid;
	}

	public double getIndvLat() {
		return indvLat;
	}

	public void setIndvLat(double indvLat) {
		this.indvLat = indvLat;
	}

	public double getIndvLng() {
		return indvLng;
	}

	public void setIndvLng(double indvLng) {
		this.indvLng = indvLng;
	}

	public String getIndvMtime() {
		return indvMtime;
	}

	public void setIndvMtime(String indvMtime) {
		this.indvMtime = indvMtime;
	}

	@Override
	public String toString() {
		return "IndividualLocationDTO [indvUserid=" + indvUserid + ", indvLat="
				+ indvLat + ", indvLng=" + indvLng + ", indvMtime=" + indvMtime
				+ "]";
	}
}
