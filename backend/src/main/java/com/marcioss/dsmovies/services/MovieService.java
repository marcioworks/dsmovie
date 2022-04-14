package com.marcioss.dsmovies.services;

import com.marcioss.dsmovies.entities.Movie;
import com.marcioss.dsmovies.entities.dtos.MovieDTO;
import com.marcioss.dsmovies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> movies = movieRepository.findAll(pageable);
        Page<MovieDTO> result = movies.map(MovieDTO::new);
        return result;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
        Movie movie = movieRepository.findById(id).get();
        MovieDTO result = new MovieDTO(movie);
        return result;
    }
}
