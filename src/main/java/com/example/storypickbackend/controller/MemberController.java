package com.example.storypickbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    // 아직 공부중 ,,, Controller 위치 확인

    @GetMapping("/hello")
    public String getHello() {
        return "안녕안녕";
    }
}
