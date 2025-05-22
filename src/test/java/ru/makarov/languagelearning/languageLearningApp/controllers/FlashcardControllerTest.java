//package ru.makarov.languagelearning.languageLearningApp.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardCreateDTO;
//import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
//import ru.makarov.languagelearning.languageLearningApp.rest.FlashcardController;
//import ru.makarov.languagelearning.languageLearningApp.services.FlashcardService;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(FlashcardController.class)
//public class FlashcardControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private FlashcardService flashcardService;
//
//    @Test
//    @WithMockUser
//    void getListFlashcard_returnsListOfFlashcards_whenFlashcardsExist() throws Exception {
//
//        FlashcardDTO flashcard1 = new FlashcardDTO(
//                1L,
//                new String("Home"),
//                1L,
//                Arrays.asList("Тег_1", "Тег_4"),
//                Arrays.asList("Дом", "Домик"));
//        FlashcardDTO flashcard2 = new FlashcardDTO(
//                2L,
//                new String("Computer"),
//                1L,
//                Arrays.asList("Тег_1", "Тег_4"),
//                Arrays.asList("Комп", "Комбахтер"));
//        List<FlashcardDTO> flashcards = Arrays.asList(flashcard1, flashcard2);
//
//        when(flashcardService.findAll()).thenReturn(flashcards);
//
//        mockMvc.perform(get("/api/v1/flashcards")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.size()", is(2)))
//                .andExpect(jsonPath("$[0].foreignWord", is("Home")))
//                .andExpect(jsonPath("$[1].foreignWord", is("Computer")))
//                .andExpect(jsonPath("$[0].foreignLanguageId", is(1)))
//                .andExpect(jsonPath("$[1].foreignLanguageId", is(1)))
//                .andExpect(jsonPath("$[0].tags", Matchers.containsInAnyOrder("Тег_1", "Тег_4")))
//                .andExpect(jsonPath("$[1].tags", Matchers.containsInAnyOrder("Тег_1", "Тег_4")))
//                .andExpect(jsonPath("$[0].nativeWords", Matchers.containsInAnyOrder("Дом", "Домик")))
//                .andExpect(jsonPath("$[1].nativeWords", Matchers.containsInAnyOrder("Комп", "Комбахтер")));
//    }
//
//    @Test
//    @WithMockUser
//    void getFlashcard_returnsFlashcards_whenFlashcardsExist() throws Exception {
//
//        FlashcardDTO flashcard1 = new FlashcardDTO(
//                1L,
//                new String("Home"),
//                1L,
//                Arrays.asList("Тег_1", "Тег_4"),
//                Arrays.asList("Дом", "Домик"));
//
//        when(flashcardService.findById(1L)).thenReturn(flashcard1);
//
//        mockMvc.perform(get("/api/v1/flashcards/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.foreignWord", is("Home")))
//                .andExpect(jsonPath("$.foreignLanguageId", is(1)))
//                .andExpect(jsonPath("$.tags", Matchers.containsInAnyOrder("Тег_1", "Тег_4")))
//                .andExpect(jsonPath("$.nativeWords", Matchers.containsInAnyOrder("Дом", "Домик")));
//    }
//
//    @Test
//    @WithMockUser
//    void createFlashcard_returnsCreatedFlashcard_whenValidData() throws Exception {
//
//        FlashcardCreateDTO flashcardCreateDTO = new FlashcardCreateDTO(new String("Home"),
//                1L,
//                Arrays.asList("Тег_1", "Тег_4"),
//                Arrays.asList("Дом", "Домик"));
//        FlashcardDTO createdFlashcardDTO = new FlashcardDTO(
//                1L,
//                new String("Home"),
//                1L,
//                Arrays.asList("Тег_1", "Тег_4"),
//                Arrays.asList("Дом", "Домик"));
//
//        when(flashcardService.create(flashcardCreateDTO)).thenReturn(createdFlashcardDTO);
//
//        mockMvc.perform(post("/api/v1/flashcards")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(flashcardCreateDTO)).with(csrf()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.foreignWord", is("Home")))
//                .andExpect(jsonPath("$.foreignLanguageId", is(1)))
//                .andExpect(jsonPath("$.tags", Matchers.containsInAnyOrder("Тег_1", "Тег_4")))
//                .andExpect(jsonPath("$.nativeWords", Matchers.containsInAnyOrder("Дом", "Домик")));
//    }
//}
