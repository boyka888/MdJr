/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.client.entity.News;
import com.md.client.mapper.NewsMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: NewsService.java, v 0.1 2019-12-09 18:00 tangyue Exp $$
 */
@Service
public class NewsService extends ServiceImpl<NewsMapper, News> {

    public News findTextOne(String lang, String type) {
        return this.baseMapper.selectTextOne(lang, type);
    }

    public List<News> findByParentId(Long parentId, String lang, String type) {
        return this.baseMapper.selectByParentId(parentId, lang, type);
    }

    public List<News> findNavs(String lang){
        return this.baseMapper.selectNav(lang);
    }


    public List<News> findContent(String lang) {
        return this.baseMapper.selectContent(lang);
    }


    public News findByTypeId(Long typeId, String lang) {
        return this.baseMapper.selectTypeId(typeId, lang);
    }
}
