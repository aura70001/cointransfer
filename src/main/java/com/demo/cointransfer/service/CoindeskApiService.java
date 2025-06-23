package com.demo.cointransfer.service;

import com.demo.cointransfer.dto.coindeskapi.CoindeskApiOutputDto;
import com.demo.cointransfer.dto.coindeskapi.CoindeskTransformedOutputDto;

public interface CoindeskApiService {
    /**
     * 呼叫Coindesk API
     * @return CoindeskApiOutputDto
     */
    CoindeskApiOutputDto fetchCoinInfo();

    /**
     * 重組時間 & 幣別資訊之API
     * @return CoindeskTransformedOutputDto
     */
    CoindeskTransformedOutputDto transformCoinInfo();
}
