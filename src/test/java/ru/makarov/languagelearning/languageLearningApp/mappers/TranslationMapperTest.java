package ru.makarov.languagelearning.languageLearningApp.mappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TranslationMapperTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TranslationMapper translationMapper;

    @Test
    void testToDTO() {

        Translation translation = new Translation();
        translation.setId(1L);
        Flashcard flashcard = new Flashcard();
        flashcard.setId(1L);
        translation.setFlashcard(flashcard);
        translation.setNativeWord("Native Word");

        TranslationDTO expectedDto = new TranslationDTO(1L,1L, "Native Word");

        when(modelMapper.map(translation, TranslationDTO.class)).thenReturn(expectedDto);

        TranslationDTO dto = translationMapper.toDTO(translation);

        assertEquals(1L, dto.getId());
        assertEquals(1L, dto.getFlashcardId());
        assertEquals("Native Word", dto.getNativeWord());
    }

    @Test
    void testToModel(){
        TranslationDTO translationDTO = new TranslationDTO(1L, 10L, "Native Word");

        Flashcard flashcard = new Flashcard();
        flashcard.setId(10L);
        Translation expectedTranslate = new Translation(1L,flashcard, "Native Word");

        when(modelMapper.map(translationDTO, Translation.class)).thenReturn(expectedTranslate);

        Translation translation = translationMapper.toModel(translationDTO);
        assertEquals(1L, translation.getId());
        assertEquals("Native Word", translation.getNativeWord());
        assertEquals(10L, translation.getFlashcard().getId());
    }

}
