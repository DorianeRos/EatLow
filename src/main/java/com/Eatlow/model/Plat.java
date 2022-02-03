package com.Eatlow.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAT")
public class Plat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "AUTRE_ETAPE")
	private Float coupAutreEtape;

	@ManyToOne // LIEN AVEC SOUS GROUPE
	@JoinColumn(name = "SOUS_GROUPE_ID")
	private SousGroupe sousGroupePlat;

	@ManyToMany // table lien entre utilisateur et plat
	@JoinTable(name = "COMPOSITION_PLAT_INGREDIENT", joinColumns = @JoinColumn(name = "PLAT_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID"))
	private Set<Ingredient> ingredients;

	// CONSTRUCTEUR VIDE
	public Plat() {
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

	public SousGroupe getSousGroupePlat() {
		return sousGroupePlat;
	}

	public void setSousGroupePlat(SousGroupe sousGroupePlat) {
		this.sousGroupePlat = sousGroupePlat;
	}

	public Float getCoupAutreEtape() {
		return coupAutreEtape;
	}

	public void setCoupAutreEtape(Float coupAutreEtape) {
		this.coupAutreEtape = coupAutreEtape;
	}
	
	
	// TO STRING

	@Override
	public String toString() {
		return "Plat [id=" + id + ", nom=" + nom + ", coupAutreEtape=" + coupAutreEtape + ", sousGroupePlat="
				+ sousGroupePlat + ", ingredients=" + ingredients + "]";
	}



}
