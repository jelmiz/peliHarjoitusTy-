package com.example.PeliHarjoitustyo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.PeliHarjoitustyo.domain.Konsoli;
import com.example.PeliHarjoitustyo.domain.KonsoliRepository;
import com.example.PeliHarjoitustyo.domain.Peli;
import com.example.PeliHarjoitustyo.domain.PeliRepository;
import com.example.PeliHarjoitustyo.domain.Genre;
import com.example.PeliHarjoitustyo.domain.GenreRepository;

@CrossOrigin
@Controller
public class RESTController {
	
	@Autowired
	private KonsoliRepository konsoliRepository;

	@Autowired
	private PeliRepository peliRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@RequestMapping("/resthome")
	public String resthome(Model model) {
		return "resthome";
	}
	
	
	
	@RequestMapping(value = "/konsolit")
	public @ResponseBody List<Konsoli> getAllkonsolit() {
		return (List<Konsoli>) konsoliRepository.findAll();
	}

	
	@RequestMapping(value = "/konsolit/{id}")
	public @ResponseBody Optional<Konsoli> findkonsoli(@PathVariable Long id) {
		return konsoliRepository.findById(id);
	}

	
	@RequestMapping(value = "/pelit")
	public @ResponseBody List<Peli> getAllpelit() {
		return (List<Peli>) peliRepository.findAll();
	}
	

	
	@RequestMapping(value = "konsolit/{konsoli_id}/peli")
	public @ResponseBody List<Peli> getkonsolinpelit(@PathVariable Long konsoli_id) {
		Iterable<Peli> all = peliRepository.findAll();
		List<Peli> konsolinpelit = new ArrayList<>();
		for (Peli peli : all) {
			if (peli.getKonsoli().getKonsoli_id() == konsoli_id) {
				konsolinpelit.add(peli);
			}
		}
		return konsolinpelit;
	}

}
