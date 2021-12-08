package com.micro.central.repository;

import com.micro.central.entity.CentralConfig;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralConfigRepository extends JpaRepository<CentralConfig, Long> {

    Optional<CentralConfig> findCentralConfigByMotherboardId(Long id);

    Optional<CentralConfig> findCentralConfigByCpuId(Long id);

    Optional<CentralConfig> findCentralConfigByGpuId(Long id);

    Optional<CentralConfig> findCentralConfigByDiscId(Long id);
}
