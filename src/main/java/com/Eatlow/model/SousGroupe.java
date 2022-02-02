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
	@Column(name = "sous_groupe_id")
	private Set<Plat> ssGrpPlat;

	@ManyToOne // LIEN AVEC GROUPE
	@JoinColumn(name = "ID_GRP")
	private Groupe groupe;

	// CONSTRUCTEUR
	public SousGroupe(int id, String nom, Set<Ingredient> ingredients, Set<Plat> ssGrpPlat, Groupe groupe) {
		super();
		this.id = id;
		this.nom = nom;
		this.ingredients = ingredients;
		this.ssGrpPlat = ssGrpPlat;
		this.groupe = groupe;
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

	// CONSTRUCTEUR VIDE
	public SousGroupe() {
		// TODO Auto-generated constructor stub
		ingredients = new HashSet<Ingredient>();
	}

}
