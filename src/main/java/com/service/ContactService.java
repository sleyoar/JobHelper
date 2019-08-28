package com.service;

import com.entity.Contact;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactService {
    /*delete one contact by id*/
    int deleteByPrimaryKey(Integer contactId);

    /*insert into contact*/
    int insert(Contact record);

    /*get one contact by id*/
    Contact selectByPrimaryKey(Integer contactId);

    /*get all contacts*/
    List<Contact> selectAll();

    /*update one contact */
    int updateByPrimaryKey(Contact record);

    void batchDelete(@Param("ids") List<Integer> ids);
}
