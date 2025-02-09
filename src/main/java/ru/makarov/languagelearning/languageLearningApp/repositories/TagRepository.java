package ru.makarov.languagelearning.languageLearningApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.makarov.languagelearning.languageLearningApp.models.Tag;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);

    List<Tag> findAllByNameIn(Collection<String> names);
}
