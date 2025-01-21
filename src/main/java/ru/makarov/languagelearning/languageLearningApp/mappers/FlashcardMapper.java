package ru.makarov.languagelearning.languageLearningApp.mappers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;

@Component
@RequiredArgsConstructor
public class FlashcardMapper {

    private final ModelMapper modelMapper;

    public Flashcard toModel(FlashcardDTO flashcardDTO) {
        return modelMapper.map(flashcardDTO, Flashcard.class);
    }

    public FlashcardDTO toDTO(Flashcard flashcard) {
        return modelMapper.map(flashcard, FlashcardDTO.class);
    }
}
