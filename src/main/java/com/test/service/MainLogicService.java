package com.test.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.test.dao.RepositoyAdaptor;
import com.test.dto.BeaconWithUserIdDTO;


@Component("mainLogicService")
public class MainLogicService extends ServiceAdaptor{
	
	@Autowired
	@Qualifier("mainLogicRepository")
	RepositoyAdaptor repo;
	
	Log log = LogFactory.getLog(MainLogicService.class);
	public List<BeaconWithUserIdDTO> selectAll(){
		log.info("============MainLogicService 실행===================");
		return repo.selectAll();
	}

}
