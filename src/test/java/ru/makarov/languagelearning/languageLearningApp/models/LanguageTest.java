package ru.makarov.languagelearning.languageLearningApp.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LanguageTest {

    @Test
    void testSetNameAndGetters() {
        Language language = new Language();
        language.setName("English");
        assertEquals("English", language.getName());
        assertEquals(0, language.getId());
    }

    @Test
    void testConstructor() {
        Language language = new Language(1L, "English");
        assertEquals(1L, language.getId());
        assertEquals("English", language.getName());
    }

    @Test
    void testAllArgsConstructorWithNullName() {
        assertThrows(NullPointerException.class, () -> new Language(1L, null));
    }

    @Test
    void testNoArgsConstructor() {
        Language language = new Language();
        assertNull(language.getName());
        assertEquals(0, language.getId());
    }
}
