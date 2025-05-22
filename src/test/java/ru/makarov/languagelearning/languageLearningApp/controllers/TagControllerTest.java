//package ru.makarov.languagelearning.languageLearningApp.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.makarov.languagelearning.languageLearningApp.dto.TagCreateDTO;
//import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
//import ru.makarov.languagelearning.languageLearningApp.dto.TagUpdateDTO;
//import ru.makarov.languagelearning.languageLearningApp.rest.TagController;
//import ru.makarov.languagelearning.languageLearningApp.services.TagService;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import java.util.Arrays;
//import java.util.List;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//
//
//
//@WebMvcTest(TagController.class)
//public class TagControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private TagService tagService;
//
//    @Test
//    @WithMockUser
//    void getListTag_returnsListOfTags_whenTagsExist() throws Exception {
//        TagDTO tag1 = new TagDTO(1L, "Tag1");
//        TagDTO tag2 = new TagDTO(2L, "Tag2");
//        List<TagDTO> tags = Arrays.asList(tag1, tag2);
//
//        when(tagService.findAll()).thenReturn(tags);
//
//        mockMvc.perform(get("/api/v1/tags")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.size()", is(2)))
//                .andExpect(jsonPath("$[0].name", is("Tag1")))
//                .andExpect(jsonPath("$[1].name", is("Tag2")));
//    }
//
//    @Test
//    @WithMockUser
//    void getTagById_returnsTag_whenExists() throws Exception {
//
//        TagDTO tag = new TagDTO(1L, "TestTag");
//
//        when(tagService.findById(1L)).thenReturn(tag);
//
//        mockMvc.perform(get("/api/v1/tags/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("TestTag")));
//    }
//    @Test
//    @WithMockUser
//    void createTag_returnsCreatedTag_whenValidData() throws Exception {
//
//        TagCreateDTO tagCreateDTO = new TagCreateDTO("TestTag");
//        TagDTO createdTagDTO = new TagDTO(1L, "TestTag");
//
//        when(tagService.create(tagCreateDTO)).thenReturn(createdTagDTO);
//
//        mockMvc.perform(post("/api/v1/tags")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(tagCreateDTO)).with(csrf()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("TestTag")));
//    }
//
//    @Test
//    @WithMockUser
//    void deleteTagById_returns204_whenTagExists() throws Exception {
//        doNothing().when(tagService).deleteById(1L);
//        mockMvc.perform(delete("/api/v1/tags/1").with(csrf()))
//                .andExpect(status().isNoContent());
//    }
//
//    @Test
//    @WithMockUser
//    void updateTag_returnsUpdatedTag_whenValidData() throws Exception {
//        long tagId = 1L;
//        TagUpdateDTO tagUpdateDTO = new TagUpdateDTO(tagId, "UpdatedTagName");
//        TagDTO updatedTagDTO = new TagDTO(tagId, "UpdatedTagName");
//
//        when(tagService.update(tagUpdateDTO)).thenReturn(updatedTagDTO);
//
//        mockMvc.perform(put("/api/v1/tags/{id}", tagId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(tagUpdateDTO)).with(csrf()))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id", is(1)))
//                .andExpect(jsonPath("$.name", is("UpdatedTagName")));
//    }
//}
