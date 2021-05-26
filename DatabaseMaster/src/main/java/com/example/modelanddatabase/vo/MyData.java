package com.example.modelanddatabase.vo;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter

// id:메인키로 사용되는 번호, name:이름, mail:메일주소, age:나이, memo:메모
@Entity //엔터티 클래스라는것을 나타내는 에너테이션
@Table(name="mydata")

@NamedQueries(
//    @NamedQuery(
//            name = "findWithName",
//            query = "from MyData where name like :fname"
//    )
        @NamedQuery(
        name = "findByAge",
        query = "from MyData where age > :min and age < :max"
    )
)
public class MyData {

    @Id //해당 컬럼을 메인키로 지정
    @GeneratedValue(strategy = GenerationType.AUTO) //값을 자동 생성하며, strategy를 통해 생성 방식을 지정
    @Column
    @NotNull //id는 절대 null값을 못가진다
    private long id;

    @Column(length= 50, nullable = false)
    @NotEmpty(message="공백 불가") // 이름 란을 공백으로 두지 말것
    private String name;

    @Column(length = 200, nullable = true)
    @Email(message="메일 주소만") // 정확한 메일주소 포맷으로 쓸것
    private String mail;

    @Column(nullable = true)
    @Min(value=0, message="0이상") //나이는 0이상 200이하의 숫자 이내로 할것
    @Max(value=200, message="200이하")
    private Integer age;

    @Column(nullable = true)
    @Phone(onlyNumber=true) // 전화번호가 제대로 맞는지 확인
    private String memo;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<MsgData> msgdatas;

}