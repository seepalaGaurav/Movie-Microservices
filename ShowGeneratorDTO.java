package com.showTime.movie.dto;

import java.util.List;

public class ShowGeneratorDTO {
    public static List<ShowsDTO> ShowGenerator(Long movieId){
        return List.of(new ShowsDTO(movieId*10+1,"11:30 AM"),
                new ShowsDTO(movieId*10+2,"02:45 PM"),
                new ShowsDTO(movieId*10+3,"06:45PM"),
                new ShowsDTO(movieId*10+4,"09:45 PM"));
    }
}
