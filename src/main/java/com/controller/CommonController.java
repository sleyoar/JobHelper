package com.controller;

import com.entity.Blog;
import com.entity.Job;
import com.entity.Resume;
import com.entity.User;
import com.service.BlogService;
import com.service.JobService;
import com.service.ResumeService;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"user", "jobs", "users", "resumes", "blogs"})
public class CommonController {

    @Autowired
    private JobService jobService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(Model model){
        List<Job> jobs = jobService.selectAll();
        List<Job> jobs1 = jobService.selectSome();
        List<User> users = userService.selectAll();
        List<Resume> resumes = resumeService.selectAll();
        List<Blog> blogs = blogService.selectAll();
        model.addAttribute("jobs",jobs);
        model.addAttribute("users",users);
        model.addAttribute("resumes",resumes);
        model.addAttribute("blogs",blogs);
        model.addAttribute("jobs1",jobs1);
        return "index";
    }

    @RequestMapping("/alljob")
    public String alljobs(){
        return "job-board";
    }
    @RequestMapping("/register")
    public String register(){
        return "login";
    }
    @RequestMapping("/resume")
    public String resume(@RequestParam("userId") Integer userId) {
        System.out.println(userId);
        return "resume";
    }
    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }
    @RequestMapping("/blogdetails")
    public String blogdetails() {
        return "blog-details";
    }
    @RequestMapping("contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/login")
    public String Login(@RequestParam("userName")String userName,
                        @RequestParam("userPassword")String userPassword, Model model){
        User user = userService.verifyUser(userName);
        if (user!=null && userPassword.equals(user.getUserPassword())){
            model.addAttribute("user",user);
            return "forward:/";
        } else {
            model.addAttribute("msg","用户名或密码错误！");
            return "redirect:/";
        }
    }


}
