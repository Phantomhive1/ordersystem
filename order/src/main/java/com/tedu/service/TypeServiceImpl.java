package com.tedu.service;

import com.tedu.dao.TypeDao;
import com.tedu.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type findById(long id) {
        return typeDao.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }
}
