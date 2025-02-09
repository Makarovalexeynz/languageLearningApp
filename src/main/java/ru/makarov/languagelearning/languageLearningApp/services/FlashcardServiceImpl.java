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


        List<Tag> tags = flashcardCreateDTO.getTagNames() != null ?
                flashcardCreateDTO.getTagNames().stream()
                        .map(tagName -> tagRepository.findByName(tagName).orElseGet(() -> tagRepository.save(new Tag(0,tagName))))
                        .collect(Collectors.toList()): new ArrayList<>();


        List<Translation> translations = flashcardCreateDTO.getNativeWords().stream()
                .map(nativeWord -> new Translation(0, flashcard ,nativeWord))
                .collect(Collectors.toList());

        flashcard.setForeignWord(flashcardCreateDTO.getForeignWord());
        flashcard.setForeignLanguage(language);
        flashcard.setTags(tags);
        flashcard.setTranslations(translations);
        flashcardRepository.save(flashcard);
        var flashcardDTO = flashcardMapper.toDTO(flashcard);
        return flashcardDTO;
    }

    @Transactional
    public FlashcardDTO update(Long id, FlashcardUpdateDTO flashcardUpdateDTO) {


        Flashcard flashcard = flashcardRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Такая карточка не найдена"));


        if (flashcardUpdateDTO.getForeignLanguageId() !=null) {
            Language language = languageRepository.findById(flashcardUpdateDTO.getId())
                    .orElseThrow(() -> new NotFoundException("Такой язык не найден"));
            flashcard.setForeignLanguage(language);
        }

        if (flashcardUpdateDTO.getForeignWord() !=null) {
            flashcard.setForeignWord(flashcardUpdateDTO.getForeignWord());
        }

        if (flashcardUpdateDTO.getTagNames() !=null) {
            List <Tag> tags = flashcardUpdateDTO.getTagNames().stream()
                    .map(tagName -> tagRepository.findByName(tagName)
                            .orElseGet(() -> tagRepository.save(new Tag(0, tagName))))
                    .collect(Collectors.toList());
            flashcard.setTags(tags);
        }

        if (flashcardUpdateDTO.getNativeWords() !=null) {
            List <Translation> translations = flashcardUpdateDTO.getNativeWords().stream()
                    .map(translationName -> translateRepository.findByNativeWord(translationName)
                            .orElseGet(() -> translateRepository.save(new Translation(0,flashcard, translationName))))
                    .collect(Collectors.toList());
            flashcard.setTranslations(translations);
        }

        flashcardRepository.save(flashcard);
        return flashcardMapper.toDTO(flashcard);
    }

    @Transactional
    public void deleteById(long id) {
        flashcardRepository.deleteById(id);
    }
}
