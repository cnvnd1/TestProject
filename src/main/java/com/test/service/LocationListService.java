package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.dao.BeaconListDAO;
import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;

//@Service("locationService")
public class LocationListService extends ServiceAdaptor {
	
	BeaconListDAO dao;

	public void setDao(BeaconListDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<IndividualLocationDTO> getposition(String userId, String mdate, String mHour){
		System.out.println("getposition service 실행...");
		List<IndividualLocationDTO> list = dao.getposition(userId, mdate, mHour);
		return list;
	}

	@Override
	public List<BeaconWithUserIdDTO> getTotalPosition(String mdate, String mHour) {
		List<BeaconWithUserIdDTO> list = dao.getTotalPosition(mdate, mHour);
		return list;
	}

	@Override
	public List<BeaconWithUserIdDTO> getLocationAtHour(String mHour) {
		List<BeaconWithUserIdDTO> list = dao.getLocationAtHour(mHour);
		return null;
	}

	@Override
	public int getCount(String lat, String lng, String mHour, String inputDate) {
		int n = dao.getCount(lat, lng, mHour, inputDate);
		return n;
	}

	@Override
	public List<IndividualLocationDTO> getIndividualPath(String userId, String mDate, String mHour) {
		List<IndividualLocationDTO> list = dao.getIndividualPath(userId, mDate, mHour);
		return list;
	}
	

}
