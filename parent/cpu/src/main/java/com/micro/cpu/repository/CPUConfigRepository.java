package com.micro.cpu.repository;

import com.micro.cpu.entity.CPUConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cpu-config", path = "cpu-config")
public interface CPUConfigRepository extends PagingAndSortingRepository<CPUConfig, Long> {
}
