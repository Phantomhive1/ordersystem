package com.tedu.dao;

import com.tedu.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User login(String username, String password);
}
