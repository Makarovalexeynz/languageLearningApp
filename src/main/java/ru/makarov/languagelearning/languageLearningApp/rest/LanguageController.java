package ru.makarov.languagelearning.languageLearningApp.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.services.LanguageService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping(path = "/api/v1/languages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LanguageDTO> getListLanguage(){
        return  languageService.findAll();
    }

    @GetMapping(path = "api/v1/languages/{id}")
    public LanguageDTO getLanguageById(@PathVariable long id) {
        return languageService.findById(id);
    }

    @GetMapping(path = "api/v1/languages/name/{name}")
    public LanguageDTO getLanguageByName (@PathVariable String name) {
        return  languageService.findByName(name);
    }

    @DeleteMapping(path = "api/v1/languages/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLanguageById(@PathVariable long id) {
        languageService.deleteById(id);
    }

    @PostMapping(path = "api/v1/languages")
    public LanguageDTO createLanguage(@Valid @RequestBody LanguageCreateDTO languageCreateDTO) {
        return languageService.create(languageCreateDTO);
    }

    @PutMapping(path = "api/v1/languages/{id}")
    public LanguageDTO updateLanguage(@PathVariable long id, @Valid @RequestBody LanguageUpdateDTO languageUpdateDTO) {
        return languageService.update(languageUpdateDTO);
    }
}
