/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.client.entity.Inform;
import com.md.client.mapper.InformMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: InformService.java, v 0.1 2019-12-10 16:41 tangyue Exp $$
 */
@Service
public class InformService extends ServiceImpl<InformMapper, Inform> {

    public List<Inform> findByType(Long newId, String lang, Integer offset, Integer size) {
        return this.baseMapper.selectByType(newId, lang, offset, size);
    }

    public Integer countByType(Long newId, String lang){
        return this.baseMapper.countByType(newId, lang);
    }

    public Inform findByTypeId(Long typeId, String lang) {
        return this.baseMapper.selectTypeId(typeId, lang);
    }
}
