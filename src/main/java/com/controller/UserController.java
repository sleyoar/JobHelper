package com.controller;

import com.entity.Admin;
import com.entity.User;
import com.service.AdminService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/register")
    public String register(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(@RequestParam("userName")String userName,
                        @RequestParam("userPassword")String userPassword, HttpServletRequest request){
        User user = userService.verifyUser(userName);
        Admin admin = adminService.verifyAdmin(userName);
        if (user!=null && userPassword.equals(user.getUserPassword())){
            request.getSession().setAttribute("user",user);
            return "forward:/";
        } else if (admin !=null && userPassword.equals(admin.getAdminPassword())){
            request.getSession().setAttribute("admin",admin);
            return "forward:/admin";
        } else {
            request.setAttribute("msg","用户名或密码错误！");
            return "forward:/";
        }
    }

    @RequestMapping("/userSave")
    private String userSave(User user, HttpServletRequest request, Model model){
        if (request.getParameter("userPassword").equals(request.getParameter("userPassword2"))){
            user.setUserId(userService.selectAll().size()+1);
            userService.insert(user);
            model.addAttribute("user",userService.selectByPrimaryKey(user.getUserId()));
            return "forward:/";
        } else {
            user=null;
            model.addAttribute("msg1","两次密码不一致");
            return "forward:/register" ;
        }
    }
}
