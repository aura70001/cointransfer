package com.demo.cointransfer.service;

import com.demo.cointransfer.domain.CurrencyMapping;
import com.demo.cointransfer.dto.currencymapping.CurrencyInputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyOutputDto;
import com.demo.cointransfer.dto.currencymapping.CurrencyUpdateInputDto;

import java.util.List;

public interface CurrencyMappingService {
    /**
     * 查詢全部幣別資訊
     * @return List<CurrencyOutputDto>
     */
    List<CurrencyOutputDto> findAll();

    /**
     * 新增一筆幣別
     * @param input CurrencyInputDto (code, codeZh)
     * @return CurrencyOutputDto (code,codeZh)
     */
    CurrencyOutputDto create(CurrencyInputDto input);

    /**
     * 修改一筆幣別
     * @param code 幣別代碼
     * @param input CurrencyUpdateInputDto (codeZh)
     * @return CurrencyOutputDto (code,codeZh)
     */
    CurrencyOutputDto modify(String code, CurrencyUpdateInputDto input);

    /**
     * 刪除一筆幣別
     * @param code 幣別代碼
     */
    void remove(String code);
}
