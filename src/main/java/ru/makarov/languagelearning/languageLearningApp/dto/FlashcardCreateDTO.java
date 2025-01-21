package ru.makarov.languagelearning.languageLearningApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashcardCreateDTO {

    @NotNull
    private String foreignWord;

    @NotNull
    private String nativeWord;
}
