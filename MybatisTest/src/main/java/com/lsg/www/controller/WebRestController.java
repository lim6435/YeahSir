package com.lsg.www.controller;

import com.lsg.www.mapper.YsMemMapper;
import com.lsg.www.vo.YsMemVO;
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
	private YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test(@RequestBody JSONObject object) throws Exception{
	    log.info("Request JSON DATA [" + object.toString() + "]");
	    String reqId = (String) object.get("id");
	    String password = (String)object.get("pwd");
        YsMemVO memVo = new YsMemVO();
        memVo.setMemId(reqId);
        memVo.setMemPwd(password);

	    log.info("Request Parameter : " + reqId + " \t##### pwd : " + password);
		HashMap result = ysMemMapper.getYsMem(memVo);

        JSONObject obj = new JSONObject();
        obj.putAll(result);
		log.info("result :: " + result.toString());
		log.info("result json :: " + obj.toString());

		return obj.toString();
	}
}
