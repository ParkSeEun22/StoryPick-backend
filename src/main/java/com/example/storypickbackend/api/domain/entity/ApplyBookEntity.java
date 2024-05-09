package com.example.storypickbackend.api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ApplyBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applyBook_id;

    @ManyToOne
    @JoinColumn(name="book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;
}
