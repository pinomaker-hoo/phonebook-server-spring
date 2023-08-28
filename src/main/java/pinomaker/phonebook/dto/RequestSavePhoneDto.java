package pinomaker.phonebook.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestSavePhoneDto {
    @Schema(example = "김인후")
    private String name;

    @Schema(example = "01012345678")
    private String number;
}
