package com.controller;

import com.entity.Admin;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private JobService jobService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        request.getSession().setAttribute("admins", adminService.selectAll());
        request.getSession().setAttribute("users", userService.selectAll());
        request.getSession().setAttribute("jobs", jobService.selectAll());
        request.getSession().setAttribute("resumes", resumeService.selectAll());
        request.getSession().setAttribute("contacts", contactService.selectAll());
        request.getSession().setAttribute("blogs", blogService.selectAll());
        return "manager/index";
    }

    @RequestMapping("desktop")
    public String desktop() {
        return "manager/welcome";
    }

    @RequestMapping("/blogManage")
    public String blogManage() {
        return "manager/article-list";
    }

    @RequestMapping("/changeAdmin")
    public String changeAdmin() {
        return "manager/login";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestParam("adminName") String adminName,
                             @RequestParam("adminPassword") String adminPassword,
                             HttpServletRequest request) {
        Admin admin = adminService.verifyAdmin(adminName);
        if (adminPassword.equals(admin.getAdminPassword())) {
            request.getSession().setAttribute("admin",admin);
            return "manager/index";
        } else {
            request.setAttribute("msg","用户名或密码错误！");
            return "forward:/changeAdmin";
        }
    }

    @RequestMapping("/adminLogout")
    public String adminLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "forward:/";
    }
}
