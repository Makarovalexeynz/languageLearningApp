package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.models.User;
import ru.makarov.languagelearning.languageLearningApp.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User register(User user){
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        user.setRole("ROLE_USER");
        return  userRepository.save(user);
    }

    @Transactional
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
