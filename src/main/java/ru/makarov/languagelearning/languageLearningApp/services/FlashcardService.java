package ru.makarov.languagelearning.languageLearningApp.services;

import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardUpdateDTO;
import java.util.List;

public interface FlashcardService {

    List<FlashcardDTO> findAll();

    FlashcardDTO findById(Long id);

    FlashcardDTO create(FlashcardCreateDTO flashcardCreateDTO);

    void deleteById(long id);

    FlashcardDTO update(Long id, FlashcardUpdateDTO flashcardUpdateDTO);



}
