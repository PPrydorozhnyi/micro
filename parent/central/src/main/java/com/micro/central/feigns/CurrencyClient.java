package com.micro.central.feigns;

import com.micro.data.controllers.InnerCurrencyController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "currency")
public interface CurrencyClient extends InnerCurrencyController {

}
