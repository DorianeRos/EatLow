package com.Eatlow.model;


import javax.persistence.*;

@Entity
@Table(name = "INGREDIENT")

public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "DQR")
	private float dqr;

	@ManyToOne //LIEN AVEC SOUS GROUPE
	@JoinColumn(name = "ID_SOUS_GRP_ING")
	private SousGroupe sousGroupeIng;

	// CONSTRUCTEUR
	public Ingredient(int id, String nom, float dqr, SousGroupe sousGroupeIng) {
		super();
		this.id = id;
		this.nom = nom;
		this.dqr = dqr;
		this.sousGroupeIng = sousGroupeIng;
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

	public float getDqr() {
		return dqr;
	}

	public void setDqr(float dqr) {
		this.dqr = dqr;
	}

	public SousGroupe getSousGroupeIng() {
		return sousGroupeIng;
	}

	public void setSousGroupeIng(SousGroupe sousGroupeIng) {
		this.sousGroupeIng = sousGroupeIng;
	}

	// TO STRING
	@Override
	public String toString() {
		return "EIngredient [id=" + id + ", nom=" + nom + ", dqr=" + dqr + ", sousGroupeIng=" + sousGroupeIng + "]";
	}

	// CONSTRUCTEUR VIDE
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}
}
