package com.andrewtao.lytlestory.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    public List<Story> findAll() {
        return storyRepository.findAll();
    }

    public Story findById(UUID id) {
        return storyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Story save(Story story) {
        return storyRepository.save(story);
    }

    public void deleteById(UUID id) {
        storyRepository.deleteById(id);
    }

    public List<Story> searchByKeyword(String keyword) {
        return storyRepository.findByTitleContainingIgnoreCase(keyword)
                .orElseThrow(() -> new EntityNotFoundException("No stories found with keyword: " + keyword));
    }

    public List<Metadata> findRandomMetadata(int limit) {
        // return storyRepository.findRandomMetadata(limit).stream()
        // .map(row -> new Metadata((UUID) row[0], (String) row[1], (String) row[2],
        // (String) row[3],
        // (String) row[4]))
        // .toList();
        Pageable pageable = PageRequest.of(0, limit); // page 0, size = limit
        return storyRepository.findRandomMetadata(pageable);
    }
}
