package com.service.impl;

import com.entity.Contact;
import com.mapper.ContactMapper;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public int deleteByPrimaryKey(Integer contactId) {
        return contactMapper.deleteByPrimaryKey(contactId);
    }

    @Override
    public int insert(Contact record) {
        return contactMapper.insert(record);
    }

    @Override
    public Contact selectByPrimaryKey(Integer contactId) {
        return contactMapper.selectByPrimaryKey(contactId);
    }

    @Override
    public List<Contact> selectAll() {
        return contactMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Contact record) {
        return contactMapper.updateByPrimaryKey(record);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        contactMapper.batchDelete(ids);
    }
}
