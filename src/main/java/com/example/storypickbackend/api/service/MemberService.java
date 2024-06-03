package com.example.storypickbackend.api.service;

import com.example.storypickbackend.api.domain.entity.MemberEntity;
import com.example.storypickbackend.api.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService /*implements UserDetailsService*/ {

    private final MemberRepository memberRepository;

    @Transactional
    public boolean register(MemberEntity member) {
        // findByUsername
        MemberEntity memberEntity = memberRepository.existsByUsername(member.getUsername());
        if(memberEntity != null) {
            memberRepository.save(member);
            memberRepository.flush();
            return true;
        }
        return false;
    }

    public boolean login(MemberEntity member) {
        MemberEntity memberEntity = memberRepository.findByIdentifier(member.getMember_id());
        if((member.getUsername() == memberEntity.getUsername()) && (member.getPassword() == memberEntity.getPassword())) {
            return true;
        }
        return false;
    }


}
