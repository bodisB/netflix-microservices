package com.codecool.netflixapp.service;

import com.codecool.netflixapp.entity.RecommendationResult;
import com.codecool.netflixapp.entity.Video;
import com.codecool.netflixapp.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation.url}")
    private String baseUrl;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public List<Video> getAllVideoWithRecommendation() {
        List<Video> videos = videoRepository.findAll();
        for (Video video: videos) {
            RecommendationResult recommendation = restTemplate.getForEntity(baseUrl + "/" + video.getId(), RecommendationResult.class).getBody();
            video.setRecommendationResult(recommendation);
        }
        return videos;
    }
}
