package ua.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class IngredientAndAmound {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn
	private Ingredient ingredient;
	
	@ManyToOne
	@JoinColumn
	private MeasuringSystem measuringSystem;
	
	@ManyToMany
	@JoinTable(name = "recipe_ingredients_and_amount",
	joinColumns = @JoinColumn(name = "ingredientsAndAmount_id"),
	inverseJoinColumns = @JoinColumn(name = "recipe_id"))
	private List<Recipe> recipes;

	public IngredientAndAmound() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public MeasuringSystem getMeasuringSystem() {
		return measuringSystem;
	}

	public void setMeasuringSystem(MeasuringSystem measuringSystem) {
		this.measuringSystem = measuringSystem;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}
