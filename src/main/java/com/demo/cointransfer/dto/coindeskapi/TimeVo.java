package com.demo.cointransfer.dto.coindeskapi;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Schema(description = "時間資訊")
public class TimeVo {
    @Schema(description = "更新時間(英)")
    private String updated;

    @Schema(description = "更新時間(ISO)")
    private String updatedISO;

    @Schema(description = "更新時間(美)")
    private String updateduk;
}
