package com.example.PeliHarjoitustyo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.PeliHarjoitustyo.domain.Genre;
import com.example.PeliHarjoitustyo.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;

	@RequestMapping("/genrelist")
	public String bookList(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		return "genrelist";
	}

	@RequestMapping(value = "/addgenre")
	public String addBook(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}

	@RequestMapping(value = "/savegenre", method = RequestMethod.POST)
	public String save(@Valid Genre genre, BindingResult bindingResult) {
		genreRepository.save(genre);
		return "redirect:genrelist";
	}
	@RequestMapping(value = "/deletegenre/{id}", method = RequestMethod.GET)
	public String deleteGenre(@PathVariable("id") Long genre_id, Model model) {
		genreRepository.deleteById(genre_id);
		return "redirect:/genrelist";
	}
}
