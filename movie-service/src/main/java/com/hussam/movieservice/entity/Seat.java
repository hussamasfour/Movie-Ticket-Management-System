package com.hussam.movieservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private SeatType seatType;
    private double price;
    private boolean reserved;
    @OneToOne
    private SeatPosition seatPosition;
}
