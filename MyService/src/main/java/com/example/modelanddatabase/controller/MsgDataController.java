package com.example.modelanddatabase.controller;

import com.example.modelanddatabase.dao.MsgDataDaoImpl;
import com.example.modelanddatabase.repositories.MsgDataRepository;
import com.example.modelanddatabase.vo.MsgData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class MsgDataController {

    @Autowired
    MsgDataRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    MsgDataDaoImpl dao;

    public ModelAndView msg(ModelAndView mav) {
        mav.setViewName("showMsgData");
        mav.addObject("title", "Sample");
        mav.addObject("msg", "MsgData의 예제입니다.");
        MsgData msgdata = new MsgData();
        mav.addObject("formModel", msgdata);
        List<MsgData> list = (List<MsgData>) dao.getAll();
        mav.addObject("datalist", list);
        return mav;
    }

    public ModelAndView msgform(MsgData msgdata, Errors result, ModelAndView mav) {
        if (result.hasErrors()) {
            mav.setViewName("showMsgdata");
            mav.addObject("title", "Sample [Error]");
            mav.addObject("msg", "값을 다시 확인해주세요!");
            return mav;
        } else {
            repository.save(msgdata);
            return new ModelAndView("redirect:/msg");
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("ok");
        dao = new MsgDataDaoImpl(entityManager);
    }
}
