package ru.makarov.languagelearning.languageLearningApp.services;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.mappers.FlashcardMapper;
import ru.makarov.languagelearning.languageLearningApp.repositories.TagRepository;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({FlashcardMapper.class, FlashcardServiceImpl.class, ModelMapper.class})
public class FlashcardSerciseImplTest {

    @Autowired
    private FlashcardServiceImpl flashcardService;

    @Autowired
    private FlashcardMapper flashcardMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TagRepository tagRepository;


    @Test
    void TestFlashcardCreateTest(){

        FlashcardDTO expectedFlashcardDTO = new FlashcardDTO(
                10L,
                new String("Home"),
                1L,
                Arrays.asList("Тег_1", "Тег_4"),
                Arrays.asList("Дом", "Домик"));
        var testFlashcardCreateDTO = new FlashcardCreateDTO (new String("Home"),
                1L,
                Arrays.asList("Тег_1", "Тег_4"),
                Arrays.asList("Дом", "Домик"));
        System.out.println(expectedFlashcardDTO);

        var actual = flashcardService.create(testFlashcardCreateDTO);
        assertThat(actual).isEqualTo(expectedFlashcardDTO);

        assertThat(tagRepository.findAll()).hasSize(4);

        System.out.println(tagRepository.findAll());
    }

    @Test
    void TestFlashcardUpdateTest(){
        FlashcardDTO expectedFlashcardDTO = new FlashcardDTO(
                1L,
                new String("Flashcard_1Update"),
                1L,
                Arrays.asList("Тег_1Update"),
                Arrays.asList("Карточка_1Update", "ДругаяКарточка_1Update"));

            System.out.println(expectedFlashcardDTO);

            var testFlashcardUpdateDTO = new FlashcardUpdateDTO(1l,new String("Flashcard_1Update"),
                    1L,
                    Arrays.asList("Тег_1Update"),
                    Arrays.asList("Карточка_1Update", "ДругаяКарточка_1Update"));

        System.out.println(testFlashcardUpdateDTO);

            var actual = flashcardService.update(testFlashcardUpdateDTO.getId(), testFlashcardUpdateDTO);

        assertThat(actual).isEqualTo(expectedFlashcardDTO);
    }

}
