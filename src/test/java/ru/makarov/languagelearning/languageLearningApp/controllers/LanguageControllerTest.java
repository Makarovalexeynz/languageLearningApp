//package ru.makarov.languagelearning.languageLearningApp.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
//import ru.makarov.languagelearning.languageLearningApp.dto.LanguageUpdateDTO;
//import ru.makarov.languagelearning.languageLearningApp.rest.LanguageController;
//import ru.makarov.languagelearning.languageLearningApp.services.LanguageService;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.is;
//import java.util.Arrays;
//import java.util.List;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(LanguageController.class)
//public class LanguageControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private LanguageService languageService;
//
//    @Test
//    @WithMockUser
//    void testListAllLanguages() throws Exception{
//
//        LanguageDTO language1 = new LanguageDTO(1L, "English");
//        LanguageDTO language2 = new LanguageDTO(2L, "Spanish");
//        List<LanguageDTO> languages = Arrays.asList(language1, language2);
//
//        when(languageService.findAll()).thenReturn(languages);
//
//        mockMvc.perform(get("/api/v1/languages")
//                        .accept(MediaType.APPLICATION_JSON));
//                .andExpect(status().isOk());
  //              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
  //              .andExpect(jsonPath("$.size()").value(2))
  //              .andExpect(jsonPath("$[0].id").value(1))
 //               .andExpect(jsonPath("$[0].name").value("English"))
 //               .andExpect(jsonPath("$[1].id").value(2))
 //               .andExpect(jsonPath("$[1].name").value("Spanish"));
    //}
//
//    @Test
//    @WithMockUser
//    void getLanguageById_returnsLanguage_whenExists() throws Exception {
//
//        LanguageDTO language = new LanguageDTO(1L, "English");
//
//        when(languageService.findById(1L)).thenReturn(language);
//
//        ResultActions result = mockMvc.perform(get("/api/v1/languages/1")
//                .accept(MediaType.APPLICATION_JSON));
//
//        result.andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("English")));
//    }
//
//    @Test
//    @WithMockUser
//    void getLanguageByName_returnsLanguage_whenFound() throws Exception {
//        LanguageDTO language = new LanguageDTO(1L, "English");
//        when(languageService.findByName("English")).thenReturn(language);
//
//        mockMvc.perform(get("/api/v1/languages/name/English")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("English")));
//    }
//
//    @Test
//    @WithMockUser
//    void deleteLanguageById_returns204_whenTagExists() throws Exception {
//        doNothing().when(languageService).deleteById(1L);
//        mockMvc.perform(delete("/api/v1/languages/1").with(csrf()))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    @WithMockUser
//    void updateLanguage_returnsUpdatedLanguage_whenValidData() throws Exception {
//
//        long languageId = 1L;
//        LanguageUpdateDTO languageUpdateDTO = new LanguageUpdateDTO(languageId, "UpdatedLanguageName");
//        LanguageDTO updatedLanguageDTO = new LanguageDTO(languageId, "UpdatedLanguageName");
//
//        when(languageService.update(languageUpdateDTO)).thenReturn(updatedLanguageDTO);
//
//        mockMvc.perform(put("/api/v1/languages/{id}", languageId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(languageUpdateDTO)).with(csrf()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("UpdatedLanguageName")));
//    }
//}
