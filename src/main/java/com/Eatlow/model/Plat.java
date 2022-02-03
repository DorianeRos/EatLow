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
	private String name;

	@Column(name = "COUT_AUTRE_ETAPE")
	private Float OtherStepCost;

	@ManyToOne // LIEN AVEC SOUS GROUPE
	@JoinColumn(name = "SOUS_GROUPE_ID")
	private SousGroupe subGroupMeal;

	@ManyToMany // table lien entre ingredient et plat
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getOtherStepCost() {
		return OtherStepCost;
	}

	public void setOtherStepCost(Float otherStepCost) {
		OtherStepCost = otherStepCost;
	}

	public SousGroupe getSubGroupMeal() {
		return subGroupMeal;
	}

	public void setSubGroupMeal(SousGroupe subGroupMeal) {
		this.subGroupMeal = subGroupMeal;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Plat [id=" + id + ", nom=" + name + ", coutAutreEtape=" + OtherStepCost + ", sousGroupePlat="
				+ subGroupMeal + ", ingredients=" + ingredients + "]";
	}

}
