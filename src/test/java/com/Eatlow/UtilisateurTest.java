package com.Eatlow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Eatlow.model.Utilisateur;
import com.Eatlow.repository.CrudUtilisateurRepo;

@SpringBootTest
class UtilisateurTest {
	@Autowired
	private CrudUtilisateurRepo cur;

	@Test
	void testCreate() {
		Utilisateur u = new Utilisateur();
		u.setPrenom("pierre");
		u.setNom("vache");
		u.setEmail("pierre.vache@gmail.com");
		u.setPassword("fjfjsodfkzeo");
		cur.save(u);
		assertThat(u.getId()).isNotNull();
	}

}
