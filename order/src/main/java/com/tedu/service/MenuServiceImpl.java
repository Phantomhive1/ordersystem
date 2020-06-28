package com.tedu.service;

import com.tedu.dao.MenuDao;
import com.tedu.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAll(int index, int limit) {
        return menuDao.findAll(index, limit);
    }

    @Override
    public int count() {
        return menuDao.count();
    }

    @Override
    public Menu findById(long id) {
        return menuDao.findById(id);
    }

    @Override
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    public void update(Menu menu) {
        menuDao.update(menu);
    }

    @Override
    public void deleteById(long id) {
        menuDao.deleteById(id);
    }
}
