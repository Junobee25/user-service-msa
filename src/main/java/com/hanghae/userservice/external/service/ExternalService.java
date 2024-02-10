package com.hanghae.userservice.external.service;

import com.hanghae.userservice.domain.entity.UserAccount;
import com.hanghae.userservice.domain.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExternalService {

    private final UserAccountRepository userAccountRepository;

    public Optional<Long> getFromUser(String email) {
        return userAccountRepository.findByEmail(email)
                .map(UserAccount::getId);
    }

    public Optional<Long> checkToUser(Long toUser) {
        return userAccountRepository.findById(toUser)
                .map(UserAccount::getId);
    }

}
