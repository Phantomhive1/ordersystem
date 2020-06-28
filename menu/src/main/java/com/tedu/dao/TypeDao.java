package com.tedu.dao;

import com.tedu.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeDao {
    public Type findById(long id);

    public List<Type> findAll();
}
