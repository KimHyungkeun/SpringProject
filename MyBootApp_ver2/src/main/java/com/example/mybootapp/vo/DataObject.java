package com.example.mybootapp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// lombok을 통해 setter, getter 등의 annotation을 제곻한다
@Getter 
@Setter
@AllArgsConstructor 
public class DataObject {
    private int id;
    private String name;
    private String value;

}
