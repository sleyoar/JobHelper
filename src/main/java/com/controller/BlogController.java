package com.controller;

import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

}
