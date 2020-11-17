package com.example.PeliHarjoitustyo.web;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.example.PeliHarjoitustyo.domain.Konsoli;
import com.example.PeliHarjoitustyo.domain.KonsoliRepository;
import com.example.PeliHarjoitustyo.domain.Peli;
import com.example.PeliHarjoitustyo.domain.PeliRepository;

@CrossOrigin
@Controller
public class KonsoliController {

	@Autowired
	private KonsoliRepository konsoliRepository;

	@Autowired
	private PeliRepository peliRepository;

	// Listaa konsolit
	@RequestMapping("/")
	public String konsoliList(Model model) {
		model.addAttribute("konsolit", konsoliRepository.findAll());
		return "konsolilist";
	}

	// Lisää konsolin
	@RequestMapping(value = "/addkonsoli")
	public String addkonsoli(Model model) {
		model.addAttribute("konsoli", new Konsoli());
		return "addkonsoli";
	}

	// tallentaa konsolin
	@RequestMapping(value = "/savekonsoli", method = RequestMethod.POST)
	public String save(Konsoli konsoli) {
		konsoliRepository.save(konsoli);
		return "redirect:/";
	}

	@RequestMapping(value = "/editkonsoli/{id}")
	public String editkonsoli(@PathVariable("id") Long konsoli_id, Model model) {
		Iterable<Peli> all = peliRepository.findAll();
		List<Peli> konsolinPelit = new ArrayList<>();
		for (Peli peli : all) {
			if (peli.getKonsoli().getKonsoli_id() == konsoli_id) {
				konsolinPelit.add(peli);
			}
		}
		
		return "addkonsoli";
	}

	@RequestMapping(value = "/deletekonsoli/{id}", method = RequestMethod.GET)
	public String deleteKonsoli(@PathVariable("id") Long konsoli_id, Model model) {
		konsoliRepository.deleteById(konsoli_id);
		return "redirect:/";
	}



}
