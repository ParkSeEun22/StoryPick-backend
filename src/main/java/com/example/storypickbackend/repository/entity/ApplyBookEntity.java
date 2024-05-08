package com.example.storypickbackend.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ApplyBookEntity {

    @Id
    @GeneratedValue
    private Long applyBook_id;

    @ManyToOne
    @JoinColumn(name="book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;
}
