package com.test.dao;

import java.util.List;

import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;

public interface MyReposioty {

	public List<IndividualLocationDTO> getposition(String userId, String mdate, String mHour);
	public List<BeaconWithUserIdDTO> getTotalPosition(String mdate, String mHour);
	public List<BeaconWithUserIdDTO> getLocationAtHour(String mHour);
	public int getCount(String lat, String lng, String mHour, String inputDate);
	public List<IndividualLocationDTO> getIndividualPath(String userId, String mDate, String mHour);
	public List<BeaconWithUserIdDTO> selectAll();
}