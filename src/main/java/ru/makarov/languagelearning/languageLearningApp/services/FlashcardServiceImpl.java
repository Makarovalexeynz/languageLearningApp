package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.mappers.FlashcardMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import org.springframework.stereotype.Service;
import ru.makarov.languagelearning.languageLearningApp.repositories.FlashcardRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FlashcardServiceImpl implements FlashcardService {

    private  final FlashcardRepository flashcardRepository;

    private final FlashcardMapper flashcardMapper;

    @Transactional(readOnly = true)
    public List<FlashcardDTO> findAll() {
        return flashcardRepository.findAll().stream().map(flashcardMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public FlashcardDTO findById(Long id) {
        Flashcard flashcard = flashcardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flashcard not found"));
        return flashcardMapper.toDTO(flashcard);
    }

    @Transactional
    public FlashcardDTO create(FlashcardCreateDTO flashcardCreateDTO) {
        return null;
    }

    @Transactional
    public FlashcardDTO update(Long id, FlashcardUpdateDTO flashcardUpdateDTO) {
        return null;
    }

    @Transactional
    public void deleteById(long id) {
        flashcardRepository.deleteById(id);
    }
}
