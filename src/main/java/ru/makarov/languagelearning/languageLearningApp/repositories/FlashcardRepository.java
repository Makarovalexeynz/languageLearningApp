package ru.makarov.languagelearning.languageLearningApp.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

    @EntityGraph("Flashcard.tags")
    List<Flashcard> findAll();

   @EntityGraph("Flashcard.tags")
   Optional<Flashcard> findById(Long id);
}
