package com.showTime.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long movieId;
    private String originalLanguage;
    private String title;
    private String posterPath;
    private String overview;
    private List<ShowsDTO> shows;
}
