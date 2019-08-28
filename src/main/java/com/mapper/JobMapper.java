package com.mapper;

import com.entity.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobMapper {
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

    /*get random 3 jobs*/
    List<Job> selectSome();

    /*update job*/
    int updateByPrimaryKey(Job record);

    void batchDelete(@Param("ids") List<Integer> ids);
}