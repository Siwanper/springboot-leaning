package com.swp.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-30 5:08 PM
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login_error")
    public String loginError(Model model){
        model.addAttribute("msg", "登录错误");
        return "login";
    }

}
