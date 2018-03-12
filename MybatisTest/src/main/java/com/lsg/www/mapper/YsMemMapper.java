package com.lsg.www.mapper;

import com.lsg.www.vo.YsMemVO;

import java.util.HashMap;

public interface YsMemMapper {
	public HashMap getYsMem(YsMemVO vo) throws Exception;
	public void insYsMem(YsMemVO vo) throws  Exception;
}
