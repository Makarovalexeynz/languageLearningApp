package ru.makarov.languagelearning.languageLearningApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageUpdateDTO {

    @NotNull
    private Long id;

    @NotBlank(message = "Language must not be empty")
    @Size(min = 1, max = 30, message = "The Language must be more than 1 letters and less than 30")
    private String name;
}
