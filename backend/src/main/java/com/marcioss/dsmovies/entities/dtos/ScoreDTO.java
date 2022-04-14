package com.marcioss.dsmovies.entities.dtos;

public class ScoreDTO {

    private Long movieId;
    private String email;
    private Double score;

    public ScoreDTO(){}

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double value) {
        this.score = value;
    }
}
