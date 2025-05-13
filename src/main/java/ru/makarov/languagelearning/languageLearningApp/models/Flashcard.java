package ru.makarov.languagelearning.languageLearningApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "flashcards")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "Flashcard.tags", attributeNodes = @NamedAttributeNode("tags"))
})
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "foreign_word", nullable = false)
    private String foreignWord;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Language.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "language_id", nullable = false)
    private Language foreignLanguage;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "flashcard", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List <Translation> translations = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "flashcards_tags",
            joinColumns = @JoinColumn(name = "flashcard_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
