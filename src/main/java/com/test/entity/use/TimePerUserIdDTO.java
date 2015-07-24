package com.test.entity.use;


public class TimePerUserIdDTO extends DTO{
	
	String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public TimePerUserIdDTO(String userId,String mTime) {
		super(mTime);
		this.userId = userId;
	}
	
	
	
}
