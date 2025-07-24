package com.andrewtao.lytlestory.recommender;

import java.util.List;

import com.andrewtao.lytlestory.story.Metadata;

// Pick up later

public interface Recommender {
    /**
     * Recommends stories based on user preferences.
     * 
     * @param query The query embedding to recommend stories.
     * @return A list of recommended story IDs.
     */
    List<Metadata> recommendStories(Long query, int numberOfRecommendations);
}
