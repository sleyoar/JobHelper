package com.mapper;

import com.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /*delete admin by id*/
    int deleteByPrimaryKey(Integer adminId);

    /*insert into admin*/
    int insert(Admin record);

    /*get one admin by id*/
    Admin selectByPrimaryKey(Integer adminId);

    /*get onr admin by naame*/
    Admin verifyAdmin(String adminName);

    /*get all admins*/
    List<Admin> selectAll();

    /*update one admin*/
    int updateByPrimaryKey(Admin record);

    void batchDelete(@Param("ids") List<Integer> ids);
}