package mypackage;
import java.util.ArrayList;



public class MainClass {

	public static void main(String[] args) {
		
	
		ArrayList<Country> countries = JPAManager.readFromFile("world.txt");

		
		JPAManager.writeIntoTable(countries);
		
		
		JPAManager.updateCountryPopulationByID(1, 11145);
		
		
		JPAManager.deleteCountryByID(2);
		
		
		
	}
}