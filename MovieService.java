package com.showTime.movie.service;

import com.showTime.movie.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import java.net.http.HttpHeaders;
import java.util.List;

@Service
public class MovieService {

    //Steps : get the base url & token details & create a rest template request to hit the external api.

    private final RestTemplate restTemplate;
    @Value("${tmdb.api.base-url}")
    private String baseUrl;
    @Value("${tmdb.api.token}")
    private String token;

    public MovieService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public List<MovieDTO> getMovies(){
        //add headers for http call

        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization",token);
        headers.set("accept","application/json");

        // create httpEntity
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        // resttemplate & call the api & get the response

        ResponseEntity<MovieAPIResponse> response=restTemplate.exchange(baseUrl+"/movie/popular",
                HttpMethod.GET,
                entity,
                MovieAPIResponse.class);

        return response.getBody().getResults()
                .stream()
                .map(m ->MovieDTO.builder()
                        .movieId(m.getId())
                        .originalLanguage(m.getOriginalLanguage())
                        .title(m.getTitle())
                        .posterPath("https://image.tmdb.org/t/p/w500"+m.getPosterPath())
                        .overview(m.getOverview())
                        .shows(ShowGeneratorDTO.ShowGenerator(m.getId()))
                        .build())
                .toList();

    }
}
