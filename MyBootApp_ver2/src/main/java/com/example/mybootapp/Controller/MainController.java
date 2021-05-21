package com.example.mybootapp.Controller;

import com.example.mybootapp.vo.DataObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// MainContoller를 통해 전반적인 통제를 담당한다
//@RestController
@Controller
@RequestMapping(value="/")
public class MainController {
    HeloController heloController = new HeloController();
    HeloControllerOther heloControllerOther = new HeloControllerOther();

    @RequestMapping(value = "/num/{num}")
    public String total(@PathVariable int num) {
        return heloController.index(num);
    }

    @RequestMapping(value = "/id/{id}")
    public DataObject objectShow(@PathVariable int id) {
        return heloController.idIndex(id);
    }

    @RequestMapping(value = "/model/{num}")
    public String showIndex(@PathVariable int num, Model model) {
        return heloControllerOther.index(num, model);
    }

    @RequestMapping(value = "/modelviewnum/{num}")
    public ModelAndView showModelView(@PathVariable int num, ModelAndView mav) {
        return heloControllerOther.mvIndex(num, mav);
    }

    @RequestMapping(value="/modelview", method= RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        return heloControllerOther.index(mav);
    }

    @RequestMapping(value="/modelview", method = RequestMethod.POST)
    public ModelAndView send(@RequestParam("text1")String str, ModelAndView mav) {
        return heloControllerOther.send(str, mav);
    }

    @RequestMapping(value="/modelviewcontroller", method= RequestMethod.GET)
    public ModelAndView indexController(ModelAndView mav) {
        return heloControllerOther.indexController(mav);
    }

    @RequestMapping(value="/modelviewcontroller", method = RequestMethod.POST)
    public ModelAndView sendController(
            @RequestParam(value="check1", required = false)boolean check1,
            @RequestParam(value="radio1", required = false)String radio1,
            @RequestParam(value="select1", required = false)String select1,
            @RequestParam(value="select2", required = false)String[] select2,
            ModelAndView mav) {
        return heloControllerOther.sendController(check1, radio1, select1, select2, mav);
    }

    @RequestMapping(value="/redir")
    public ModelAndView redirectIdx(ModelAndView mav) {
        return heloControllerOther.redirectIndex(mav);
    }

    @RequestMapping(value="/other")
    public String other () {
        return heloControllerOther.other();
    }

    @RequestMapping(value="/home")
    public String home() {
        return heloControllerOther.home();
    }

}
