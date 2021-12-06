package com.micro.central.repository;

import com.micro.central.entity.CentralConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "central-config",path = "central-config")
public interface CentralConfigRepository extends PagingAndSortingRepository<CentralConfig, Long> {
}
