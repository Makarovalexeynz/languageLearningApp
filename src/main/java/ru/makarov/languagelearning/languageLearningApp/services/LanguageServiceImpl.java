package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.config.AuthenticationFacade;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.LanguageUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.mappers.LanguageMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Language;
import ru.makarov.languagelearning.languageLearningApp.models.User;
import ru.makarov.languagelearning.languageLearningApp.repositories.LanguageRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    private final LanguageMapper languageMapper;

    private final UserRepository userRepository;

    private final AuthenticationFacade authenticationFacade;

    @Override
    @Transactional(readOnly = true)
    public List<LanguageDTO> findAll() {
        return languageRepository.findAll().stream().map(languageMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LanguageDTO findById(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Language not found"));
        return languageMapper.toDTO(language);
    }

    @Override
    @Transactional(readOnly = true)
    public LanguageDTO findByName(String name) {
        Language language = languageRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Language not found"));
        return languageMapper.toDTO(language);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        languageRepository.deleteById(id);
    }

    @Override
    @Transactional
    public LanguageDTO create(LanguageCreateDTO languageCreateDTO) {

        User currentUser = authenticationFacade.getCurrentUser();
        Language language = new Language();
        language.setName(languageCreateDTO.getName());
        language.setUser(currentUser);
        languageRepository.save(language);
        LanguageDTO languageDTO = languageMapper.toDTO(language);
        return languageDTO;
    }

    @Override
    @Transactional
    public LanguageDTO update(LanguageUpdateDTO languageUpdateDTO) {

        User currentUser = authenticationFacade.getCurrentUser();
        Language updateLanguage = new Language(languageUpdateDTO.getId(), languageUpdateDTO.getName(), currentUser);
        languageRepository.save(updateLanguage);
        LanguageDTO languageDTO = languageMapper.toDTO(updateLanguage);
        return languageDTO;
    }
}
