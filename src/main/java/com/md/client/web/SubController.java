package com.md.client.web;

import com.md.client.entity.Inform;
import com.md.client.entity.News;
import com.md.client.service.InformService;
import com.md.client.service.NewsService;
import com.md.client.web.model.SubModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tang
 * 2019-12-07
 */
@Controller
@RequestMapping(value = "/sub")
public class SubController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private InformService informService;

    @RequestMapping(value = "/{menuId}")
    public String sub(@PathVariable("menuId") Long menuId, Model model,
                      @ModelAttribute("lang") String lang){

        News news = newsService.findByTypeId(menuId, lang);
        if (news == null){
            return "index";
        }
        SubModel sub = new SubModel();
        sub.setTitle(news.getTitle());
        sub.setSubTitle(news.getSubTitle());
        sub.setContent(news.getContent());

        List<News> newsList = this.newsService.findByParentId(news.getParentId(), lang, null);

        if (newsList != null && !newsList.isEmpty()) {
            List<News> left = new ArrayList<>();
            List<News> right = new ArrayList<>();
            for (News tmp : newsList) {
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

        List<Inform> news1 = this.informService.findByType(menuId, lang, 0,4);
        model.addAttribute("news1", news1);


        List<News> contents = this.newsService.findContent(lang);
        model.addAttribute("contents", contents);
        return "sub";
    }

}
