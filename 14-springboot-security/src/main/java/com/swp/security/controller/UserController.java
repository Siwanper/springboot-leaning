package com.swp.security.controller;

import com.swp.security.model.SysUser;
import com.swp.security.repository.UserRepository;
import com.swp.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-11 11:06 AM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('userInfo/userList')")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "/user/index";
    }

    @PreAuthorize("hasAuthority('userInfo/userList')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<SysUser> users = repository.findAll();
        model.addAttribute("users", users);
        return "/user/list";
    }

    @PreAuthorize("hasAuthority('userInfo/userAdd')")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(){
        return "/user/add";
    }

    @PreAuthorize("hasAuthority('userInfo/userDel')")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(){
        return "/user/delete";
    }

    @PreAuthorize("hasAuthority('userInfo/userEdit')")
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(){
        return "/user/edit";
    }

}
