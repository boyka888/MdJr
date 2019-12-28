/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.client.entity.News;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: NewsMapper.java, v 0.1 2019-12-09 17:58 tangyue Exp $$
 */
public interface NewsMapper extends BaseMapper<News> {

    /**
     * 查询title为text
     * @param lang
     * @param type
     * @return
     */
    News selectTextOne(@Param("lang") String lang, @Param("type") String type);

    /**
     * 通过perentId查询
     * @param parentId
     * @param lang
     * @return
     */
    List<News> selectByParentId(@Param("parentId") Long parentId,
                                @Param("lang") String lang,
                                @Param("type") String type
                                );


    /**
     * 导航
     * @param lang
     * @return
     */
    List<News> selectNav(@Param("lang") String lang);

    /**
     * 首页内容
     * @param lang
     * @return
     */
    List<News> selectContent(@Param("lang") String lang);

    /**
     * 新闻类型
     * @param typeId
     * @param lang
     * @return
     */
    News selectTypeId(@Param("typeId") Long typeId, @Param("lang") String lang);

}
