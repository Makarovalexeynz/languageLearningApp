package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TranslationUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.mappers.TranslationMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
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
    @Transactional
    public void deleteById(long id) {
        translateRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TranslationDTO create(TranslationCreateDTO translationCreateDTO) {

            Flashcard flashcard = flashcardRepository.findById(translationCreateDTO.getFlashcardId())
                    .orElseThrow(() -> new NotFoundException("Флэш-карта не найдена"));

            Translation translation = new Translation();
            translation.setFlashcard(flashcard);
            translation.setNativeWord(translationCreateDTO.getNativeWord());

            Translation savedTranslation = translateRepository.save(translation);

            return translationMapper.toDTO(savedTranslation);
    }


    @Override
    @Transactional
    public TranslationDTO update(TranslationUpdateDTO translationUpdateDTO) {

        Translation translation = translateRepository.findById(translationUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Такого перевода не нашлось"));

        if (translationUpdateDTO.getFlashcardId() != null) {
            Flashcard flashcard = flashcardRepository.findById(translationUpdateDTO.getFlashcardId())
                    .orElseThrow(() -> new NotFoundException("Не найдена карточка"));
            translation.setFlashcard(flashcard);
        }
         if (translationUpdateDTO.getNativeWord() != null) {
             translation.setNativeWord(translationUpdateDTO.getNativeWord());
         }

         translateRepository.save(translation);

         return  translationMapper.toDTO(translation);

    }
}
