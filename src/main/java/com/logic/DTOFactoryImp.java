package com.logic;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.BeaconUserInfoDTO;
import com.test.entity.use.DTO;
import com.test.entity.use.TimePerLocationDTO;
import com.test.entity.use.TimePerUserIdDTO;

@Component("DTOFactory")
public class DTOFactoryImp implements DTOFactory{
	Log log = LogFactory.getLog(DTOFactoryImp.class);
	@Override
	public DTO makeDTO(String type,BeaconWithUserIdDTO dto) throws InvalidDTOType {
		switch(type){
		case  "userId" :
			log.info(">>>>>>>>>>>>>>>>Make userId type<<<<<<<<<<<<<<<<");
			return new TimePerLocationDTO(dto.getLat(),dto.getLng(),dto.getmTime());
		case  "beaconId" :
			log.info(">>>>>>>>>>>>>>>>Make beaconId type<<<<<<<<<<<<<<<<");
			return new TimePerUserIdDTO(dto.getmTime(),dto.getUserId());	
		case "mTime" : 
			log.info(">>>>>>>>>>>>>>>>Make mTime type<<<<<<<<<<<<<<<<");
			return new BeaconUserInfoDTO(dto.getUserId(),dto.getLat(),dto.getLng());
		default :
			throw new InvalidDTOType("wrong");
		}
	}
	
}
