package com.az.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.az.model.LogInfo;
@Repository
public interface LogInfoDAO extends JpaRepository<LogInfo,Long> {

}
