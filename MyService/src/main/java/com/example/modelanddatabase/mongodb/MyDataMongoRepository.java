package com.example.modelanddatabase.mongodb;

import com.example.modelanddatabase.mongodb.MyDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> {
    public List<MyDataMongo> findByName(String s);
}
