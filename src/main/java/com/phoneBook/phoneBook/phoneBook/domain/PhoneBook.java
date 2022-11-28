package com.phoneBook.phoneBook.phoneBook.domain;

import com.phoneBook.phoneBook.common.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "phoneBook")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PhoneBook extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;
}
