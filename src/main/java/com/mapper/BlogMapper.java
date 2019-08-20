package com.mapper;

import com.entity.Blog;

import java.util.List;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(Blog record);

    Blog selectByPrimaryKey(Integer blogId);

    List<Blog> selectAll();

    int updateByPrimaryKey(Blog record);
}