package com.demo.cointransfer.service.impl;

import com.demo.cointransfer.domain.CurrencyMapping;
import com.demo.cointransfer.dto.currencymapping.CurrencyInputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyOutputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyUpdateInputDto;
import com.demo.cointransfer.mapper.CurrencyMapper;
import com.demo.cointransfer.repository.CurrencyRepository;
import com.demo.cointransfer.service.CurrencyMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CurrencyMappingServiceImpl implements CurrencyMappingService {
    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    CurrencyMapper currencyMapper;

    @Override
    public List<CurrencyOutputDto> findAll() {
        return currencyRepository.findAll()
                .stream()
                .map(e -> currencyMapper.toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyOutputDto create(CurrencyInputDto input) {
        if (currencyRepository.existsById(input.getCode())) {
            throw new RuntimeException("this code already exists");
        }
        CurrencyMapping entity = currencyMapper.toEntity(input);
        CurrencyMapping saved = currencyRepository.save(entity);
        return currencyMapper.toDto(saved);
    }

    @Override
    public CurrencyOutputDto modify(String code, CurrencyUpdateInputDto input) {
        CurrencyMapping entity = currencyRepository.findById(code)
                .orElseThrow(() -> new RuntimeException("currency code not found"));

        entity.setCodeZh(input.getCodeZh());
        CurrencyMapping saved = currencyRepository.save(entity);
        return currencyMapper.toDto(saved);
    }

    @Override
    public void remove(String code) {
        if (!currencyRepository.existsById(code)) {
            throw new RuntimeException("currency code not found");
        }
        currencyRepository.deleteById(code);
    }
}
