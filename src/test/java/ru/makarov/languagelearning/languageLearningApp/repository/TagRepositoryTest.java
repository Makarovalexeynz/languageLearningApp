package ru.makarov.languagelearning.languageLearningApp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.repositories.TagRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    void testfindAllByNameIn(){

        List<String> forTest = new ArrayList<>();
        forTest.add("Тег_1");
        forTest.add("Тег_2");

        List<Tag> expected = new ArrayList<>();
        expected.add(new Tag(1,"Тег_1"));
        expected.add(new Tag(2,"Тег_2"));

        List<Tag> actual = tagRepository.findAllByNameIn(forTest);

        System.out.println(actual);

        assertThat(actual).isEqualTo(expected);
    }
}
