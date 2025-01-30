package ru.makarov.languagelearning.languageLearningApp.services;

import ru.makarov.languagelearning.languageLearningApp.dto.TranslationCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationUpdateDTO;

import java.util.List;

public interface TranslationService {

    List <TranslationDTO> findAll();

    List <TranslationDTO> findByFlashcardId(Long flashcardId);

    TranslationDTO findById(Long id);

    void deleteById(long id);

    TranslationDTO create(TranslationCreateDTO translationCreateDTO);

    TranslationDTO update(TranslationUpdateDTO translationUpdateDTO);
}
