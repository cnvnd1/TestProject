package com.test.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.dto.BeaconWithUserIdDTO;
import com.test.entity.use.IndividualLocationDTO;
import com.test.entity.user.UserDTO;
import com.test.service.Service;

@Controller
public class LocationController {
	
	@Autowired
	@Qualifier("mainLogicService")
	Service mainLogicServie;
	
	@Autowired
	@Qualifier("userService")
	Service userServie;
	
	Log log = LogFactory.getLog(LocationController.class);
	
	@RequestMapping("/requestData")
	public ModelAndView makeResultData(ModelAndView mav){
		
		//MainLogic mainLogic= new 
		//ResultDATA resultData = 
		
		return mav;
	
	}
	@RequestMapping("login")
	public ModelAndView login(UserDTO dto,ModelAndView mav){
	
		System.out.println("login 실행");
		userServie.insert(dto);
		
		System.out.println("redirect 실행");
		mav.setViewName("redirect:loginForm");
		return mav;
	}
	@RequestMapping("/GoogleMap")
	public String GoogleMapOpen(){
		return "GoogleMap";
	}
	
	@RequestMapping("/admingooglemap")
	public String AdminGoogleMapOpen(){
		return "AdminUseGoogleMap";
	}
	
	
	
	
	
}
