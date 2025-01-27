package ru.makarov.languagelearning.languageLearningApp.mappers;

import org.springframework.stereotype.Component;
import ru.makarov.languagelearning.languageLearningApp.dto.FlashcardDTO;
import ru.makarov.languagelearning.languageLearningApp.models.Flashcard;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.models.Translation;
import java.util.stream.Collectors;

@Component
public class FlashcardMapper {

  public FlashcardDTO toDTO (Flashcard flashcard){

      var tags = flashcard.getTags().stream().map(Tag::getName).collect(Collectors.toList());

      var nativeWords = flashcard.getTranslations().stream().map(Translation::getNativeWord).collect(Collectors.toList());

        FlashcardDTO flashcardDTO = new FlashcardDTO(
                flashcard.getId(),
                flashcard.getForeignWord(),
                flashcard.getForeignLanguage().getId(),
                tags,
                nativeWords
        );
        return flashcardDTO;
    }

    public Flashcard toModel(FlashcardDTO flashcardDTO) {
        return null;
    }
}