package com.md.client.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author tang
 * 2019-12-08
 */
@RestController
public class HeaderController {

    @GetMapping(value = "/lang")
    public String setLang(@ModelAttribute("lang") String lang){

        return lang;
    }
}
