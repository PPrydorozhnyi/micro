package com.micro.motherboard.repository;

import com.micro.motherboard.entity.MotherboardConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "motherboard-config", path = "motherboard-config")
public interface MotherboardConfigRepository extends PagingAndSortingRepository<MotherboardConfig, Long> {
}
