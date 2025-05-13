package ru.makarov.languagelearning.languageLearningApp.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.makarov.languagelearning.languageLearningApp.config.AuthenticationFacade;
import ru.makarov.languagelearning.languageLearningApp.mappers.TagMapper;

@DataJpaTest
@Import({TagServiceImpl.class, TagMapper.class, ModelMapper.class, AuthenticationFacade.class})
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

    }

    @DisplayName("Должен обновлять Тег")
    @Test
    public void testUpdate(){

    }
}
