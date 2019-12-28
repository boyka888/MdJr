/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.web;

import com.md.client.entity.Inform;
import com.md.client.entity.News;
import com.md.client.service.InformService;
import com.md.client.service.NewsService;

import com.md.client.web.face.CommonService;
import com.md.client.web.model.SubModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author tangyue
 * @version $Id: IndexController.java, v 0.1 2019-12-05 13:05 tangyue Exp $$
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private InformService informService;

    @RequestMapping(value = "/")
    public String toIndex(){
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){

        String lang = (String) request.getSession().getAttribute("lang");
        log.info("index: {}", lang);

        List<News> news = this.newsService.findNavs(lang);
        model.addAttribute("navs", news);

        List<News> contents = this.newsService.findContent(lang);
        model.addAttribute("contents", contents);

        List<Inform> news1 = this.informService.findByType(14L, lang, 0, 6);
        model.addAttribute("news1", news1);
        List<Inform> news2 = this.informService.findByType(16L, lang, 0, 6);
        model.addAttribute("news2", news2);
        List<Inform> plats1 = this.informService.findByType(20L, lang, 0,6);
        model.addAttribute("plats1", plats1);
        List<Inform> plats2 = this.informService.findByType(21L, lang, 0,6);
        model.addAttribute("plats2", plats2);

        return "index";
    }

    @GetMapping(value = "/nav")
    @ResponseBody
    public Object getNav(@ModelAttribute("lang") String lang){

        return this.commonService.getNav(0L, lang);
    }

}
