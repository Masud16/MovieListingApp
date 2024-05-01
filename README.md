# MovieListingApp
Here I'm Implementing a simple movie listing application. Such as IMDB is a movie listing application.
my task was to implement an application where a user should be able to
- Register with their email address. No need for any authentication.
- Search all the movies in the app. Users can search for either title, cast or category and all 
matching movies should be returned in ascending order of movie title.
- See details for any movie like movie title, cast, category, release date, budget.
- Add movies to favorites.
- Remove movies from their favorites.
- See their personal details and movies they added to their favorites.
- Search only movies they added to their favorites.
## constraints
- No need to use any database.

My task is completed. Now I'm describing my Api endpoints:
1. user registration with their email address (POST API)
        http://localhost:8888/user/register?email=masud@gmail.com
    -to see all registered users (GET API)
        http://localhost:8888/user/getAllUser

2. Search all the movies in the app (GET API)
        http://localhost:8888/movies
    - Users can search for either title, cast or category and all matching movies should be returned in     ascending order of movie title. (GET API)
        http://localhost:8888/movies/search?query=777 Charlie

3. See details for any movie like movie title, cast, category, release date, budget. (GET API)
        http://localhost:8888/movies
        and 
        http://localhost:8888/movies/search?query=777 Charlie

4. Add movies to favorites (POST API)
        http://localhost:8888/user/user-1/favorites
        in the request body you should use this JSON -
            {
                "title": "Inception",
                "cast": "Leonardo DiCaprio, Joseph Gordon-Levitt",
                "category": "Sci-Fi",
                "releaseDate": 2010,
                "budget": 1.60000001E7
            }

5. Remove movies from their favorites (DELETE API)
        http://localhost:8888/user/user-1/favorites/777 Charlie

6. See their personal details and movies they added to their favorites (GET API)
        http://localhost:8888/user/search/user-1

7. Search only movies they added to their favorites (GET API)
        http://localhost:8888/user/user-1/favorites/search?query=Inception
