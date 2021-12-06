package com.micro.gpu.repository;

import com.micro.gpu.entity.GPUHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gpu-history", path = "gpu-history")
public interface GPUHistoryRepository extends PagingAndSortingRepository<GPUHistory, Long> {
}
