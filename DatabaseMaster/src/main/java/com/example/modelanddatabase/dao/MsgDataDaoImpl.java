package com.example.modelanddatabase.dao;

import com.example.modelanddatabase.repositories.MsgDataRepository;
import com.example.modelanddatabase.vo.MsgData;
import com.example.modelanddatabase.vo.MyData;

import javax.persistence.EntityManager;
import java.util.List;

public class MsgDataDaoImpl implements MsgDataDao<MsgDataDao> {

    private EntityManager entityManager;

    public MsgDataDaoImpl() {
        super();
    }

    public MsgDataDaoImpl(EntityManager manager) {
        entityManager = manager;
    }

    @Override
    public List<MsgData> getAll() {
        return entityManager.createQuery("from MsgData").getResultList();
    }

    @Override
    public MsgData findById(long id) {
        return (MsgData) entityManager.createQuery("from MsgData where id = " + id)
                .getSingleResult();
    }
}
