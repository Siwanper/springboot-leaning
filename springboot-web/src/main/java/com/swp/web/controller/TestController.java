package com.swp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-03 2:53 PM
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }

}
