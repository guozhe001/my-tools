package com.nicai.controller;

import com.nicai.dao.MyTable0Dao;
import com.nicai.dao.MyTable1Dao;
import org.springframework.web.bind.annotation.*;

/**
 * @author guozhe
 * @date 2020-04-27
 */
@RestController
public class CustomerController {

    private final MyTable1Dao myTable1Dao;
    private final MyTable0Dao myTable0Dao;

    public CustomerController(MyTable1Dao myTable1Dao, MyTable0Dao myTable0Dao) {
        this.myTable1Dao = myTable1Dao;
        this.myTable0Dao = myTable0Dao;
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestParam("name") String name) {
        Long id1 = myTable1Dao.save(name);
        Long id0 = myTable0Dao.save(name);
        return String.format("id0=%s;id1=%s", id0, id1);
    }

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello";
    }

}
