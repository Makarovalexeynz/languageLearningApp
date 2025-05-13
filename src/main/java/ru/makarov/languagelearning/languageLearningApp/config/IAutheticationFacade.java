package ru.makarov.languagelearning.languageLearningApp.config;

import ru.makarov.languagelearning.languageLearningApp.models.User;

public interface IAutheticationFacade {
    User getCurrentUser();
}
