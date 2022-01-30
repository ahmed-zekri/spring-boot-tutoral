package com.example.demo.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class UserTable {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @GeneratedValue(generator = "user_seq", strategy = javax.persistence.GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDate createdAt;

    public UserTable(String name, String email, String role, LocalDate createdAt) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public UserTable() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Transient
    private int age;

    public int getAge() {
        if (createdAt != null)
            return Period.between(createdAt, LocalDate.now()).getYears();
        else return 0;
    }
}
