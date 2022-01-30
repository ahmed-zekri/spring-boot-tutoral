package com.example.demo.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            UserTable a = new UserTable("user1", "ahmed.zekri.a@gmail", "", LocalDate.of(1993, Month.MARCH,10));
            UserTable b = new UserTable("user2", "ahmed.zekri.a@gmail", "", LocalDate.of(1993, Month.MARCH,10));
            UserTable c = new UserTable("user3", "ahmed.zekri.a@gmail", "", LocalDate.of(1993, Month.MARCH,10));
            UserTable d = new UserTable("user4", "ahmed.zekri.a@gmail", "", LocalDate.of(1993, Month.MARCH,10));
            UserTable e = new UserTable("user5", "ahmed.zekri.a@gmail", "", LocalDate.of(1993, Month.MARCH,10));
            UserTable f = new UserTable("user6", "ahmed.zekri.a@gmail", "", LocalDate.of(1993, Month.MARCH,10));
            userRepository.saveAll(List.of(a, b, c, d, e, f));
        };
    }
}
