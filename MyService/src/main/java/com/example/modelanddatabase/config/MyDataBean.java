package com.example.modelanddatabase.config;

import com.example.modelanddatabase.repositories.MyDataRepository;
import com.example.modelanddatabase.vo.MyData;
import org.springframework.beans.factory.annotation.Autowired;

public class MyDataBean {

    @Autowired
    MyDataRepository repository;

    public String getTableTagById(Long id) {
        MyData data = repository.getById(id);
        String result = "<tr><td>" + data.getName()
                + "</td><td>" + data.getMail()
                + "</td><td>" + data.getAge()
                + "</td><td>" + data.getMemo()
                + "</td></tr>";
        return result;
    }
}
