package com.demo.cointransfer.controller;

import com.demo.cointransfer.dto.currencymapping.CurrencyInputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyOutputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyUpdateInputDto;
import com.demo.cointransfer.service.CurrencyMappingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "CurrencyMappingController", description = "針對幣別資料表CRUD API")
@RestController
@RequestMapping("/currency")
public class CurrencyMappingController {
    @Autowired
    CurrencyMappingService currencyMappingService;

    @Operation(summary = "查詢全部")
    @GetMapping("/findAllCurrencies")
    public List<CurrencyOutputDto> findAllCurrencies() {
        return currencyMappingService.findAll();
    }

    @Operation(summary = "新增一筆幣別")
    @PostMapping("/createCurrency")
    public CurrencyOutputDto createCurrency(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "貨幣資訊")
                                            @RequestBody CurrencyInputDto input) {
        if (input == null || StringUtils.isEmpty(input.getCode())) {
            throw new RuntimeException("code is necessary");
        }
        return currencyMappingService.create(input);
    }

    @Operation(summary = "修改一筆幣別")
    @PutMapping("/modifyCurrency/{code}")
    public CurrencyOutputDto modifyCurrency(@Parameter(description = "幣別代碼") @PathVariable String code,
                                            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "貨幣資訊")
                                            @RequestBody CurrencyUpdateInputDto input) {
        if (input == null || StringUtils.isEmpty(code)) {
            throw new RuntimeException("code is necessary");
        }
        return currencyMappingService.modify(code, input);
    }

    @Operation(summary = "刪除一筆幣別")
    @DeleteMapping("/removeCurrency/{code}")
    public void removeCurrency(@Parameter(description = "幣別代碼") @PathVariable String code) {
        if (StringUtils.isEmpty(code)) {
            throw new RuntimeException("code is necessary");
        }
        currencyMappingService.remove(code);
    }
}
