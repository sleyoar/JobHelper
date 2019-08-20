package com.service;

import com.entity.Job;

import java.util.List;

public interface JobService {
    /**
     * delete by id
     *
     * @param jobId id
     * @return row
     */
    int deleteByPrimaryKey(Integer jobId);

    /**
     * insert into job
     *
     * @param record job
     * @return row
     */
    int insert(Job record);

    /**
     * get job by id
     *
     * @param jobId id
     * @return job
     */
    Job selectByPrimaryKey(Integer jobId);

    /*get all jobs*/
    List<Job> selectAll();

    /*update job*/
    int updateByPrimaryKey(Job record);
}
