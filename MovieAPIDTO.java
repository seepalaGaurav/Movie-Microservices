package com.showTime.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieAPIDTO {
    private Long id;
    @JsonProperty("original_language")
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Long popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    private String releaseDate;
    private String title;
    private boolean video;
    private Long voteAverage;
    private Long voteCount;
}


