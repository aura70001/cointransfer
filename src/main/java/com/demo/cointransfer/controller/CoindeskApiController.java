package com.demo.cointransfer.controller;

import com.demo.cointransfer.dto.coindeskapi.CoindeskApiOutputDto;
import com.demo.cointransfer.dto.coindeskapi.CoindeskTransformedOutputDto;
import com.demo.cointransfer.service.CoindeskApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "CoindeskApiController", description = "呼叫Coindesk API & 重組時間 & 幣別資訊之API")
@RestController
@RequestMapping("/coindesk")
public class CoindeskApiController {
    @Autowired
    CoindeskApiService coindeskApiService;

    @Operation(summary = "呼叫Coindesk API")
    @GetMapping("/fetchCoinInfo")
    public CoindeskApiOutputDto callCoindeskApi() {
        return coindeskApiService.fetchCoinInfo();
    }

    @Operation(summary = "重組時間 & 幣別資訊之API")
    @GetMapping("transformedApi")
    public CoindeskTransformedOutputDto transformedApi() {
        return coindeskApiService.transformCoinInfo();
    }
}
