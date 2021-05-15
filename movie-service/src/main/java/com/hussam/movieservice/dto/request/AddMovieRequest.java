package com.hussam.movieservice.dto.request;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AddMovieRequest {
    @NotNull(message="Name can't be empty" )

    private String name;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @NotNull
    private String genre;
}
