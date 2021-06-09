package com.example.modelanddatabase.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.example.modelanddatabase.config.MyDataBean;
import com.example.modelanddatabase.dao.MyDataDaoImpl;
import com.example.modelanddatabase.repositories.MyDataRepository;
import com.example.modelanddatabase.service.MyDataService;
import com.example.modelanddatabase.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class HeloController {

    // @Autowired는 애플리케이션에 있는 Bean 객체와 연동하기 위함
    // 1) 앱 실행시에 @Repository가 붙은 인터페이스를 자동 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
    // 2) 컨트롤러 등의 클래스가 로드될때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색하여 자동으로 해당 필드에 할당

    @Autowired
    MyDataRepository repository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    MyDataDaoImpl dao;

    @Autowired
    MyDataService service;

    @Autowired
    MyDataBean myDataBean;

    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData의 예제입니다.");
        List<MyData> list = service.getAll();
        mav.addObject("datalist", list);
        return mav;
    }
    
    // Repository와 @Query를 이용한 데이터 질의
//    public ModelAndView index(MyData mydata, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("title", "Find Page");
//        mav.addObject("msg", "MyData의 예제입니다.");
//        //JpaRepository의 findAll 메소드를 통해 모든 엔터니가 자동 추출된다.
//        // MyDataRepository가 JpaRepository로 부터 상속받고 있기 때문
////        Iterable<MyData> list = repository.findAllOrderByName();
//        Iterable<MyData> list = dao.getAll();
//        mav.addObject("datalist", list);
//        return mav;
//    }

    // 현재 저장되어있는 모든 데이터를 보여준다.
//    public ModelAndView index(MyData mydata, ModelAndView mav) {
//        mav.setViewName("index");
//        mav.addObject("msg", "this is sample content.");
//        //JpaRepository의 findAll 메소드를 통해 모든 엔터니가 자동 추출된다.
//        // MyDataRepository가 JpaRepository로 부터 상속받고 있기 때문
//        Iterable<MyData> list = dao.getAll();
//        mav.addObject("datalist", list);
//        return mav;
//    }
    
    // 새 데이터를 추가하고 새로 추가된 형태의 테이블을 다시 새로 불러온다
//    public ModelAndView form(MyData mydata, ModelAndView mav) {
//        repository.saveAndFlush(mydata);
//        return new ModelAndView("redirect:/");
//    }

    public ModelAndView form(MyData mydata, BindingResult result, ModelAndView mav) {
        ModelAndView res = null;
        if (!result.hasErrors()) {
            repository.saveAndFlush(mydata);
            res = new ModelAndView("redirect:/");
        } else {
            mav.setViewName("index");
            mav.addObject("msg", "sorry, error is occured...");
            Iterable<MyData> list = repository.findAll();
            mav.addObject("datalist", list);
            res = mav;
        }
        return res;
    }

    //     아래 내용을 통해 미리 여러 데이터들을 생성해 놓는다.
    public void init() {
        dao = new MyDataDaoImpl(entityManager);
        MyData d1 = new MyData();
        d1.setName("tsuyano");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
//        d1.setMemo("090-999-999");
        d1.setMemo("090999999"); // 하이픈(-) 없이 오직 번호만
//        repository.saveAndFlush(d1);
        repository.save(d1);

        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
//        d2.setMemo("080-888-888");
        d2.setMemo("080888888"); // 하이픈(-) 없이 오직 번호만
//        repository.saveAndFlush(d2);
        repository.save(d2);

        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
//        d3.setMemo("070-777-777");
        d3.setMemo("070777777"); // 하이픈(-) 없이 오직 번호만
//        repository.saveAndFlush(d3);
        repository.save(d3);
    }
    
    // /edit을 통해 들어와서 작동하는 메소드. edit메소드에서 데이터를 수정하고 update메소드를 통해 POST를 하여 변경을 완료한다
    public ModelAndView edit(MyData mydata, int id, ModelAndView mav) {
        mav.setViewName("edit");
        mav.addObject("title", "edit mydata.");
        MyData data = repository.getById((long)id);
        mav.addObject("formModel", data);
        return mav;
    }
    
    // update 메소드를 통해 변경 내용을 최종 결정한다
    public ModelAndView update(MyData mydata, ModelAndView mav) {
        repository.saveAndFlush(mydata);
        return new ModelAndView("redirect:/");
    }
    
    // /delete를 통해 들어와서 작동하는 메소드
    public ModelAndView delete(int id, ModelAndView mav) {
        mav.setViewName("delete");
        mav.addObject("title", "delete mydata.");
        MyData data = repository.getById((long)id);
        mav.addObject("formModel", data);
        return mav;
    }

    // remove 메소드를 통해 삭제를 최종 결정한다
    public ModelAndView remove(long id, ModelAndView mav) {
        // JpaRepository 상으로는 deleteById가 맞는 메소드이다
        repository.deleteById(id);
        return new ModelAndView("redirect:/");
    }
    
    // 컨트롤러에서 서비스 Bean 사용
    public ModelAndView find(ModelAndView mav) {
        mav.setViewName("find");
        mav.addObject("title", "Find Page");
        mav.addObject("msg", "MyData의 예제입니다.");
        mav.addObject("value", "");
        List<MyData> list = service.getAll();
        mav.addObject("datalist", list);
        return mav;
    }
    // HTTPServletRequest를 이용한 메소드
//    public ModelAndView find(ModelAndView mav) {
//        mav.setViewName("find");
//        mav.addObject("title", "Find Page");
//        mav.addObject("msg", "MyData의 예제입니다.");
//        mav.addObject("value", "");
//        Iterable<MyData> list = dao.getAll();
//        mav.addObject("datalist", list);
//        return mav;
//    }


    public ModelAndView search(HttpServletRequest request, ModelAndView mav) {
        mav.setViewName("find");
        String param = request.getParameter("fstr");
        if (param == "") {
            mav = new ModelAndView("redirect:/find");
        } else {
            mav.addObject("title", "Find result");
            mav.addObject("msg", "<" + param + "> 의 검색 결과");
            mav.addObject("value",param);
            List<MyData> list = service.find(param);
            mav.addObject("datalist", list);
        }
        return mav;
    }
    // Query를 통해 질의를 응답받으면 그에 맞는 결과를 보여준다
//    public ModelAndView search(HttpServletRequest request, ModelAndView mav) {
//        mav.setViewName("find");
//        String param = request.getParameter("fstr");
//        if (param == "") {
//            mav = new ModelAndView("redirect:/find");
//        } else {
//            mav.addObject("title", "Find result");
//            mav.addObject("msg", "<" + param + ">의 검색 결과");
//            mav.addObject("value", param);
//            List <MyData> list = dao.find(param);
//            mav.addObject("datalist", list);
//        }
//
//        return mav;
//    }

    public ModelAndView indexById(long id, ModelAndView mav) {
        mav.setViewName("pickup");
        mav.addObject("title", "Pickup Page");
        String table = "<table>" + myDataBean.getTableTagById(id) + "</table>";
        mav.addObject("msg", "pickup data id = " + id);
        mav.addObject("data", table);
        return mav;
    }


}
