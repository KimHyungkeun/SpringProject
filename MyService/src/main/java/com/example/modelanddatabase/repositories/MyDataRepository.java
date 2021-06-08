package com.example.modelanddatabase.repositories;

import com.example.modelanddatabase.vo.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import java.util.List;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
    // ID번호를 인수로 하여 MyData 인스턴스를 추출한다
    // 책에서는 findById라 나와있으나, JpaRepository를 이용한다면 getById가 맞다

    public MyData getById(Long name);
    public List<MyData> findByNameLike(String name);
    public List<MyData> findByIdIsNotNullOrderByIdDesc();
    public List<MyData> findByAgeGreaterThan(Integer age);
    public List<MyData> findByAgeBetween(Integer age1, Integer age2);

    @Query("SELECT d FROM MyData d ORDER BY d.name")
    List<MyData> findAllOrderByName();
}
