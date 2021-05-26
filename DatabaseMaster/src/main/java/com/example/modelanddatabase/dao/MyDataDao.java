package com.example.modelanddatabase.dao;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao <T> extends Serializable {

    public List<T> getAll(); // 모든 데이터 찾기
    public T findById(long id); // ID따라 찾기
    public List<T> findByName(String name); // 이름를 통해 찾기
    public List<T> find(String fstr); // 입력받은 쿼리 조건에 따라 찾기
    public List<T> findByAge(int min, int max); // 나이를 통해 찾기
}
