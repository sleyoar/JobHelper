package com.controller;

import com.entity.Admin;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.util.Msg;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private JobService jobService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        request.getSession().setAttribute("admins", adminService.selectAll());
        request.getSession().setAttribute("users", userService.selectAll());
        request.getSession().setAttribute("jobs", jobService.selectAll());
        request.getSession().setAttribute("resumes", resumeService.selectAll());
        request.getSession().setAttribute("contacts", contactService.selectAll());
        request.getSession().setAttribute("blogs", blogService.selectAll());
        return "manager/index";
    }

    @RequestMapping("desktop")
    public String desktop() {
        return "manager/welcome";
    }

    @RequestMapping("/blogManage")
    public String blogManage() {
        return "manager/article-list";
    }

    @RequestMapping("/jobManager")
    public String jobManager() {
        return "manager/job-list";
    }

    @RequestMapping("/contactManager")
    public String contactManager() {
        return "manager/contact-list";
    }

    @RequestMapping("/userManager")
    public String userManager() {
        return "manager/user-list";
    }

    @RequestMapping("/adminManager")
    public String adminManager() {
        return "manager/admin-list";
    }

    @RequestMapping("/changeAdmin")
    public String changeAdmin() {
        return "manager/login";
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestParam("adminName") String adminName,
                             @RequestParam("adminPassword") String adminPassword,
                             HttpServletRequest request) {
        Admin admin = adminService.verifyAdmin(adminName);
        if (adminPassword.equals(admin.getAdminPassword())) {
            request.getSession().setAttribute("admin", admin);
            return "manager/index";
        } else {
            request.setAttribute("msg", "用户名或密码错误！");
            return "forward:/changeAdmin";
        }
    }

    @RequestMapping("/adminLogout")
    public String adminLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "forward:/";
    }

    @RequestMapping("/manageAdmin")
    @ResponseBody
    public Msg getAdmins(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Admin> admins = adminService.selectAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(admins, 3);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public Msg addAdmin(Admin admin) {
        if (adminService.insert(admin) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public Msg deleteAdmin(Integer id) {
        if (adminService.deleteByPrimaryKey(id) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/editAdmin")
    @ResponseBody
    public Msg editAdmin(@RequestParam("id") Integer id) {
        Admin admin = adminService.selectByPrimaryKey(id);
        if (admin != null) {
            return Msg.success().add("admin", admin);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateAdmin")
    @ResponseBody
    public Msg updateAdmin(Admin admin) {
        if (adminService.updateByPrimaryKey(admin) > 0) {
            return Msg.success().add("admin", admin);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/batchDeleteAdmin")
    @ResponseBody
    public Msg batchDeleteAdmin(@RequestBody String ids) {
        JSONArray json = JSONArray.fromObject(ids);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            list.add(Integer.parseInt((String) json.get(i)));
        }
        try {
            if (list != null && list.size() > 0) {
                adminService.batchDelete(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.success();
    }


}
