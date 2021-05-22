package com.example.modelanddb.controller;

import com.example.modelanddb.repositories.MyDataRepository;
import com.example.modelanddb.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloContoller {
    
    // @Autowired는 애플리케이션에 있는 Bean 객체와 연동하기 위함
    // 1) 앱 실행시에 @Repository가 붙은 인터페이스를 자동 검색해서 자동으로 클래스를 만들고, 해당 인스턴스를 애플리케이션에 Bean으로 등록
    // 2) 컨트롤러 등의 클래스가 로드될때 @Autowired가 설정된 필드가 있으면 등록 완료된 Bean에서 동일 클래스를 검색하여 자동으로 해당 필드에 할당
    @Autowired
    MyDataRepository repository;

    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        //JpaRepository의 findAll 메소드를 통해 모든 엔터니가 자동 추출된다.
        // MyDataRepository가 JpaRepository로 부터 상속받고 있기 때문
        Iterable<MyData> list = repository.findAll(); 
        mav.addObject("data", list);
        return mav;

    }
}
