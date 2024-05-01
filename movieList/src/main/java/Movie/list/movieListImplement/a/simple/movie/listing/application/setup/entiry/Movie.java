package Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry;

import lombok.Data;

@Data
public class Movie {
    private String title;
    private String cast;
    private String category;
    private int releaseDate;
    private double budget;

    public Movie(String title, String cast, String category, int releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

}
