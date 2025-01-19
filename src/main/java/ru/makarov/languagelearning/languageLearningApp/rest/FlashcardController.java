package ru.makarov.languagelearning.languageLearningApp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.services.FlashcardService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class FlashcardController {

    private final FlashcardService flashcardService;

    @GetMapping(path = "/api/v1/flashcards", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Flashcard> getListFlashcard(){
        return  flashcardService.findAll();
    }

    @GetMapping(path = "api/v1/flashcards/{id}")
    public Optional<Flashcard> getFlashcard(@PathVariable long id) {
        return flashcardService.findById(id);
    }

    @PostMapping(path = "api/v1/flashcadrs")
    public Flashcard createFlashcard (@RequestBody Flashcard flashcard){
        return flashcardService.create(flashcard);
    }

}
