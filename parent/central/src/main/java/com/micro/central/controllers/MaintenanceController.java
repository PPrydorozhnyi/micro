package com.micro.central.controllers;

import com.micro.central.services.MaintenanceService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MaintenanceController {

    public static final String FORWARD_HEADER = "X-FORWARDED-FOR";

    private final MaintenanceService maintenanceService;

    @GetMapping("/maintenance/{configId}")
    public String proceedMaintenance(@PathVariable long configId,
                                   HttpServletRequest request, Model model){
        String ipAddress = request.getHeader(FORWARD_HEADER);

        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        log.info("ip {}", ipAddress);
        final var result = maintenanceService.proceedMaintenance(configId, ipAddress);

        model.addAttribute("maintenance", result);

        return "maintenance/maintenanceView";
    }

}
