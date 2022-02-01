package com.Eatlow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Eatlow.model.CoupEnergetique;
import com.Eatlow.repository.CrudCoupEnergetiqueRepo;

@SpringBootTest
public class EnergetiqueTest {

	@Autowired
	private CrudCoupEnergetiqueRepo cer;

	@Test
	public void testCreate() {
		CoupEnergetique ce = new CoupEnergetique();
		ce.setAgriculture((float) 1.6);
		ce.setConsomation((float) 2.3);
		ce.setEmballage((float) 3.6);
		ce.setSupermarche((float) 4.6);
		ce.setTransformation((float) 5.6);
		ce.setTransport((float) 6.6);
		cer.save(ce);
		assertThat(ce.getId()).isNotNull();
	}

	@Test
	public void testdelete() {

	}

	@Test
	public void testupdate() {

	}

	@Test
	public void testextractOne() {

	}

	@Test
	public void testextractAll() {

	}

}
