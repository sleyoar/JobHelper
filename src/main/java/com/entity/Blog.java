package com.entity;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {
    private static final long serialVersionUID = 354507549220004454L;
    private Integer blogId;

    private String blogUser;

    private String blogCategory;

    private String blogTitle;

    private Date blogDate;

    private String blogContext;

    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogUser='" + blogUser + '\'' +
                ", blogCategory='" + blogCategory + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogDate=" + blogDate +
                ", blogContext='" + blogContext + '\'' +
                '}';
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogUser() {
        return blogUser;
    }

    public void setBlogUser(String blogUser) {
        this.blogUser = blogUser == null ? null : blogUser.trim();
    }

    public String getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(String blogCategory) {
        this.blogCategory = blogCategory == null ? null : blogCategory.trim();
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Date getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(Date blogDate) {
        this.blogDate = blogDate;
    }

    public String getBlogContext() {
        return blogContext;
    }

    public void setBlogContext(String blogContext) {
        this.blogContext = blogContext == null ? null : blogContext.trim();
    }
}