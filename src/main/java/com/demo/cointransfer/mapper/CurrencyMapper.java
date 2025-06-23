package com.demo.cointransfer.mapper;

import com.demo.cointransfer.domain.CurrencyMapping;
import com.demo.cointransfer.dto.currencymapping.CurrencyInputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyOutputDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    CurrencyMapping toEntity(CurrencyInputDto input);
    CurrencyOutputDto toDto(CurrencyMapping entity);
}
