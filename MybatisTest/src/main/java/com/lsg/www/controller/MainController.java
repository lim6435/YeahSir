package com.lsg.www.controller;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsg.www.mapper.MainMapper;
import com.lsg.www.vo.YsCoptVo;

@RestController
public class MainController {
	private static final Logger log = LoggerFactory.getLogger(WebRestController.class);
	
	@Autowired
	MainMapper mainMapper;
	
	@RequestMapping(value="/selCoptInfo", method= {RequestMethod.GET, RequestMethod.POST})
	public String selCopt(@RequestBody JSONObject object) throws Exception{
		
	    log.info("Request JSON DATA [" + object.toString() + "]");
//	    String reqId = (String) object.get("id");
//	    String password = (String)object.get("pwd");
        YsCoptVo coptVo = new YsCoptVo();
//        memVo.setMemId(reqId);
//        memVo.setMemPwd(password);

//	    log.info("Request Parameter : " + reqId + " \t##### pwd : " + password);
		HashMap result = mainMapper.getYsCopt(coptVo);

        JSONObject obj = new JSONObject();
        obj.putAll(result);
		log.info("result :: " + result.toString());
		log.info("result json :: " + obj.toString());

		return obj.toString();
	}
}
