package com.tedu.service;

import com.tedu.entity.Type;

import java.util.List;

public interface TypeService {
    public Type findById(long id);
    public List<Type> findAll();

}
