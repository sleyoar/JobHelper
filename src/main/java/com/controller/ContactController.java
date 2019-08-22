package com.controller;

import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("contact")
    public String contact(){
        return "contact";
    }

}
