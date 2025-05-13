package ru.makarov.languagelearning.languageLearningApp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.models.User;
import ru.makarov.languagelearning.languageLearningApp.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class AuthenticationFacade implements IAutheticationFacade {
    private final UserRepository userRepository;

    @Override
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
