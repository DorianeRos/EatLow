package com.Eatlow.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")

public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany // table de lien entre utilisateur et ingredients
	@JoinTable(	name = "HISTORIQUE_INGREDIENT", 
				joinColumns = @JoinColumn(name = "ID_UTI", referencedColumnName = "ID"), 
				inverseJoinColumns = @JoinColumn(name = "ID_ING", referencedColumnName = "ID"))

	private List<Ingredient> historiqueIngredient;

	@ManyToMany // table lien entre utilisateur et plat
	@JoinTable(	name = "HISTORIQUE_PLAT", 
				joinColumns = @JoinColumn(name = "ID_UTI", referencedColumnName = "ID"), 
				inverseJoinColumns = @JoinColumn(name = "ID_PLAT", referencedColumnName = "ID"))

	private List<Plat> historiquePlat;

	// CONSTRUCTEUR VIDE
	public Utilisateur() {
		// TODO Auto-generated constructor stub
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ingredient> getHistoriqueIngredient() {
		return historiqueIngredient;
	}

	public void setHistoriqueIngredient(List<Ingredient> historiqueIngredient) {
		this.historiqueIngredient = historiqueIngredient;
	}

	public List<Plat> getHistoriquePlat() {
		return historiquePlat;
	}

	public void setHistoriquePlat(List<Plat> historiquePlat) {
		this.historiquePlat = historiquePlat;
	}

	// TO STRING

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", historiqueIngredient=" + historiqueIngredient + ", historiquePlat=" + historiquePlat
				+ "]";
	}
}
