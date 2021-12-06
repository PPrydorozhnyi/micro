package com.micro.gpu.repository;

import com.micro.gpu.entity.GPUConfig;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gpu-config", path = "gpu-config")
public interface GPUConfigRepository extends PagingAndSortingRepository<GPUConfig, Long> {
}
