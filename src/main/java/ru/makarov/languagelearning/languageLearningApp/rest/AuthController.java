package ru.makarov.languagelearning.languageLearningApp.rest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.languagelearning.languageLearningApp.dto.JwtAuthenticationResponse;
import ru.makarov.languagelearning.languageLearningApp.dto.SignInRequest;
import ru.makarov.languagelearning.languageLearningApp.dto.SignUpRequest;
import ru.makarov.languagelearning.languageLearningApp.models.User;
import ru.makarov.languagelearning.languageLearningApp.services.AuthenticationService;
import ru.makarov.languagelearning.languageLearningApp.services.RegistrationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;;

    private  final RegistrationService registrationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/auth/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }
    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/auth/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

    @GetMapping(path = "api/v1/users")
    public List<User> getAllUser(){
        return registrationService.getAllUser();
    }

    @GetMapping("/admin")
    @Operation(summary = "Доступен только авторизованным пользователям с ролью ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    public String exampleAdmin() {
        return "Hello, admin!";
    }
}
