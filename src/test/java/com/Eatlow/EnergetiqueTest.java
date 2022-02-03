package com.Eatlow;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Eatlow.model.EnergyCost;
import com.Eatlow.repository.CrudEnergyCostRepo;

@SpringBootTest
public class EnergetiqueTest {

	@Autowired
	private CrudEnergyCostRepo cer;

	@Test
	public void testCreate() {
		EnergyCost ce = new EnergyCost();
		ce.setAgriculture((float) 1.6);
		ce.setConsomation((float) 2.3);
		ce.setPackaging((float) 3.6);
		ce.setSupermarket((float) 4.6);
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
