package com.swp.dockerdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESCRIPTION：   ${DESCRIPTION}
 *
 * @ProjectName: dockerdemo
 * @Package: com.swp.dockerdemo.controller
 * @Author: Siwanper
 * @CreateDate: 2019/4/24 下午9:48
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */

@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "Hello Docker!";
    }

}
