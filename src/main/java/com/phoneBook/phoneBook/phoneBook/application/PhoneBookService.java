package com.phoneBook.phoneBook.phoneBook.application;

import com.phoneBook.phoneBook.phoneBook.domain.PhoneBook;
import com.phoneBook.phoneBook.phoneBook.dto.RequestSavePhoneBookDto;
import com.phoneBook.phoneBook.phoneBook.infrastructure.PhoneBookJpaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneBookService {
    private final PhoneBookJpaRepository phoneBookJpaRepository;

    public PhoneBook save(RequestSavePhoneBookDto body){
        PhoneBook savePhoneBook = new PhoneBook(body.getName(), body.getPhone());
        return phoneBookJpaRepository.save(savePhoneBook);
    }

    public List<PhoneBook> findAll(){
        return phoneBookJpaRepository.findAll();
    }

    public Optional<PhoneBook> findByIdx(Long idx){
        return phoneBookJpaRepository.findById(idx);
    }
}
