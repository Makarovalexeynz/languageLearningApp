package ru.makarov.languagelearning.languageLearningApp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.repositories.LanguageRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class LanguageRepositoryTest {
    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testUniqueName() {
        var testUser = userRepository.getReferenceById(1L);
        var expectedLanguage = new Language(1, "English", testUser);
        var actualLanguage = languageRepository.findById(1L);
        assertThat(actualLanguage)
                .isPresent()
                .get()
                .isEqualTo(expectedLanguage);
    }

    @Test
    void testFindByName() {
        var testUser = userRepository.getReferenceById(1L);
        var expectedLanguage = new Language(1, "English", testUser);
        var actualLanguage = languageRepository.findByName("English");
        assertThat(actualLanguage)
                .isPresent()
                .get()
                .isEqualTo(expectedLanguage);
    }

    @Test
    void testNotFindByName() {
        var expectedLanguage = new Language(1, "English", null);
        var actualLanguage = languageRepository.findByName("Русский");
        assertFalse(actualLanguage.isPresent());
    }
}
