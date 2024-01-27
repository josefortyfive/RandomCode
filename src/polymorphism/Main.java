package polymorphism;

public class Main {
	
	public static void main(String args[]) {
		Movie theMovie = new Movie("Star wars");
		theMovie.watchMovie();
		
		Adventure adventure = new Adventure("Star Wars");
		adventure.watchMovie();
	}

}
