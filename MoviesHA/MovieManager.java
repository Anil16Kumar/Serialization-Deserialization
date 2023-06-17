package MoviesHA;
 
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
	private List<Movie> movies;
    private static final String filePath = "C:\\Users\\ANIL KUMAR\\Desktop\\Monocept/namess.txt";

    public MovieManager() {
        movies = new ArrayList<>();
        loadMovies();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        saveMovies();
        System.out.println("Movie added successfully!");
    }

    public void clearMovies() {
        movies.clear();
        saveMovies();
        System.out.println("All movies deleted successfully!");
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public int getMovieId() {
        return movies.size() + 1;
    }

    public void loadMovies() {
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            movies = (List<Movie>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
        	System.out.println("No existing movie data found. Starting with an empty movie list.");
        }
    }

    public void saveMovies() {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(movies);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllMovies() {
        movies.clear();
        saveMovies();
        System.out.println("All movies deleted successfully!");
    }
	  
}
