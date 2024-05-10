package com.example.storypickbackend.api.domain.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ReviewEntity {

    @Id
    @GeneratedValue
    private Long Review_id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name="book_id")
    private BookEntity book;

    private Long rating;

    private String contents;
}
