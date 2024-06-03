package com.example.storypickbackend.api.dto.request;

import com.example.storypickbackend.api.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private String username;

    private String password;

    private String department;

    private Long grade;

/*    public MemberEntity toEntity() {
        MemberEntity memberEntity = MemberEntity.builder()
                .username(username)
                .password(password)
                .department(department)
                .grade(grade)
                .build();
        return memberEntity;
    }*/
}
