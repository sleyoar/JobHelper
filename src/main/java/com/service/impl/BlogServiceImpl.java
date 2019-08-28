package com.service.impl;

import com.entity.Blog;
import com.mapper.BlogMapper;
import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int deleteByPrimaryKey(Integer blogId) {
        return blogMapper.deleteByPrimaryKey(blogId);
    }

    @Override
    public int insert(Blog record) {
        return blogMapper.insert(record);
    }

    @Override
    public Blog selectByPrimaryKey(Integer blogId) {
        return blogMapper.selectByPrimaryKey(blogId);
    }

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }

    @Override
    public List<Blog> selectSome() {
        return blogMapper.selectSome();
    }

    @Override
    public int updateByPrimaryKey(Blog record) {
        return blogMapper.updateByPrimaryKey(record);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        blogMapper.batchDelete(ids);
    }
}
