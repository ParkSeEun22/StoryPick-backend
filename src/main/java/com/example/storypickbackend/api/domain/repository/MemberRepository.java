package com.example.storypickbackend.api.domain.repository;

import com.example.storypickbackend.api.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    MemberEntity existsByUsername(String username);

    MemberEntity findByIdentifier(Long id);

}
