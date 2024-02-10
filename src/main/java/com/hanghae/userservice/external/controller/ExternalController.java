package com.hanghae.userservice.external.controller;

import com.hanghae.userservice.dto.response.Response;
import com.hanghae.userservice.external.service.ExternalService;
import com.hanghae.userservice.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class ExternalController {

    private final UserAccountService userAccountService;
    private final ExternalService externalService;

    /// REST API
    @GetMapping("/users/email")
    public String getUserEmail(Authentication authentication) {
        return Response.success(authentication.getName()).getResult();
    }

    @GetMapping("/users/from-user-id")
    public Optional<Long> getFromUserId(Authentication authentication) {
        return Response.success(externalService.getFromUser(authentication.getName())).getResult();
    }

    @GetMapping("/users/{toUser}")
    public Optional<Long> checkToUserId(@PathVariable Long toUser) {
        return externalService.checkToUser(toUser);
    }
}
