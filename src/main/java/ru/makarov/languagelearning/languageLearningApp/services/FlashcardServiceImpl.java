package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.mappers.FlashcardMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import org.springframework.stereotype.Service;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import ru.makarov.languagelearning.languageLearningApp.repositories.FlashcardRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.LanguageRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.TagRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.TranslateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FlashcardServiceImpl implements FlashcardService {

    private  final FlashcardRepository flashcardRepository;

    private final FlashcardMapper flashcardMapper;

    private final LanguageRepository languageRepository;

    private final TagRepository tagRepository;

    private final TranslateRepository translateRepository;

    private static final Logger log = LoggerFactory.getLogger(FlashcardServiceImpl.class);


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

        Flashcard flashcard = new Flashcard();
        var language = languageRepository.findById(flashcardCreateDTO.getForeignLanguageId())
                .orElseThrow(() -> new NotFoundException("languages not found"));

       flashcard.setForeignWord(flashcardCreateDTO.getForeignWord());
        flashcard.setForeignLanguage(language);
        flashcardRepository.save(flashcard);

        List<Tag> tags = flashcardCreateDTO.getTags() == null ? new ArrayList<>() :
                flashcardCreateDTO.getTags().stream()
                        .map(tagNames -> tagRepository.findByName(tagNames).orElseGet(() -> tagRepository.save(new Tag(0,tagNames))))
                        .collect(Collectors.toList());

        List<Translation> translations = flashcardCreateDTO.getNativeWords().stream()
                .map(nativeWord -> translateRepository.save(new Translation(0, flashcard ,nativeWord) ) )
                .collect(Collectors.toList());

        flashcard.setTags(tags);
        flashcard.setTranslations(translations);

        var flashcardDTO = flashcardMapper.toDTO(flashcard);
        return flashcardDTO;
    }

    @Transactional
    public FlashcardDTO update(FlashcardUpdateDTO flashcardUpdateDTO) {
        Flashcard flashcard = flashcardRepository.findById(flashcardUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Такая карточка не найдена"));


            Language language = languageRepository.findById(flashcardUpdateDTO.getForeignLanguageId())
                    .orElseThrow(() -> new NotFoundException("Такой язык не найден"));

            flashcard.setForeignLanguage(language);

            flashcard.setForeignWord(flashcardUpdateDTO.getForeignWord());

            flashcardRepository.save(flashcard);

        List<Tag> tags = flashcardUpdateDTO.getTags() == null ? new ArrayList<>() :
                flashcardUpdateDTO.getTags().stream()
                        .map(tagNames -> tagRepository.findByName(tagNames).orElseGet(() -> tagRepository.save(new Tag(0,tagNames))))
                        .collect(Collectors.toList());

                    flashcard.setTags(tags);

        List<String> newNativeWords = flashcardUpdateDTO.getNativeWords();

        List<Translation> existingTranslations = flashcard.getTranslations();
        Map<String, Translation> existingTranslationsMap = existingTranslations.stream()
                .collect(Collectors.toMap(Translation::getNativeWord, t -> t));

        List<Translation> updatedTranslations = new ArrayList<>();
        for (String nativeWord : newNativeWords) {
            Translation translation = existingTranslationsMap.get(nativeWord);
            if (translation != null) {
                updatedTranslations.add(translation);
            } else {
                updatedTranslations.add(new Translation(0, flashcard, nativeWord));
            }
        }
        List<Translation> translationsToRemove = existingTranslations.stream()
                .filter(t -> !newNativeWords.contains(t.getNativeWord()))
                .collect(Collectors.toList());

        translateRepository.deleteAll(translationsToRemove);

        flashcard.setTranslations(updatedTranslations);

        return flashcardMapper.toDTO(flashcard);
    }

    @Transactional
    public void deleteById(long id) {
        flashcardRepository.deleteById(id);
    }
}
