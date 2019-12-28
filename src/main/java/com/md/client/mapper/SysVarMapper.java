package com.md.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.client.entity.SysVar;
import org.apache.ibatis.annotations.Param;

/**
 * @author tang
 * 2019-12-13
 */
public interface SysVarMapper extends BaseMapper<SysVar> {

    SysVar selectByVarName(@Param("varName") String varName);
}
