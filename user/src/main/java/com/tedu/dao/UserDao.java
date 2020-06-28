package com.tedu.dao;

import com.tedu.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> findAll(int index, int limit);
    public User findById(long id);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
