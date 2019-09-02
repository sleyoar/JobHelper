package com.controller;

import com.entity.Admin;
import com.entity.Resume;
import com.entity.UJM;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.AdminService;
import com.service.ResumeService;
import com.service.UserService;
import com.util.Msg;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/register")
    public String register(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(@RequestParam("userName")String userName,
                        @RequestParam("userPassword")String userPassword, HttpServletRequest request){
        User user = userService.verifyUser(userName);
        Admin admin = adminService.verifyAdmin(userName);
        if (user!=null && userPassword.equals(user.getUserPassword())){
            User user1 = userService.getUserJob(user.getUserId());
            request.getSession().setAttribute("user",user1);
            return "forward:/";
        } else if (admin !=null && userPassword.equals(admin.getAdminPassword())){
            request.getSession().setAttribute("admin",admin);
            return "forward:/admin";
        } else {
            request.setAttribute("msg","用户名或密码错误！");
            return "forward:/";
        }
    }
    @RequestMapping("/insertUJM")
    @ResponseBody
    public Msg insertUJM(@RequestParam("userId")Integer userId,@RequestParam("jobId")Integer jobId) {
        if (userService.getUJM(userId,jobId)==null){
            UJM ujm = new UJM();
            ujm.setUserId(userId);
            ujm.setJobId(jobId);
            userService.insertUJM(ujm);
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/infor")
    public String resume(HttpServletRequest request) {
        Integer userId = ((User)request.getSession().getAttribute("user")).getUserId();
        User user = userService.getUserJob(userId);
        request.getSession().setAttribute("user",user);
        return "info";
    }
    @RequestMapping("/logout")
    public String adminLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "forward:/";
    }

    @RequestMapping("/userSave")
    private String userSave(User user, HttpServletRequest request){
        if (request.getParameter("userPassword").equals(request.getParameter("userPassword2"))){
            user.setUserId(userService.selectAll().size()+1);
            userService.insert(user);
            request.getSession().setAttribute("user",userService.selectByPrimaryKey(user.getUserId()));
            return "forward:/";
        } else {
            user=null;
            request.setAttribute("msg1","两次密码不一致");
            return "forward:/register" ;
        }
    }
    @RequestMapping("/manageUser")
    @ResponseBody
    public Msg getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<User> users = userService.selectAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(users, 3);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Msg addUser(User user) {
        if (userService.insert(user) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Msg deleteUser(Integer id) {
        if (userService.deleteByPrimaryKey(id) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/editUser")
    @ResponseBody
    public Msg editUser(@RequestParam("id") Integer id) {
        User user = userService.selectByPrimaryKey(id);
        if (user != null) {
            return Msg.success().add("user", user);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Msg updateUser(User user) {
        if (userService.updateByPrimaryKey(user) > 0) {
            return Msg.success().add("user", user);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/batchDeleteUser")
    @ResponseBody
    public Msg batchDeleteUser(@RequestBody String ids) {
        JSONArray json = JSONArray.fromObject(ids);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            list.add(Integer.parseInt((String) json.get(i)));
        }
        try {
            if (list != null && list.size() > 0) {
                userService.batchDelete(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.success();
    }


}
