package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    /*delete one user by id*/
    int deleteByPrimaryKey(Integer userId);

    /*insert into user*/
    int insert(User record);

    /*get one user by id*/
    User selectByPrimaryKey(Integer userId);

    /*get all users*/
    List<User> selectAll();

    /*update one user*/
    int updateByPrimaryKey(User record);
}
