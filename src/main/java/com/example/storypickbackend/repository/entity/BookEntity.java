package com.example.storypickbackend.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class BookEntity {

    // MySQL 수정하기

    @Id
    private Long id;

    private String writer;

    private String bookName;

    private String bookCover;

    private String bookDatail;

    private String bookLocation;

    private String bookNumber;

    private String genre;

    private boolean isExist;

    private boolean isStored;

    private boolean isApply;

    private boolean isMajor;

    private boolean isCertification;
}
