package com.example.storypickbackend.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Member {

    @Id
    private Long member_id;
    // MySQL 수정 member이 VarChar로 되어있다 -> Int로 ,,,

    private String password;

    private String username;

    private String department;

    private Long grade;

}
