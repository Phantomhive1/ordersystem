package com.tedu.dao;

import com.tedu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {
    public List<Menu> findAll(int index, int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(long id);
}
