package com.example.modelanddatabase.repositories;

import com.example.modelanddatabase.vo.MsgData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgDataRepository extends JpaRepository<MsgData, Long> {
}
