package com.micro.disc.mappers;

import com.micro.data.models.DiscHistoryDto;
import com.micro.disc.entity.DiscHistory;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiscHistoryMapper {

  List<DiscHistoryDto> map(List<DiscHistory> configs);

  DiscHistoryDto map(DiscHistory config);

}
