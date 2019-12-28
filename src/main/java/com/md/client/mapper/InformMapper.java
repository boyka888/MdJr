/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.md.client.entity.Inform;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: InformMapper.java, v 0.1 2019-12-10 16:41 tangyue Exp $$
 */
public interface InformMapper extends BaseMapper<Inform> {

    List<Inform> selectByType(@Param("newId") Long newId,
                              @Param("lang") String lang,
                              @Param("offset") Integer offset,
                              @Param("size") Integer size
                              );

    Integer countByType(@Param("newId") Long newId,
                        @Param("lang") String lang);

    /**
     *
     * @param typeId
     * @param lang
     * @return
     */
    Inform selectTypeId(@Param("typeId") Long typeId, @Param("lang") String lang);
}
