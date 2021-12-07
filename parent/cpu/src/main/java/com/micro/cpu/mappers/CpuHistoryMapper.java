package com.micro.cpu.mappers;

import com.micro.cpu.entity.CPUHistory;
import com.micro.data.models.CPUHistoryDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CpuHistoryMapper {

  List<CPUHistoryDto> map(List<CPUHistory> configs);

  CPUHistoryDto map(CPUHistory config);

}
