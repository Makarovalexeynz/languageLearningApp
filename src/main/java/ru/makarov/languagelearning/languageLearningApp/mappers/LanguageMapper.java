package ru.makarov.languagelearning.languageLearningApp.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Language;

@Component
@RequiredArgsConstructor
public class LanguageMapper {

    private final ModelMapper modelMapper;

    public LanguageDTO toDTO(Language language) {
        return modelMapper.map(language, LanguageDTO.class);
    }

    public Language toModel(LanguageDTO languageDTO) {
        return modelMapper.map(languageDTO, Language.class);
    }
}
