package com.controller;

import com.entity.Blog;
import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }

    @RequestMapping("/blogdetails")
    public ModelAndView blogdetails(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Blog blog = blogService.selectByPrimaryKey(Integer.parseInt(request.getParameter("blogId")));
        //System.out.println(blog);
        mv.addObject("blog",blog);
        mv.setViewName("blog-details");
        return mv;
    }

}
