package com.test.service;

import java.util.List;

import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;
import com.test.entity.user.UserDTO;

public  class ServiceAdaptor implements Service{

	@Override
	public List<IndividualLocationDTO> getposition(String userId, String mdate,
			String mHour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeaconWithUserIdDTO> getTotalPosition(String mdate, String mHour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeaconWithUserIdDTO> getLocationAtHour(String mHour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(String lat, String lng, String mHour, String inputDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<IndividualLocationDTO> getIndividualPath(String userId,
			String mDate, String mHour) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeaconWithUserIdDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void select(UserDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(UserDTO dto) {
		// TODO Auto-generated method stub
		
	}

}
