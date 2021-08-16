package com.dipinder.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dipinder.languages.models.Languages;


@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long> {
	// this method retrieves all the Languagess from the database
	List<Languages> findAll();
	
}
