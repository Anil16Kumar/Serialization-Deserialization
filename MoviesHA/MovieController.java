package MoviesHA;

import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.Scanner;

public class MovieController {
	 private MovieManager manager;
	    Scanner scanner=new Scanner(System.in);

	    public MovieController() {
	        manager = new MovieManager();
	        scanner = new Scanner(System.in);
	    }

	    public void start() {
	        int choice;
	        do { 
	        	System.out.println();
	        	System.out.println(); 
	            System.out.println("1. Add Movie");
	            System.out.println("2. Clear All Movies");
	            System.out.println("3. List All Movies");
	            System.out.println("4. Exit");
	            System.out.print("Now Make choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    addMovie();
	                    break;
	                case 2:
	                    clearMovies();
	                    break;
	                case 3:
	                    listMovies();
	                    break;
	                case 4:
	                    System.out.println("Exiting the program...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 4);
	    }

	    private void addMovie() { 
	    	System.out.println("Enter movie name:");
	        String name = scanner.next();
	        System.out.println("Enter movie year:");
	        int year = scanner.nextInt();
	        scanner.nextLine();  
	        System.out.println("Enter movie genre:");
	        String genre = scanner.nextLine();

	        int id = manager.getMovieId();
	        Movie movie = new Movie(id, name, year, genre);
	        manager.addMovie(movie);
	    }

	    private void clearMovies() { 
	        manager.clearMovies();
	    }

	    private void listMovies() { 
	        List<Movie> movies = manager.getMovies();
	        if (movies.isEmpty()) {
	            System.out.println("NO movies FOUND.");
	        } else {
	            System.out.println("   Movie List :->   ");
	            for (Movie movie : movies) {
	                System.out.println(movie);
	            }
	            System.out.println("__________________________");
	        }
	    }
	 
	     
}
