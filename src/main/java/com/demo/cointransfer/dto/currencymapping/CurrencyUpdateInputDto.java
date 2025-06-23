package com.demo.cointransfer.dto.currencymapping;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "幣別輸入")
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyUpdateInputDto {
    @Schema(description = "幣別中文名稱")
    private String codeZh;
}
