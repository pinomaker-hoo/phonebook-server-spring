package pinomaker.phonebook.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pinomaker.phonebook.repoistory.UserJpaRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserJpaRepository userJpaRepository;
}
