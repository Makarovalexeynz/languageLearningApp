package ru.makarov.languagelearning.languageLearningApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import java.util.List;
import java.util.Optional;

public interface TranslateRepository extends JpaRepository<Translation, Long> {

    List<Translation> findByFlashcardId(Long flashcardId);

    Optional<Translation> findByNativeWord(String nativeWord);
}
