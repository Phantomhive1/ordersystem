package com.tedu.feign;

import com.tedu.entity.Order;
import com.tedu.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    @GetMapping("/order/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid);

    @GetMapping("/order/findAllByState/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @GetMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id") long id);

}
