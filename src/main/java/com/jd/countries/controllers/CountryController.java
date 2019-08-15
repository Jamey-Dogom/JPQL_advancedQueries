package com.jd.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.countries.models.City;
import com.jd.countries.services.ApiService;

@Controller
public class CountryController {
	@Autowired
	private ApiService apiService;

	@RequestMapping("/")
	public String index() {
		// 1. What query would you run to get all the countries that speak Slovene? 
		List<Object[]> countries1 = apiService.findCountriesByLanguage("Slovene");
		for (Object[] row : countries1) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
		}
		// 2. What query would you run to display the total number of cities for each country?
		List<Object[]> cities1 = apiService.findTotalCities();
		for (Object[] row : cities1) {
			System.out.println(row[0]);
			System.out.println(row[1]);
		}
		// 3. What query would you run to get all the cities in Mexico with a population of greater than 500,000?
		List<City> cities2 = apiService.findCitiesInCountryWithPopulationGreaterThan("Mexico", 500000);
		for(City c : cities2) {
			System.out.println(c.getName());
			System.out.println(c.getPopulation());
		}
		
		// 4. What query would you run to get all languages in each country with a percentage greater than 89%?
		List<Object[]> countries2 = apiService.findLanguagesWithPercentageGreaterThan(89.0);
		for(Object[] row : countries2) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
		}
		
		// 5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
		List<Object[]> countries3 = apiService.SBelowPopGreater(501.00, 100000);
		for(Object[] row : countries3) {
			System.out.println(row[0]);
		}
		
		// 6. What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a 
		// life expectancy greater than 75 years?
		List<Object[]> countries4 = apiService.govSaLe("Constitutional Monarchy", 200.00, 75.00);
		for(Object[] row : countries4) {
			System.out.println(row[0]);
		}
		
		// 7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? 
		// The query should return the Country Name, City Name, District, and Population. 
		List<Object[]> countries5 = apiService.findNumSev("Argentina", "Buenos Aires", 500000);
		for(Object[] row: countries5) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
			System.out.println(row[3]);
		}
		
		// 8. What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. 
		// Also, the query should arrange the result by the number of countries in descending order.
		List<Object[]> countries6 = apiService.findEachRegion();
		for(Object[] row: countries6) {
			System.out.println(row[0]);
			System.out.println(row[1]);
		}
		return "index.jsp";
	}

}
