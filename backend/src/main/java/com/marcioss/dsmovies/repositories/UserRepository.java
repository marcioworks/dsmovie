package com.marcioss.dsmovies.repositories;

import com.marcioss.dsmovies.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
