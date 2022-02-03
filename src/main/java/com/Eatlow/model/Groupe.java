package com.Eatlow.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "GROUPE")
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Transient//LIEN VERS SOUS GROUPE
	private Set<SousGroupe> sousGroupe;

	// CONSTRUCTEUR VIDE
	public Groupe() {
		sousGroupe = new HashSet<SousGroupe>();
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

	public Set<SousGroupe> getSousGroupe() {
		return sousGroupe;
	}

	public void setSousGroupe(Set<SousGroupe> sousGroupe) {
		this.sousGroupe = sousGroupe;
	}

	// TO STRING
	@Override
	public String toString() {
		return "EGroupe [id=" + id + ", nom=" + nom + ", sousGroupe=" + sousGroupe + "]";
	}

}
