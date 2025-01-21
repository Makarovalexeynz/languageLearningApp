package ru.makarov.languagelearning.languageLearningApp.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.services.FlashcardService;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class FlashcardController {

    private final FlashcardService flashcardService;

    @GetMapping(path = "/api/v1/flashcards", produces = MediaType.APPLICATION_JSON_VALUE)
    public List <FlashcardDTO> getListFlashcard(){
        return  flashcardService.findAll();
    }

    @GetMapping(path = "api/v1/flashcards/{id}")
    public FlashcardDTO getFlashcard(@PathVariable long id) {
        return flashcardService.findById(id);
    }

    @PostMapping(path = "api/v1/flashcards")
    public FlashcardDTO createFlashcard (@RequestBody FlashcardCreateDTO flashcardCreateDTO){
        return flashcardService.create(flashcardCreateDTO);
    }

    @DeleteMapping(path = "api/v1/flashcards/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFlashcard(@PathVariable long id) {
        flashcardService.deleteById(id);
    }

    @PutMapping(path = "api/v1/flashcards/{id}")
    public FlashcardDTO updateFlashcard(@PathVariable Long id, @RequestBody FlashcardUpdateDTO flashcardUpdateDTO){
        return flashcardService.update(id, flashcardUpdateDTO);
    }
}
