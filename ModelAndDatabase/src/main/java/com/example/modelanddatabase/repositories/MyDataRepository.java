package com.example.modelanddatabase.repositories;

import com.example.modelanddatabase.vo.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
}