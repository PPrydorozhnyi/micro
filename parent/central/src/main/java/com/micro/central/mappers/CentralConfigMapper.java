package com.micro.central.mappers;

import com.micro.central.entity.CentralConfig;
import com.stakelogic.livecasino.common.dto.gameflow.InBalance;
import com.stakelogic.livecasino.common.dto.gc.Bonus;
import com.stakelogic.livecasino.common.dto.gc.GcBalanceDto;
import com.stakelogic.livecasino.common.dto.roulette.GcRouletteBalanceDto;
import com.stakelogic.livecasino.common.general.Cents;
import com.stakelogic.roulette.models.entities.Funds;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CentralConfigMapper {

  List<CentralConfigDto> map(List<CentralConfig>);

  CentralConfigDto map(CentralConfig);

}
