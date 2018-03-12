package com.lsg.www.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lsg.www.mapper.YsMemMapper;

@RestController
public class WebRestController {

	
	private static final Logger log = LoggerFactory.getLogger(WebRestController.class);

	@Autowired
	YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test(HttpServletRequest req, HttpServletResponse res) throws Exception{
	    String reqId = (String) req.getAttribute("id");
	    log.info("Request Parameter : " + reqId);
		HashMap result = ysMemMapper.getYsMem(reqId);

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
