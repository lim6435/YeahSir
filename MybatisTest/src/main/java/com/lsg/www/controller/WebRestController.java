package com.lsg.www.controller;

import com.lsg.www.mapper.YsMemMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class WebRestController {
	private static final Logger log = LoggerFactory.getLogger(WebRestController.class);

	@Autowired
	YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test(@RequestBody JSONObject object) throws Exception{
	    log.info("Request JSON DATA [" + object.toString() + "]");
	    String reqId = (String) object.get("id");
	    String password = (String)object.get("pwd");
	    log.info("Request Parameter : " + reqId + "##### pwd : " + password);
		HashMap result = ysMemMapper.getYsMem(reqId, password);

		JSONArray jsonArray = new JSONArray();

		for(int i = 0; i<result.size(); i++) {
			JSONObject obj = new JSONObject();
			obj.putAll((HashMap)result);
			jsonArray.add(obj);
		}

		log.info("result :: ", result.toString());
		System.out.println(result.toString());
		
		log.info("result json :: " + jsonArray.toString());
		log.info(jsonArray.toString());
		System.out.println("result json :: " + jsonArray.toString());
		
		return jsonArray.toString();
	}
}
