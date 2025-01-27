package ru.makarov.languagelearning.languageLearningApp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.repositories.LanguageRepository;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LanguageRepositoryTest {
    @Autowired
    private LanguageRepository languageRepository;

    @Test
    void testUniqueName() {
        var expectedLanguage = new Language(1, "English");
        var actualLanguage = languageRepository.findById(1L);
        assertThat(actualLanguage)
                .isPresent()
                .get()
                .isEqualTo(expectedLanguage);

    }

}
