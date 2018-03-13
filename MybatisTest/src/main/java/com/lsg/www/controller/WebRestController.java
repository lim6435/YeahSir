package com.lsg.www.controller;

import com.lsg.www.mapper.MainMapper;
import com.lsg.www.mapper.YsMemMapper;
import com.lsg.www.vo.YsCoptVo;
import com.lsg.www.vo.YsMemVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class WebRestController {
	private static final Logger log = LoggerFactory.getLogger(WebRestController.class);

	@Autowired
	private YsMemMapper ysMemMapper;
	@Autowired
    private MainMapper mainMapper;
	
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test(@RequestBody JSONObject object) throws Exception{
	    log.info("Request JSON DATA [" + object.toString() + "]");
        JSONArray jsonArray = new JSONArray();
        String reqId = (String) object.get("id");
        String password = (String)object.get("pwd");
        YsMemVO memVo = new YsMemVO();
        memVo.setMemId(reqId);
        memVo.setMemPwd(password);

        log.info("Request Parameter : " + reqId + " \t##### pwd : " + password);
        HashMap result = ysMemMapper.getYsMem(memVo);
        YsCoptVo coptVo = new YsCoptVo();
        List<YsCoptVo> coptList = mainMapper.getYsCopt(coptVo);
        JSONObject obj = new JSONObject();
        for(int i=0; i<coptList.size(); i++) {
            jsonArray.add(coptList.get(i));
        }
        log.info("List Type : " + coptList.get(0));
        obj.putAll(result);
        obj.put("getCoptInfo", jsonArray.toJSONString());
		log.info("result json :: " + obj.toString());

		return obj.toString();
	}
}
