package com.example.project.controller;

import com.example.project.entity.ArticleEntity;
import com.example.project.service.MyViewService;
import com.example.project.service.ViewService;
import com.example.project.vo.Article;
import com.example.project.vo.TwoNumber;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/api")
@RequiredArgsConstructor
public class MainController {
    private final ViewService viewService;
    private final MyViewService myViewService;
    @ResponseBody
    @GetMapping(value="/hello")
    public String hello() {
        return "hello world";
    }

    @ResponseBody
    @PostMapping(value="/add")
    public String add(@RequestBody TwoNumber twoNumber) {
        return String.valueOf(twoNumber.getA() + twoNumber.getB());
    }

    @ResponseBody
    @GetMapping(value="/view")
    public String view() {
        viewService.increaseViewCount();
        return String.valueOf(viewService.getViewCount());
    }

    @ResponseBody
    @GetMapping(value="/myview")
    public List<ArticleEntity> myview() {
        return myViewService.show();
    }

    @ResponseBody
    @PostMapping(value="/myview")
    public String myRegister(@RequestBody Article article) {
        myViewService.register(article);
        return "Success";
    }

    @ResponseBody
    @DeleteMapping(value="/myview/{articleID}")
    public String myDelete(@PathVariable long articleID) {
        if (myViewService.delete(articleID)) {
            return "Success";
        } else {
            return "Failed";
        }
    }



}
