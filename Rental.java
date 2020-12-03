package courseraita;

public class Rental {
	
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public int getFrequentRenterPoints() {
		
		int daysRented = getDaysRented();
		return _movie.getFrequentRenterPoints(daysRented);
	}

	public double getAmount() {
		
		int daysRented = getDaysRented();
		return _movie.getAmount(daysRented);
	
	}
	
}

