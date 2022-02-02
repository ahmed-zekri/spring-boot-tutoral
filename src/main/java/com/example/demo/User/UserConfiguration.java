package com.example.demo.User;

import com.example.demo.model.UserTable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            UserTable a = new UserTable("user1", "ahmed.zekri.a@gmail", "1234", LocalDate.of(1993, Month.MARCH, 10), UserTable.Role.USER);
            UserTable b = new UserTable("user2", "ahmed.zekri.a@gmail", "12345", LocalDate.of(1993, Month.MARCH, 10), UserTable.Role.ADMIN);
            UserTable c = new UserTable("user3", "ahmed.zekri.a@gmail", "12345", LocalDate.of(1993, Month.MARCH, 10), UserTable.Role.USER);
            UserTable d = new UserTable("user4", "ahmed.zekri.a@gmail", "12345", LocalDate.of(1993, Month.MARCH, 10), UserTable.Role.USER);

            userRepository.saveAll(List.of(a, b, c, d));
        };
    }
}
