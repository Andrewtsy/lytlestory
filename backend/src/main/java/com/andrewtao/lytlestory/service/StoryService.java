package com.andrewtao.lytlestory.service;

import com.andrewtao.lytlestory.data.Story;
import com.andrewtao.lytlestory.repository.StoryRepository;
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

}
