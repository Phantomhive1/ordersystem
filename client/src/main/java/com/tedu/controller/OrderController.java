package com.tedu.controller;

import com.tedu.entity.Menu;
import com.tedu.entity.Order;
import com.tedu.entity.OrderVO;
import com.tedu.entity.User;
import com.tedu.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}") //与前端对接，必须用GetMapping
    public String save(@PathVariable("mid") int mid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        Menu menu = new Menu();
        menu.setId(mid);
        order.setUser(user);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session) {
       User user = (User) session.getAttribute("user");
       int index = (page-1)*limit;
       return orderFeign.findAllByUid(index, limit, user.getId());
    }

    @GetMapping("/findAllByState")
    @ResponseBody //注意！！
    public OrderVO findAllByState(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page-1)*limit;
        return orderFeign.findAllByState(index, limit);
    }

    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") long id) {
        orderFeign.updateState(id);
        return "redirect:/menu/redirect/order_handler";
    }

}
