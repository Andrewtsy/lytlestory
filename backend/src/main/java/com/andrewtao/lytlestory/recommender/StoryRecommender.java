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
    public List<Metadata> recommendStories(Long query, int numberOfRecommendations) {
        int k = 10;
        Random random = new Random(query);
        List<Integer> recommendationIds = new java.util.ArrayList<>();
        for (int i = 1; i <= numberOfRecommendations; i++) {
            recommendationIds.add(random.nextInt(1, k));
        }
        return recommendationIds.stream()
                .map(id -> getMetadata(id))
                .collect(java.util.stream.Collectors.toList());
    }

    private Metadata getMetadata(long storyId) {
        Story story = storyService.findById(String.valueOf(storyId));
        return new Metadata(story.getId(), story.getTitle(), story.getAuthor(),
                story.getGenre(), story.getFileName());
    }

}
