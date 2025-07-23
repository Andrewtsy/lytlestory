package com.andrewtao.lytlestory.recommender;

import java.util.List;
import java.util.Random;

import com.andrewtao.lytlestory.story.Metadata;
import com.andrewtao.lytlestory.story.StoryService;
import com.andrewtao.lytlestory.story.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoryRecommender {

    private final StoryService storyService;
    
    @Autowired
    public StoryRecommender(StoryService storyService) {
        this.storyService = storyService;
    }

    // @Override
    public List<Metadata> recommendStories(Long userId, int numberOfRecommendations) {
        int k = 3;
        Random random = new Random(42);
        List<Long> recommendationIds = new java.util.ArrayList<>();
        for (long i = 0; i < numberOfRecommendations; i++) {
            recommendationIds.add(1 + random.nextLong(k));
        }
        return recommendationIds.stream()
                .map(id -> getMetadata(id))
                .collect(java.util.stream.Collectors.toList());
    }


    private Metadata getMetadata(long storyId) {
        // Simulate fetching metadata for the user
        Story story = storyService.findById(String.valueOf(storyId));
        return new Metadata(story.getId(), story.getTitle(), story.getAuthor(),
                            story.getGenre(), story.getFileName());
    }

    
}
