package com.demo.cointransfer.service;

import com.demo.cointransfer.dto.currencymapping.CurrencyInputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyOutputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyUpdateInputDto;
import com.demo.cointransfer.repository.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CurrencyMappingServiceITest {
    @Autowired
    CurrencyMappingService currencyMappingService;

    @Autowired
    CurrencyRepository currencyRepository;

    @Test
    void findAllCurrencyTest() {
        List<CurrencyOutputDto> result = currencyMappingService.findAll();
        assertEquals(7, result.size());
    }

    @Test
    void createCurrencyTest() {
        CurrencyInputDto input = new CurrencyInputDto("THB", "泰銖");
        CurrencyOutputDto created = currencyMappingService.create(input);
        assertEquals("THB", created.getCode());
    }

    @Test
    void modifyCurrencyTest() {
        CurrencyUpdateInputDto update = new CurrencyUpdateInputDto("美國國幣");
        CurrencyOutputDto updated = currencyMappingService.modify("USD", update);
        assertEquals("美國國幣", updated.getCodeZh());
    }

    @Test
    void removeCurrencyTest() {
        currencyMappingService.remove("USD");
        assertFalse(currencyRepository.existsById("USD"));
    }

}
