package com.andrewtao.lytlestory.repository;

import com.andrewtao.lytlestory.data.Story;
import org.springframework.data.repository.CrudRepository;;

public interface StoryRepository extends CrudRepository<Story, String> {
}