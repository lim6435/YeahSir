package com.lsg.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List result = ysMemMapper.getYsMem("11");
		
		ObjectMapper objetMapper = new ObjectMapper();
		ObjectWriter writer = objetMapper.writerWithDefaultPrettyPrinter();
		
		log.info("result :: ", result.toString());
		System.out.println(result.toString());
		
		String json = writer.writeValueAsString(result);
		log.info("result json :: " + json);
		log.info(json);
		System.out.println("result json :: " + json);
		
		return result.toString();
	}
}
