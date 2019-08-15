package com.jd.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jd.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{

	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE language = ?1 ORDER BY percentage DESC")
	List<Object[]> findCountriesByLanguageDesc(String language);
	
	@Query("SELECT c.name, COUNT(c.id) AS numberOfCities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY numberOfCities DESC")
	List<Object[]> findCountriesWithNumCities();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >= ?1 ORDER BY l.percentage DESC")
	List<Object[]> findLanguagesWithPercentageGreaterThan(Double percentage);

	@Query("SELECT c.name FROM Country c WHERE c.surfaceArea < ?1 AND c.population > ?2")
	List<Object[]> findSBelowPopGreater(Double i, Integer j);
	
	@Query("SELECT c.name FROM Country c WHERE c.governmentForm = ?1 AND c.surfaceArea > ?2 AND c.lifeExpectancy > ?3")
	List<Object[]> findGovSaLe(String government, Double surface, Double life);

	@Query("SELECT co.name, ci.name, ci.district, ci.population FROM Country co JOIN co.cities ci WHERE co.name = ?1 AND ci.district = ?2 AND ci.population > ?3")
	List<Object[]> findCoCiDiPop(String countryName, String cityDistrict, Integer population);
	
	@Query("SELECT c.region, COUNT(c.id) AS numberOfCountries FROM Country c GROUP BY c.region ORDER BY numberOfCountries DESC")
	List<Object[]> findNumberOfCountriesInEachRegion();

}
