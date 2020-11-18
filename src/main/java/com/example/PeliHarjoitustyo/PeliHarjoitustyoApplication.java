package com.example.PeliHarjoitustyo;


import java.util.Locale;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.PeliHarjoitustyo.domain.Genre;
import com.example.PeliHarjoitustyo.domain.GenreRepository;
import com.example.PeliHarjoitustyo.domain.Konsoli;
import com.example.PeliHarjoitustyo.domain.KonsoliRepository;
import com.example.PeliHarjoitustyo.domain.Peli;
import com.example.PeliHarjoitustyo.domain.PeliRepository;
import com.example.PeliHarjoitustyo.domain.User;
import com.example.PeliHarjoitustyo.domain.UserRepository;



@SpringBootApplication
public class PeliHarjoitustyoApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory.getLogger(PeliHarjoitustyoApplication.class);

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PeliHarjoitustyoApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PeliHarjoitustyoApplication.class, args);
	}
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
	@Bean
	public CommandLineRunner demo(KonsoliRepository konsolirepo, PeliRepository pelirepo, GenreRepository genrerepo, UserRepository uRepository) {
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
			
			User user1 = new User("user", "$2y$10$Hf9NL8Ieu.Tw99PfPoD14.s2uBHJjDTnttr9YlSwMBPcaYJZTmTVu", "ROLE_USER");
			//salasana user
        	User user2 = new User("admin", "$2y$10$LX8vykzELW7F0BTjkylSuuh1EO0m896amOGXaE.vsQrSLMBlLE9bS", "ROLE_ADMIN");
        	//salasana admin
        	uRepository.save(user1);
        	uRepository.save(user2);
			
			
		};
		
	}

}
