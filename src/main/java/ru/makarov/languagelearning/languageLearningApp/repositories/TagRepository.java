package ru.makarov.languagelearning.languageLearningApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
