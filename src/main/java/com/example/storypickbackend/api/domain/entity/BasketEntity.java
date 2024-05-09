package com.example.storypickbackend.api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Basket_id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;
}
