package com.service.impl;

import com.entity.Job;
import com.mapper.JobMapper;
import com.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jobMapper;

    @Override
    public int deleteByPrimaryKey(Integer jobId) {
        return jobMapper.deleteByPrimaryKey(jobId);
    }

    @Override
    public int insert(Job record) {
        return jobMapper.insert(record);
    }

    @Override
    public Job selectByPrimaryKey(Integer jobId) {
        return jobMapper.selectByPrimaryKey(jobId);
    }

    @Override
    public List<Job> selectAll() {
        return jobMapper.selectAll();
    }

    @Override
    public List<Job> selectSome() {
        return jobMapper.selectSome();
    }

    @Override
    public int updateByPrimaryKey(Job record) {
        return jobMapper.updateByPrimaryKey(record);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        jobMapper.batchDelete(ids);
    }

    @Override
    public List<Job> getByCategory(String jobCategory) {
        return jobMapper.getByCategory(jobCategory);
    }
}
