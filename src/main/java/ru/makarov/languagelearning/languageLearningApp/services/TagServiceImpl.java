package ru.makarov.languagelearning.languageLearningApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makarov.languagelearning.languageLearningApp.config.AuthenticationFacade;
import ru.makarov.languagelearning.languageLearningApp.dto.TagCreateDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagDTO;
import ru.makarov.languagelearning.languageLearningApp.dto.TagUpdateDTO;
import ru.makarov.languagelearning.languageLearningApp.exceptions.NotFoundException;
import ru.makarov.languagelearning.languageLearningApp.mappers.TagMapper;
import ru.makarov.languagelearning.languageLearningApp.models.Tag;
import ru.makarov.languagelearning.languageLearningApp.models.User;
import ru.makarov.languagelearning.languageLearningApp.repositories.TagRepository;
import ru.makarov.languagelearning.languageLearningApp.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    private  final TagMapper tagMapper;

    private final UserRepository userRepository;

    private final AuthenticationFacade authenticationFacade;

    @Override
    @Transactional(readOnly = true)
    public List<TagDTO> findAll() {
        return tagRepository.findAll().stream().map(tagMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TagDTO findById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tag not found"));
        return tagMapper.toDTO(tag);
    }

    @Override
    @Transactional(readOnly = true)
    public TagDTO findByName(String name) {
        Tag tag = tagRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Tag not found"));
        return tagMapper.toDTO(tag);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
         tagRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TagDTO create(TagCreateDTO tagCreateDTO) {
        User currentUser = authenticationFacade.getCurrentUser();
        Tag tag = new Tag();
        tag.setName(tagCreateDTO.getName());
        tag.setUser(currentUser);
        tagRepository.save(tag);
        TagDTO tagDTO = tagMapper.toDTO(tag);
        return tagDTO;
    }

    @Override
    @Transactional
    public TagDTO update(TagUpdateDTO tagUpdateDTO) {
        User currentUser = authenticationFacade.getCurrentUser();
        Tag updateTag = new Tag(tagUpdateDTO.getId(), tagUpdateDTO.getName(), currentUser);
        tagRepository.save(updateTag);
        TagDTO tagDTO = tagMapper.toDTO(updateTag);
        return tagDTO;
    }
}
