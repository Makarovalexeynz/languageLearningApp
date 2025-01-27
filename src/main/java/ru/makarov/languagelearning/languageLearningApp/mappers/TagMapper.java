package ru.makarov.languagelearning.languageLearningApp.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;

@Component
@RequiredArgsConstructor
public class TagMapper {

    private final ModelMapper modelMapper;

    public TagDTO toDTO(Tag tag) {
        return modelMapper.map(tag, TagDTO.class);
    }

    public Tag toModel(TagDTO tagDTO) {
        return modelMapper.map(tagDTO, Tag.class);
    }
}
