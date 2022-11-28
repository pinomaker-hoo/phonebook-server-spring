package com.phoneBook.phoneBook.phoneBook.application;

import com.phoneBook.phoneBook.phoneBook.infrastructure.PhoneBookJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneBookService {
    private final PhoneBookJpaRepository phoneBookJpaRepository;

}
