package com.example.modelanddatabase.dao;

import com.example.modelanddatabase.vo.MsgData;

import java.util.List;

public interface MsgDataDao <T>{

    public List<MsgData> getAll();
    public MsgData findById(long id);
}
