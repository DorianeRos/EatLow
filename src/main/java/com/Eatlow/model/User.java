package com.Eatlow.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "UTILISATEUR")

public class User implements UserDetails {

	private static final long serialVersionUID = -7318820308134853289L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String lastname;

	@Column(name = "PRENOM")
	private String firstname;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Nullable
	@ManyToMany // table de lien entre utilisateur et ingredients
	@JoinTable(name = "HISTORIQUE_INGREDIENT", joinColumns = @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "ID"))
	private List<Ingredient> historyIngredients;

	@Nullable
	@ManyToMany // table lien entre utilisateur et plat
	@JoinTable(name = "HISTORIQUE_PLAT", joinColumns = @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PLAT_ID", referencedColumnName = "ID"))
	private List<Plat> historyMeals;

	// CONSTRUCTEUR VIDE
	public User() {
		historyIngredients = new ArrayList<>();
		historyMeals = new ArrayList<>();
	}

	// SETTERS / GETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public List<Ingredient> getHistoryIngredients() {
		return historyIngredients;
	}

	public void setHistoryIngredients(List<Ingredient> historyIngredients) {
		this.historyIngredients = historyIngredients;
	}

	public List<Plat> getHistoryMeals() {
		return historyMeals;
	}

	public void setHistoryMeals(List<Plat> historyMeals) {
		this.historyMeals = historyMeals;
	}

	// TO STRING
	@Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
				+ ", password=" + password + ", historyIngredients=" + historyIngredients + ", historyMeals="
				+ historyMeals + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
