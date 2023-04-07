package pinomaker.phonebook.dto;

import lombok.Data;

@Data
public class RequestTokenDto {
    private String refreshToken;
    private String accessToken;
}
