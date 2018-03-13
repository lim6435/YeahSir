package com.lsg.www.controller;

import com.lsg.www.mapper.MainMapper;
import com.lsg.www.mapper.YsMemMapper;
import com.lsg.www.vo.YsCoptVo;
import com.lsg.www.vo.YsMemVO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class WebRestController {
    private static final Logger log = LoggerFactory.getLogger(WebRestController.class);

    @Autowired
    private YsMemMapper ysMemMapper;
    @Autowired
    private MainMapper mainMapper;


    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})

    public String test(@RequestBody String str) throws Exception {
        log.info("Original String ::: " + str);
        str = new String(str.getBytes(), "UTF-8");
        log.info("Converting String ::: " + str);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject)parser.parse(str);

        log.info("Request JSON DATA [" + object.toString() + "]");
        String reqId = (String) object.get("id");
        String password = (String) object.get("pwd");
        YsMemVO memVo = new YsMemVO();
        memVo.setMemId(reqId);
        memVo.setMemPwd(password);

        log.info("Request Parameter : " + reqId + " \t##### pwd : " + password);
        HashMap result = ysMemMapper.getYsMem(memVo);
        YsCoptVo coptVo = new YsCoptVo();
        List<HashMap> coptList = mainMapper.getYsCopt(coptVo);

        JSONObject obj = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < coptList.size(); i++) {
            JSONObject tempObj = new JSONObject();
            tempObj.putAll(coptList.get(i));
            jsonArray.add(tempObj);
        }

        obj.put("getCoptList", jsonArray);
        obj.putAll(result);

        log.info("result json :: " + obj.toJSONString());
        return obj.toJSONString();
    }
}
