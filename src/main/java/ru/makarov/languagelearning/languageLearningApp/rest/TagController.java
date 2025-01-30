package ru.makarov.languagelearning.languageLearningApp.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.makarov.languagelearning.languageLearningApp.dto.TagCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.services.TagService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping(path = "api/v1/tags")
    public List<TagDTO> getListTag(){
        return  tagService.findAll();
    }

    @GetMapping(path = "api/v1/tags/{id}")
    public TagDTO getTagById(@PathVariable long id){
        return tagService.findById(id);
    }

    @GetMapping(path = "api/v1/tags/{name}")
    public TagDTO getTagByName(@PathVariable String name){
        return tagService.findByName(name);
    }

    @DeleteMapping(path = "api/v1/tags/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTagById(@PathVariable long id) {
        tagService.deleteById(id);
    }

    @PostMapping(path = "api/v1/tags")
    public TagDTO createTag(@Valid @RequestBody TagCreateDTO tagCreateDTO) {
        return tagService.create(tagCreateDTO);
    }

    @PutMapping(path = "api/v1/tags/{id}")
    public TagDTO updateTag(@PathVariable long id, @Valid @RequestBody TagUpdateDTO tagUpdateDTO) {
        return tagService.update(tagUpdateDTO);
    }
}
