package com.controller;

import com.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

/*    @RequestMapping("/")
    public String index(){

    }*/
}
