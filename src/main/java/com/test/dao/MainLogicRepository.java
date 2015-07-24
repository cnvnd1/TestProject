package com.test.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.test.dto.BeaconWithUserIdDTO;

@Component("mainLogicRepository")
public class MainLogicRepository extends RepositoyAdaptor{
	
	Log log = LogFactory.getLog(MainLogicRepository.class);
	
	@Autowired
	@Qualifier("sessionTemplete")
	SqlSessionTemplate template;
	
	public List<BeaconWithUserIdDTO> selectAll(){
		 log.info("select 실행 ~~~~~~~~~~~");
		 List<BeaconWithUserIdDTO>  list = template.selectList("position.selectAll");
		 log.info(list);
		return list;
	}
}
