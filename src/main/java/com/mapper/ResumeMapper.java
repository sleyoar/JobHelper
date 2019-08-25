package com.mapper;

import com.entity.Resume;

import java.util.List;

public interface ResumeMapper {
    /**
     * delete resume
     *
     * @param resumeId resume_id
     * @return row
     */
    int deleteByPrimaryKey(Integer resumeId);

    /**
     * insert into resume
     *
     * @param record resume
     * @return row
     */
    int insert(Resume record);

    /**
     * get one resume by id
     *
     * @param resumeId resume_id
     * @return resume
     */
    Resume selectByPrimaryKey(Integer resumeId);

    /**
     * get one resume by id
     *
     * @param userId user_id
     * @return resume
     */
    Resume selectByUserId(Integer userId);

    /**
     * get all resumes
     *
     * @return resume-list
     */
    List<Resume> selectAll();

    /**
     * update one resume
     *
     * @param record resume
     * @return row
     */
    int updateByPrimaryKey(Resume record);
}