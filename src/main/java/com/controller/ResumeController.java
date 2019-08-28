package com.controller;

import com.entity.Resume;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ResumeService;
import com.service.UserService;
import com.util.Msg;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
                //System.out.println("更新前"+resume);
                return mv;
            }
        }
        mv.setViewName("resume");
        return mv;
    }

    @RequestMapping("/resumeSave")
    public String resumeSave(Resume resume,Model model) {
        //System.out.println("页面传值"+resume);
        if (resumeService.selectByPrimaryKey(resume.getResumeId())!=null){
            resumeService.updateByPrimaryKey(resume);
            Resume resume1 = resumeService.selectByPrimaryKey(resume.getResumeId());
            //System.out.println("更新后："+resume1);
            model.addAttribute("resume",resume1);
            return "resume";
        }
        resumeService.insert(resume);
        return "resume";
    }

    @RequestMapping("/manageResume")
    @ResponseBody
    public Msg getResumes(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Resume> resumes = resumeService.selectAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(resumes, 3);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/addResume")
    @ResponseBody
    public Msg addResume(Resume resume) {
        if (resumeService.insert(resume) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping("/deleteResume")
    @ResponseBody
    public Msg deleteResume(Integer id) {
        if (resumeService.deleteByPrimaryKey(id) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/editResume")
    @ResponseBody
    public Msg editResume(@RequestParam("id") Integer id) {
        Resume resume = resumeService.selectByPrimaryKey(id);
        if (resume != null) {
            return Msg.success().add("resume", resume);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateResume")
    @ResponseBody
    public Msg updateResume(Resume resume) {
        if (resumeService.updateByPrimaryKey(resume) > 0) {
            return Msg.success().add("resume", resume);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/batchDeleteResume")
    @ResponseBody
    public Msg batchDeleteResume(@RequestBody String ids) {
        JSONArray json = JSONArray.fromObject(ids);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            list.add(Integer.parseInt((String) json.get(i)));
        }
        try {
            if (list != null && list.size() > 0) {
                resumeService.batchDelete(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.success();
    }


}
