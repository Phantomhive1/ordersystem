package com.tedu.service;

import com.tedu.entity.Order;

import java.util.List;

public interface OrderService {
    public void save(Order order);
    public List<Order> findAllByUid(int index, int limit, long uid);
    public int countByUid(long uid);
    public List<Order> findAllByState(int index, int limit);
    public void updateState(long id);
    public int count();
}
