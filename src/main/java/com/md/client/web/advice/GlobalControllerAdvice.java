/**
 * chenxitech.cn Inc. Copyright (c) 2017-2019 All Rights Reserved.
 */
package com.md.client.web.advice;

import com.md.client.entity.Lang;
import com.md.client.entity.SysVar;
import com.md.client.service.LangService;
import com.md.client.service.SysVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tangyue
 * @version $Id: GlobalControllerAdvice.java, v 0.1 2019-12-09 18:34 tangyue Exp $$
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @Autowired
    private SysVarService varService;

    @Autowired
    private LangService langService;

    @ModelAttribute
    public void lang(@RequestParam(value = "lang", required = false) String lang, Model model, HttpServletRequest request) {
        log.info("lang: {}", lang);
        HttpSession session = request.getSession();

        Object s = session.getAttribute("lang");
        if (lang == null && s != null){
            lang = s.toString();
        } else {
            Lang lg = this.langService.selectByLang(lang);
            if (lg != null){
                lang = lg.getGtLang();
            } else {
                SysVar var = this.varService.findByVarName("lang");
                log.info("sys var info: {}", var);
                if (lang == null){
                    lang = var.getVarValue();
                    session.setAttribute("lang", lang);
                }
            }
        }


        if (lang.equals("CN")){
            lang = "zh-CN";
            session.setAttribute("lang", lang);
        }

        if (!lang.equals(s)){
            session.setAttribute("lang", lang);
        }
        log.info("lang end: {}", lang);
        model.addAttribute("lang", lang);
    }

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception ex){

        log.error("Exception info: {}", ex.fillInStackTrace());
    }
}
