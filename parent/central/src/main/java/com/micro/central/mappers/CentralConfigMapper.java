package com.micro.central.mappers;

import com.micro.central.dto.CentralConfigDto;
import com.micro.central.entity.CentralConfig;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CentralConfigMapper {

  List<CentralConfigDto> map(List<CentralConfig> configs);

  CentralConfigDto map(CentralConfig config);

  CentralConfig map(CentralConfigDto centralConfigDto);
}