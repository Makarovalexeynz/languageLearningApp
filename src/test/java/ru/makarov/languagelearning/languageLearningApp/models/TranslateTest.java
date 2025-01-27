package ru.makarov.languagelearning.languageLearningApp.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TranslateTest {

    @Test
    void testAllArgsConstructor() {
        Flashcard flashcard = new Flashcard();
        Translation translation = new Translation(1L, flashcard, "hello");
        assertEquals(1L, translation.getId());
        assertEquals(flashcard, translation.getFlashcard());
        assertEquals("hello", translation.getNativeWord());
    }

    @Test
    void testNoArgsConstructor() {
        Translation translation = new Translation();
        assertEquals(0L, translation.getId());
        assertNull(translation.getFlashcard());
        assertNull(translation.getNativeWord());
    }







}
