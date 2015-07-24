package com.test.entity.result;

import java.util.ArrayList;
import java.util.List;

import com.logic.MakeDTOList;
import com.test.entity.use.DTO;

//비콘 아이별 사용자정보 (날짜+시간 사용자아이디)
public class BeaconIdPerUserInfo extends ResultDTO implements MakeDTOList{
	
	String beaconId;
	private List<DTO> UserInfoList;
	
	@Override
	public void addList(DTO dto) {
		UserInfoList.add(dto);
		
	}
	public BeaconIdPerUserInfo(String beaconId) {
		super();
		this.beaconId = beaconId;
		UserInfoList = new ArrayList<DTO>();
	}
	public String getBeaconId() {
		return beaconId;
	}
	public List<DTO> getUserInfoList() {
		return UserInfoList;
	}
	
	
	

}
