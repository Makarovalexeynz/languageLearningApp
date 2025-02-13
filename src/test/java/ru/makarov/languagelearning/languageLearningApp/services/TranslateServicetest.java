package ru.makarov.languagelearning.languageLearningApp.services;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.mappers.TranslationMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import ru.makarov.languagelearning.languageLearningApp.repositories.TranslateRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@Import({ModelMapper.class, TranslationServiceImpl.class, TranslationMapper.class})
public class TranslateServicetest {

    @Autowired
    private TranslationMapper translationMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TranslationServiceImpl translationService;

    @Autowired
    private TranslateRepository translateRepository;

    @Test
    void TestCreateTranslation(){
        var expectedtranslationDTO = new TranslationDTO(19L, 1L, "Дом");

        var testTranslationCreateDTO = new TranslationCreateDTO(1l, "Дом");
         var actial = translationService.create(testTranslationCreateDTO);

         assertThat(actial).isEqualTo(expectedtranslationDTO);
    }

    @Test
    void testUpdateTranslation(){
        TranslationDTO expectedtranslationDTO = new TranslationDTO(1L, 1L, "Дом");

        var testTranslationUpdateDTO = new TranslationUpdateDTO(1L,1l, "Дом");
        var actial = translationService.update(testTranslationUpdateDTO);

        assertThat(actial).isEqualTo(expectedtranslationDTO);
    }
    @Test
    void testDeletetranslation() {
        Translation translation = new Translation(19L, new Flashcard(), "Word");

        System.out.println(translation);
        Optional<Translation> deletedTranslation = translateRepository.findById(19L);
        assertFalse(deletedTranslation.isPresent());
        System.out.println(deletedTranslation);
    }
}
