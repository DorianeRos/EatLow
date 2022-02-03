package com.Eatlow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Nullable
	@Column(name = "DQR")
	private Float dqr;

	@ManyToOne // LIEN AVEC SOUS GROUPE
	@JoinColumn(name = "SOUS_GROUPE_ID")
	private SousGroupe sousGroupeIng;

	@ManyToOne // LIEN AVEC COUT_ENERGETIQUE
	@JoinColumn(name = "COUT_ENERGETIQUE_ID")
	private CoutEnergetique coutEnergetique;

	// CONSTRUCTEUR VIDE
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	// GETTERS / SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getDqr() {
		return dqr;
	}

	public void setDqr(Float dqr) {
		this.dqr = dqr;
	}

	public SousGroupe getSousGroupeIng() {
		return sousGroupeIng;
	}

	public void setSousGroupeIng(SousGroupe sousGroupeIng) {
		this.sousGroupeIng = sousGroupeIng;
	}

	// TO STRING

	public CoutEnergetique getCoutEnergetique() {
		return coutEnergetique;
	}

	public void setCoutEnergetique(CoutEnergetique coutEnergetique) {
		this.coutEnergetique = coutEnergetique;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + ", dqr=" + dqr + ", sousGroupeIng=" + sousGroupeIng + "]";
	}

}
