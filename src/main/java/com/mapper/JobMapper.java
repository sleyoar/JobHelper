package com.mapper;

import com.entity.Job;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(Integer jobId);

    int insert(Job record);

    Job selectByPrimaryKey(Integer jobId);

    List<Job> selectAll();

    int updateByPrimaryKey(Job record);
}