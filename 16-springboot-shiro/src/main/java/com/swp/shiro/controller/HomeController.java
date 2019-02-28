package com.swp.shiro.controller;

import com.swp.shiro.tools.vcode.Captcha;
import com.swp.shiro.tools.vcode.GifCaptcha;
import com.swp.shiro.tools.vcode.SpecCaptcha;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-02-22 4:30 PM
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * 首页
     * @return
     */
    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String ,Object> map, String username, String password){
        return "login";
    }

    @RequestMapping("/kickout")
    public String kickout(){
        return "kickout";
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin(){
        return "redirect:/login";
    }
    /**
     * 登录接口
     * @param username
     * @param password
     * @param rememberMe
     * @param map
     * @return
     */
    @RequestMapping( value = "/toLogin", method = RequestMethod.POST)
    public String toLogin(String username, String password, String vcode, Boolean rememberMe, Map<String, Object> map) {
        logger.info("登录用户：" + username +" "+ password +" "+ vcode + rememberMe);
        if (vcode == null || vcode == "") {
            map.put("msg" , "验证码不能为空！");
            return "/login";
        }

        Session session = SecurityUtils.getSubject().getSession();
        String svcode = (String) session.getAttribute("vcode");
        if (!svcode.equals(vcode.toLowerCase())) {
            map.put("msg" , "验证码有误！");
            return "/login";
        }

        if (rememberMe == null) {
            rememberMe = false;
        }

        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            SecurityUtils.getSubject().login(token);
            return "redirect:/index";
        } catch (Exception e) {
            String msg = "";
            String ename = e.getClass().getName();
            if (UnknownAccountException.class.getName().equals(ename)) {
                logger.info("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(ename)) {
                logger.info("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(ename)) {
                logger.info("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            }  else {
                msg = "else >> "+e.getMessage();
                logger.info("else >>" + e.getMessage());
            }
            map.put("msg", msg);
            return "/login";
        }
    }

    /**
     * 获取验证码
     * @param response
     * @param request
     */
    @RequestMapping(value = "/getVcode", method=RequestMethod.GET, produces = "image/png" )
    public void getVcode(HttpServletResponse response, HttpServletRequest request){

        try {
            /**
             * 获取gif验证码
             */
            Captcha captcha = new SpecCaptcha(144 , 33, 4);
            captcha.out(response.getOutputStream());
            // 保持在session中，登录时比对
            HttpSession session = request.getSession(true);
            session.setAttribute("vcode", captcha.text().toLowerCase());

        } catch (IOException e) {
            e.printStackTrace();
            logger.info("获取验证码失败");
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }


}
