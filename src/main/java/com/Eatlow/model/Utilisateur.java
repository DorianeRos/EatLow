package com.Eatlow.model;

import java.util.Set;

import javax.persistence.*;

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

	
	@ManyToMany //table de lien entre utilisateur et ingredients
	@JoinTable(	name = "CONSOMMER",
				joinColumns=@JoinColumn(name="ID_UTI", referencedColumnName="ID"),
				inverseJoinColumns=@JoinColumn(name="ID_ING", referencedColumnName="ID"))
	
	private Set<Utilisateur> utiConso;
	
	@ManyToMany //table lien entre utilisateur et plat
	@JoinTable(	name = "MANGER",
				joinColumns=@JoinColumn(name="ID_UTI", referencedColumnName="ID"),
				inverseJoinColumns=@JoinColumn(name="ID_PLAT", referencedColumnName="ID"))
	
	private Set<Utilisateur> utiPlat;
	

	// CONSTRUCTEUR
		public Utilisateur(int id, String nom, String prenom, String email, String password, Set<Utilisateur> utiConso,
			Set<Utilisateur> utiPlat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.utiConso = utiConso;
		this.utiPlat = utiPlat;
	}

	
	//SETTERS / GETTERS
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

	public Set<Utilisateur> getUtiConso() {
		return utiConso;
	}

	public void setUtiConso(Set<Utilisateur> utiConso) {
		this.utiConso = utiConso;
	}

	public Set<Utilisateur> getUtiPlat() {
		return utiPlat;
	}

	public void setUtiPlat(Set<Utilisateur> utiPlat) {
		this.utiPlat = utiPlat;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "EUtilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", utiConso=" + utiConso + ", utiPlat=" + utiPlat + "]";
	}
	
	// CONSTRUCTEUR VIDE
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
}
