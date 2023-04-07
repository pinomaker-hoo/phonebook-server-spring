package pinomaker.phonebook.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pinomaker.phonebook.common.dto.RequestResponseDto;
import pinomaker.phonebook.domain.Phone;
import pinomaker.phonebook.domain.User;
import pinomaker.phonebook.dto.RequestSavePhoneDto;
import pinomaker.phonebook.repoistory.PhoneJpaRepository;
import pinomaker.phonebook.repoistory.UserJpaRepository;
import pinomaker.phonebook.service.PhoneService;
import pinomaker.phonebook.util.SecurityUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneJpaRepository phoneJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public RequestResponseDto<?> save(RequestSavePhoneDto dto) {
        try {
            String id = SecurityUtil.getCurrentUserId();
            Optional<User> findUser = userJpaRepository.findUserById(id);

            if (findUser.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "사용자를 찾을 수 없습니다.", false);
            }

            Phone savePhone = Phone.builder()
                    .name(dto.getName())
                    .number(dto.getNumber())
                    .user(findUser.get()).build();
            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "전화번호 저장 성공", phoneJpaRepository.save(savePhone));
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findAll() {
        try {
            String id = SecurityUtil.getCurrentUserId();
            Optional<User> findUser = userJpaRepository.findUserById(id);

            if (findUser.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "사용자를 찾을 수 없습니다.", false);
            }

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "전화번호 전체 조회 성공", phoneJpaRepository.findAllByUser(findUser.get()));
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> findOne(Long idx) {
        try {
            Optional<Phone> findPhone = phoneJpaRepository.findByIdx(idx);

            if (findPhone.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "전화번호를 찾을 수 없습니다.", false);
            }

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "전화번호 조회 성공", findPhone.get());
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto delete(Long idx) {
        try {
            Optional<Phone> findPhone = phoneJpaRepository.findByIdx(idx);

            if (findPhone.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "전화번호를 찾을 수 없습니다.", false);
            }

            phoneJpaRepository.delete(findPhone.get());

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "전화번호 삭제 성공", true);
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> update(Long idx, RequestSavePhoneDto dto) {
        try {
            Optional<Phone> findPhone = phoneJpaRepository.findByIdx(idx);

            if (findPhone.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "전화번호를 찾을 수 없습니다.", false);
            }

            if(!dto.getName().isEmpty()){
                findPhone.get().setName(dto.getName());
            }

            if(!dto.getName().isEmpty()){
                findPhone.get().setNumber(dto.getNumber());
            }

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "전화번호 수정 성공", phoneJpaRepository.save(findPhone.get()));
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }
}
