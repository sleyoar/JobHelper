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
@SessionAttributes({"jobs", "jobs1","users", "resumes", "blogs","blogs1"})
public class CommonController {

    @Autowired
    private JobService jobService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String index(Model model){
        List<Job> jobs = jobService.selectAll();
        List<Job> jobs1 = jobService.selectSome();
        List<User> users = userService.selectAll();
        List<Resume> resumes = resumeService.selectAll();
        List<Blog> blogs = blogService.selectAll();
        List<Blog> blogs1 = blogService.selectSome();
        model.addAttribute("jobs",jobs);
        model.addAttribute("users",users);
        model.addAttribute("resumes",resumes);
        model.addAttribute("blogs",blogs);
        model.addAttribute("blogs1",blogs1);
        model.addAttribute("jobs1",jobs1);
        return "index";
    }




}
