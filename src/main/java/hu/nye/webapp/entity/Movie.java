package hu.nye.webapp.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

/**
 * This is a class which is representing a database movie entity
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    private String tagline;

    @Min(value = 0)
    @Max(value = 100)
    private double voteAverage;

    @Min(value = 0)
    private int voteCount;

    private Date releaseDate;

    @NotBlank
    private String posterPath;

    @NotBlank
    private String overview;

    @Min(value = 0)
    private int budget;

    @Min(value = 0)
    private int revenue;

    @ElementCollection
    private Set<@NotBlank String> genres;

    @NotNull
    @Min(value = 0)
    private Integer runtime;
}
