package com.example.demo.User;

import com.example.demo.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
    @Query("SELECT u FROM UserTable u WHERE u.name LIKE %?1%")
    Optional<List<UserTable>> userHasString(String pattern);

    @Query("SELECT u FROM UserTable u WHERE u.name = ?1")
    Optional<UserTable> getUserByUserName(String userName);
}
