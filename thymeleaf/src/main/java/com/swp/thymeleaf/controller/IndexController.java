package com.swp.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-04 10:47 AM
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "views/index";
    }

}
