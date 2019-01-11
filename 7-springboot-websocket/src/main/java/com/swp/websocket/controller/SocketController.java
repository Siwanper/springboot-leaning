package com.swp.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-11 11:34 AM
 */
@Controller
public class SocketController {

    @RequestMapping("/")
    public String index(){
        return "socket";
    }

}
