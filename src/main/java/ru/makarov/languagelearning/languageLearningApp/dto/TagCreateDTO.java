package ru.makarov.languagelearning.languageLearningApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagCreateDTO {

    @NonNull
    private String name;
}
