package com.lsg.www.mapper;

import com.lsg.www.vo.YsMemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface YsMemMapper {
	public HashMap getYsMem(YsMemVO vo) throws Exception;
	public void insYsMem(YsMemVO vo) throws  Exception;
}
