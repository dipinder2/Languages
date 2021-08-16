package com.dipinder.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dipinder.languages.models.Languages;
import com.dipinder.languages.services.LanguagesService;

@Controller
public class LanguagesController {
	
	private final LanguagesService languagesService;
	
	public LanguagesController(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}
	
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("languages1") Languages languages1, 
			BindingResult result, Model model) {
		List<Languages> languages = languagesService.allLanguagess();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	

	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("languages1") Languages languages1, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			languagesService.createLanguages(languages1);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String  show(Model model,
			@PathVariable("id") Long id) {
		
		Languages languages = (languagesService.findLanguages(id));
		model.addAttribute("languages",languages);
		return "show.jsp";
	}
	
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Languages lang = languagesService.findLanguages(id);
		model.addAttribute("languages", lang);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}/edit", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("languages") Languages languages, 
			BindingResult result,@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			languagesService.updateLanguages(languages);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languagesService.deleteLanguages(id);
		return "redirect:/languages";
	}
	
	
}