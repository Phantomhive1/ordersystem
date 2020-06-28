package com.tedu.service;

import com.tedu.dao.UserDao;
import com.tedu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

}
