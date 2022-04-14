package com.marcioss.dsmovies.controllers;

import com.marcioss.dsmovies.entities.dtos.MovieDTO;
import com.marcioss.dsmovies.entities.dtos.ScoreDTO;
import com.marcioss.dsmovies.services.MovieService;
import com.marcioss.dsmovies.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto){
        MovieDTO movieDTO =  scoreService.saveScore(dto);
        return movieDTO;

    }

    

}
