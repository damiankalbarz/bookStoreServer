package com.example.bookstore.service;

import com.example.bookstore.models.User;
import com.example.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            // Dodaj inne pola do zaktualizowania
            userRepository.save(existingUser);
        });
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
