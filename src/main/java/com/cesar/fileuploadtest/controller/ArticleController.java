package com.cesar.fileuploadtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cesar on 2016/11/30.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveArticle(@RequestParam("content") String content) {
        logger.info(content);
        return "ok";
    }


}
