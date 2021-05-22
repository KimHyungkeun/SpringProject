package com.example.modelanddb.repositories;

import com.example.modelanddb.vo.MyData;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 자체는 JpaRepository 클래스를 상속하고 있다.
@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
