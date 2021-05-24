package com.example.modelanddatabase.repositories;

import com.example.modelanddatabase.vo.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{

    public MyData getById(Long name);
}
