package com.andrewtao.lytlestory.recommender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.andrewtao.lytlestory.story.Metadata;

@RestController
@RequestMapping("/api/recommender")
@CrossOrigin(origins = "*")
public class RecommenderController {

    private RecommenderService recommenderService;

    @Autowired
    public RecommenderController(RecommenderService recommenderService) {
        this.recommenderService = recommenderService;
    }

    @GetMapping("/recommend")
    public List<Metadata> recommendStories(
            @RequestParam Long query,
            @RequestParam Integer numberOfStories) {
        return recommenderService.recommendStories(query, numberOfStories);
    }
}
