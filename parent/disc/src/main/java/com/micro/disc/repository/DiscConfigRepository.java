package com.micro.disc.repository;

import com.micro.disc.entity.DiscConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "disc-config", path = "disc-config")
public interface DiscConfigRepository extends PagingAndSortingRepository<DiscConfig, Long> {
}
