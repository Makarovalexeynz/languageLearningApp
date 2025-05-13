package ru.makarov.languagelearning.languageLearningApp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.makarov.languagelearning.languageLearningApp.config.AuthenticationFacade;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
import ru.makarov.languagelearning.languageLearningApp.mappers.LanguageMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({LanguageMapper.class, LanguageServiceImpl.class, ModelMapper.class, AuthenticationFacade.class})
public class LanguageServiceTest {

    @Autowired
    private LanguageServiceImpl languageService;

    @Autowired
    private LanguageMapper languageMapper;

    @Autowired
    private ModelMapper modelMapper;

    List <LanguageDTO> dbLanguageListDTO;

    @BeforeEach
    void setUp(){
        List<Language> languageList = new ArrayList<>();
        languageList.add(new Language(1L, "English", new User()));
        languageList.add(new Language(2L, "Deutsch", new User()));
        languageList.add(new Language(3L, "Татар теле", new User()));

        dbLanguageListDTO =
                languageList.stream().map(languageMapper::toDTO).collect(Collectors.toList());
    }

    @DisplayName("должен извлекать список всех языков")
    @Test
    public void findAllTest(){

        var expectedLanguages = dbLanguageListDTO;
        var actualLanguages = languageService.findAll();
        assertThat(actualLanguages).isNotEmpty()
                .hasSize(3)
                .hasOnlyElementsOfType(LanguageDTO.class)
                .usingRecursiveComparison();
        assertThat(actualLanguages).containsExactlyInAnyOrderElementsOf(expectedLanguages);
    }
}
