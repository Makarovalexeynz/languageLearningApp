package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.mappers.TranslationMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import ru.makarov.languagelearning.languageLearningApp.repositories.FlashcardRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.TranslateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService {

    private final TranslateRepository translateRepository;

    private final FlashcardRepository flashcardRepository;

    private final TranslationMapper translationMapper;



    @Override
    @Transactional(readOnly = true)
    public List<TranslationDTO> findAll() {
        return translateRepository.findAll().stream().map(translationMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TranslationDTO> findByFlashcardId(Long flashcardId) {
        List<Translation> translations = translateRepository.findByFlashcardId(flashcardId);
        return translations.stream().map(translationMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TranslationDTO findById(Long id) {
        Translation translation = translateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Translation not found"));
        return translationMapper.toDTO(translation);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public TranslationDTO create(TranslationCreateDTO translationCreateDTO) {
        return null;
    }

    @Override
    public TranslationDTO update(TranslationUpdateDTO translationUpdateDTO) {
        return null;
    }
}
