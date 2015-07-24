package com.test.service;

import java.util.List;

import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;
import com.test.entity.user.UserDTO;

public interface Service {
	public abstract List<IndividualLocationDTO> getposition(String userId, String mdate, String mHour);
	public abstract List<BeaconWithUserIdDTO> getTotalPosition(String mdate, String mHour);
	public abstract List<BeaconWithUserIdDTO> getLocationAtHour(String mHour);
	public abstract int getCount(String lat, String lng, String mHour, String inputDate);
	public abstract List<IndividualLocationDTO> getIndividualPath(String userId, String mDate, String mHour);
	public abstract List<BeaconWithUserIdDTO> selectAll();
	public abstract void select(UserDTO dto);
	public abstract void insert(UserDTO dto);
}
