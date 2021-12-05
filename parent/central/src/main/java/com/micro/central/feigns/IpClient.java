package com.micro.central.feigns;

import com.micro.data.controllers.InnerIpController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ip-service", url = "http://localhost:7090")
public interface IpClient extends InnerIpController {

}
