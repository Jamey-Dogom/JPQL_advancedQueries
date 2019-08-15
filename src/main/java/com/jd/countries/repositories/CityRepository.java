package com.jd.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jd.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

	@Query("SELECT ci FROM City ci JOIN ci.country c WHERE c.name = ?1 AND ci.population >= ?2 ORDER BY ci.population DESC")
	List<City> findCitiesInCountryWithPopulationGreaterThan(String country, Integer population);

}
