package com.swp.thymeleaf.controller;

import com.swp.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-03 5:04 PM
 */
@Controller
public class WebController {

    @RequestMapping("/string")
    public String string(Model model){
        model.addAttribute("username","thymeleaf");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(Model model){
        model.addAttribute("flag","no");
        return "if";
    }

    @RequestMapping("/list")
    public String list(Model model){

        List<User> users = new ArrayList<>();
        users.add(new User("zhang", 21));
        users.add(new User("wang", 22));
        users.add(new User("li", 23));
        model.addAttribute("users",users);

        return "list";
    }

    @RequestMapping("/url")
    public String url(Model model) {
        model.addAttribute("type","link");
        model.addAttribute("pageId","springcloud/2017/07/11");
        model.addAttribute("img","http://www.ityouknow.com/assets/images/neo.jpg");
        return "url";
    }

    @RequestMapping("/switch")
    public String switchcase(Model model){
        model.addAttribute("sex","women");
        return "switch";
    }

    @RequestMapping("/inline")
    public String inline(Model model) {
        model.addAttribute("username","thymeleaf");
        return "inline";
    }

    @RequestMapping("/utility")
    public String utility(Model map) {
        map.addAttribute("userName", "neo");
        map.addAttribute("users", getUserList());
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "utility";
    }

    private List<User> getUserList(){
        List<User> users=new ArrayList<User>();
        users.add(new User("zhang", 21));
        users.add(new User("wang", 22));
        users.add(new User("li", 23));
        return  users;
    }


}
