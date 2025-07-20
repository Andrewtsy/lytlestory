package com.andrewtao.lytlestory.repository;

import com.andrewtao.lytlestory.data.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, String> {
    Optional<List<Story>> findByTitleContainingIgnoreCase(String title);
}