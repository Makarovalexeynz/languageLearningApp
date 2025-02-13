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
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import ru.makarov.languagelearning.languageLearningApp.repositories.FlashcardRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.TagRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @Autowired
    private FlashcardRepository flashcardRepository;


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

        System.out.println(actual);
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

            var actual = flashcardService.update(testFlashcardUpdateDTO);

        assertThat(actual).isEqualTo(expectedFlashcardDTO);
    }

    @Test
    void deleteById_deletesFlashcard() {
        Language language = new Language(1L, "English");
        Flashcard flashcard = new Flashcard();
        Translation translation1 = new Translation();
        Translation translation2 = new Translation();
        List<Translation> translations = new ArrayList<>();
        translations.add(translation1);
        translations.add(translation2);
        Tag tag1 = new Tag(1L, "Tag1");
        Tag tag2 = new Tag(2L, "Tag2");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag1);
        tags.add(tag2);
        flashcard.setId(10L);
        flashcard.setForeignWord("House");
        flashcard.setForeignLanguage(language);
        flashcard.setTranslations(translations);
       flashcard.setTags(tags);
        long idToDelete = flashcard.getId();

        flashcardService.deleteById(10L);

        Optional<Flashcard> deletedFlashcard = flashcardRepository.findById(idToDelete);
        assertFalse(deletedFlashcard.isPresent());

        System.out.println(translations);
        System.out.println(tags);
        System.out.println(language);
    }
}
