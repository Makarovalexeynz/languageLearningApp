package ru.makarov.languagelearning.languageLearningApp.mappers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LanguageMapperTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private LanguageMapper languageMapper;

    @Test
    void testToDTO() {
        Language language = new Language(1L, "English");
        LanguageDTO expectedDto = new LanguageDTO(1L, "English");
        when(modelMapper.map(language, LanguageDTO.class)).thenReturn(expectedDto);
        LanguageDTO actualDto = languageMapper.toDTO(language);
        assertEquals(expectedDto, actualDto);
    }

    @Test
    void testToModel() {
        LanguageDTO languageDTO = new LanguageDTO(1L, "English");
        Language expectedLanguage = new Language(1L, "English");
        when(modelMapper.map(languageDTO, Language.class)).thenReturn(expectedLanguage);
        Language actualLanguage = languageMapper.toModel(languageDTO);
        assertEquals(expectedLanguage, actualLanguage);
    }

    @Test
    void testToDTO_NullLanguage() {
        LanguageDTO actualDto = languageMapper.toDTO(null);
        assertNull(actualDto);
    }

    @Test
    void testToModel_NullLanguageDTO() {
        Language actualLanguage = languageMapper.toModel(null);
        assertNull(actualLanguage);
    }

    @Test
    void testToDTO_EmptyLanguage(){
        Language language = new Language();
        LanguageDTO dto = languageMapper.toDTO(language);
        assertNull(dto);
    }
}
