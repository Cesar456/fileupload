package com.cesar.fileuploadtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cesar on 2016/11/10.
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
