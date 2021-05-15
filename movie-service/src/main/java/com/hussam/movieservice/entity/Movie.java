package com.hussam.movieservice.entity;

import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    private Date releasedDate;
    private String genre;

}
