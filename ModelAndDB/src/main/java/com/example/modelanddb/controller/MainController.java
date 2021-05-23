package com.example.modelanddb.controller;

import com.example.modelanddb.vo.MyData;
import com.example.modelanddb.repositories.MyDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller

public class MainController {

    @Autowired
    HeloContoller heloContoller;


    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        return heloContoller.index(mydata, mav);
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        return heloContoller.form(mydata, mav);
    }

    @PostConstruct
    public void init() {
        heloContoller.init();
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData mydata, @PathVariable int id, ModelAndView mav) {
        return heloContoller.edit(mydata, id, mav);
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView update(@ModelAttribute MyData mydata, ModelAndView mav) {
        return heloContoller.update(mydata, mav);
    }
}
