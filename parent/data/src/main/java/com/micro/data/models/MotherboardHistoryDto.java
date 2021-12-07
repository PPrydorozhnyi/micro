package com.micro.data.models;

import com.micro.data.models.enums.Component;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MotherboardHistoryDto extends GeneralHistoryResponse {

  private List<Component> components;

  private List<Component> freePorts;

}
