package com.md.client.web.face;

import com.md.client.entity.News;
import com.md.client.service.NewsService;
import com.md.client.web.model.SubModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tang
 * 2019-12-10
 */
@Service
public class CommonService {

    @Autowired
    private NewsService newsService;

    public List<SubModel> getNav(Long parentId, String lang){

        List<SubModel> list = new ArrayList<>();

        List<News> news = this.newsService.findByParentId(parentId, lang, "index");
        if (news != null){

            for (News item : news){
                SubModel subModel = new SubModel();
                subModel.setTitle(item.getTitle());
                subModel.setType(item.getType());
                subModel.setId(item.getId());
                subModel.setParentId(item.getParentId());

                List<News> lst = this.newsService.findByParentId(item.getId(), lang, "index");
                if (lst != null) {

                    List<News> left = new ArrayList<>();
                    List<News> right = new ArrayList<>();
                    for (News tmp : lst) {
                        tmp.setContent(null);
                        tmp.setSubTitle(null);
                        if (tmp.getLevel().equals(1)){
                            left.add(tmp);
                        } else {
                            right.add(tmp);
                        }
                    }
                    subModel.setLeft(left);
                    subModel.setRight(right);
                }

                list.add(subModel);
            }

        }

        return list;
    }
}
