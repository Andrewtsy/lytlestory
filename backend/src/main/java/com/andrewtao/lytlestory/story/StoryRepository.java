package com.andrewtao.lytlestory.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StoryRepository extends JpaRepository<Story, UUID> {
    Optional<List<Story>> findByTitleContainingIgnoreCase(String title);

    @Query(value = "SELECT id, title, author, genre, file_name FROM stories ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Object[]> findRandomMetadata(@Param("limit") int limit);

    @Query("SELECT new com.andrewtao.lytlestory.story.Metadata(s.id, s.title, s.author, s.genre, s.file_name) FROM Story s ORDER BY function('RAND')")
    List<Metadata> findRandomMetadata(Pageable pageable);

}