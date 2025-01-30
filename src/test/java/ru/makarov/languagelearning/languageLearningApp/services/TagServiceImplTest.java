package ru.makarov.languagelearning.languageLearningApp.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.makarov.languagelearning.languageLearningApp.dto.TagCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.mappers.TagMapper;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({TagServiceImpl.class, TagMapper.class, ModelMapper.class})
public class TagServiceImplTest {

    @Autowired
    private TagServiceImpl tagService;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ModelMapper modelMapper;

    @DisplayName("Должен создавать ноыый Тег")
    @Test
    public void testSave(){
        var expectedTag = new TagDTO(4L, "Tag_4");
        var actualCreatedTag = tagService.create(new TagCreateDTO("Tag_4"));

        System.out.println(actualCreatedTag);

        assertThat(actualCreatedTag).isEqualTo(expectedTag);
    }

    @DisplayName("Должен обновлять Тег")
    @Test
    public void testUpdate(){
        var expectedTag = new TagDTO(3L, "TagUpdate_3");
        var actualUpdateTag = tagService.update(new TagUpdateDTO(3L, "TagUpdate_3"));

        System.out.println(actualUpdateTag);

        assertThat(actualUpdateTag).isEqualTo(expectedTag);
    }
}
