package com.swp.dockercompose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-05-25 12:49 PM
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){

        return "index";
    }


}
