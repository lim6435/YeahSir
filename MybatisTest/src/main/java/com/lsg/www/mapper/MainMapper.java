package com.lsg.www.mapper;

import java.util.HashMap;

import com.lsg.www.vo.YsCoptVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MainMapper {
	public HashMap getYsCopt(YsCoptVo vo) throws Exception;
}
	