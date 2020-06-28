package com.tedu.controller;

import com.tedu.entity.Menu;
import com.tedu.entity.MenuVO;
import com.tedu.entity.Type;
import com.tedu.service.MenuService;
import com.tedu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuService menuService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/index")
    public String index() {
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        List<Menu> menuList = menuService.findAll(index, limit);
        return new MenuVO(0,"", menuService.count(), menuList);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuService.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes() {
        return typeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu) {
        menuService.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id) {
        return menuService.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu) {
        menuService.update(menu);
    }

}
