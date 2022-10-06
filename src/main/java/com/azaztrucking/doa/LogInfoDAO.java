package com.azaztrucking.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azaztrucking.model.LogInfo;
@Repository
public interface LogInfoDAO extends JpaRepository<LogInfo,Long> {

}
