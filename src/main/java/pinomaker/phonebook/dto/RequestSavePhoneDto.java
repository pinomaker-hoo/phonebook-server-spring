package pinomaker.phonebook.dto;

import lombok.Data;

@Data
public class RequestSavePhoneDto {
    private String name;
    private String number;
}
