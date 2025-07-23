package com.andrewtao.lytlestory.recommender;

import java.util.List;

import com.andrewtao.lytlestory.story.Metadata;

// Pick up later

public interface Recommender {
    /**
     * Recommends stories based on user preferences.
     * 
     * @param userId The ID of the user for whom to recommend stories.
     * @return A list of recommended story IDs.
     */
    List<Metadata> recommendStories(Long userId, int numberOfRecommendations);
}
