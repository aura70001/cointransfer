package com.demo.cointransfer.dto.coindeskapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Schema(description = "Coindesk Transformed API回傳物件")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CoindeskTransformedOutputDto {

    @Schema(description = "更新時間")
    private String updateTime;

    @Schema(description = "幣別資訊")
    private List<CurrencyInfo> currencyInfo;
}
