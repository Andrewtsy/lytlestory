package com.andrewtao.lytlestory.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    public Story findById(String id) {
        return storyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Story save(Story story) {
        return storyRepository.save(story);
    }

    public void deleteById(String id) {
        storyRepository.deleteById(id);
    }

    public List<Story> searchByKeyword(String keyword) {
        return storyRepository.findByTitleContainingIgnoreCase(keyword)
                .orElseThrow(() -> new EntityNotFoundException("No stories found with keyword: " + keyword));
    }
}
