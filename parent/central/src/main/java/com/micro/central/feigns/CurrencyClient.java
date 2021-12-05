package com.micro.central.feigns;

import com.micro.data.controllers.InnerCurrencyController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "currency", url = "http://localhost:7091")
public interface CurrencyClient extends InnerCurrencyController {

}
