package com.controller;

import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/blogdetails")
    public String blogdetails() {
        return "blog-details";
    }

}
