package com.swp.dockercompose.controller;

import com.swp.dockercompose.model.Visitor;
import com.swp.dockercompose.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-05-25 1:11 PM
 */
@Controller
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    private VisitorRepository repository;

    @RequestMapping("/")
    @ResponseBody
    public String visitor(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        Visitor visitor = repository.findByIp(ip);
        if (null == visitor) {
            visitor = new Visitor();
            visitor.setIp(ip);
            visitor.setTimes(1);
        } else {
            visitor.setTimes(visitor.getTimes() + 1);
        }
        repository.save(visitor);

        return "I have been seen ip:" + visitor.getIp() + " " + visitor.getTimes() + " times";
    }

}
