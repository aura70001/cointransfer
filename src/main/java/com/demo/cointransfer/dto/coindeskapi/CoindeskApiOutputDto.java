package com.demo.cointransfer.dto.coindeskapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

@Data
@Schema(description = "Coindesk API回傳物件")
public class CoindeskApiOutputDto {
    @Schema(description = "時間資訊")
    private TimeVo time;

    @Schema(description = "聲明")
    private String disclaimer;

    @Schema(description = "圖表名")
    private String chartName;

    @Schema(description = "幣別匯率相關資訊")
    private Map<String, CurrencyVo> bpi;
}
