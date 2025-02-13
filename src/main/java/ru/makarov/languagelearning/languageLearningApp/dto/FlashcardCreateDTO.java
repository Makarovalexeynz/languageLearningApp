package ru.makarov.languagelearning.languageLearningApp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashcardCreateDTO {

    @NotNull
    private String foreignWord;

    @NotNull
    private Long foreignLanguageId;

    private List<String> tags;

    @NotNull
    private List<String> nativeWords;
}
