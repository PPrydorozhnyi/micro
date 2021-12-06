package com.micro.motherboard.repository;

import com.micro.motherboard.entity.MotherboardHistory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "motherboard-history", path = "motherboard-history")
public interface MotherboardHistoryRepository extends PagingAndSortingRepository<MotherboardHistory, Long> {
}
