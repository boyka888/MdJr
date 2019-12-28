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
 * @version $Id: Lang.java, v 0.1 2019-12-23 13:00 tangyue Exp $$
 */
@Data
@TableName("md_lang")
public class Lang implements Serializable {

    private Long id;

    private String lang;

    private String gtLang;

    private String remark;

}
