package com.example.PeliHarjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.PeliHarjoitustyo.web.GenreController;
import com.example.PeliHarjoitustyo.web.KonsoliController;
import com.example.PeliHarjoitustyo.web.PeliController;
import com.example.PeliHarjoitustyo.web.RESTController;
import com.example.PeliHarjoitustyo.domain.Konsoli;
import com.example.PeliHarjoitustyo.domain.KonsoliRepository;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class PeliHarjoitustyoApplicationTests {

	@Autowired
	private KonsoliController konsoliController;
	@Autowired
	private PeliController peliController;
	@Autowired
	private RESTController restController;
	@Autowired
	private GenreController genreController;
	@Autowired
	private KonsoliRepository krepo;
	@Test
	void contextLoads() throws Exception{
		 assertThat(konsoliController).isNotNull();
		 assertThat(peliController).isNotNull();
		 assertThat(restController).isNotNull();
		 assertThat(genreController).isNotNull();
	}
	@Test
	public void findByNameShouldReturnConsole() {
		List<Konsoli> konsolit = krepo.findByName("PS4");
		
		assertThat(konsolit).hasSize(1);
		assertThat(konsolit.get(0).getPublisher()).isEqualTo("Sony");
	}

}
