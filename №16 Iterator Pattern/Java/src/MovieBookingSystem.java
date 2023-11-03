import java.util.List;

class Movie {
    private String title;
    private String director;
    private int duration;

    public Movie(String title, String director, int duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }
}

class MovieList {
    private List<Movie> movies;

    public MovieList(List<Movie> movies) {
        this.movies = movies;
    }

    public Iterator<Movie> createIterator() {
        return new MovieIterator();
    }

    private class MovieIterator implements Iterator<Movie> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex < movies.size();
        }

        @Override
        public Movie next() {
            if (hasNext()) {
                return movies.get(currentIndex++);
            }
            return null;
        }
    }
}

interface Iterator<T> {
    boolean hasNext();

    T next();
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        List<Movie> movieList = List.of(
                new Movie("Movie 1", "Director 1", 120),
                new Movie("Movie 2", "Director 2", 110),
                new Movie("Movie 3", "Director 3", 140)
        );

        MovieList movieAggregate = new MovieList(movieList);

        Iterator<Movie> movieIterator = movieAggregate.createIterator();

        while (movieIterator.hasNext()) {
            Movie movie = movieIterator.next();
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Duration: " + movie.getDuration() + " minutes");
            System.out.println();
        }
    }
}
