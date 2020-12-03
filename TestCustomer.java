package courseraita;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestCustomer  { 
	
	Customer client;

	@Before
	public void init() throws Exception {
		client = new Customer("João");
	}
	
	public void rentMovie(String title, int type, int days) throws Exception {
		System.out.println ("title = " + title + " type = " + type + " days = " + days);
		Movie movie = Movie.factoryMovie (title,type);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}
	
	public void assertContain(String result, String content) {
		assertTrue(result.indexOf(content)>=0);
	}
	
	@Test
	public void testNameCreation(){
		String result = client.statement();
		assertContain(result,"Rental Record for João");
	}
	@Test
	public void testOneRegularOneDay() throws Exception{
		rentMovie("Indiana Jones",Movie.REGULAR,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 2.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	@Test
	public void testOneRegularTreeDays() throws Exception{
		rentMovie("Indiana Jones",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	@Test
	public void testOneChildrensOneDay() throws Exception{
		rentMovie("Procurando Nemo",Movie.CHILDRENS,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 1.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	@Test
	public void testOneChildrensFiveDays() throws Exception{
		rentMovie("Procurando Nemo",Movie.CHILDRENS,5);
		String result = client.statement();
		assertContain(result,"Amount owed is 4.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	@Test
	public void testOneNewReleaseOneDay() throws Exception{
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	@Test
	public void testOneNewReleaseTreeDays() throws Exception{
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 9.0");
		assertContain(result,"You earned 2 frequent renter points");
	}
	@Test
	public void testManyRents() throws Exception{
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,2);
		rentMovie("Troia",Movie.NEW_RELEASE,3);
		rentMovie("Procurando Nemo",Movie.CHILDRENS,3);
		rentMovie("Indiana Jones",Movie.REGULAR,2);
		rentMovie("Rei Leão",Movie.CHILDRENS,4);
		rentMovie("E o vento levou...",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 25.0");
		assertContain(result,"You earned 8 frequent renter points");
	}

	
}
