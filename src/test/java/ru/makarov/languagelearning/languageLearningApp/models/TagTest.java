package ru.makarov.languagelearning.languageLearningApp.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagTest {

    @Test
    void testSetNameAndGetters() {
        Tag tag = new Tag();
        tag.setName("Home");
        assertEquals("Home", tag.getName());
        assertEquals(0, tag.getId());
    }

    @Test
    void testConstructor() {
        Tag tag = new Tag(1L, "Home");
        assertEquals(1L, tag.getId());
        assertEquals("Home", tag.getName());
    }

    @Test
    void testAllArgsConstructorWithNullName() {
        assertThrows(NullPointerException.class, () -> new Tag(1L, null));
    }

    @Test
    void testNoArgsConstructor() {
        Tag tag = new Tag();
        assertNull(tag.getName());
        assertEquals(0, tag.getId());
    }
}
