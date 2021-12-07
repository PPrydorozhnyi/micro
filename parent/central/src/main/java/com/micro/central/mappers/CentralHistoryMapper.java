package com.micro.central.mappers;

import com.micro.central.dto.CentralHistoryDto;
import com.micro.central.entity.CentralHistory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CentralHistoryMapper {
    List<CentralHistoryDto> map(List<CentralHistory> histories);

    CentralHistoryDto map(CentralHistory history);

    CentralHistory map(CentralHistoryDto centralHistoryDto);
}