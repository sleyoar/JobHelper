package com.controller;

import com.entity.Resume;
import com.service.ResumeService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;

    @RequestMapping("/resume")
    public ModelAndView resume(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        ModelAndView mv = new ModelAndView();
        if (userId!=null){
            Integer userId1 = Integer.parseInt(request.getParameter("userId"));
            Resume resume = resumeService.selectByUserId(userId1);
            if (resume!=null) {
                mv.addObject("resume",resume);
                mv.setViewName("resume");
                System.out.println("更新前"+resume);
                return mv;
            }
        }
        mv.setViewName("resume");
        return mv;
    }

    @RequestMapping("/resumeSave")
    public String resumeSave(Resume resume,Model model) {
        System.out.println("页面传值"+resume);
        if (resumeService.selectByPrimaryKey(resume.getResumeId())!=null){
            resumeService.updateByPrimaryKey(resume);
            Resume resume1 = resumeService.selectByPrimaryKey(resume.getResumeId());
            System.out.println("更新后："+resume1);
            model.addAttribute("resume",resume1);
            return "resume";
        }
        resumeService.insert(resume);
        return "resume";
    }
}
