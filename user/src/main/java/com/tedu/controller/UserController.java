package com.tedu.controller;

import com.tedu.entity.User;
import com.tedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return userService.findAll(index, limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id) {
        return userService.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return userService.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userService.deleteById(id);
    }

}
