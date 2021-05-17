package com.hussam.movieservice.repository;

import com.hussam.movieservice.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends JpaRepository<Seat,Long> {
}
