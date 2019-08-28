package com.service.impl;

import com.entity.Resume;
import com.mapper.ResumeMapper;
import com.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public int deleteByPrimaryKey(Integer resumeId) {
        return resumeMapper.deleteByPrimaryKey(resumeId);
    }

    @Override
    public int insert(Resume record) {
        return resumeMapper.insert(record);
    }

    @Override
    public Resume selectByPrimaryKey(Integer resumeId) {
        return resumeMapper.selectByPrimaryKey(resumeId);
    }

    @Override
    public Resume selectByUserId(Integer userId) {
        return resumeMapper.selectByUserId(userId);
    }

    @Override
    public List<Resume> selectAll() {
        return resumeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Resume record) {
        return resumeMapper.updateByPrimaryKey(record);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        resumeMapper.batchDelete(ids);
    }
}
