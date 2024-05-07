package com.example.storypickbackend.repository;

import com.example.storypickbackend.repository.entity.ApplyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyBookRepository extends JpaRepository<ApplyBook, Long> {
}
