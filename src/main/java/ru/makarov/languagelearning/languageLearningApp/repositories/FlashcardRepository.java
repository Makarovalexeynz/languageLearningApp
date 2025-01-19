package ru.makarov.languagelearning.languageLearningApp.repositories;

import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
}
