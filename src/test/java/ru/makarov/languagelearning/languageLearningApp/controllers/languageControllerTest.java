package ru.makarov.languagelearning.languageLearningApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.makarov.languagelearning.languageLearningApp.rest.LanguageController;
import ru.makarov.languagelearning.languageLearningApp.services.LanguageService;

@WebMvcTest(LanguageController.class)
public class languageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LanguageService languageService;

    @Test
    void test(){}
}
