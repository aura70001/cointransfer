package com.demo.cointransfer.dto.coindeskapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Coindesk Transformed API 幣別資訊")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInfo {
    @Schema(description = "幣別代碼")
    private String code;

    @Schema(description = "幣別中文名稱")
    private String codeZh;

    @Schema(description = "匯率")
    private Double rate;

}
