package ru.makarov.languagelearning.languageLearningApp.mappers;

import org.junit.jupiter.api.Test;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlashcardMapperTest {

    @Test
    void testToDTO() {
        Flashcard flashcard = new Flashcard();
        flashcard.setId(1L);
        flashcard.setForeignWord("Foreign Word");
        Language language = new Language(1L, "English");
        flashcard.setForeignLanguage(language);

        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1L,"Tag1"));
        tags.add(new Tag(2L,"Tag2"));
        flashcard.setTags(tags);

        List<Translation> translations = new ArrayList<>();
        translations.add(new Translation(1L, flashcard, "Translation1"));
        translations.add(new Translation(2L, flashcard, "Translation2"));
        flashcard.setTranslations(translations);

        FlashcardMapper mapper = new FlashcardMapper();

        FlashcardDTO dto = mapper.toDTO(flashcard);

        assertEquals(1L, dto.getId());
        assertEquals("Foreign Word", dto.getForeignWord());
        assertEquals(1L, dto.getForeignLanguageId());
        assertEquals(Arrays.asList("Tag1", "Tag2"), dto.getTags());
        assertEquals(Arrays.asList("Translation1", "Translation2"), dto.getNativeWords());
        System.out.println(dto);
    }
}



