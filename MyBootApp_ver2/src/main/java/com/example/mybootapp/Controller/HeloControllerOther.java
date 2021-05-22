package com.example.mybootapp.Controller;

import com.example.mybootapp.vo.DataObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloControllerOther {

    // num에 대한 누적값을 구한다. Model은 웹페이지에서 사용할 데이터를 다루기위한 클래스이다
    public String index(int num, Model model) {
        int res = 0;
        for (int i = 1 ; i <= num ; i ++)
            res += i;
        model.addAttribute("msg", "total: " + res); //addAttribute 메소드를 통해 웹페이지 상으로 나타나도록 한다
        return "index";
    }
    // ModelAndView 또한 웹페이지에서 사용할 데이터를 다루기 위한 클래스이다.
    // 다만, Model과 사용법이 조금 다르며, ModelAndView는 반환값으로 사용이 가능하다
    public ModelAndView mvIndex(int num, ModelAndView mav) {
        int res = 0;
        for (int i = 1 ; i <= num ; i ++)
            res += i;
        mav.addObject("msg", "total: " + res); //addObject 함수를 통해 표현한다
        mav.setViewName("index"); // view의 이름을 index로 짓는다
        return mav;
    }

    // 사용자로부터 이름(name)을 입력받는다. (GET 방식)
    // Chapter4. 템플릿 엔진. index.html에서 *{} 방식을통해 값을 직접 참조한다
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "message 1<hr/>message 2<br/>message 3");
        mav.addObject("msg","current data.");
        DataObject obj = new DataObject(123, "lee", "lee@flower");
        mav.addObject("object",obj);
        return mav;
    }
    // 이름을 입력받으면 "안녕하세요! (이름) 님!" 이라고 변경 될것이다 (POST방식)
    public ModelAndView send(String str, ModelAndView mav) {
        mav.addObject("msg","안녕하세요! " + str + "님!");
        mav.addObject("value",str);
        mav.setViewName("index");
        return mav;
    }


    // 사용자로부터 이름(name)을 입력받는다. (GET 방식)
    public ModelAndView indexController(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg","폼을 전송해주세요.");
        return mav;
    }
    
    // 체크박스, 라디오 버튼, 선택 등등의 입력을 받는다
    public ModelAndView sendController(boolean check1, String radio1, String select1, String[] select2, ModelAndView mav) {
        
        // 입력받은 최종 결과를 res에 넣는다
        String res = "";
        try {
            res = "check:" + check1 +
                    " radio:" + radio1 +
                    " select:" + select1 +
                    "\nselect2:";
        } catch (NullPointerException e) {}
        
        // select2의 경우 다중 선택이 가능한 경우이므로, 이에따른 핸들링을 해준다
        try {
            res += select2[0];
            for (int i = 1 ; i < select2.length ; i++)
                res += ", " + select2[i];
        } catch (NullPointerException e) {
            res += "null";
        }

        // index.html에서 설정된 msg에 들어갈 값이다.
        mav.addObject("msg", res);
        mav.setViewName("index");
        return mav;
    }
    
    // 리다이렉트 view이름을 index라 명명한다
    public ModelAndView redirectIndex(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
    
    // 현재의 주소에서 리다이렉트 한다
    public String other() {
        return "redirect:/";
    }
    
    // 현재의 주소로 이동한다
    public String home() {
        return "forward:/";
    }


}
