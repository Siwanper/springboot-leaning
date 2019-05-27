package com.swp.jpa.controller;

import com.swp.jpa.model.User;
import com.swp.jpa.param.UserParam;
import com.swp.jpa.service.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-09 11:14 AM
 */
@Controller
public class UserController implements ErrorController{


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       Model model){
        Sort sort = new Sort(Sort.Direction.ASC, "uid");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> users = userRepository.findAll(pageable);
        model.addAttribute("users",users);
        return "/user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/user/userAdd";
    }

    @Transactional
    @RequestMapping("/add")
    public String add(@RequestParam(name = "birthday") String birthday, @Valid UserParam userParam, BindingResult result, Model model) throws ParseException {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            return "user/userAdd";
        }
        User u= userRepository.findByUserName(userParam.getUserName());
        if (u != null) {
            model.addAttribute("errorMsg","用户已存在!");
            return "user/userAdd";
        }
        User user = new User();
        BeanUtils.copyProperties(userParam, user);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date userBirthday = format.parse(birthday);
        user.setUserBirthday(userBirthday);
        user.setUserRegTime(new Date());
        userRepository.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Long uid, Model model){
        Optional<User> optionalUser = userRepository.findById(uid);
        User user = optionalUser.get();
        model.addAttribute("user",user);
        return "/user/userEdit";
    }

    @Transactional
    @RequestMapping("/edit")
    public String edit(@RequestParam(name = "birthday") String birthday, @Valid UserParam userParam, BindingResult result,Model model) throws ParseException {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            model.addAttribute("user", userParam);
            return "user/userEdit";
        }

        User u= userRepository.findByUserName(userParam.getUserName());
        if (u != null) {
            model.addAttribute("errorMsg","用户姓名不能重复!");
            model.addAttribute("user", userParam);
            return "user/userEdit";
        }

        User user=new User();
        BeanUtils.copyProperties(userParam,user);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date userBirthday = format.parse(birthday);
        user.setUserBirthday(userBirthday);
        user.setUserRegTime(new Date());
        userRepository.save(user);
        return "redirect:/list";
    }

    @Transactional
    @RequestMapping("/delete")
    public String delete(Long uid){
        userRepository.deleteById(uid);
        return "redirect:/list";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(Model model){
        return "/error/404";
    }

}
