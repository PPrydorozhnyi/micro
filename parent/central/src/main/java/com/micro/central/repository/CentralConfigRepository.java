package com.micro.central.repository;

import com.micro.central.entity.CentralConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "central-config",path = "central-config")
public interface CentralConfigRepository extends PagingAndSortingRepository<CentralConfig, Long> {

    Optional<CentralConfig> findCentralConfigByMotherboardId(Long id);

    Optional<CentralConfig> findCentralConfigByCpuId(Long id);

    Optional<CentralConfig> findCentralConfigByGpuId(Long id);

    Optional<CentralConfig> findCentralConfigByDiscId(Long id);
}
