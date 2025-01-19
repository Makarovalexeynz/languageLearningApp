package ru.makarov.languagelearning.languageLearningApp.services;

import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;

import java.util.List;
import java.util.Optional;

public interface FlashcardService {

    List<Flashcard> findAll();

    Optional<Flashcard> findById(Long id);

    Flashcard create(Flashcard flashcard);

    void deleteById(long id);

    Flashcard update(Flashcard flashcard);



}
