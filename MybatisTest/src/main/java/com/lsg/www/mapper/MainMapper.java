package com.lsg.www.mapper;

import java.util.HashMap;
import java.util.List;

import com.lsg.www.vo.YsCoptVo;

public interface MainMapper {
	public List<YsCoptVo> getYsCopt(YsCoptVo vo) throws Exception;
}