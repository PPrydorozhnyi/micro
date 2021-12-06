package com.micro.disc.repository;

import com.micro.disc.entity.DiscHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "disc-history", path = "disc-history")
public interface DiscHistoryRepository extends PagingAndSortingRepository<DiscHistory, Long> {
}
