package com.codecool.recommendation;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class RecommendationApplication {

    @Autowired
    private RecommendationRepository recommendationRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecommendationApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/recom/**"))
                .build();
    }

    @PostConstruct
    public void setup() {
        Recommendation recommendation1 = Recommendation.builder()
                .comment("Not bad, but not good")
                .rating(3)
                .videoId(1)
                .build();

        Recommendation recommendation2 = Recommendation.builder()
                .comment("It is really good")
                .rating(5)
                .videoId(2)
                .build();

        Recommendation recommendation3 = Recommendation.builder()
                .comment("I don't want to hear it again")
                .rating(1)
                .videoId(3)
                .build();

        Recommendation recommendation4 = Recommendation.builder()
                .comment("Not bad")
                .rating(4)
                .videoId(4)
                .build();

        Recommendation recommendation5 = Recommendation.builder()
                .comment("It is bad")
                .rating(2)
                .videoId(5)
                .build();

        recommendationRepository.saveAll(Arrays.asList(
                recommendation1,
                recommendation2,
                recommendation3,
                recommendation4,
                recommendation5));
    }
}
