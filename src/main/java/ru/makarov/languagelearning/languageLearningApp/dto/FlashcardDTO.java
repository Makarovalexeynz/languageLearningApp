package ru.makarov.languagelearning.languageLearningApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashcardDTO {

    private Long id;

    private String foreignWord;

    private String nativeWord;
}
