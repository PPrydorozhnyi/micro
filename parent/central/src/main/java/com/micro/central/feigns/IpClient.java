package com.micro.central.feigns;

import com.micro.data.controllers.InnerIpController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ip-service")
public interface IpClient extends InnerIpController {

}
