package com.example.storypickbackend.api.controller;

import com.example.storypickbackend.api.domain.entity.MemberEntity;
import com.example.storypickbackend.api.dto.request.MemberDto;
import com.example.storypickbackend.api.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Member")
public class MemberController {

    private MemberService memberService;

    // 회원가입
    @PostMapping("/registerProc")
    public boolean registerProc(@RequestBody MemberEntity memberEntity) {
        return memberService.register(memberEntity);
    }

    // 로그인
    @GetMapping("/login")
    public boolean login(@RequestBody MemberEntity memberEntity) {
        return memberService.login(memberEntity);
    }

}
