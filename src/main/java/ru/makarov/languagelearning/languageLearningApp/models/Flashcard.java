package ru.makarov.languagelearning.languageLearningApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "flashcards")
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "foreign_word", nullable = false)
    private String foreignWord;

    @Column(name = "native_word", nullable = false)
    private String nativeWord;
}
