package com.tedu.controller;

import com.tedu.entity.Menu;
import com.tedu.entity.MenuVO;
import com.tedu.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody //不返回视图，只返回数据
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page-1)*limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        menuFeign.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/findTypes")
    public String findTypes(Model model) {
        model.addAttribute("list", menuFeign.findTypes());
        return "menu_add.html";
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") long id, Model model) {
        model.addAttribute("menu", menuFeign.findById(id));
        model.addAttribute("list", menuFeign.findTypes());
        return "menu_update.html";
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

}
