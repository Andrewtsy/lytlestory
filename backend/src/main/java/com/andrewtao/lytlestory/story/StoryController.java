package com.andrewtao.lytlestory.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/story")
@CrossOrigin(origins = "*")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/all")
    public List<Story> findAll() {
        return storyService.findAll();
    }

    @GetMapping("/{id}")
    public Story findById(@PathVariable UUID id) {
        return storyService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Story create(@RequestBody Story story) {
        return storyService.save(story);
    }

    @PutMapping("/{id}")
    public Story update(@RequestBody Story story) {
        return storyService.save(story);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        storyService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Story> search(@RequestParam String query) {
        return storyService.searchByKeyword(query);
    }

}
