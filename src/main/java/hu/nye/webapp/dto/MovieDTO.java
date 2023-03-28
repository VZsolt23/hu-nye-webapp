package hu.nye.webapp.dto;

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
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
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

    private Set<@NotBlank String> genres;

    @NotNull
    @Min(value = 0)
    private Integer runtime;
}
