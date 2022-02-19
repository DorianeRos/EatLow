package com.Eatlow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Eatlow.model.User;
import com.Eatlow.repository.CrudUserRepo;

@SpringBootTest
class UtilisateurTest {
	@Autowired
	private CrudUserRepo cur;

	@Test
	void testCreate() {
		User u = new User();
		u.setFirstname("pierre");
		u.setLastname("vache");
		u.setEmail("pierre.vache@gmail.com");
		u.setPassword("fjfjsodfkzeo");
		cur.save(u);
		assertThat(u.getId()).isNotNull();
	}

	@Test
	void testUpdate() {

	}

}
