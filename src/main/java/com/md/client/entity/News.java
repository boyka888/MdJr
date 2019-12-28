/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author tangyue
 * @version $Id: News.java, v 0.1 2019-12-09 17:56 tangyue Exp $$
 */
@Data
@TableName(value = "md_news")
public class News implements Serializable {

    private Long id;

    private String lang;

    private Long parentId;

    private String type;

    private Long typeId;

    private Integer level;

    private Integer sort;

    private String title;

    private String subTitle;

    private String content;
}
