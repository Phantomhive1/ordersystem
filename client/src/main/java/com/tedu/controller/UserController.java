package com.tedu.controller;

import com.tedu.entity.User;
import com.tedu.entity.UserVO;
import com.tedu.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody //不返回视图，只返回数据
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page-1)*limit;
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setCount(userFeign.count());
        userVO.setMsg("");
        userVO.setData(userFeign.findAll(index, limit));
        return userVO;
    }

    @GetMapping("/count")
    public int count() {
        return userFeign.count();
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
        return "redirect:/menu/redirect/user_manage";
    }

    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/menu/redirect/user_manage";
    }

}
