package com.showTime.movie.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieAPIResponse {
    private Long page;
    private List<MovieAPIDTO> results;
    private Long totalPages;
    private Long totalResults;

}
