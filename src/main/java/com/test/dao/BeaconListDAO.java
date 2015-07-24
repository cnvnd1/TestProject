package com.test.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;

public class BeaconListDAO extends RepositoyAdaptor {
	
	SqlSessionTemplate templete;
	
	public void setTemplete(SqlSessionTemplate templete) {
		this.templete = templete;
	}

	@Override
	public List<IndividualLocationDTO> getposition(String userId, String mdate, String mHour) {
		System.out.println("getposition BeaconListDAO 실행...");
		Map<String, String> map = new HashMap<String, String>();
		map.put("indvUserid", userId);
		map.put("indvMtime", mdate);
		map.put("indvMhour", mHour);
		List<IndividualLocationDTO> list = templete.selectList("getposition" ,map);
		return list;
	}

	@Override
	public List<BeaconWithUserIdDTO> getTotalPosition(String mdate, String mHour) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("totalMtime", mdate);
		map.put("totalMhour", mHour);
		List<BeaconWithUserIdDTO> list = templete.selectList("getTotalPosition" ,map);
		return list;
	}

	@Override
	public List<BeaconWithUserIdDTO> getLocationAtHour(String mHour) {
		List<BeaconWithUserIdDTO> list = templete.selectList("getLocationAtHour", mHour);
		return list;
	}

	@Override
	public int getCount(String lat, String lng, String mHour, String inputDate) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("lat", lat);
		map.put("lng", lng);
		map.put("mHour", mHour);
		map.put("inputDate", inputDate);
		int n = templete.selectOne("getCount", map);
		System.out.println("dao : " +n);
		return n;
	}

	@Override
	public List<IndividualLocationDTO> getIndividualPath(String userId, String mDate, String mHour) {
		
		System.out.println("getIndividualPath DAO 실행..." + userId + "\t" + mDate);
		Map<String, String> map = new HashMap<String, String>();
		map.put("indvUserid", userId);
		map.put("indvMtime", mDate);
		map.put("indvMhour", mHour);
		List<IndividualLocationDTO> list = templete.selectList("getIndividualPath" ,map);
		
		return list;
	}

}
