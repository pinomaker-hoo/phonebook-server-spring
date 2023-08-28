package pinomaker.phonebook.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RequestSaveUserDto {
    @Schema(example = "admin")
    private String id;

    @Schema(example = "1234")
    private String password;

    @Schema(example = "admin")
    private String name;
}