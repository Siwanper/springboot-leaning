package com.swp.jpa.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-09 3:43 PM
 */

@ControllerAdvice
public class GloabExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exception(RedirectAttributes attributes, Exception e){
        attributes.addFlashAttribute("errorMsg",e.getCause().getMessage());
        return "redirect:/error/500";
    }

}
