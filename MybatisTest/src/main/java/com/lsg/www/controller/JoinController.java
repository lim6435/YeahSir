package com.lsg.www.controller;

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
	YsMemMapper ysMemMapper;
	
	@RequestMapping(value="/memJoin", method= {RequestMethod.GET, RequestMethod.POST})
	public String memJoin(@RequestBody JSONObject object) throws Exception{
		log.info("Request Message : " + object.toString());

		String memId = (String) object.get("id");
		String memPwd = (String) object.get("pwd");
		String memName = (String) object.get("memName");
		String lgnTpcd = (String) object.get("lgnTpcd");
		String memBirth = (String) object.get("memBirth");
		String memTall = (String) object.get("memTall");
		String memWeight = (String) object.get("memWeight");
		String regId = this.getClass().getName();

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

