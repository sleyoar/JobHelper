package com.controller;

import com.entity.Contact;
import com.service.ContactService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

/*     @RequestMapping("/contactSave")
    public String contactSave(Contact contact, HttpServletResponse response) {
        contact.setContactId();
     }*/
}
