package com.phoneBook.phoneBook.phoneBook.ui;

import com.phoneBook.phoneBook.phoneBook.application.PhoneBookService;
import com.phoneBook.phoneBook.phoneBook.domain.PhoneBook;
import com.phoneBook.phoneBook.phoneBook.dto.RequestSavePhoneBookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PhoneBookController {
    private final PhoneBookService phoneBookService;

    @PostMapping()
    public PhoneBook save(@RequestBody RequestSavePhoneBookDto body){
        return phoneBookService.save(body);
    }

    @GetMapping()
    public List<PhoneBook> findAll(){
        return phoneBookService.findAll();
    }

    @GetMapping("/{idx}")
    public Optional<PhoneBook> findByIdx(@PathVariable(name = "idx") Long idx){
        return phoneBookService.findByIdx(idx);
    }
}
