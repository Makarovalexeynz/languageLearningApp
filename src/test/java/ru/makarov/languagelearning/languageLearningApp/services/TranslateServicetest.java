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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Import({ModelMapper.class, TranslationServiceImpl.class, TranslationMapper.class})
public class TranslateServicetest {

    @Autowired
    private TranslationMapper translationMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TranslationServiceImpl translationService;

    @Test
    void TestCreateTranslation(){
        var expectedtranslationDTO = new TranslationDTO(7L, 1L, "Дом");

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
}
