package com.lsg.www.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsg.www.mapper.YsMemMapper;

@RestController
public class MainController {

	@Autowired
	YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/selMemInfo", method= {RequestMethod.GET, RequestMethod.POST})
	public String selMemInfo(HttpServletRequest req, HttpServletResponse res){
//		HashMap result = ysMemMapper.getYsMem("11", "1111");
//		System.out.println(result);
//
		return null;
//		return result.toString();
	}
}
