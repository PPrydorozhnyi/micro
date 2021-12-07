package com.micro.gpu.mappers;

import com.micro.data.models.GPUHistoryDto;
import com.micro.gpu.entity.GPUHistory;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GpuHistoryMapper {

  List<GPUHistoryDto> map(List<GPUHistory> configs);

  GPUHistoryDto map(GPUHistory config);

}
