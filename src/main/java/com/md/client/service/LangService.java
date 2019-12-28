/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.client.entity.Lang;
import com.md.client.mapper.LangMapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author tangyue
 * @version $Id: LangService.java, v 0.1 2019-12-23 13:02 tangyue Exp $$
 */
@Service
public class LangService extends ServiceImpl<LangMapper, Lang> {

    /**
     * 通过前端语言标识查询谷歌翻译语言标识
     * @param lang
     * @return
     */
    public Lang selectByLang(String lang) {
        if (StringUtils.isBlank(lang)){
            return null;
        }
        return this.baseMapper.selectByLang(lang);
    }
}
