package com.example.modelanddb.repositories;

import com.example.modelanddb.vo.MyData;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
