package com.demo.cointransfer.service.impl;

import com.demo.cointransfer.api.CoindeskApi;
import com.demo.cointransfer.config.RetrofitConfig;
import com.demo.cointransfer.domain.CurrencyMapping;
import com.demo.cointransfer.dto.coindeskapi.CoindeskApiOutputDto;
import com.demo.cointransfer.dto.coindeskapi.CoindeskTransformedOutputDto;
import com.demo.cointransfer.dto.coindeskapi.CurrencyInfo;
import com.demo.cointransfer.repository.CurrencyRepository;
import com.demo.cointransfer.service.CoindeskApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.Response;
import util.TimeUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class CoindeskApiServiceImpl implements CoindeskApiService {
    private final CoindeskApi coindeskApi;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Value("${external.coindesk.url}")
    private String coindeskUrl;

    public CoindeskApiServiceImpl() {
        this.coindeskApi = RetrofitConfig.getInstance().create(CoindeskApi.class);
    }

    @Override
    public CoindeskApiOutputDto fetchCoinInfo() {
        try {
            Call<CoindeskApiOutputDto> call = coindeskApi.fetchCoinInfo(coindeskUrl);
            Response<CoindeskApiOutputDto> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            }
            throw new RuntimeException("not found response or unsuccessful status");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CoindeskTransformedOutputDto transformCoinInfo() {
        // 先取Coindesk API 資料
        CoindeskApiOutputDto fetchCoinInfo = fetchCoinInfo();

        // 抓取H2資料庫中，幣別代碼與中文對應資料
        Map<String, String> currencyMapping = currencyRepository.findAll() // key: code , value: codeZh
                .stream()
                .collect(Collectors.toMap(CurrencyMapping::getCode, CurrencyMapping::getCodeZh));

        // bpi(CurrencyVo)需要資訊為 代碼、匯率(數值)，轉為List<CurrencyInfo>
        List<CurrencyInfo> currencyInfos = fetchCoinInfo.getBpi().entrySet()
                .stream()
                .map(entry -> {
                    String code = entry.getKey();
                    Double rate = entry.getValue().getRateFloat();

                    // 代碼中文，以currencyMapping對應。若對應不到則給預設值"未知"
                    String codeZh = currencyMapping.getOrDefault(code,"未知");
                    return CurrencyInfo.builder()
                            .code(code).codeZh(codeZh).rate(rate).build();
                }).collect(Collectors.toList());

        // 處理時間轉換
        String transformedTime = TimeUtil.transLocaleTime(fetchCoinInfo.getTime().getUpdatedISO());

        // 封裝最後回傳之CoindeskTransformedOutputDto
        return CoindeskTransformedOutputDto.builder()
                .updateTime(transformedTime)
                .currencyInfo(currencyInfos)
                .build();
    }
}
