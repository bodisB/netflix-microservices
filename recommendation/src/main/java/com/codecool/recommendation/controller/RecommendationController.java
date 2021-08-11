package com.codecool.recommendation.controller;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recom")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{videoId}")
    public List<Recommendation> getAllRecommendation(@PathVariable long videoId) {
        return recommendationService.getAllRecommendationForVideo(videoId);
    }

    @PostMapping("/add")
    public void addNewRecommendation(@RequestBody Recommendation recommendation) {
        recommendationService.saveNewRecommendation(recommendation);
    }
}
