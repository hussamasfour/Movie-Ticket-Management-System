package com.hussam.movieservice.repository;

import com.hussam.movieservice.entity.SeatPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatPositionRepository extends JpaRepository<SeatPosition, Long> {
}
