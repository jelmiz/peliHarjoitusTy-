package com.example.PeliHarjoitustyo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.PeliHarjoitustyo.domain.Genre;
import com.example.PeliHarjoitustyo.domain.GenreRepository;
import com.example.PeliHarjoitustyo.domain.Konsoli;
import com.example.PeliHarjoitustyo.domain.KonsoliRepository;
import com.example.PeliHarjoitustyo.domain.Peli;
import com.example.PeliHarjoitustyo.domain.PeliRepository;

@SpringBootApplication
public class PeliHarjoitustyoApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(PeliHarjoitustyoApplication.class);

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PeliHarjoitustyoApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PeliHarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(KonsoliRepository konsolirepo, PeliRepository pelirepo, GenreRepository genrerepo) {
		return(args)-> {
			
			
			Konsoli ekakonsoli = new Konsoli("PS4","Sony",200.0);
			Konsoli tokakonsoli = new Konsoli("Switch","Nintendo",150.0);
			Konsoli kolmaskonsoli = new Konsoli("Xbox1","Microsoft",199.0);
			konsolirepo.save(ekakonsoli);
			konsolirepo.save(tokakonsoli);
			konsolirepo.save(kolmaskonsoli);
			
			Genre ekagenre = new Genre("Fps");
			Genre tokagenre = new Genre("Horror");
			Genre kolmasgenre = new Genre("Strategy");
			Genre neljäsgenre = new Genre("Platformer");
			genrerepo.save(ekagenre);
			genrerepo.save(tokagenre);
			genrerepo.save(kolmasgenre);
			genrerepo.save(neljäsgenre);
			
			
			Peli ekapeli = new Peli("Knack","Sony Interactive Entertainment",30.00, neljäsgenre, ekakonsoli);
			Peli tokapeli = new Peli("Halo 5: Guardians","Microsoft Studios",60.00, ekagenre, kolmaskonsoli);
			
			
		
			pelirepo.save(ekapeli);
			pelirepo.save(tokapeli);
			
			
			
			
		};
		
	}

}
