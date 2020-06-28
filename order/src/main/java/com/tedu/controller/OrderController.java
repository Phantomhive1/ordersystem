package com.tedu.controller;

import com.tedu.entity.Order;
import com.tedu.entity.OrderVO;
import com.tedu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid) {
        OrderVO orderVO = new OrderVO();
        orderVO.setData(orderService.findAllByUid(index, limit, uid));
        orderVO.setCount(orderService.countByUid(uid));
        orderVO.setMsg("");
        return orderVO;
    }

    @GetMapping("/count/{uid}")
    public int countByUid(@PathVariable("uid") int uid) {
        return orderService.countByUid(uid);
    }

    @GetMapping("/findAllByState/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setData(orderService.findAllByState(index, limit));
        orderVO.setCount(orderService.count());
        return orderVO;
    }

    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id) {
        orderService.updateState(id);
    }

}
