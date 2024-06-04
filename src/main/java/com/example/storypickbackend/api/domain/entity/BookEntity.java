package com.example.storypickbackend.api.domain.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class BookEntity {

    @Id
    private Long book_id;

    private String writer;

    private String bookName;

    private String bookCover;

    private String bookDetail;

    private String bookLocation;

    private String bookNumber;

    private String genre;

    private boolean isExist;

    private boolean isStored;

    private boolean isApply;

    private boolean isMajor;

    private boolean isCertification;
}
