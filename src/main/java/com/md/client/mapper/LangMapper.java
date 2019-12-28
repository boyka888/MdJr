/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.client.entity.Lang;
import com.md.client.entity.News;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author tangyue
 * @version $Id: NewsMapper.java, v 0.1 2019-12-09 17:58 tangyue Exp $$
 */
public interface LangMapper extends BaseMapper<Lang> {

    /**
     * 通过前端语言标识查询谷歌翻译语言标识
     * @param lang
     * @return
     */
    Lang selectByLang(@Param("lang") String lang);

}
