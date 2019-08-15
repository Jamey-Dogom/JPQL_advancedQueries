package com.jd.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.countries.models.City;
import com.jd.countries.repositories.CityRepository;
import com.jd.countries.repositories.CountryRepository;
import com.jd.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private LanguageRepository languageRepository;
	
	
	public List<Object[]> findCountriesByLanguage(String string) {
		return countryRepository.findCountriesByLanguageDesc(string);
	}


	public List<Object[]> findTotalCities() {
		return countryRepository.findCountriesWithNumCities();
	}


	public List<City> findCitiesInCountryWithPopulationGreaterThan(String country, Integer population){
		return cityRepository.findCitiesInCountryWithPopulationGreaterThan(country, population);
	}


	public List<Object[]> findLanguagesWithPercentageGreaterThan(double d) {
		return countryRepository.findLanguagesWithPercentageGreaterThan(d);
	}


	public List<Object[]> SBelowPopGreater(Double i, Integer j) {
		return countryRepository.findSBelowPopGreater(i, j);
	}
	
	public List<Object[]> govSaLe(String gov, Double sA, Double lE){
		return countryRepository.findGovSaLe(gov, sA, lE);
	}
	
	public List<Object[]> findNumSev(String cName, String dName, Integer pop){
		return countryRepository.findCoCiDiPop(cName, dName, pop);
	}
	
	public List<Object[]> findEachRegion(){
		return countryRepository.findNumberOfCountriesInEachRegion();
	}

}
