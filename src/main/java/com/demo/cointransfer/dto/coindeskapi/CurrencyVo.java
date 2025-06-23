package com.demo.cointransfer.dto.coindeskapi;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "幣別匯率相關資訊")
public class CurrencyVo {
    @Schema(description = "幣別代碼")
    private String code;

    @Schema(description = "幣別符號")
    private String symbol;

    @Schema(description = "匯率(字串)")
    private String rate;

    @Schema(description = "幣別全名")
    private String description;

    @Schema(description = "匯率(數值)")
    @SerializedName("rate_float")
    private Double rateFloat;
}
