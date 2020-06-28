package com.tedu.service;

import com.tedu.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll(int index, int limit);
    public User findById(long id);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
