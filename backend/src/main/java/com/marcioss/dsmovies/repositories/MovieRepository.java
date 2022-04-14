package com.marcioss.dsmovies.repositories;

import com.marcioss.dsmovies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
