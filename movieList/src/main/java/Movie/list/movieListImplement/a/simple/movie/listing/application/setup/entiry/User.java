package Movie.list.movieListImplement.a.simple.movie.listing.application.setup.entiry;

import lombok.Data;

@Data
public class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

}
