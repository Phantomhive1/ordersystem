package com.tedu.service;

import com.tedu.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> findAll(int index, int limit);
    public int count();
    public Menu findById(long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(long id);
}
