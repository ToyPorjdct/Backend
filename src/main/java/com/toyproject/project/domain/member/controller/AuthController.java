package com.toyproject.project.domain.member.controller;

import com.toyproject.project.domain.member.dto.request.LoginRequest;
import com.toyproject.project.domain.member.dto.request.JoinRequest;
import com.toyproject.project.domain.member.dto.request.TokenRequest;
import com.toyproject.project.domain.member.dto.response.TokenResponse;
import com.toyproject.project.domain.member.service.AuthService;
import com.toyproject.project.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest signupRequest) {
        authService.join(signupRequest);
        return "회원가입 성공";
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


    @GetMapping("/token")
    public String token(@RequestBody TokenRequest tokenRequest) {
        return jwtTokenProvider.getUuid(tokenRequest.getToken());
    }
}
