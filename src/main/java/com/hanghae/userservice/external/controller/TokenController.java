package com.hanghae.userservice.external.controller;

import com.hanghae.userservice.domain.entity.Token;
import com.hanghae.userservice.domain.repository.TokenRepository;
import com.hanghae.userservice.external.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping("/tokens/{email}")
    public String getToken(@PathVariable(value="email") String email) {
        return tokenService.getToken(email);
    }
}
