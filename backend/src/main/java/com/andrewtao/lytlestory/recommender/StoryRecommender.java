package com.andrewtao.lytlestory.recommender;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.andrewtao.lytlestory.story.Metadata;
import com.andrewtao.lytlestory.story.StoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoryRecommender {

    private final StoryService storyService;

    @Autowired
    public StoryRecommender(StoryService storyService) {
        this.storyService = storyService;
    }

    // // @Override
    // public List<Metadata> recommendStories(Long query, int
    // numberOfRecommendations) {
    // List<Metadata> recommendations =
    // storyService.findRandomMetadata(numberOfRecommendations)
    // .stream()
    // // .distinct()
    // // .limit(numberOfRecommendations)
    // .collect(java.util.stream.Collectors.toList());

    // return recommendations;
    // }

    public List<Metadata> recommendStories(Long query, int numberOfRecommendations) {
        List<Metadata> all = storyService.findAll()
                .stream()
                .map(story -> new Metadata(story.getId(), story.getTitle(), story.getAuthor(), story.getGenre(),
                        story.getFileName()))
                .toList();
        List<Metadata> result = new ArrayList<>();
        Random rand = new Random(query);
        for (int i = 0; i < numberOfRecommendations; i++) {
            result.add(all.get(rand.nextInt(all.size())));
        }
        return result;
    }

}
