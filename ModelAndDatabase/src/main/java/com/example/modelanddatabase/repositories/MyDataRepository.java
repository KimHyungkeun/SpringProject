package com.example.modelanddatabase.repositories;

import com.example.modelanddatabase.vo.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
    // ID번호를 인수로 하여 MyData 인스턴스를 추출한다
    // 책에서는 findById라 나와있으나, JpaRepository를 이용한다면 getById가 맞다
    public MyData getById(Long name);
}
