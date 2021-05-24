package com.example.modelanddatabase.vo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

// id:메인키로 사용되는 번호, name:이름, mail:메일주소, age:나이, memo:메모
@Entity //엔터티 클래스라는것을 나타내는 에너테이션
@Table(name="mydata")
public class MyData {

    @Id //해당 컬럼을 메인키로 지정
    @GeneratedValue(strategy = GenerationType.AUTO) //값을 자동 생성하며, strategy를 통해 생성 방식을 지정
    @Column
    @NotNull
    private long id;

    @Column(length= 50, nullable = false)
    private String name;

    @Column(length = 200, nullable = true)
    private String mail;

    @Column(nullable = true)
    private Integer age;

    @Column(nullable = true)
    private String memo;
}