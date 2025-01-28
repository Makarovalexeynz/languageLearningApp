package ru.makarov.languagelearning.languageLearningApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;

public interface TranslateRepository extends JpaRepository<Translation, Long> {
}
