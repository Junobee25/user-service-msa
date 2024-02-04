package com.hanghae.userservice.controller;

import com.hanghae.userservice.dto.request.UserLoginRequest;
import com.hanghae.userservice.dto.request.UserProfileModifyRequest;
import com.hanghae.userservice.dto.request.UserSignUpRequest;
import com.hanghae.userservice.dto.response.Response;
import com.hanghae.userservice.dto.response.UserLoginResponse;
import com.hanghae.userservice.dto.response.UserSignUpResponse;
import com.hanghae.userservice.service.UserAccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/users/sign-up")
    public Response<UserSignUpResponse> signUp(UserSignUpRequest request) {
        return Response.success(UserSignUpResponse.from(userAccountService.signUp(
                request.email(),
                request.userName(),
                request.password(),
                request.memo(),
                request.profilePicture())));
    }

    @PostMapping("/users/login")
    public Response<UserLoginResponse> login(UserLoginRequest request) {
        return Response.success(userAccountService.login(request.email(), request.password()));
    }

    @PostMapping("/api/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userAccountService.refreshToken(request, response);
    }

    @PutMapping("/api/modify-profile")
    public void modifyProfile(UserProfileModifyRequest request, Authentication authentication) {
        //TODO: 프로필 변경시 프로필 사진은 일단 String 으로 대체한다. 후에 변경
        userAccountService.modifyProfile(authentication.getName(), request.userName(), request.memo(), request.profilePicture());
    }

    @PutMapping("/api/modify-password")
    public Response<UserLoginResponse> modifyPassword(String currentPassword, String newPassword, Authentication authentication) {
        return Response.success(userAccountService.modifyPassword(authentication.getName(), currentPassword, newPassword));
    }
}
