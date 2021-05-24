package com.example.modelanddatabase.controller;

import com.example.modelanddatabase.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;

@Controller

public class MainController {

    @Autowired
    HeloController heloController;

    // 현재까지 저장되어 있는 모든 데이터들을 보여준다
    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        return heloController.index(mydata, mav);
    }
    
    // 새로 추가할 데이터를 생성한다
//    @RequestMapping(value="/", method= RequestMethod.POST)
//    @Transactional(readOnly = false)
//    public ModelAndView form(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
//        return heloController.form(mydata, mav);
//    }

    // 새로 추가할 데이터를 생성하되, 올바른 데이터 입력이 들어가지 않으면 에러처리한다
    @RequestMapping(value="/", method= RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(@ModelAttribute("formModel") @Validated MyData mydata, BindingResult result, ModelAndView mav) {
        return heloController.form(mydata, result ,mav);
    }
    
    // 초기에 데이터 몇 개를 미리 생성해놓는다
    @PostConstruct
    public void init() {
        heloController.init();
    }
    
    // 데이터 Update 영역
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData mydata, @PathVariable int id, ModelAndView mav) {
        return heloController.edit(mydata, id, mav);
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public ModelAndView update(@ModelAttribute MyData mydata, ModelAndView mav) {
        return heloController.update(mydata, mav);
    }
    
    // 데이터 Delete 영역
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
        return heloController.delete(id, mav);
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
        return heloController.remove(id, mav);
    }
}
