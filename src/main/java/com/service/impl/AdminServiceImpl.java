package com.service.impl;

import com.entity.Admin;
import com.mapper.AdminMapper;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }
}
