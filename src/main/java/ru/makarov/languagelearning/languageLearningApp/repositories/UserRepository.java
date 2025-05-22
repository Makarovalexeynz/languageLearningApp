package ru.makarov.languagelearning.languageLearningApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.makarov.languagelearning.languageLearningApp.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username); //для проверки уникальности
    boolean existsByEmail(String email); //для проверки уникальности
}
