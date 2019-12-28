/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.web;

import com.md.client.entity.Inform;
import com.md.client.entity.News;
import com.md.client.service.InformService;
import com.md.client.service.NewsService;
import com.md.client.web.model.SubModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tangyue
 * @version $Id: DetailController.java, v 0.1 2019-12-10 10:35 tangyue Exp $$
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/inform")
public class DetailController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private InformService informService;


    @RequestMapping(value = "/{informId}")
    public String getDetail(@PathVariable(value = "informId") Long informId, Model model,
                            @ModelAttribute("lang") String lang){

        Inform inform = informService.findByTypeId(informId, lang);
        if (inform == null){
            return "index";
        }
        SubModel sub = new SubModel();
        sub.setInformTitle(inform.getTitle());
        sub.setTdate(inform.getTdate());

        News news = newsService.findByTypeId(inform.getNewId(), lang);
        if (news == null){
            return "index";
        }
        sub.setContent(inform.getContent());
        sub.setTitle(news.getTitle());
        sub.setSubTitle(news.getSubTitle());

        List<News> newsList = this.newsService.findByParentId(news.getParentId(), lang, "index");

        if (newsList != null && !newsList.isEmpty()) {
            List<News> left = new ArrayList<>();
            List<News> right = new ArrayList<>();
            for (News tmp : newsList) {
                if (inform.getNewId().equals(tmp.getTypeId())){
                    sub.setTitle(tmp.getTitle());
                    sub.setSubTitle(tmp.getSubTitle());
                }
                if (tmp.getLevel().equals(1)){
                    if (tmp.getSort() == 1){
                        sub.setLeftTitle(tmp.getTitle());
                        continue;
                    }
                    left.add(tmp);
                } else {
                    if (tmp.getSort() == 1){
                        sub.setRightTitle(tmp.getTitle());
                        continue;
                    }
                    right.add(tmp);
                }


            }
            sub.setLeft(left);
            sub.setRight(right);
        }

        model.addAttribute("subModel", sub);

        List<News> navs = this.newsService.findNavs(lang);
        model.addAttribute("navs", navs);

        List<Inform> news1 = this.informService.findByType(informId, lang, 0, 4);
        model.addAttribute("news1", news1);


        List<News> contents = this.newsService.findContent(lang);
        model.addAttribute("contents", contents);

        return "detail";
    }

    @GetMapping(value = "/list/{newId}")
    public Object getInformPage(@ModelAttribute("lang") String lang,
                                @PathVariable(value = "newId") Long newId,
                                @RequestParam(value = "offset", defaultValue = "0") Integer offset, Model model
                                ){

        List<Inform> informs = this.informService.findByType(newId, lang, offset, 10);
        model.addAttribute("informs", informs);

        model.addAttribute("total", 100);
        model.addAttribute("page", offset);

        News news = newsService.findByTypeId(newId, lang);
        if (news == null){
            return "index";
        }
        SubModel sub = new SubModel();

        sub.setContent(news.getContent());
        sub.setTitle(news.getTitle());
        sub.setSubTitle(news.getSubTitle());

        List<News> newsList = this.newsService.findByParentId(news.getParentId(), lang, "index");

        if (newsList != null && !newsList.isEmpty()) {
            List<News> left = new ArrayList<>();
            List<News> right = new ArrayList<>();
            for (News tmp : newsList) {
                /*if (news.getTypeId().equals(tmp.getTypeId())){
                    sub.setTitle(tmp.getTitle());
                    sub.setSubTitle(tmp.getSubTitle());
                }*/
                if (tmp.getLevel().equals(1)){
                    if (tmp.getSort() == 1){
                        sub.setLeftTitle(tmp.getTitle());
                        continue;
                    }
                    left.add(tmp);
                } else {
                    if (tmp.getSort() == 1){
                        sub.setRightTitle(tmp.getTitle());
                        continue;
                    }
                    right.add(tmp);
                }


            }
            sub.setLeft(left);
            sub.setRight(right);
        }

        model.addAttribute("subModel", sub);

        List<News> navs = this.newsService.findNavs(lang);
        model.addAttribute("navs", navs);

        List<Inform> news1 = this.informService.findByType(newId, lang, 0, 4);
        model.addAttribute("news1", news1);


        List<News> contents = this.newsService.findContent(lang);
        model.addAttribute("contents", contents);
        return "informList";
    }
}
