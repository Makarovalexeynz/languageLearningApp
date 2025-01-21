package ru.makarov.languagelearning.languageLearningApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FlashcardUpdateDTO {


    @NotNull
    private String foreignWord;

    @NotNull
    private String nativeWord;
}
