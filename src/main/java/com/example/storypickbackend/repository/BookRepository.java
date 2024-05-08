package com.example.storypickbackend.repository;

import com.example.storypickbackend.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
