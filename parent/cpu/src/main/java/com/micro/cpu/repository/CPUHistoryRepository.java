package com.micro.cpu.repository;

import com.micro.cpu.entity.CPUHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cpu-history", path = "cpu-history")
public interface CPUHistoryRepository extends PagingAndSortingRepository<CPUHistory, Long> {
}
