package com.codecool.netflixapp.controller;

import com.codecool.netflixapp.entity.Video;
import com.codecool.netflixapp.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/all")
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/all-with-recommendation")
    public List<Video> getAllVideoWithRecommendation() {
        return videoService.getAllVideoWithRecommendation();
    }

    @PutMapping("/update")
    public String updateVideo() {
        return "true";
    }

}
