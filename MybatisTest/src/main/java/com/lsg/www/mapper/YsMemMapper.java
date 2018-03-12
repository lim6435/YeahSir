package com.lsg.www.mapper;

import com.lsg.www.vo.YsMemVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface YsMemMapper {
	public HashMap getYsMem(YsMemVO vo) throws Exception;
	public void insYsMem(YsMemVO vo) throws  Exception;
}
