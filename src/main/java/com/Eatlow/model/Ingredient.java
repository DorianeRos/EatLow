package com.Eatlow.model;

import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENT")

public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String name;

	@Nullable
	@Column(name = "DQR", nullable = true)
	private Float dqr;

	@Nullable
	@ManyToOne // LIEN AVEC SOUS GROUPE
	@JoinColumn(name = "SOUS_GROUPE_ID", nullable = true)
	private SousGroupe subGroup;

	@ManyToOne // LIEN AVEC COUT_ENERGETIQUE
	@JoinColumn(name = "COUT_ENERGETIQUE_ID")
	private EnergyCost energyCost;

	// CONSTRUCTEUR VIDE
	public Ingredient() {
	}

	// GETTERS / SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String nom) {
		this.name = name;
	}

	public Float getDqr() {
		return dqr;
	}
	public void setDqr(Float dqr) {
		this.dqr = dqr;
	}

	public SousGroupe getSubGroup() {return subGroup;}
	public void setSubGroup(SousGroupe subGroup) {this.subGroup = subGroup;}

	public EnergyCost getEnergyCost() {return energyCost;}
	public void setEnergyCost(EnergyCost energyCost) {this.energyCost = energyCost;}

	// TO STRING
	@Override
	public String toString() {
		return "ID: " + id + "-> " + name + " - DQR: " + dqr + " - Sub-group: " + subGroup +
				"/n--> Energy cost: " + energyCost;
	}
}
