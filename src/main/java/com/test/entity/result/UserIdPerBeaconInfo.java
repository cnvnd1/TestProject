package com.test.entity.result;

import java.util.ArrayList;
import java.util.List;

import com.logic.MakeDTOList;
import com.test.entity.use.DTO;

//사용자 아이디 별 비콘 정보 (날짜+시간 위치 )
public class UserIdPerBeaconInfo extends ResultDTO implements MakeDTOList{
	
	private String userId;
	private List<DTO> BeaconInfoList;
	
	
	@Override
	public void addList(DTO dto) {
		BeaconInfoList.add(dto);
		
	}
	public UserIdPerBeaconInfo(String userId) {
		super();
		this.userId = userId;
		BeaconInfoList = new ArrayList<DTO>();
	}

	public List<DTO> getBeaconInfoList() {
		return BeaconInfoList;
	}
	
	public String getUserId() {
		return userId;
	}

}
