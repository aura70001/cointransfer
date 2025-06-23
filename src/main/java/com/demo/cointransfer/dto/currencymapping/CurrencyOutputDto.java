package com.demo.cointransfer.dto.currencymapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "幣別回傳")
public class CurrencyOutputDto {
    @Schema(description = "幣別代碼")
    private String code;

    @Schema(description = "幣別中文名稱")
    private String codeZh;
}
