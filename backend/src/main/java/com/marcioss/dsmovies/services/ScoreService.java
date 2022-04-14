package com.marcioss.dsmovies.services;

import com.marcioss.dsmovies.entities.Movie;
import com.marcioss.dsmovies.entities.Score;
import com.marcioss.dsmovies.entities.User;
import com.marcioss.dsmovies.entities.dtos.MovieDTO;
import com.marcioss.dsmovies.entities.dtos.ScoreDTO;
import com.marcioss.dsmovies.repositories.MovieRepository;
import com.marcioss.dsmovies.repositories.ScoreRepository;
import com.marcioss.dsmovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.getById(dto.getMovieId());
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s: movie.getScores()){
            sum = sum +s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        MovieDTO movieDto = new MovieDTO(movie);
        return movieDto;

    }


}
