package com.example.modelanddatabase.controller;

import com.example.modelanddatabase.service.MyDataService;
import com.example.modelanddatabase.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyDataRestController {

    @Autowired
    private MyDataService service;

    @RequestMapping(value = "/rest")
    public List<MyData> restAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/rest/{num}")
    public MyData restBy(@PathVariable int num) {
        return service.get(num);
    }
}
