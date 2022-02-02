package com.example.demo.User;

import com.example.demo.model.UserTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;




    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<UserTable> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserTable> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserTable user) {
        if (userRepository.userHasString(user.getName()).isPresent())
            if (userRepository.userHasString(user.getName()).get().isEmpty())
                userRepository.save(user);

            else throw new IllegalArgumentException("User with this name pattern already exists");

    }

    public Optional<UserTable> findByUsername(String name) {
        return userRepository.getUserByUserName(name);
    }

    @Transactional
    public void updateUser(Long id, String name) {
        UserTable userTable = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User with this id doesn't exist"));


        if (name == null)
            throw new IllegalArgumentException("Name can't be null");
        if (!name.equals(userTable.getName()))
            userTable.setName(name);

        else throw new IllegalArgumentException("User with this name pattern already exists");
    }
}
