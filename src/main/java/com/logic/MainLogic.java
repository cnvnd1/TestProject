package com.logic;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.dto.BeaconWithUserIdDTO;

@Component("mainLogic")
public class MainLogic {
	
	private static final String USERID_DATATYPE = "userId";
	private static final String MTIME_DATATYPE = "mTime";
	private static final String BEACONID_DATATYPE = "beaconId";
	
	Log log = LogFactory.getLog(MainLogic.class);
	//DB에서 읽어 온 값들 저장 
	List<BeaconWithUserIdDTO> inputList;
	//반활할 결과 DTO
	@Autowired
	@Qualifier("resultDATA")
	ResultDATA resultDATA;
	//타입별 DTO을 만들어 주는 클래스 
	
	//단위 DTO를 만들어 주는 클래스
	@Autowired
	@Qualifier("DTOFactory")
	DTOFactoryImp dtoFactory;
	
	
	public MainLogic() {
		super();
	}

	public List<BeaconWithUserIdDTO> getInputList() {
		return inputList;
	}
	
	public void setInputList(List<BeaconWithUserIdDTO> inputList) {
		this.inputList = inputList;
	}
	
	public ResultDATA makeResultDTO() throws InvalidDTOType{	
		for (BeaconWithUserIdDTO dto : inputList) {
			log.info("============= Start==================");
			log.info(dto);
			//해당 아이디의 사용자의 hashmap이 있는 경우 
			//이경우 해당사용자의 리스트에 addlist(dto)를 해준다 
			if(resultDATA.getUserResultData().containsKey(dto.getUserId())){
				log.info("============= Make userId type 1==================");
				log.info(dto.getUserId());
				resultDATA.existSetUserIdPerBeaconInfo(dto.getUserId(), dtoFactory.makeDTO(USERID_DATATYPE, dto));
			}else{ //없는 경우 
				log.info("============= Make userId type ==================");
				log.info(dto.getUserId());
				resultDATA.firstSetUserResultData(dto.getUserId(), dtoFactory.makeDTO(USERID_DATATYPE, dto));
			}
			
			//해당 비콘의 hashmap이 있는경우 
			//이경우 해당 비콘의 리스트에 addlist(dto)를 해준다.
			if(resultDATA.getBeaconResultData().containsKey(dto.getBeaconId())){
				log.info("============= Make BeaconId type 1==================");
				log.info(dto.getBeaconId());
				resultDATA.existSetBeaconIdPerUserInfo(dto.getBeaconId(), dtoFactory.makeDTO(BEACONID_DATATYPE, dto));		
			}else{ //없는 경우 
				log.info("============= Make BeaconId type ==================");
				log.info(dto.getBeaconId());
				resultDATA.fistSetBeaconResultData(dto.getBeaconId(), dtoFactory.makeDTO(BEACONID_DATATYPE, dto));
			}
			
			//해당 비콘의 hashmap이 있는경우 
			//이경우 해당 비콘의 리스트에 addlist(dto)를 해준다.
			if(resultDATA.getmTimeResultData().containsKey(dto.getmTime())){
				log.info("============= Make mTime type 1 ==================");
				log.info(dto.getmTime());
				resultDATA.existSetMtimePerBeaconUserInfo(dto.getmTime(), dtoFactory.makeDTO(MTIME_DATATYPE, dto));		
			}else{ //없는 경우 
				log.info("============= Make mTime type ==================");
				log.info(dto.getmTime());
				resultDATA.fistSetMtimeResultData(dto.getmTime(), dtoFactory.makeDTO(MTIME_DATATYPE, dto));
			}
			
			//날짜별 사용자의 아이디를 set에 저장 
			Date date = Calendar.getInstance().getTime();
			String check = new SimpleDateFormat("yyyymmdd",Locale.KOREA).format(date);
			
			if(check.equals(dto.getmTime().substring(0,7))){
				log.info("============= Make AddTodayUser type ==================");
				log.info(dto.getmTime().substring(0,7));
				resultDATA.AddTodayUser(dto.getUserId());
			}else{
				log.info("============= Make AddYesterdayUser type ==================");
				resultDATA.AddYesterdayUser(dto.getUserId());
			}	
		}
		
		return resultDATA;
	}
	public void onlyAdminMakeResult(){
			
	}
	
	public void memberMakeResult(){
		
	}
	
	public void userMakeResult(){
		
	}	
	
		
		
	

	
}
