package com.swp.springbootfileupload.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 描述: 统一处理服务器500异常
 *
 * @outhor ios
 * @create 2019-01-04 3:01 PM
 */
@ControllerAdvice
public class GloadExceptionController {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e, RedirectAttributes attributes){
        System.out.println(e.getClass().getName());
        attributes.addFlashAttribute("message", "error : " + e.getCause().getMessage());
        return "redirect:/uploadStatus";
    }

}
