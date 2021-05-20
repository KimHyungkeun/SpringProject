package com.example.mybootapp.Controller;

import com.example.mybootapp.vo.DataObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

//  GET방식으로 id를 입력받으면, 해당 id번호와 id번째 인덱스에 해당하는 이름, 이메일값을 리턴한다
//  리턴했을 시 형태는 JSON 형식이다    
    public DataObject idIndex(int id) {
        return new DataObject(id, names[id], mails[id]);
    }


}
