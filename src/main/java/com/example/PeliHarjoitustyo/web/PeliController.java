package com.example.PeliHarjoitustyo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.PeliHarjoitustyo.domain.GenreRepository;
import com.example.PeliHarjoitustyo.domain.Konsoli;
import com.example.PeliHarjoitustyo.domain.KonsoliRepository;
import com.example.PeliHarjoitustyo.domain.Peli;
import com.example.PeliHarjoitustyo.domain.PeliRepository;

@CrossOrigin
@Controller
public class PeliController {

	@Autowired
	private KonsoliRepository konsoliRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private PeliRepository peliRepository;
	
	@RequestMapping("/pelilist")
	public String peliList(Model model) {
		model.addAttribute("pelit", peliRepository.findAll());
		return "pelilist";
	}
	
	
	@RequestMapping(value = "/savepeli", method = RequestMethod.POST)
	public String save(@Valid Peli peli, BindingResult bindingResult, Model model)
		{
		  if (bindingResult.hasErrors()) {
			  model.addAttribute("konsolit", konsoliRepository.findAll());
			  model.addAttribute("genres", genreRepository.findAll());
			  return "addpeli";
		  } else {
		
			peliRepository.save(peli);
		
		Iterable<Peli> all = peliRepository.findAll();
		List<Peli> konsolinPelit= new ArrayList<>(); 
		for(Peli peli2 : all) {
			if(peli2.getKonsoli().getKonsoli_id() == peli.getKonsoli().getKonsoli_id()) {
				konsolinPelit.add(peli2);
			}
		}
		Optional<Konsoli> konsoliopt = konsoliRepository.findById(peli.getKonsoli().getKonsoli_id());
		Konsoli konsoli = konsoliopt.get();
		model.addAttribute("Pelit", konsolinPelit);
		return "redirect:/pelilist";
	}
	}
	
	@RequestMapping(value = "/addpeli")
	@PreAuthorize("hasRole('ADMIN')")
	public String addpeli(Model model) {
		model.addAttribute("konsolit", konsoliRepository.findAll());
		model.addAttribute("genres", genreRepository.findAll());
		model.addAttribute("peli", new Peli());
		return "addpeli";
	}
	@RequestMapping(value = "/deletepeli/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deletePeli(@PathVariable("id") Long peli_id, Model model) {
		peliRepository.deleteById(peli_id);
		return "redirect:/pelilist";
	}
}
