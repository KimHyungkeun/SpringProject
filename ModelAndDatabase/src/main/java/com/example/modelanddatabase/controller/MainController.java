package com.example.modelanddatabase.controller;

import com.example.modelanddatabase.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller

public class MainController {

    @Autowired
    HeloController heloController;



    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        return heloController.index(mydata, mav);
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        return heloController.form(mydata, mav);
    }

    @PostConstruct
    public void init() {
        heloController.init();
    }
//
//    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
//    public ModelAndView edit(@ModelAttribute MyData mydata, @PathVariable int id, ModelAndView mav) {
//        return heloController.edit(mydata, id, mav);
//    }
//
//    @RequestMapping(value="/edit", method=RequestMethod.POST)
//    public ModelAndView update(@ModelAttribute MyData mydata, ModelAndView mav) {
//        return heloController.update(mydata, mav);
//    }
}
