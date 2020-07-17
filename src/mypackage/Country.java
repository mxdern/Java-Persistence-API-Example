package mypackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryID;
	
	
	private String countryName;
	private String landName;
	private String capitalName;
	private int population;


	
	public Country(String countryName, String landName, String capitalName, int population) {
		
		this.countryName = countryName;
		this.landName = landName;
		this.capitalName = capitalName;
		this.population = population;
	}
	public Country() {
		super();
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = 
				countryName;
	}
	public String getLandName() {
		return landName;
	}
	public void setLandName(String landName) {
		this.landName = 
				landName;
	}
	
	
	public String getCapitalName() {
		return capitalName;
	}
	public void setCapitalName(String capitalName) {
		this.capitalName = 
				capitalName;
	}
	
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = 
				population;
	}
	
	
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = 
				countryID;
	}
}
	

