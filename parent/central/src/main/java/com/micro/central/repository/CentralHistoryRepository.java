package com.micro.central.repository;

import com.micro.central.entity.CentralHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "central-history", path = "central-history")
public interface CentralHistoryRepository extends PagingAndSortingRepository<CentralHistory, Long> {
}
