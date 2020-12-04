package courseraita;
import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector _rentals = new Vector();
	private int _frequentRenterPoints;
	private double _totalAmount;
	
	
	public Customer(String name) {
		this._name = name;
		this._frequentRenterPoints = 0;
		this._totalAmount = 0;
	};
	public void addRental(Rental rent) {
		_rentals.addElement(rent);
		_frequentRenterPoints += rent.getFrequentRenterPoints();
		_totalAmount += rent.getAmount();
	}
	public String getName() {
		return _name;
	}

	public double getTotalAmount() {
		return _totalAmount;
	}

	public int getFrequentRenterPoints() {
		return _frequentRenterPoints;
	}
	
	public String statement() {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += "\t" + each.getMovie().getTitle() + "\t" 
			       + String.valueOf(each.getAmount()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getFrequentRenterPoints())
		       + " frequent renter points";
		System.out.println (result + "\n");
		return result;
	}
}


