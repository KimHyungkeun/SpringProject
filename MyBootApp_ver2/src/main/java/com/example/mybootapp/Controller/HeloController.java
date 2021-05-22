package com.example.mybootapp.Controller;

import com.example.mybootapp.vo.DataObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class HeloController {

    String[] names = {"kim", "lee", "park", "choi", "jo"};
    String[] mails = {"kim@tuuyano.com", "lee@flower", "park@yamada", "choi@happy", "jo@baseball"};

//  GET방식으로 num을 입력받았을때, 해당 num까지의 누적합을 구함
    public String index(int num) {
        int res = 0;
        for (int i=1 ; i <= num ; i ++) {
            res += i;
        }
        return "total : " + res;
    }

    public ModelAndView index(int id, ModelAndView mav) {
        mav.setViewName("index");
//        mav.addObject("tax", tax);

        // DataObject를 사용한 테이블 내용 출력
//        mav.addObject("num", num);
//        if (num >= 0) {
//            mav.addObject("check", "num >= data.size() ? 0 : num");
//        } else {
//            mav.addObject("check", "num <= data.size() * -1 ? 0 : num * -1");
//        }
//        ArrayList<DataObject> data = new ArrayList<>();
//        data.add(new DataObject(0, "park", "park@yamada"));
//        data.add(new DataObject(1, "lee", "lee@flower"));
//        data.add(new DataObject(2, "choi", "choi@happy"));
//        mav.addObject("data",data);

        // 어레이리스트에 담긴 요소들을 차례대로 출력
//        ArrayList<String[]> data = new ArrayList<String[]>();
//        data.add(new String[]{"park", "park@yamada", "090-999-999"});
//        data.add(new String[]{"lee", "leff@flower", "080-888-888"});
//        data.add(new String[]{"choi", "choif@happy", "080-888-888"});
//        mav.addObject("data",data);

        // 월(month)에 따른 계절 판별
//        int m = Math.abs(month) % 12;
//        m = m == 0 ? 12 : m ;
//        mav.addObject("month", m);
//        mav.addObject("check", Math.floor(m / 3));

        //양수, 음수 확인
//        mav.addObject("id", id);
//        mav.addObject("check",id >= 0);
//        mav.addObject("trueVal", "POSITIVE");
//        mav.addObject("falseVal", "Negative...");
        
        //홀짝 확인
//        mav.addObject("check",id % 2 == 0);
//        mav.addObject("trueVal", "Even number!");
//        mav.addObject("falseVal", "Odd number...");
        return mav;
    }

//  GET방식으로 id를 입력받으면, 해당 id번호와 id번째 인덱스에 해당하는 이름, 이메일값을 리턴한다
//  리턴했을 시 형태는 JSON 형식이다    
    public DataObject idIndex(int id) {

        return new DataObject(id, names[id], mails[id]);
    }


}
