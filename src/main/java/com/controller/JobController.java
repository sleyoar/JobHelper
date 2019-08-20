package com.controller;

import com.entity.Job;  
import com.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String index(Model model){
        List<Job> jobs = jobService.selectAll();
        model.addAttribute("jobs",jobs);
        return "index";
    }
}
