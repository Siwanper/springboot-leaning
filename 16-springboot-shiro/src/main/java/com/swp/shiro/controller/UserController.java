package com.swp.shiro.controller;

import com.swp.shiro.model.SysUser;
import com.swp.shiro.repository.UserRepository;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 4:30 PM
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")
    public String userInfo(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "5") int size, Model model){

        Pageable pageable = PageRequest.of(page,size);

        Page<SysUser> userList = repository.findAll(pageable);
        System.out.println("users : " + userList);
        model.addAttribute("userList",userList);
        return "userInfo";
    }

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userAdd(){
        return "userAdd";
    }

    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userDel(){
        return "userDel";
    }


}
