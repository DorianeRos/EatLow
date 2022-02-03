package com.Eatlow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUT_ENERGETIQUE")
public class CoutEnergetique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "AGRICULTURE")
	private float agriculture;

	@Column(name = "TRANSFORMATION")
	private float transformation;

	@Column(name = "EMBALLAGE")
	private float emballage;

	@Column(name = "TRANSPORT")
	private float transport;

	@Column(name = "SUPERMARCHE")
	private float supermarche;

	@Column(name = "CONSOMMATION")
	private float consomation;

	// CONSTRUCTEUR
	public CoutEnergetique(int id, float agriculture, float transformation, float emballage, float transport,
			float supermarche, float consomation) {
		super();
		this.id = id;
		this.agriculture = agriculture;
		this.transformation = transformation;
		this.emballage = emballage;
		this.transport = transport;
		this.supermarche = supermarche;
		this.consomation = consomation;
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

	public float getEmballage() {
		return emballage;
	}

	public void setEmballage(float emballage) {
		this.emballage = emballage;
	}

	public float getTransport() {
		return transport;
	}

	public void setTransport(float transport) {
		this.transport = transport;
	}

	public float getSupermarche() {
		return supermarche;
	}

	public void setSupermarche(float supermarche) {
		this.supermarche = supermarche;
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
		return "ECoutEnergie [id=" + id + ", agriculture=" + agriculture + ", transformation=" + transformation
				+ ", emballage=" + emballage + ", transport=" + transport + ", supermarche=" + supermarche
				+ ", consomation=" + consomation + "]";
	}

	// CONSTRUCTEUR VIDE
	public CoutEnergetique() {
		// TODO Auto-generated constructor stub
	}

}
