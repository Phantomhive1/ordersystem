package com.tedu.dao;

import com.tedu.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    public Admin login(String username, String password);

}
