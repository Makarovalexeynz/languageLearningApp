package ru.makarov.languagelearning.languageLearningApp.mappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagMapperTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TagMapper tagMapper;

    @Test
    void testToDTO() {
        Tag tag = new Tag(1L, "Tag1", null);
        TagDTO expectedDto = new TagDTO(1L, "Tag1");
        when(modelMapper.map(tag, TagDTO.class)).thenReturn(expectedDto);
        TagDTO actualDto = tagMapper.toDTO(tag);
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testToModel() {
        TagDTO tagDTO = new TagDTO(1L, "English");
        Tag expectedTag = new Tag(1L, "English", null);
        when(modelMapper.map(tagDTO, Tag.class)).thenReturn(expectedTag);
        Tag actualTag = tagMapper.toModel(tagDTO);
        assertEquals(expectedTag, actualTag);
    }

    @Test
    void testToDTO_NullTag() {
        TagDTO actualDto = tagMapper.toDTO(null);
        assertNull(actualDto);
    }

    @Test
    void testToModel_NullTagDTO() {
        Tag actualTag = tagMapper.toModel(null);
        assertNull(actualTag);
    }

    @Test
    void testToDTO_EmptyTag(){
        Tag tag = new Tag();
        TagDTO dto = tagMapper.toDTO(tag);
        assertNull(dto);
    }
}
