package courseraita;

public abstract class Movie {
	
	public static final int CHILDRENS = 2;	
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;

	public static Movie factoryMovie(String title, int typeOfMovie) throws Exception {
		
		//  Factory Method Pattern 
		
		if (typeOfMovie == REGULAR)
			return new RegularMovie (title);
		
		if (typeOfMovie == CHILDRENS)
			return new ChildrensMovie (title);	
		
		if (typeOfMovie == NEW_RELEASE)
			return new NewReleaseMovie (title);	
		
		throw new Exception("Nao Existe Este tipo de Filme - Os tipos Atuais sao REGULAR, CHILDRENS e NEW-RELEASE");
	}

	public Movie(String title) {
		_title = title;
	}

	public String getTitle() {
		return _title;
	}

	public abstract double getAmount(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);
}
