package courseraita;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

	public double getAmount(int daysRented) {
		double thisAmount = 0;
		thisAmount += daysRented * 3;
		return thisAmount;
	}

	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > 1)
			return 2;  else  return 1;
	}

}
