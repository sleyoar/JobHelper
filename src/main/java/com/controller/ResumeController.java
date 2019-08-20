package com.controller;

import com.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    
}
