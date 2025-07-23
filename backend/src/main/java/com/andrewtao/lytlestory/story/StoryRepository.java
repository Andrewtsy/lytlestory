package com.andrewtao.lytlestory.story;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, String> {
    Optional<List<Story>> findByTitleContainingIgnoreCase(String title);
}