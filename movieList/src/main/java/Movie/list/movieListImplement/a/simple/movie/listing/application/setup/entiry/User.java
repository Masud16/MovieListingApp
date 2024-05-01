package Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String id;
    private String email;
    private Set<Movie> favoriteMovies;

    public User(String id, String email) {
        this.id = id;
        this.email = email;
        this.favoriteMovies = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void addFavoriteMovie(Movie movie) {
        favoriteMovies.add(movie);
    }

    public void removeFavoriteMovie(Movie movie) {
        favoriteMovies.remove(movie);
    }
}
