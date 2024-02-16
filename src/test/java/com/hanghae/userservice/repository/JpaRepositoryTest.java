package com.hanghae.userservice.repository;

import com.hanghae.userservice.domain.entity.UserAccount;
import com.hanghae.userservice.domain.repository.UserAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaRepositoryTest {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public JpaRepositoryTest(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelection_thenWorksFine() {
        //given
        UserAccount user1 = userAccountRepository.save(UserAccount.of("test1@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user2 = userAccountRepository.save(UserAccount.of("test2@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user3 = userAccountRepository.save(UserAccount.of("test3@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user4 = userAccountRepository.save(UserAccount.of("test4@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user5 = userAccountRepository.save(UserAccount.of("test5@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user6 = userAccountRepository.save(UserAccount.of("test6@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user7 = userAccountRepository.save(UserAccount.of("test7@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user8 = userAccountRepository.save(UserAccount.of("test8@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user9 = userAccountRepository.save(UserAccount.of("test9@email", "qo", "1234", true, "gdgd", "ease"));
        UserAccount user10 = userAccountRepository.save(UserAccount.of("test10@email", "qo", "1234", true, "gdgd", "ease"));

        //when
        Optional<UserAccount> userAccount1 = userAccountRepository.findByEmail(user1.getEmail());
        Optional<UserAccount> userAccount2 = userAccountRepository.findByEmail(user2.getEmail());
        Optional<UserAccount> userAccount3 = userAccountRepository.findByEmail(user3.getEmail());
        Optional<UserAccount> userAccount4 = userAccountRepository.findByEmail(user4.getEmail());
        Optional<UserAccount> userAccount5 = userAccountRepository.findByEmail(user5.getEmail());
        Optional<UserAccount> userAccount6 = userAccountRepository.findByEmail(user6.getEmail());
        Optional<UserAccount> userAccount7 = userAccountRepository.findByEmail(user7.getEmail());
        Optional<UserAccount> userAccount8 = userAccountRepository.findByEmail(user8.getEmail());
        Optional<UserAccount> userAccount9 = userAccountRepository.findByEmail(user9.getEmail());
        Optional<UserAccount> userAccount10 = userAccountRepository.findByEmail(user10.getEmail());

        //then
        assertThat(userAccount1).isNotNull();
        assertThat(userAccount2).isNotNull();
        assertThat(userAccount3).isNotNull();
        assertThat(userAccount4).isNotNull();
        assertThat(userAccount5).isNotNull();
        assertThat(userAccount6).isNotNull();
        assertThat(userAccount7).isNotNull();
        assertThat(userAccount8).isNotNull();
        assertThat(userAccount9).isNotNull();
        assertThat(userAccount10).isNotNull();

    }
}
