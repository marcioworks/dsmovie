package com.marcioss.dsmovies.repositories;

import com.marcioss.dsmovies.entities.Score;
import com.marcioss.dsmovies.entities.ScorePK;
import com.marcioss.dsmovies.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {


}
