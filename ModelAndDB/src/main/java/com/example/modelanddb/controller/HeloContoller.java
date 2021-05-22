package com.example.modelanddb.controller;

import com.example.modelanddb.repositories.MyDataRepository;
import com.example.modelanddb.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloContoller {

    @Autowired
    MyDataRepository repository;

    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        Iterable<MyData> list = repository.findAll();
        mav.addObject("data", list);
        return mav;

    }
}
