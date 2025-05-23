package com.nergamed.backend.service;

import com.nergamed.backend.model.User;
import com.nergamed.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Rejestracja nowego użytkownika - hasło jest szyfrowane
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("User with this username already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER"); // domyślna rola
        }
        return userRepository.save(user);
    }

    // Znajdź użytkownika po username (loginie)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Znajdź użytkownika po ID
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    // Aktualizacja danych użytkownika (np. email, imię)
    public User updateUser(User user) {
        // Możesz dodać dodatkowe walidacje
        return userRepository.save(user);
    }

    // Usuwanie użytkownika
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    // Metoda do sprawdzania poprawności hasła (np. przy logowaniu)
    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
