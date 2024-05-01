package Movie.list.movieListImplement.a.simple.movie.listing.application.setup.controller;
import Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private static final List<Movie> movies = new ArrayList<>();

    //adding demo movies
    static {
        movies.add(new Movie("12th Fail", "Vikrant Massey, Medha Shankr", "Love & Drama", 2023,1810683.20));
        movies.add(new Movie("777 Charlie", "Rakshit Shetty", " Adventure Drama", 2022, 2820683.50));
        movies.add(new Movie("The Dark Knight", "Christian Bale, Heath Ledger", "Action", 2008, 18500000.40));
        movies.add(new Movie("Inception", "Leonardo DiCaprio, Joseph Gordon-Levitt", "Sci-Fi", 2010, 16000000.10));
        movies.add(new Movie("Pulp Fiction", "John Travolta, Uma Thurman", "Crime", 1994, 850000.60));
    }

    //Searching all the movies in the app.
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movies);
    }

    //searching for either title, cast or category
    @GetMapping("/movies/search")
    public ResponseEntity<List<Movie>> searchMovies(
            @RequestParam(value = "query", required = true) String query) {
        List<Movie> searchResults = movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        movie.getCast().toLowerCase().contains(query.toLowerCase()) ||
                        movie.getCategory().toLowerCase().contains(query.toLowerCase()))
                .sorted(Comparator.comparing(Movie::getTitle))
                .collect(Collectors.toList());
        return ResponseEntity.ok(searchResults);
    }
}
