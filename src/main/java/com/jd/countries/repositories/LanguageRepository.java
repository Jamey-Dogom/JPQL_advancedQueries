package com.jd.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jd.countries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

}
