package ru.makarov.languagelearning.languageLearningApp.models;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlashcardTest {

    @Test
    void testAllArgsConstructor() {
        Language language = new Language(1L, "English");
        List<Translation> translations = new ArrayList<>();
        List<Tag> tags = new ArrayList<>();
        Flashcard flashcard = new Flashcard(1L, "Hello", language, translations, tags);
        assertEquals(1L, flashcard.getId());
        assertEquals("Hello", flashcard.getForeignWord());
        assertEquals(language, flashcard.getForeignLanguage());
        assertEquals(translations, flashcard.getTranslations());
        assertEquals(tags, flashcard.getTags());
    }

    @Test
    void testNoArgsConstructor() {
        Flashcard flashcard = new Flashcard();
        assertEquals(0L, flashcard.getId());
        assertNull(flashcard.getForeignLanguage());
        assertTrue(flashcard.getTranslations().isEmpty());
        assertTrue(flashcard.getTags().isEmpty());
    }
}
