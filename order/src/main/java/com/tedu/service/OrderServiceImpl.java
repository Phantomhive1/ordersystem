package com.tedu.service;

import com.tedu.dao.OrderDao;
import com.tedu.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        order.setDate(new Date());
        orderDao.save(order);
    }

    @Override
    public List<Order> findAllByUid(int index, int limit, long uid) {
        return orderDao.findAllByUid(index, limit, uid);
    }

    @Override
    public int countByUid(long uid) {
        return orderDao.countByUid(uid);
    }

    @Override
    public List<Order> findAllByState(int index, int limit) {
        return orderDao.findAllByState(index, limit);
    }

    @Override
    public void updateState(long id) {
        orderDao.updateState(id);
    }

    @Override
    public int count() {
        return orderDao.count();
    }

}
