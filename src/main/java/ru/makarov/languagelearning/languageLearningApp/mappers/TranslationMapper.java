package ru.makarov.languagelearning.languageLearningApp.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;

@Component
@RequiredArgsConstructor
public class TranslationMapper {

    private final ModelMapper modelMapper;

    public TranslationDTO toDTO(Translation translation){

        TranslationDTO dto = modelMapper.map(translation, TranslationDTO.class);
        dto.setFlashcardId(translation.getFlashcard().getId());
        return dto;
    }

    public Translation toModel (TranslationDTO translationDTO){
        return modelMapper.map(translationDTO, Translation.class);
    }
}
