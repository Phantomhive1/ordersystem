package com.tedu.service;

import com.tedu.dao.AdminDao;
import com.tedu.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username, password);
    }
}
