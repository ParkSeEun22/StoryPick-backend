package com.example.storypickbackend.api.domain.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class MemberEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long member_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String department;

    private Long grade;

    private String genre;

}
