package com.andrewtao.lytlestory.recommender;
import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.andrewtao.lytlestory.story.Metadata;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RecommenderService {

    private final StoryRecommender storyRecommender;

    @Autowired
    public RecommenderService(StoryRecommender storyRecommender) {
        this.storyRecommender = storyRecommender;
    }

    public List<Metadata> recommendStories(Long userId, int numberOfRecommendations) {
        return storyRecommender.recommendStories(userId, numberOfRecommendations);
    }
    
}
