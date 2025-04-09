package com.example.puzzleappbackend.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    public Integer addUser(User user) {
        User savedUser = User.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .country(user.getCountry())
                .build();
        return userRepository.save(savedUser).getUserId();
    }

    public User updateUser(Integer userId, User user) {
        User foundUser = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        foundUser.setUsername(user.getUsername());
        foundUser.setEmail(user.getEmail());
        foundUser.setPassword(user.getPassword());
        foundUser.setCountry(user.getCountry());
        return userRepository.save(foundUser);
    }

    public void deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException();
        }
        userRepository.deleteById(userId);
    }
}
