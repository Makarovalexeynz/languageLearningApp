package ru.makarov.languagelearning.languageLearningApp.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationCreateDTO {

    @NonNull
    @NotNull(message = "ID flashcard must not empty")
    private Long flashcardId;

    @NonNull
    @NotNull(message = "native word must not empty")
    @Size(min =1, max = 255)
    private String nativeWord;
}
