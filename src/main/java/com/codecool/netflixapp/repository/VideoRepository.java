package com.codecool.netflixapp.repository;

import com.codecool.netflixapp.entity.Video;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
