package ru.makarov.languagelearning.languageLearningApp.services;

import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
import java.util.List;

public interface LanguageService {

    List<LanguageDTO> findAll();

    LanguageDTO findById(Long id);

    LanguageDTO findByName(String name);

    void deleteById(long id);
}
