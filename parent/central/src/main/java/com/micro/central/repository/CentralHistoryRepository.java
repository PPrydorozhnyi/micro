package com.micro.central.repository;

import com.micro.central.entity.CentralHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralHistoryRepository extends JpaRepository<CentralHistory, Long> {
}
