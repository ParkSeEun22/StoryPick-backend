package com.example.storypickbackend.api.domain.repository;

import com.example.storypickbackend.api.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity existsByUserName(String username);

    Optional<MemberEntity> findById(Long member_id);

}
