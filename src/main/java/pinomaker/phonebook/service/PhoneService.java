package pinomaker.phonebook.service;

import pinomaker.phonebook.common.dto.RequestResponseDto;
import pinomaker.phonebook.dto.RequestSavePhoneDto;

public interface PhoneService {
    RequestResponseDto<?> save(RequestSavePhoneDto dto);
    RequestResponseDto<?> findAll();
    RequestResponseDto<?> findOne(Long idx);
    RequestResponseDto<?> delete(Long idx);
    RequestResponseDto<?> update(Long idx, RequestSavePhoneDto dto);
}
