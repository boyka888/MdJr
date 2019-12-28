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
 * @version $Id: Inform.java, v 0.1 2019-12-10 16:40 tangyue Exp $$
 */
@Data
@TableName(value = "md_inform")
public class Inform implements Serializable {

    private Long id;

    private Long newId;

    private Long typeId;

    private String lang;

    private String title;

    private String subTitle;

    private String content;

    private String remark;

    private String tdate;
}
