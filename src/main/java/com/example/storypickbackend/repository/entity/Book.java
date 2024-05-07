package com.example.storypickbackend.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

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
