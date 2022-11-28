package com.phoneBook.phoneBook.phoneBook.infrastructure;

import com.phoneBook.phoneBook.phoneBook.domain.PhoneBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBook, Long> {
}
