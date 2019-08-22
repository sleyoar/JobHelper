package com.controller;

import com.entity.Resume;
import com.service.ResumeService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private UserService userService;

    @RequestMapping("/resume")
    public ModelAndView resume(HttpServletRequest request, Model model) {
        String userId = request.getParameter("userId");
        ModelAndView mv = new ModelAndView();
        if (userId!=null){
            Integer userId1 = Integer.parseInt(request.getParameter("userId"));
            Integer resumeId = userService.selectByPrimaryKey(userId1).getResumeId();
            Resume resume = resumeService.selectByPrimaryKey(resumeId);
            if (resume!=null) {
                mv.addObject("resume",resume);
                mv.setViewName("resume");
                System.out.println(resume);
                return mv;
            }
        }
        mv.setViewName("resume");
        return mv;
    }

    @RequestMapping("/resumeSave")
    public String resumeSave(Resume resume,Model model) {
        if (resumeService.selectByPrimaryKey(resume.getResumeId())!=null){
            resumeService.updateByPrimaryKey(resume);
            Resume resume1 = resumeService.selectByPrimaryKey(resume.getResumeId());
            model.addAttribute("resume",resume1);
            return "resume";
        }
        resumeService.insert(resume);
        return "resume";
    }
}
