package com.micro.motherboard.mappers;

import com.micro.data.models.MotherboardHistoryDto;
import com.micro.motherboard.entity.MotherboardHistory;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MotherboardHistoryMapper {

  List<MotherboardHistoryDto> map(List<MotherboardHistory> configs);

  MotherboardHistoryDto map(MotherboardHistory config);

}
