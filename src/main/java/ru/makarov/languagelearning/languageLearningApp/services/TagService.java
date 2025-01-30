package ru.makarov.languagelearning.languageLearningApp.services;

import ru.makarov.languagelearning.languageLearningApp.dto.TagCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagUpdateDTO;

import java.util.List;

public interface TagService {

    List<TagDTO> findAll();

    TagDTO findById(Long id);

    TagDTO findByName(String name);

    void deleteById(long id);

    TagDTO create(TagCreateDTO tagCreateDTO);

    TagDTO update(TagUpdateDTO tagUpdateDTO);
}
