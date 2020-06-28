package com.tedu.service;

import com.netflix.discovery.converters.Auto;
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
    public List<User> findAll(int index, int limit) {
        return userDao.findAll(index, limit);
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }
}
