package com.mapper;

import com.entity.Resume;

import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer resumeId);

    int insert(Resume record);

    Resume selectByPrimaryKey(Integer resumeId);

    List<Resume> selectAll();

    int updateByPrimaryKey(Resume record);
}