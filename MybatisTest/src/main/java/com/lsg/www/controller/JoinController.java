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
		String memId = new String(object.get("id").getAsString().getBytes("UTF-8"), "UTF-8");
		String memPwd = new String(object.get("pwd").getAsString().getBytes("UTF-8"), "UTF-8");
		String memName = new String(object.get("memName").getAsString().getBytes("UTF-8"), "UTF-8");
		String lgnTpcd = new String(object.get("lgnTpcd").getAsString().getBytes("UTF-8"), "UTF-8");
		String memBirth = new String(object.get("memBirth").getAsString().getBytes("UTF-8"), "UTF-8");
		String memTall = new String(object.get("memTall").getAsString().getBytes("UTF-8"), "UTF-8");
		String memWeight = new String(object.get("memWeight").getAsString().getBytes("UTF-8"), "UTF-8");
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

