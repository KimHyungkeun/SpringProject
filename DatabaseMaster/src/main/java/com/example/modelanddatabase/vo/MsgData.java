package com.example.modelanddatabase.vo;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter

@Entity
@Table(name = "msgdata")
public class MsgData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @NotNull
    private  long id;

    @Column
    private String title;

    @Column(nullable = false)
    @NotEmpty
    private String message;

    @ManyToOne
    private MyData myData;

    public MsgData() {
        super();
        myData = new MyData();
    }

}
