package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(@RequestParam("userName")String userName,
                        @RequestParam("userPassword")String userPassword, Model model){
        User user = userService.verifyUser(userName);
        if (user!=null && userPassword.equals(user.getUserPassword())){
            model.addAttribute("user",user);
            return "forward:/";
        } else {
            model.addAttribute("msg","用户名或密码错误！");
            return "forward:/";
        }
    }
}
