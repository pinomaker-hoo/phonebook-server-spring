package pinomaker.phonebook.service;

import pinomaker.phonebook.common.dto.RequestResponseDto;
import pinomaker.phonebook.dto.RequestLoginUserDto;
import pinomaker.phonebook.dto.RequestSaveUserDto;
import pinomaker.phonebook.dto.RequestTokenDto;

public interface UserService {
    RequestResponseDto<?> save(RequestSaveUserDto dto);

    RequestResponseDto<?> login(RequestLoginUserDto dto);

    RequestResponseDto<?> getTokenByRefreshToken(RequestTokenDto dto);
}
