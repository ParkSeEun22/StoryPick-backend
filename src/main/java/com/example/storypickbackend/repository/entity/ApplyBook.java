package com.example.storypickbackend.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class ApplyBook {

    @Id
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;
}
