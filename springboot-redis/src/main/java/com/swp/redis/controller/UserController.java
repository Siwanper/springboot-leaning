package com.swp.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-12 3:27 PM
 */
@RestController
public class UserController {

    @RequestMapping("/sessionId")
    public String index(HttpSession session){
       return session.getId();
    }

}
