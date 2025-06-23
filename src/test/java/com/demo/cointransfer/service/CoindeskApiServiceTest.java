package com.demo.cointransfer.service;

import com.demo.cointransfer.dto.coindeskapi.CoindeskApiOutputDto;
import com.demo.cointransfer.dto.coindeskapi.CoindeskTransformedOutputDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoindeskApiServiceTest {
    @Autowired
    CoindeskApiService coindeskApiService;

    @Test
    void fetchCoinInfoTest() {
        CoindeskApiOutputDto fetchCoinInfo = coindeskApiService.fetchCoinInfo();
        assertEquals(3,fetchCoinInfo.getBpi().size());
        assertEquals("&#36;",fetchCoinInfo.getBpi().get("USD").getSymbol());
    }

    @Test
    void transformCoinInfoTest() {
        CoindeskTransformedOutputDto transformCoinInfo = coindeskApiService.transformCoinInfo();
        assertEquals("歐元",transformCoinInfo.getCurrencyInfo().get(2).getCodeZh());
    }
}
