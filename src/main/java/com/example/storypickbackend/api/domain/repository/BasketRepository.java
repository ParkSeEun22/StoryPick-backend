package com.example.storypickbackend.api.domain.repository;

import com.example.storypickbackend.api.domain.entity.BasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, Long> {
}
