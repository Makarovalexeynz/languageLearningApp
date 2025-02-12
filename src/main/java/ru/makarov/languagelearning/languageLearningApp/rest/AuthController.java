package ru.makarov.languagelearning.languageLearningApp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.languagelearning.languageLearningApp.models.User;
import ru.makarov.languagelearning.languageLearningApp.services.RegistrationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;

    @PostMapping(path = "auth/registration")
    public User registration(@RequestBody User user) {
        return registrationService.register(user);
    }

    @GetMapping(path = "api/v1/users")
    public List<User> getAllUser(){
        return registrationService.getAllUser();
    }
}
