package com.test.entity.result;

import java.util.ArrayList;
import java.util.List;

import com.logic.MakeDTOList;
import com.test.entity.use.DTO;

//사용자 아이디 별 비콘 정보 (날짜+시간 위치 )
public class MTimePerBeaconUserInfo extends ResultDTO implements MakeDTOList{
	
	private String mTime;
	private List<DTO> BeaconUserInfoList;
	
	
	@Override
	public void addList(DTO dto) {
		BeaconUserInfoList.add(dto);
		
	}
	public MTimePerBeaconUserInfo(String mTime) {
		super();
		this.mTime = mTime;
		BeaconUserInfoList = new ArrayList<DTO>();
	}

	public List<DTO> getBeaconInfoList() {
		return BeaconUserInfoList;
	}
	
	public String getMtime() {
		return mTime;
	}

}
