package com.example.storypickbackend.api.domain.repository;

import com.example.storypickbackend.api.domain.entity.ApplyBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyBookRepository extends JpaRepository<ApplyBookEntity, Long> {
}
