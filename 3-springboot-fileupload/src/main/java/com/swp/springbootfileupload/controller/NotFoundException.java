package com.swp.springbootfileupload.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 描述:统一处理404异常
 *
 * @outhor ios
 * @create 2019-01-04 3:49 PM
 */
@Controller
public class NotFoundException implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(ModelMap map){
        map.addAttribute("message", "404 not found link！");
        return "uploadStatus";
    }

}
