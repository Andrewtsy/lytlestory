package com.andrewtao.lytlestory.repository;

import com.andrewtao.lytlestory.data.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, String> {
}