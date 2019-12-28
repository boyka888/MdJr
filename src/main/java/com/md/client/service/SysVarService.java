package com.md.client.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.client.entity.SysVar;
import com.md.client.mapper.SysVarMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author tang
 * 2019-12-13
 */
@Service
public class SysVarService extends ServiceImpl<SysVarMapper, SysVar> {

    @Cacheable(value = "client", key = "#varName", unless = "#result == null")
    public SysVar findByVarName(String varName){
        return this.baseMapper.selectByVarName(varName);
    }
}
