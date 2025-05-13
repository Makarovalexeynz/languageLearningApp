package ru.makarov.languagelearning.languageLearningApp.services;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.makarov.languagelearning.languageLearningApp.config.AuthenticationFacade;
import ru.makarov.languagelearning.languageLearningApp.mappers.FlashcardMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import ru.makarov.languagelearning.languageLearningApp.repositories.FlashcardRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.TagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@Import({FlashcardMapper.class, FlashcardServiceImpl.class, ModelMapper.class, AuthenticationFacade.class})
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
    }

    @Test
    void TestFlashcardUpdateTest(){
    }

    @Test
    void deleteById_deletesFlashcard() {
        Language language = new Language(1L, "English",null);
        Flashcard flashcard = new Flashcard();
        Translation translation1 = new Translation();
        Translation translation2 = new Translation();
        List<Translation> translations = new ArrayList<>();
        translations.add(translation1);
        translations.add(translation2);
        Tag tag1 = new Tag(1L, "Tag1", null);
        Tag tag2 = new Tag(2L, "Tag2", null);
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
