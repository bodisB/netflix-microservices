package com.codecool.netflixapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class RecommendationResult {
    private long id;
    private int rating;
    private String comment;
    private int videoId;
}
