package ru.makarov.languagelearning.languageLearningApp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.services.TranslationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService translationService;

    @GetMapping(path = "api/v1/translations")
    public List<TranslationDTO> getListTranslation(){
        return  translationService.findAll();
    }

    @GetMapping(path = "api/v1/translations/{flashcardId}")
    public List<TranslationDTO> getTranslationByFlashcardId(@PathVariable Long flashcardId){
        return  translationService.findByFlashcardId(flashcardId);
    }
}
