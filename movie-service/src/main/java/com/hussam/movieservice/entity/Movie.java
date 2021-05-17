package com.hussam.movieservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie extends RepresentationModel<Movie> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    private Date releasedDate;
    @Column(updatable = false)
    private String genre;

    private String language;
    private int duration;

    @OneToMany
    private List<Seat> seats;

}
