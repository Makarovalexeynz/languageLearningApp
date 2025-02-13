package ru.makarov.languagelearning.languageLearningApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.rest.TranslationController;
import ru.makarov.languagelearning.languageLearningApp.services.TranslationService;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TranslationController.class)
public class TranstationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TranslationService translationService;

    @Test
    @WithMockUser
    void getListTranslation_returnsListOfTranslations_whenTranslationsExist() throws Exception {
        TranslationDTO translation1 = new TranslationDTO(1L,1L , "Привет");
        TranslationDTO translation2 = new TranslationDTO(2L, 2L, "Мир");
        List<TranslationDTO> translations = Arrays.asList(translation1, translation2);

        when(translationService.findAll()).thenReturn(translations);

        mockMvc.perform(get("/api/v1/translations")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nativeWord", is("Привет")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nativeWord", is("Мир")));
    }

    @Test
    @WithMockUser
    void getTranslationById_returnsTranslation_whenExists() throws Exception {
        TranslationDTO translation = new TranslationDTO(1L, 1L, "Привет");

        when(translationService.findById(1L)).thenReturn(translation);

        mockMvc.perform(get("/api/v1/translations/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nativeWord", is("Привет")));
    }

    @Test
    @WithMockUser
    void getTranslationByFlashcardId_returnsListOfTranslations_whenTranslationsExist() throws Exception {
        TranslationDTO translation1 = new TranslationDTO(1L, 1L, "Привет");
        TranslationDTO translation2 = new TranslationDTO(2L, 2L, "Мир");
        List<TranslationDTO> translations = Arrays.asList(translation1, translation2);
        long flashcardId = 1L;

        when(translationService.findByFlashcardId(flashcardId)).thenReturn(translations);

        mockMvc.perform(get("/api/v1/translations/flashcard/{flashcardId}", flashcardId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].nativeWord", is("Привет")))
                .andExpect(jsonPath("$[1].nativeWord", is("Мир")));
    }

    @Test
    @WithMockUser
    void createTranslation_returnsCreatedTranslation_whenValidData() throws Exception {

        TranslationCreateDTO translationCreateDTO = new TranslationCreateDTO(1L, "Привет");
        TranslationDTO translationDTO = new TranslationDTO(1L, 1L, "Привет");

        when(translationService.create(translationCreateDTO)).thenReturn(translationDTO);

        mockMvc.perform(post("/api/v1/translations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(translationCreateDTO)).with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nativeWord", is("Привет")));
    }

    @Test
    @WithMockUser
    void deleteTranslation_returns204_whenTranslationExists() throws Exception {
        long existingTranslationId = 2L;

        doNothing().when(translationService).deleteById(existingTranslationId);
        mockMvc.perform(delete("/api/v1/translations/{id}", existingTranslationId).with(csrf()))
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser
    void updateTranslation_returnsUpdatedTranslation_whenValidData() throws Exception {
        long translationId = 1L;
        TranslationUpdateDTO translationUpdateDTO = new TranslationUpdateDTO(translationId, 1L, "Обновленное родное слово");
        TranslationDTO updatedTranslationDTO = new TranslationDTO(translationId, 1L, "Обновленное родное слово");
        when(translationService.update(translationUpdateDTO)).thenReturn(updatedTranslationDTO);
        mockMvc.perform(put("/api/v1/translations/{id}", translationId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(translationUpdateDTO)).with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nativeWord", is("Обновленное родное слово")));
    }
}
