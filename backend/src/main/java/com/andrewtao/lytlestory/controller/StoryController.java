package com.andrewtao.lytlestory.controller;

import com.andrewtao.lytlestory.data.Story;
import com.andrewtao.lytlestory.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping
    public Iterable<Story> findAll() {
        return storyService.findAll();
    }

    @GetMapping("/{id}")
    public Story findById(@PathVariable String id) {
        return storyService.findById(id);
    }

    @PostMapping
    public Story create(@RequestBody Story story) {
        return storyService.save(story);
    }

    @PutMapping("/{id}")
    public Story update(@RequestBody Story story) {
        return storyService.save(story);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        storyService.deleteById(id);
    }

}
