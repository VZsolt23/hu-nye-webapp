package hu.nye.webapp.service.impl;

import hu.nye.webapp.dto.MovieDTO;
import hu.nye.webapp.entity.Movie;
import hu.nye.webapp.exception.MovieNotFoundException;
import hu.nye.webapp.repository.MovieRepository;
import hu.nye.webapp.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Default implementation of {@link MovieService}.
 */
@Service
public class MovieServiceImplementation implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieServiceImplementation(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MovieDTO> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDTO> findById(Long id) {
        return movieRepository.findById(id)
                .map(m -> modelMapper.map(m, MovieDTO.class));
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        movieDTO.setId(null);

        Movie movieToSave = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieRepository.save(movieToSave);

        return modelMapper.map(savedMovie, MovieDTO.class);
    }

    @Override
    public MovieDTO update(MovieDTO movieDTO) {
        Long id = movieDTO.getId();
        Optional<Movie> movieToUpdate = movieRepository.findById(id);

        if (movieToUpdate.isEmpty()) {
            throw new MovieNotFoundException("Movie not found with id=" + id);
        }

        Movie movieToPersist = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieRepository.save(movieToPersist);

        return modelMapper.map(savedMovie, MovieDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Movie> movieToDelete = movieRepository.findById(id);

        if (movieToDelete.isPresent()) {
            movieRepository.delete(movieToDelete.get());
        } else {
            throw new MovieNotFoundException("Movie not found with id=" + id);
        }
    }
}
