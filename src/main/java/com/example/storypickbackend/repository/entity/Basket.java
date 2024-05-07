package com.example.storypickbackend.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Basket {

    @Id
    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
