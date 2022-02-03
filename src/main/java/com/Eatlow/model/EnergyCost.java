package com.Eatlow.model;

import javax.persistence.*;

@Entity
@Table(name = "COUT_ENERGETIQUE")
public class EnergyCost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "AGRICULTURE")
	private float agriculture;

	@Column(name = "TRANSFORMATION")
	private float transformation;

	@Column(name = "EMBALLAGE")
	private float packaging;

	@Column(name = "TRANSPORT")
	private float transport;

	@Column(name = "SUPERMARCHE")
	private float supermarket;

	@Column(name = "CONSOMMATION")
	private float consomation;

	// CONSTRUCTEUR VIDE
	public EnergyCost() {
	}

	// GETTERS / SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getAgriculture() {
		return agriculture;
	}
	public void setAgriculture(float agriculture) {
		this.agriculture = agriculture;
	}

	public float getTransformation() {
		return transformation;
	}
	public void setTransformation(float transformation) {
		this.transformation = transformation;
	}

	public float getPackaging() {
		return packaging;
	}
	public void setPackaging(float packaging) {
		this.packaging = packaging;
	}

	public float getTransport() {
		return transport;
	}
	public void setTransport(float transport) {
		this.transport = transport;
	}

	public float getSupermarket() {
		return supermarket;
	}
	public void setSupermarket(float supermarket) {
		this.supermarket = supermarket;
	}

	public float getConsomation() {
		return consomation;
	}
	public void setConsomation(float consomation) {
		this.consomation = consomation;
	}

	// TO STRING
	@Override
	public String toString() {
		return "EnergyCost{" +
				"id=" + id +
				", agriculture=" + agriculture +
				", transformation=" + transformation +
				", packaging=" + packaging +
				", transport=" + transport +
				", supermarket=" + supermarket +
				", consomation=" + consomation +
				'}';
	}
}
