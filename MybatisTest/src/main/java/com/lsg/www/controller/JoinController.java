package com.lsg.www.controller;

import com.google.gson.*;
import com.lsg.www.vo.YsMemVO;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsg.www.mapper.YsMemMapper;

@RestController
public class JoinController {
	private static final Logger log = LoggerFactory.getLogger(JoinController.class);
	@Autowired
	private YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/memJoin", method= {RequestMethod.GET, RequestMethod.POST})
	public String memJoin(@RequestBody String str) throws Exception{
		log.info("Request Message : " + str);
		JsonParser jsonParser = new JsonParser();

		JsonObject object = (JsonObject) jsonParser.parse(str);
		String memId = object.get("id").getAsString();
		String memPwd = object.get("pwd").getAsString();
		String memName = object.get("memName").getAsString();
		String lgnTpcd = object.get("lgnTpcd").getAsString();
		String memBirth = object.get("memBirth").getAsString();
		String memTall = object.get("memTall").getAsString();
		String memWeight = object.get("memWeight").getAsString();
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

