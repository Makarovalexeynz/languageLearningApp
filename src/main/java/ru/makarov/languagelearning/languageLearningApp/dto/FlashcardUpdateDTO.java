package ru.makarov.languagelearning.languageLearningApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FlashcardUpdateDTO {

    private Long id;

    private String foreignWord;

    private Long foreignLanguageId;

    private List<String> tagNames;

    private List<String> nativeWords;
}
