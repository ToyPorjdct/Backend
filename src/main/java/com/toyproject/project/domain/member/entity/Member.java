package com.toyproject.project.domain.member.entity;

import com.toyproject.project.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255)
    private String socialCode;

    private boolean status;

    @Enumerated(EnumType.STRING)
    private MemberRole role;


    public void updateSocialCode(String socialCode) {
        this.socialCode = socialCode;
    }



}
