package com.lsg.www.controller;

import com.google.gson.*;
import com.lsg.www.vo.YsMemVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsg.www.mapper.YsMemMapper;

import java.net.URLDecoder;

@RestController
public class JoinController {
	private static final Logger log = LoggerFactory.getLogger(JoinController.class);
	@Autowired
	private YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/memJoin", method= {RequestMethod.GET, RequestMethod.POST})
	public String memJoin(@RequestBody String str) throws Exception{
		log.info("Original String ::: " + str);

		str = URLDecoder.decode(str, "UTF-8");
//		str = new String(temps, "UTF-8");
		log.info("Converting String ::: " + str);
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject)parser.parse(str);

		log.info("JSON PARSE DATA ::: " + object.toJSONString());
		String memId = (String)object.get("id");
		String memPwd = (String)object.get("pwd");
		String memName = (String)object.get("memName");
		String lgnTpcd = (String)object.get("lgnTpcd");
		String memBirth = (String)object.get("memBirth");
		String memTall = (String)object.get("memTall");
		String memWeight = (String)object.get("memWeight");
		String regId = this.getClass().getSimpleName();

		log.info("memId ::: " + memId);

		YsMemVO vo = new YsMemVO();
		vo.setMemPwd(memPwd);
		vo.setMemId(memId);
		vo.setMemName(memName);
		vo.setLgnTpcd(lgnTpcd);
		vo.setMemBirth(memBirth);
		vo.setMemTall(memTall);
		vo.setMemWeight(memWeight);
		vo.setRegId(regId);
		ysMemMapper.insYsMem(vo);

        return "success";
	}
}

