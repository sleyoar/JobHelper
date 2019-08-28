package com.controller;

import com.entity.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BlogService;
import com.util.Msg;
import net.sf.json.JSONArray;
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

    @RequestMapping("/manageBlog")
    @ResponseBody
    public Msg getBlogs(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Blog> blogs = blogService.selectAll();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(blogs, 3);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/add")
    @ResponseBody
    public Msg addBlog(Blog blog) {
        if (blogService.insert(blog) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Msg deleteBlog(Integer id) {
        if (blogService.deleteByPrimaryKey(id) > 0) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Msg editBlog(@RequestParam("id") Integer id) {
        Blog blog = blogService.selectByPrimaryKey(id);
        if (blog != null) {
            return Msg.success().add("blog", blog);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public Msg updateBlog(Blog blog) {
        if (blogService.updateByPrimaryKey(blog) > 0) {
            return Msg.success().add("blog", blog);
        } else {
            return Msg.fail();
        }
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public Msg batchDeleteBlog(@RequestBody String ids) {
        System.out.println("============================================================");
        System.out.println(ids);
        JSONArray json = JSONArray.fromObject(ids);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            list.add(Integer.parseInt((String) json.get(i)));
        }
        try {
            if (list != null && list.size() > 0) {
                blogService.batchDelete(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.success();
    }

}
