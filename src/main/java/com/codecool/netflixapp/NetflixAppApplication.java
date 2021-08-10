package com.codecool.netflixapp;

import com.codecool.netflixapp.entity.Video;
import com.codecool.netflixapp.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class NetflixAppApplication {

    @Autowired
    private VideoRepository videoRepository;

    public static void main(String[] args) {
        SpringApplication.run(NetflixAppApplication.class, args);
    }
    @PostConstruct
    public void setup() {
        Video whatever = Video.builder()
                .name("Mind1")
                .url("https://www.youtube.com/watch?v=Mfy0OweIo3w&ab_channel=Azahriah")
                .build();

        Video el_barto = Video.builder()
                .name("El Barto")
                .url("hhttps://www.youtube.com/watch?v=AU5mEqR_yJ8&ab_channel=Azahriah")
                .build();

        Video why_not = Video.builder()
                .name("Miért ne?")
                .url("https://www.youtube.com/watch?v=wpkAEwFRuq4&ab_channel=DZS%C3%9ADL%C3%93")
                .build();

        Video animal = Video.builder()
                .name("Állat")
                .url("https://www.youtube.com/watch?v=qehnDZjIJeE&ab_channel=DZS%C3%9ADL%C3%93")
                .build();

        Video falling = Video.builder()
                .name("Hullik")
                .url("https://www.youtube.com/watch?v=aYEVXsQxWq8&ab_channel=ByeAlexIttVan")
                .build();

        videoRepository.saveAll(Arrays.asList(whatever, el_barto, why_not, animal, falling));
    }
}