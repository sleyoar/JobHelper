package com.mapper;

import com.entity.Contact;

import java.util.List;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer contactId);

    int insert(Contact record);

    Contact selectByPrimaryKey(Integer contactId);

    List<Contact> selectAll();

    int updateByPrimaryKey(Contact record);
}