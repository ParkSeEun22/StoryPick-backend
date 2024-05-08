package com.example.storypickbackend.repository;

import com.example.storypickbackend.repository.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
