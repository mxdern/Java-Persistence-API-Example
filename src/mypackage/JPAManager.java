package mypackage;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAManager {

	public static ArrayList<Country> readFromFile(String filename)
	{
		ArrayList<Country> countries = new ArrayList<Country>();
		try 
		{
			FileReader reader = new FileReader("world.txt");
			BufferedReader bfr = new BufferedReader(reader);
			while(true)
			{
				String line = bfr.readLine();
				if (line == null)
				{
					break;
				}
			
				String[] arr = line.split(",");
				
				String countryName = arr[0];
				String landName = arr[1];
				String capitalName = arr[2];
				int population = Integer.parseInt(arr[3]);
				
				Country c = new Country(countryName, landName, capitalName, population);
				
				countries.add(c);
			}
			reader.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("no have rights to read that file");
			e.printStackTrace();
		}
		return countries;
	}		
	
	
	
	public static void writeIntoTable(ArrayList<Country> countries) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager =emf.createEntityManager();
			
		for (Country c : countries)
		{
								
			entityManager.getTransaction().begin();
			
			entityManager.persist(c);
				
			entityManager.getTransaction().commit();
		}
					
		System.out.println("Data inserted!!!");
	}
	
	
	public static Country getCountryByID(int countryID) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager =emf.createEntityManager();
					
	    int country_ID = countryID;
	         
	    Country c_ntry = entityManager.find(Country.class, country_ID);
				
		return c_ntry;	
	}
	
	
	public static void deleteCountryByID(int countryID) {
			
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager =emf.createEntityManager();
			
		entityManager.getTransaction().begin();
			
		Country obj_found = entityManager.find(Country.class, countryID);
					
		entityManager.remove(obj_found);
		
		entityManager.getTransaction().commit();
					
	}
		
	
	public static void updateCountryPopulationByID (int countryID, int population) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		EntityManager entityManager =emf.createEntityManager();
			
		entityManager.getTransaction().begin();
		
		Country cntry = entityManager.find(Country.class, countryID); 
			
		cntry.setPopulation(population);
		
		entityManager.merge(cntry);
		
		entityManager.getTransaction().commit();
			
		System.out.println("Data inserted.");
	}
}
