package com.Eatlow.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SOUS_GROUPE")
public class SousGroupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Transient // LIEN AVEC INGREDIENT
	private Set<Ingredient> ingredients;

	@Transient // LIEN AVEC PLAT
	private Set<Plat> ssGrpPlat;

	@ManyToOne // LIEN AVEC GROUPE
	@JoinColumn(name = "GROUPE_ID")
	private Groupe groupe;

	// CONSTRUCTEUR VIDE
	public SousGroupe() {
		ingredients = new HashSet<Ingredient>();
	}

	// SETTERS / GETTERS
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

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Plat> getSsGrpPlat() {
		return ssGrpPlat;
	}

	public void setSsGrpPlat(Set<Plat> ssGrpPlat) {
		this.ssGrpPlat = ssGrpPlat;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	// TO STRING
	@Override
	public String toString() {
		return "ESousGroupe [id=" + id + ", nom=" + nom + ", ingredients=" + ingredients + ", ssGrpPlat=" + ssGrpPlat
				+ ", groupe=" + groupe + "]";
	}
}
