package com.example.modelanddatabase.controller;

import com.example.modelanddatabase.repositories.MyDataRepository;
import com.example.modelanddatabase.vo.MyData;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.PostConstruct;

import javax.transaction.Transactional;

@Controller
public class HeloController {

    // @Autowired는 애플리케이션에 있는 Bean 객체와 연동하기 위함
    // 1) 앱 실행시에 @Repository가 붙은 인터페이스를 자동 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
    // 2) 컨트롤러 등의 클래스가 로드될때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색하여 자동으로 해당 필드에 할당
    @Autowired
    MyDataRepository repository;
//
//
//
//    public ModelAndView index(MyData mydata, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("msg", "this is sample content.");
//        //JpaRepository의 findAll 메소드를 통해 모든 엔터니가 자동 추출된다.
//        // MyDataRepository가 JpaRepository로 부터 상속받고 있기 때문
//        Iterable<MyData> list = repository.findAll();
//        mav.addObject("datalist", list);
//        return mav;
//
//    }
//
//
//    public ModelAndView form(MyData mydata, ModelAndView mav) {
//        repository.saveAndFlush(mydata);
//        return new ModelAndView("redirect:/");
//    }

    //     아래 내용을 통해 미리 여러 데이터들을 생성해 놓는다.
    public void init() {
        MyData d1 = new MyData();
        d1.setName("kim");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
//        repository.saveAndFlush(d1);

        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
        d2.setMemo("my girl friend. ");
//        repository.saveAndFlush(d2);

        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
        d3.setMemo("my work friend. ");
//        repository.saveAndFlush(d3);
    }
//
//    public ModelAndView edit(MyData mydata, int id, ModelAndView mav) {
//        mav.setViewName("edit");
//        mav.addObject("title", "edit mydata.");
//        MyData data = repository.findBy((long)id);
//        mav.addObject("formModel", data);
//        return mav;
//    }
//
//    public ModelAndView update(MyData mydata, ModelAndView mav) {
//        repository.saveAndFlush(mydata);
//        return new ModelAndView("redirect:/");
//    }
}
