package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
    @Query("SELECT u FROM UserTable u WHERE u.name LIKE %?1%")
    public Optional<List<UserTable>> userHasString(String pattern);

    @Query("SELECT u FROM UserTable u WHERE u.name = ?1")
    public Optional<UserTable> getUserByUserName(String userName);
}
