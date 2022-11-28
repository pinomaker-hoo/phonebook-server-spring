package com.phoneBook.phoneBook.phoneBook.ui;

import com.phoneBook.phoneBook.phoneBook.application.PhoneBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@AllArgsConstructor
public class PhoneBookController {
    private final PhoneBookService phoneBookService;
}
