package com.tedu.dao;

import com.tedu.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    public User findById(long id);

}
