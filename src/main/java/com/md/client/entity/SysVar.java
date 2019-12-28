package com.md.client.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tang
 * 2019-12-13
 */
@Data
@TableName(value = "md_sys_var")
public class SysVar implements Serializable {

    private Long id;

    private String type;

    private String varName;

    private String varValue;

    private Integer status;
}
