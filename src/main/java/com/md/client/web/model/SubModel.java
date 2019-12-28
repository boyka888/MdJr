package com.md.client.web.model;

import com.md.client.entity.News;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tang
 * 2019-12-09
 */
@Data
public class SubModel implements Serializable {

    private Long id;

    private Long parentId;

    private String type;

    private String title;

    private String subTitle;

    private String informTitle;

    private String tdate;

    private String content;

    private String leftTitle;

    private List<News> left;

    private String rightTitle;

    private List<News> right;
}
