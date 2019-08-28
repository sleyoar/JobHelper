package com.controller;

import com.entity.Contact;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ContactService;
import com.sun.deploy.net.HttpResponse;
import com.util.Msg;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

     @RequestMapping("/contactSave")
    public String contactSave(Contact contact, HttpServletResponse response) throws IOException {
        contact.setContactId(contactService.selectAll().size()+1);
        contactService.insert(contact);
         response.setCharacterEncoding("UTF-8");
         response.setContentType("text/html; charset=utf-8");
         PrintWriter out=response.getWriter();
         out.print("<script>alert('反馈成功！');</script>");
         return "forward:/contact";
     }

    @RequestMapping("/manageContact")
    @ResponseBody
    public Msg getStudents(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Contact> contacts = contactService.selectAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(contacts, 3);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/addContact")
    @ResponseBody
    public Msg addStudent(Contact contact) {
        if (contactService.insert(contact) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping("/deleteContact")
    @ResponseBody
    public Msg deleteBlog(Integer id) {
        if (contactService.deleteByPrimaryKey(id) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/editContact")
    @ResponseBody
    public Msg edit(@RequestParam("id") Integer id) {
        Contact contact = contactService.selectByPrimaryKey(id);
        if (contact != null) {
            return Msg.success().add("contact", contact);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/updateContact")
    @ResponseBody
    public Msg update(Contact contact) {
        if (contactService.updateByPrimaryKey(contact) > 0) {
            return Msg.success().add("contact", contact);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/batchDeleteContact")
    @ResponseBody
    public Msg batchDelete(@RequestBody String ids) {
        JSONArray json = JSONArray.fromObject(ids);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            list.add(Integer.parseInt((String) json.get(i)));
        }
        try {
            if (list != null && list.size() > 0) {
                contactService.batchDelete(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.success();
    }

}
