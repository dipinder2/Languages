package com.dipinder.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dipinder.languages.models.Languages;
import com.dipinder.languages.repositories.LanguagesRepository;



@Service
public class LanguagesService {
	// adding the languages repository as a dependency
	private final LanguagesRepository languagesRepository;
	
	public LanguagesService(LanguagesRepository languagesRepository) {
		this.languagesRepository = languagesRepository;
	}
	// returns all the languagess
	public List<Languages> allLanguagess() {
		
		return languagesRepository.findAll();
	}
	// creates a languages
	public Languages createLanguages(Languages b) {
		return languagesRepository.save(b);
	}
	// retrieves a languages
	public Languages findLanguages(Long id) {
		Optional<Languages> optionalLanguages = languagesRepository.findById(id);
		if(optionalLanguages.isPresent()) {
			return optionalLanguages.get();
		} else {
			return null;
		}
	}
	public Languages updateLanguages(Languages b) {
		return languagesRepository.save(b);
	}
	public void deleteLanguages(Long id) {
		languagesRepository.deleteById(id);
	}
	
}