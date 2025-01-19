package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import org.springframework.stereotype.Service;
import ru.makarov.languagelearning.languageLearningApp.repositories.FlashcardRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FlashcardServiceImpl implements FlashcardService {

    private  final FlashcardRepository flashcardRepository;

    public List<Flashcard> findAll() {

        return flashcardRepository.findAll();
    }

    public Optional<Flashcard> findById(Long id){
        return flashcardRepository.findById(id);
    }

    public Flashcard create(Flashcard flashcard) {
        return flashcardRepository.save(flashcard);
    }

    public Flashcard update(Flashcard flashcard) {
        return flashcardRepository.save(flashcard);
    }

    public void deleteById(Long id) {
        flashcardRepository.deleteById(id);
    }

}
