package hu.nye.webapp.repository;

import hu.nye.webapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Operations related to the 'Movies' database.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
